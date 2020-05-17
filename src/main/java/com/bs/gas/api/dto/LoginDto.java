package com.bs.gas.api.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.bs.gas.api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 登录返回dto
 *
 * @author Admin 2020/05/15 0:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {

    private static final long serialVersionUID = 1L;

    private String token;

    private User user;

}
