package cn.zhijing.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@MapperScan("cn.zhijing.mapper")
@Import(SpringService.class)
public class SpringMybatis {
    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource = null;
        InputStream stream = SpringMybatis.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
            dataSource = new DruidDataSource();
            dataSource.configFromPropety(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        try {
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
