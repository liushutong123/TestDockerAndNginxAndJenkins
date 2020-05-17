package com.bs.gas.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * shiro密码加密与解析
 *
 * @author Admin 2020/05/14 23:49
 */
public class ShiroKit {

    private static final String NAMES_DELIMETER = ",";

    /**
     * 加盐参数
     */
    public final static String hashAlgorithmName = "MD5";

    /**
     * 循环次数
     */
    public final static int hashIterations = 1024;

    /**
     * @MethodName: md5
     * @Description: 加密
     * @Author: shutong.liu
     * @Date: 2020/5/14 23:49
     */
    public static String md5(String credentials, String saltSource) {
        ByteSource salt = new Md5Hash(saltSource);
        return new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations).toString();
    }

    /**
     * @MethodName: getRandomSalt
     * @Description: 获取随机盐
     * @Author: shutong.liu
     * @Date: 2020/5/14 23:51
     */
    public static String getRandomSalt(int length) {
        return ToolUtil.getRandomString(length);
    }
}
