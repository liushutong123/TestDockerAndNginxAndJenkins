package com.bs.gas.api.service;

import com.bs.gas.api.dto.LoginSysDto;
import com.bs.gas.api.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lst
 * @since 2020-05-14
 */
public interface IUserService extends IService<User> {

    /**
     * @MethodName: checkLogin
     * @Description: 验证登录
     * @Author: shutong.liu
     * @Date: 2020/5/15 0:10
     */
    User checkLogin(LoginSysDto user);
}
