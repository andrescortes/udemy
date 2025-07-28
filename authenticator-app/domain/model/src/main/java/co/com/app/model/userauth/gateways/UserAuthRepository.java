package co.com.app.model.userauth.gateways;

import co.com.app.model.userauth.UserAuth;
import reactor.core.publisher.Mono;

public interface UserAuthRepository {
    Mono<UserAuth> byUsername(String username);

    Mono<UserAuth> login(UserAuth userAuth);
}
