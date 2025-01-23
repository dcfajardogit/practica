package co.com.bancolombia.model.ordersmodel.gateways;

import co.com.bancolombia.model.ordersmodel.OrdersModel;
import java.util.ArrayList;

public interface OrdersModelRepository {

    ArrayList<OrdersModel> orders();
}
