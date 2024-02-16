package com.tj.exercise.flash.netty.learn.serialize;

import com.tj.exercise.flash.netty.learn.serialize.impl.JSONSerializer;

/**
 * @Author: tj
 * @Date: 2024/2/14 22:25
 */
public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlogrithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
