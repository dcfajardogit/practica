package co.com.bancolombia.model.ordersmodel.gateways;

//import co.com.bancolombia.consumer.ObjectResponse;
import co.com.bancolombia.model.ordersmodel.Ordersmodel;
import java.util.ArrayList;
import java.io.IOException;

public interface OrdersmodelRepository {

    ArrayList<Ordersmodel> orders() throws IOException;
}
