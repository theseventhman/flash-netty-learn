package com.tj.exercise.flash.netty.learn.server.handler;

import com.tj.exercise.flash.netty.learn.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.spi.CalendarDataProvider;

/**
 * @Author: tj
 * @Date: 2024/2/18 11:14
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
       if(!LoginUtil.hasLogin(ctx.channel())){
           ctx.channel().close();
       } else{
           ctx.pipeline().remove(this);
           super.channelRead(ctx,msg);
       }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx){
      if(LoginUtil.hasLogin(ctx.channel())){
          System.out.println("当前连接登录验证完毕,无需再次验证, AuthHandler被移除");
      } else{
          System.out.println("无登录验证,强制关闭连接!");
      }
    }
}
