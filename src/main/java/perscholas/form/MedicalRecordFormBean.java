package perscholas.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class MedicalRecordFormBean {

    private Integer id;
    private String recordType;
    private String fileName;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date DateUploaded;
    private Integer patientId;


    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);

    }
}
