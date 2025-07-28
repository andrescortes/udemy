package co.com.app.r2dbc.userauth.dto;

import co.com.app.model.userauth.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "user_auth")
public class UserAuthData implements Persistable<Long> {

    @Id
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private Set<Role> roles;

    @Override
    public boolean isNew() {
        return Objects.isNull(id);
    }
}
