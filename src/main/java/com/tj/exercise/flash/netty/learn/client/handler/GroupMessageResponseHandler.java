package com.tj.exercise.flash.netty.learn.client.handler;

import com.tj.exercise.flash.netty.learn.protocol.response.GroupMessageResponsePacket;
import com.tj.exercise.flash.netty.learn.session.Session;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: tj
 * @Date: 2024/2/22 22:07
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GroupMessageResponsePacket responsePacket) throws Exception {
        String fromGroupId = responsePacket.getFromGroupId();
        Session fromUser = responsePacket.getFromUser();
        System.out.println("收到群[" + fromGroupId +"]中[" + fromUser +"]发来的消息: " +responsePacket.getMessage());
    }
}
