package com.bs.gas.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author lst
 * @since 2020-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@ApiModel(value = "用户实体")
@TableName("GAS_USER")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    @ApiModelProperty(value = "user主键")
    private Long userId;

    /**
     * 用户名
     */
    @TableField("USER_NAME")
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 账号
     */
    @TableField("ACCOUNT")
    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 联系电话
     */
    @TableField("PHONE")
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /**
     * 用户类型
     */
    @TableField("USER_TYPE")
    @ApiModelProperty(value = "用户类型")
    private String userType;

    /**
     * 创建人
     */
    @TableField("CREATE_BY")
    @ApiModelProperty(value = "创建人")
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField("CREATE_DATE")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 最后修改人
     */
    @TableField("LAST_UPDATE_BY")
    @ApiModelProperty(value = "最后修改人")
    private Long lastUpdateBy;

    /**
     * 最后修改时间
     */
    @TableField("LAST_UPDATE_DATE")
    @ApiModelProperty(value = "最后修改时间")
    private Date lastUpdateDate;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
