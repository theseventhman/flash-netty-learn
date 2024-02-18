package com.tj.exercise.flash.netty.learn.client.handler;

import com.tj.exercise.flash.netty.learn.protocol.command.LoginRequestPacket;
import com.tj.exercise.flash.netty.learn.protocol.response.LoginResponsePacket;
import com.tj.exercise.flash.netty.learn.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: tj
 * @Date: 2024/2/17 20:37
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    public void channelActive(ChannelHandlerContext ctx){
       // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("flash");
        loginRequestPacket.setPassword("pwd");

        // 写数据
      //  ctx.channel().writeAndFlush(loginRequestPacket);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if(loginResponsePacket.isSuccess()){
            System.out.println(new Date() +": 客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        }
        else{
            System.out.println(new Date() + ": 客户端登录失败, 原因："+loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }
}
