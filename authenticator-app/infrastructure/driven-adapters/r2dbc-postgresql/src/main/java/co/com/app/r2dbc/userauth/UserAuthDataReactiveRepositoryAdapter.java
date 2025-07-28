package co.com.app.r2dbc.userauth;

import co.com.app.model.userauth.UserAuth;
import co.com.app.model.userauth.gateways.UserAuthRepository;
import co.com.app.r2dbc.helper.ReactiveAdapterOperations;
import co.com.app.r2dbc.userauth.dto.UserAuthData;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserAuthDataReactiveRepositoryAdapter extends ReactiveAdapterOperations<UserAuth, UserAuthData, Long, UserAuthDataReactiveRepository> implements UserAuthRepository {

    protected UserAuthDataReactiveRepositoryAdapter(UserAuthDataReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, UserAuth.UserAuthBuilder.class).build());
    }

    @Override
    public Mono<UserAuth> byUsername(String username) {
        return repository.findUserAuthDataByUsername(username)
                .map(super::toEntity)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new IllegalArgumentException("Username " + username + " not found"))));
    }

    @Override
    public Mono<UserAuth> login(UserAuth userAuth) {
        return Mono.just(userAuth);
    }
}
