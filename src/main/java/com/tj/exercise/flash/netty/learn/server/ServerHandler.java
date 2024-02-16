package com.tj.exercise.flash.netty.learn.server;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import com.tj.exercise.flash.netty.learn.protocol.PacketCodeC;
import com.tj.exercise.flash.netty.learn.protocol.command.LoginRequestPacket;
import com.tj.exercise.flash.netty.learn.protocol.response.LoginResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @Author: tj
 * @Date: 2024/2/14 19:29
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        System.out.println(new Date() +": 客户端开始登录.....");
        ByteBuf requestByteBuf = (ByteBuf)msg;

        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        //判断是否是登录请求数据包

        if(packet instanceof LoginRequestPacket){
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket)packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();

            loginResponsePacket.setVersion(packet.getVersion());
            //登录校验

            if(valid(loginRequestPacket)){
                loginResponsePacket.setSuccess(true);
                System.out.println(new Date() +": 登录成功!");
            } else{
                loginResponsePacket.setReason("账号密码校验失败");
                loginResponsePacket.setSuccess(false);
                System.out.println(new Date() +": 登录失败!");
            }
            // 登录响应
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(),loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return  true;
    }
}
