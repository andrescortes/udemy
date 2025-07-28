package co.com.app.r2dbc.userauth;

import co.com.app.r2dbc.userauth.dto.UserAuthData;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserAuthDataReactiveRepository extends ReactiveCrudRepository<UserAuthData, Long>, ReactiveQueryByExampleExecutor<UserAuthData> {
    Mono<UserAuthData> findUserAuthDataByUsername(String username);
}
