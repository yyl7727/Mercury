package com.yyl.mercury.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public String login(String userName, String password, Model model) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("error", "不存在的用户");
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("error", "密码错误");
        } catch (AuthenticationException e) {
            model.addAttribute("error", "登录异常");
        }
        return "login";
    }

    @RequiresPermissions("user:select")
    @RequestMapping("/select")
    public String testSelect() {
        return "index";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("/delete")
    public String testDelete() {
        return "index";
    }
}
