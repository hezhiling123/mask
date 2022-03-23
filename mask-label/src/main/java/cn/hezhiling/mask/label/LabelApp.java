package cn.hezhiling.mask.label;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author hezhiling
 * @date 2021/6/29 9:06
 * @since V1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("cn.hezhiling.**.dao")
@EnableEurekaClient
public class LabelApp {
    public static void main(String[] args) {
        SpringApplication.run(LabelApp.class);
    }

    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
