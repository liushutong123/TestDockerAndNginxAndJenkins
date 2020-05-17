package com.bs.gas.api.controller;


import com.bs.gas.base.R;
import com.bs.gas.api.entity.User;
import com.bs.gas.api.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lst
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public R saveUser(User user) {
        Date nowDate = new Date();
        user.setUserName(user.getAccount()).setCreateBy(-99L).setCreateDate(nowDate).setLastUpdateBy(-99L).setLastUpdateDate(nowDate);
        try {
            if (userService.save(user)) {
                user.setCreateBy(user.getUserId()).setLastUpdateBy(user.getUserId()).setLastUpdateDate(nowDate);
                userService.updateById(user);
                user.setUserName(null)
                        .setPassword(null)
                        .setPhone(null)
                        .setCreateBy(user.getUserId())
                        .setLastUpdateBy(user.getUserId());
                return R.success("注册成功", user);
            } else {
                return R.fail("注册失败", null);
            }
        } catch (Exception e) {
            LOG.error("注册异常: ", e);
            return R.fail("注册失败, 用户可能已存在", null);
        }
    }
}

