package co.com.bancolombia.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.com.bancolombia.model.ordersmodel.gateways.OrdersmodelRepository;
import co.com.bancolombia.model.ordersmodel.Ordersmodel;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@Service
public class RestConsumer implements OrdersmodelRepository
{
    private final String url;
    private final OkHttpClient client;
    private final ObjectMapper mapper;
    private static final Logger logger = Logger.getLogger(RestConsumer.class.getName());

    public RestConsumer(@Value("${adapter.restconsumer.url}") String url, OkHttpClient client, ObjectMapper mapper) {
        this.url = url;
        this.client = client;
        this.mapper = mapper;
    }

    // these methods are an example that illustrates the implementation of OKHTTP Client.
    // You should use the methods that you implement from the Gateway from the domain.

    @Override
    @CircuitBreaker(name = "orders", fallbackMethod = "testGetOk") // this name should match with settings name in application.yaml
    public ArrayList<Ordersmodel> orders() throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Content-Type", "application/json")
                .build();

        TypeReference<ArrayList<Ordersmodel>> typeReference = new TypeReference<ArrayList<Ordersmodel>>() {};
        ArrayList<Ordersmodel> orders = callAndMap(request, typeReference);
        return orders;
    }

    public ArrayList<Ordersmodel> testGetOk(Exception ignored) {
        ArrayList<Ordersmodel> orders = new ArrayList<Ordersmodel>();
        logger.info(ignored.getMessage()); 
        Ordersmodel exception = new Ordersmodel();
        exception.setId(ignored.getMessage());
        orders.add(exception);
        
        return orders;
    }

    @CircuitBreaker(name = "testPost") // this name should match with settings name in application.yaml
    public ArrayList<Ordersmodel> testPost() throws IOException {
        String json = mapper.writeValueAsString(ObjectRequest.builder()
            .val1("exampleval1")
            .val2("exampleval1")
            .build()
        );

        RequestBody requestBody = RequestBody
            .create(json, MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
            .url(url)
            .post(requestBody)
            .addHeader("Content-Type","application/json")
            .build();

        
        TypeReference<ArrayList<Ordersmodel>> typeReference = new TypeReference<ArrayList<Ordersmodel>>() {};
        ArrayList<Ordersmodel> orders = callAndMap(request, typeReference);
        return orders;
    }

    public <T> T callAndMap(Request request, TypeReference<T> typeReference) throws IOException {
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return mapper.readValue(response.body().string(), typeReference);
        }
        throw new IOException(response.toString());
    }

}
