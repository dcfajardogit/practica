package co.com.bancolombia.consumer.gateway;

import co.com.bancolombia.consumer.ObjectResponse;
import java.io.IOException;

public interface RestRepository {

ObjectResponse apiGet() throws IOException;

}