package com.tj.exercise.flash.netty.learn.client.handler;

import com.tj.exercise.flash.netty.learn.protocol.response.ListGroupMembersResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: tj
 * @Date: 2024/2/21 15:33
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket responsePacket){
        System.out.println("群[" + responsePacket.getGroupId() +"]中的人包括: " +responsePacket.getSessionList());
    }
}
