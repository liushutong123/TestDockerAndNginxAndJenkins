package com.bs.gas.config.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName SingleDataSourceConfig
 * @Description TODO 单例数据源配置
 * @Author shutong.liu
 * @Date 2019/10/26
 * @Version V1.0
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = "com.bs.gas.api.mapper")
public class SingleDataSourceConfig {

    /*
    *   通过其两个属性name以及havingValue来实现的，其中name用来从application.properties中读取某个属性值。
        如果该值为空，则返回false;
        如果值不为空，则将该值与havingValue指定的值进行比较，如果一样则返回true;否则返回false。
        如果返回值为false，则该configuration不生效；为true则生效。
    * */
}
