package com.yyl.mercury.Base;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @auther yyl
 * @date 2021/6/6 14:11
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * id
     */
    private int id;
    /**
     * 是否删除 0:未删除  1:已删除
     */
    private String isDelete;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
