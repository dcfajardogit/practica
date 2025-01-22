package co.com.bancolombia.usecase.user;

import lombok.RequiredArgsConstructor;
import co.com.bancolombia.consumer.gateway.RestRepository;
import java.util.ArrayList;
import java.io.IOException;

@RequiredArgsConstructor
public class UserUseCase {

    private final RestRepository restConsumer;

    public ArrayList user() throws IOException{
        return restConsumer.apiGet();
    }
}
