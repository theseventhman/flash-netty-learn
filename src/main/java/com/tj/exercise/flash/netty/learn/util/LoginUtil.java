package com.tj.exercise.flash.netty.learn.util;

import com.tj.exercise.flash.netty.learn.attribute.Attributes;
import com.tj.exercise.flash.netty.learn.protocol.response.LoginResponsePacket;
import io.netty.channel.Channel;
import io.netty.util.Attribute;


/**
 * @Author: tj
 * @Date: 2024/2/16 20:47
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel){
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
        return ((io.netty.util.Attribute) loginAttr).get() != null;
    }


}
