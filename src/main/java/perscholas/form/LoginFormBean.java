package perscholas.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class LoginFormBean {

    private String usernameFromLoginForm;
    @Length(min=5, max=50, message="Password must be between 5 and 30 characters")
    private String passwordFromLoginForm;

 //   public String getUsernameFromLoginForm() {
//        return usernameFromLoginForm;
//    }
//
//    public void setUsernameFromLoginForm(String usernameFromLoginForm) {
//        this.usernameFromLoginForm = usernameFromLoginForm;
//    }
//
//    public String getPasswordFromLoginForm() {
//        return passwordFromLoginForm;
//    }
//
//    public void setPasswordFromLoginForm(String passwordFromLoginForm) {
//        this.passwordFromLoginForm = passwordFromLoginForm;
//    }
}
