package com.bs.gas.api.controller;

import com.bs.gas.api.dto.LoginSysDto;
import com.bs.gas.cons.Cons;
import com.bs.gas.api.dto.LoginDto;
import com.bs.gas.base.R;
import com.bs.gas.api.entity.User;
import com.bs.gas.api.service.IUserService;
import com.bs.gas.util.RedisUtils;
import com.bs.gas.util.ToolUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 登录控制器
 *
 * @author Admin 2020/05/14 23:40
 */
@RestController
@Api(value = "登录控制器")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping(value = "/login")
    @ApiOperation(value = "登录")
    public R login(LoginSysDto user) {
        User res = userService.checkLogin(user);
        if (ObjectUtils.isEmpty(res)){
            return R.fail("用户名或密码错误，请确认！",null);
        }
        String token = ToolUtil.getRandomString(Cons.RANDOM_LENGTH);
        redisUtils.lSet(res.getAccount() + Cons.USER_TOKEN, token);
        redisUtils.lSet(res.getAccount() + Cons.NOW_USER, res);
        return R.success(LoginDto.builder().user(res).token(token).build());
    }

    @GetMapping(value = "/login-out")
    @ApiOperation(value = "登出")
    public R loginOut(@RequestParam String account) {
        redisUtils.del(account + Cons.USER_TOKEN);
        redisUtils.del(account + Cons.NOW_USER);
        return R.success(null);
    }
}
