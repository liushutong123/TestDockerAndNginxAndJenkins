package com.bs.gas.util;

import java.util.Random;

/**
 * 工具类
 *
 * @author Admin 2020/05/14 23:50
 */
public class ToolUtil {

    /**
     * @MethodName: getRandomString
     * @Description: 获取随机数
     * @Author: shutong.liu
     * @Date: 2020/5/14 23:51
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }

}
