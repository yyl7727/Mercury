package com.yyl.mercury.Entity;

import com.yyl.mercury.Base.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @auther yyl
 * @date 2021/6/6 19:59
 */
@Data
public class SysUser extends BaseEntity {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 系统用户名
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String trueName;
    /**
     * 部门uuid
     */
    private String deptUuid;
    /**
     * 角色uuid
     */
    private String roleUuid;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 电子邮箱
     */
    private String eMail;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 性别
     */
    private String sex;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 状态 0:可用 1:停用
     */
    private String status;
    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 角色组
     */
    private String[] roleUuids;
}
