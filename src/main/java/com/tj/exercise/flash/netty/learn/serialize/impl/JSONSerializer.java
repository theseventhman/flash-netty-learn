package com.tj.exercise.flash.netty.learn.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.tj.exercise.flash.netty.learn.serialize.Serializer;
import com.tj.exercise.flash.netty.learn.serialize.SerializerAlogrithm;

/**
 * @Author: tj
 * @Date: 2024/2/14 22:26
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes,clazz);
    }
}
