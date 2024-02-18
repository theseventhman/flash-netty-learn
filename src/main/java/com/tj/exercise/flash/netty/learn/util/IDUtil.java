package com.tj.exercise.flash.netty.learn.util;

import java.util.UUID;

/**
 * @Author: tj
 * @Date: 2024/2/18 11:32
 */
public class IDUtil {
    public static String randomId(){
        return UUID.randomUUID().toString().split("-")[0];
    }
}
