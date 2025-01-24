package co.com.bancolombia.api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancolombia.usecase.orders.OrdersUseCase;
import java.util.ArrayList;

import co.com.bancolombia.model.ordersmodel.OrdersModel;
import java.util.logging.Logger;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

private final OrdersUseCase ordersUse;

private static final Logger logger = Logger.getLogger(ApiRest.class.getName());

    @GetMapping(path = "/orders")
    public ArrayList<OrdersModel> getOrders() {
        logger.info("recibió la petición");  
        var respuesta= ordersUse.orders();
        logger.info(respuesta.toString()); 
        return respuesta;
    }
}
