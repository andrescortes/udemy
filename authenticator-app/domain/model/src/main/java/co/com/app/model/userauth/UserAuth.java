package co.com.app.model.userauth;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserAuth {
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private Set<Role> roles;
}
