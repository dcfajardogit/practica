package co.com.bancolombia.usecase.user;

import lombok.RequiredArgsConstructor;
import co.com.bancolombia.model.ordersmodel.gateways.OrdersmodelRepository;
import java.util.ArrayList;

import co.com.bancolombia.model.ordersmodel.Ordersmodel;
import java.io.IOException;

@RequiredArgsConstructor
public class UserUseCase {

    private final OrdersmodelRepository OrdersModelRepository;

    public ArrayList<Ordersmodel> user() throws IOException{
        return OrdersModelRepository.orders();
    }
}
