package perscholas.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class LoginFormBean {

    private String usernameFromLoginForm;
    @Length(min=5, max=15, message="Password must be between 5 and 15 characters")
    private String passwordFromLoginForm;

}
