package com.tj.exercise.flash.netty.learn.handler.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: tj
 * @Date: 2024/2/17 11:32
 */
public class InBoundHandlerA extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws  Exception{
        System.out.println("InBoundHandlerA: " +msg);
        super.channelRead(ctx,msg);
    }
}
