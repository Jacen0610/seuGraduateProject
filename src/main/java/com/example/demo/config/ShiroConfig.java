package com.example.demo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("SM") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String,String> filterMap = new LinkedHashMap<>();

        filterMap.put("/dashborad","authc");
        filterMap.put("/userList","perms[admin]");
        filterMap.put("/InfoList","perms[admin]");
        filterMap.put("/expert","perms[expert]");
        filterMap.put("/info","perms[admin]");
        filterMap.put("/publish","authc");
        filterMap.put("/info2","authc");
        filterMap.put("/userFile","authc");


        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/index");
        return bean;

    }

    @Bean(name = "SM")
    public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
