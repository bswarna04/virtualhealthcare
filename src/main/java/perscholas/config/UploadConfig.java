package perscholas.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Slf4j
@Configuration
public class UploadConfig {

    @Value("${fileupload.maxFileSize}")
    private String maxFileSize;

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSizePerFile(DataSize.parse(maxFileSize).toBytes());
        return commonsMultipartResolver;
    }

}
