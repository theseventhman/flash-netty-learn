package com.tj.exercise.flash.netty.learn.codec;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tj.exercise.flash.netty.learn.protocol.Packet;
import com.tj.exercise.flash.netty.learn.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2024/2/22 11:53
 */
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {
    public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

    private PacketCodecHandler(){

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) {
       out.add(PacketCodeC.INSTANCE.decode(byteBuf));
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, List<Object> out) throws Exception {
       ByteBuf byteBuf = ctx.channel().alloc().ioBuffer();
       PacketCodeC.INSTANCE.encode(byteBuf,packet);
       out.add(byteBuf);
    }
}
