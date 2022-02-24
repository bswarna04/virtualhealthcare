package perscholas.form;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class AppointmentFormBean {

    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date apptDate;
    private String apptTime;
    private String status;
    private Integer patientId;
    private Integer doctorId;
    private String message;

    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);

    }

}
