package co.com.bancolombia.api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancolombia.usecase.user.UserUseCase;
import co.com.bancolombia.model.ordersmodel.Ordersmodel;
import java.util.ArrayList;
import java.io.IOException;

/**
 * API Rest controller.
 * 
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 * 
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {


    private final UserUseCase userUseCase;

    @GetMapping(path = "/user")
    public ArrayList<Ordersmodel> commandName() throws IOException{
        ArrayList<Ordersmodel> microservice = new ArrayList<Ordersmodel>();
        microservice = userUseCase.user();
        return microservice;
    }
}
