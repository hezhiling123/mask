package cn.hezhiling.mask.productService.config;


import cn.hezhiling.mask.productService.dbutils.DBTypeEnum;
import cn.hezhiling.mask.productService.dbutils.MyRoutingDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ray
 * @date 2018/2/1.
 */
@Configuration
public class DataSourceConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis.config-location}")
    private String configLocation;

    @Autowired
    @Qualifier("myRoutingDataSource")
    @Lazy
    private DataSource myRoutingDataSource;

    /*自定义数据源，内部持有了主库和从库的数据源，
       通过某种机制让应用程序在进行数据读写时，按业务情况走主库或者从库*/
    @Bean("myRoutingDataSource")
    @Primary
    public DataSource myRoutingDataSource(
            @Qualifier("masterDataSource")DataSource masterDataSource,
            @Qualifier("slaveDataSource")DataSource slaveDataSource){
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER,masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE,slaveDataSource);
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        /*当执行的方法没有被Aop拦截时，缺省使用的数据源*/
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        return myRoutingDataSource;
    }
    /**
     *返回sqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(myRoutingDataSource);
        //自定义数据源一定要手工设置mapperLocations， application.yml里设置的不起作用
        sqlSessionFactory.setMapperLocations(applicationContext.getResources(mapperLocations));
        sqlSessionFactory.setConfigLocation(applicationContext.getResource(configLocation));
        return sqlSessionFactory;
    }

}
