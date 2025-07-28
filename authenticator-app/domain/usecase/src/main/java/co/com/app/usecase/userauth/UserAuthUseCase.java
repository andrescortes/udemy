package co.com.app.usecase.userauth;

import co.com.app.model.userauth.UserAuth;
import co.com.app.model.userauth.gateways.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class UserAuthUseCase {

    private final UserAuthRepository userAuthRepository;

    public Mono<UserAuth> login(UserAuth userAuth) {

        return Objects.nonNull(userAuth) ? userAuthRepository.login(userAuth) : Mono.empty();
    }
}
