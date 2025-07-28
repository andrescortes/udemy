package co.com.app.api;

import co.com.app.model.userauth.UserAuth;
import co.com.app.usecase.userauth.UserAuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final UserAuthUseCase useCase;
//private  final UseCase useCase;
//private  final UseCase2 useCase2;

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        // useCase.logic();
        return serverRequest.bodyToMono(UserAuth.class)
                .flatMap(auth -> ServerResponse
                        .status(HttpStatus.CREATED.value())
                        .body(useCase.login(auth), UserAuth.class)
                );
//        return ServerResponse.ok().body(useCase.login(serverRequest.bodyToMono(UserAuth.class)), UserAuth.class);
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
