package com.yyl.mercury.Config.Shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    /**
     * 注册权限标签的核心类
     * @return 权限标签的核心类
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    /**
     * 注册凭证匹配器
     * @return 凭证匹配器
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(5);
        return hashedCredentialsMatcher;
    }

    /**
     * 注册授权缓存
     * @return 缓存
     */
    @Bean
    public MemoryConstrainedCacheManager memoryConstrainedCacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    /**
     * 注册自定义realm
     * @return 自定义realm
     */
    @Bean
    public MyRealm myRealm(HashedCredentialsMatcher hashedCredentialsMatcher, MemoryConstrainedCacheManager memoryConstrainedCacheManager) {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        myRealm.setCacheManager(memoryConstrainedCacheManager);
        return myRealm;
    }

    /**
     * 注册安全管理器
     * @param myRealm 自定义realm
     * @return webSecurityManager
     */
    @Bean
    public DefaultWebSecurityManager webSecurityManager(MyRealm myRealm) {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(myRealm);
        return webSecurityManager;
    }

    /**
     * 注册权限拦截过滤器
     * @param webSecurityManager 安全管理器
     * @return shiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager webSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(webSecurityManager);
        //设置不通拦截路径对应拦截方式， 拦截优先级和配置的优先级有关
        //key为请求路径 支持通配符
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/user/login", "anon");
        map.put("/user/logout", "logout");
        map.put("/user/select", "perms[user:select]");
        map.put("/user/delete", "perms[user:delete]");
        map.put("/css/**", "anon");
        map.put("/js/**", "anon");
        map.put("/images/**", "anon");
        map.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //未认证请求跳转页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/401");
        return shiroFilterFactoryBean;
    }
}
