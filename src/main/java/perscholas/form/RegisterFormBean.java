package perscholas.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import perscholas.validation.TwoFieldsAreEqual;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Confirm Password must be the same.")
public class RegisterFormBean {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date dateOfBirth;
    private String phoneNumber;
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$", message = "Invalid email format")
    private String email;
    @NotEmpty(message = "password is required")
    @Length(min=5, max=50, message="Password must be between 8 and 50 characters")
    private String password;
    private String confirmPassword;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);

    }

}