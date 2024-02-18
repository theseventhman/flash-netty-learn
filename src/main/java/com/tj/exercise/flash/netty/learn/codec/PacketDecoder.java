package com.tj.exercise.flash.netty.learn.codec;

import com.tj.exercise.flash.netty.learn.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2024/2/17 12:13
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out){
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}
