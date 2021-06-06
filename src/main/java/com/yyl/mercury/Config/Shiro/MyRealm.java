package com.yyl.mercury.Config.Shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

public class MyRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("----------- 授权 -----------");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Collection<String> permissions = new ArrayList<>();
        permissions.add("user:select");

        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 认证
     * @param token token
     * @return 认证信息
     * @throws AuthenticationException 认证错误
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("----------- 认证 -----------");
        Object principal = token.getPrincipal();
        if (!principal.equals("a")) {
            return null;
        }
        Object credentials = "f958e78ccbe8c424973162e7fe00e60e";
        ByteSource salt = ByteSource.Util.bytes("xyz");
        return new SimpleAuthenticationInfo(principal, credentials, salt, this.getName());
    }
}
