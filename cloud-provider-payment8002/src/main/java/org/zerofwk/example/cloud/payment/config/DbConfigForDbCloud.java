package org.zerofwk.example.cloud.payment.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/4 13:17
 */
@Configuration
@MapperScan(basePackages = "org.zerofwk.example.cloud.payment.dao", sqlSessionTemplateRef = "sqlSessionTemplateForPayment")
public class DbConfigForDbCloud {
    /**
     * 创建数据源
     *
     * @return DataSource
     */
    @Primary
    @Bean(name = "dataSourceForPayment")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource ds = DruidDataSourceBuilder.create().build();
        //ds.addFilters("stat,wall");
        return ds;
    }

    /**
     * 创建工厂
     *
     * @param dataSource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactoryForPayment")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceForPayment") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //要么在此处指定路径，要么把*Mapper.xml文件放在于*Mapper.class同一位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mybatis/mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * 创建事务
     *
     * @param dataSource
     * @return DataSourceTransactionManager
     */
    @Bean(name = "transactionManagerForPayment")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(
            @Qualifier("dataSourceForPayment") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建模板
     *
     * @param sqlSessionFactory
     * @return SqlSessionTemplate
     */
    @Bean(name = "sqlSessionTemplateForPayment")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactoryForPayment") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
