package com.tj.exercise.flash.netty.learn.server.handler;

import com.tj.exercise.flash.netty.learn.protocol.command.LoginRequestPacket;
import com.tj.exercise.flash.netty.learn.protocol.response.LoginResponsePacket;
import com.tj.exercise.flash.netty.learn.session.Session;
import com.tj.exercise.flash.netty.learn.util.IDUtil;
import com.tj.exercise.flash.netty.learn.util.LoginUtil;
import com.tj.exercise.flash.netty.learn.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @Author: tj
 * @Date: 2024/2/17 12:22
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        System.out.println(new Date() + ": 收到客户端登录请求……");

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            System.out.println(new Date() + ": 登录成功!");
            LoginUtil.markAsLogin(ctx.channel());
//           String userId = IDUtil.randomId();
//            loginResponsePacket.setUserId(userId);
//            System.out.println("[" + loginRequestPacket.getUserName() + "]登录成功");
//            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUserName()), ctx.channel());
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }

        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
