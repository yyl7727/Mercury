package com.yyl.mercury.Service;

import com.yyl.mercury.Entity.SysUser;
import org.springframework.util.StringUtils;

/**
 * @auther yyl
 * @date 2021/6/6 20:37
 */
public class LoginService {
    public SysUser login(String userName, String password) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            //throw new LoginInfoEmptyException();
        }
        return new SysUser();
    }
}
