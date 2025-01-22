package co.com.bancolombia.usecase.orders;

import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import co.com.bancolombia.model.ordersmodel.OrdersModel;

@RequiredArgsConstructor
public class OrdersUseCase {
    public ArrayList orders() {
        ArrayList<OrdersModel> ordersList= new ArrayList<>();
        OrdersModel ordersModel = new OrdersModel();
        ordersModel.setId("1");
        ordersModel.setName("Portatil");
        ordersModel.setStatus("Entregado");
        ordersList.add(ordersModel);
        OrdersModel ordersModel2 = new OrdersModel();
        ordersModel2.setId("2");
        ordersModel2.setName("escritorio");
        ordersModel2.setStatus("Entregado");
        ordersList.add(ordersModel2);
        OrdersModel ordersModel3 = new OrdersModel();
        ordersModel3.setId("3");
        ordersModel3.setName("silla");
        ordersModel3.setStatus("Pendiente");
        ordersList.add(ordersModel3);

        return ordersList;
    }
}
