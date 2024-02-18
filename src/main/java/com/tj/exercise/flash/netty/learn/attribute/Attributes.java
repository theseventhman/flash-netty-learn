package com.tj.exercise.flash.netty.learn.attribute;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tj.exercise.flash.netty.learn.session.Session;
import io.netty.util.AttributeKey;

/**
 * @Author: tj
 * @Date: 2024/2/16 20:36
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
