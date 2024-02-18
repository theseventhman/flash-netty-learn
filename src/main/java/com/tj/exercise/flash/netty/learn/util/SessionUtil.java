package com.tj.exercise.flash.netty.learn.util;

import com.tj.exercise.flash.netty.learn.attribute.Attributes;
import com.tj.exercise.flash.netty.learn.session.Session;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: tj
 * @Date: 2024/2/18 11:37
 */
public class SessionUtil {
    private static final Map<String,Channel> userIdChannelMap = new ConcurrentHashMap<>();

    private static final Map<String, ChannelGroup> groupIdChannelGroupMap = new ConcurrentHashMap<>();

    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put( session.getUserId(),  channel);
        channel.attr(Attributes.SESSION).set(session);
    }
}
