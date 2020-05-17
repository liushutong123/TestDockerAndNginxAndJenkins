package com.bs.gas.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bs.gas.api.dto.LoginSysDto;
import com.bs.gas.api.entity.User;
import com.bs.gas.api.mapper.UserMapper;
import com.bs.gas.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lst
 * @since 2020-05-14
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * @param user
     * @MethodName: checkLogin
     * @Description: 验证登录
     * @Author: shutong.liu
     * @Date: 2020/5/15 0:10
     */
    @Override
    public User checkLogin(LoginSysDto user) {
        //通过用户查询
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getAccount, user.getAccount().trim());
        User checkUser = userMapper.selectOne(userQueryWrapper);
        //没有用户或密码错误返回0，否则返回1
        if (ObjectUtils.isEmpty(checkUser)) {
            return null;
        } else if (!checkUser.getPassword().equals(user.getPassword())) {
            return null;
        } else {
            return User.builder().userName(checkUser.getUserName()).
                    account(checkUser.getAccount()).
                    phone(checkUser.getPhone()).
                    userId(checkUser.getUserId()).userType(checkUser.getUserType()).build();
        }
    }
}
