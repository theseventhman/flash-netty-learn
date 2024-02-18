package com.tj.exercise.flash.netty.learn.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Author: tj
 * @Date: 2024/2/13 12:00
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx){
      for(int i = 0; i < 1000;i++) {
          // 1.获取数据
          ByteBuf buffer = getByteBuf(ctx);

          // 2. 写数据
          ctx.channel().writeAndFlush(buffer);
      }
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        // 1. 获取二进制抽象 ByteBuf
           ByteBuf buffer = ctx.alloc().buffer();

       //  2. 准备数据，指定字符串的字符集为 UTF-8
        byte[] bytes = "你好，欢迎关注我的微信公众号，《闪电侠的博客》!".getBytes(Charset.forName("utf-8"));

      //   3. 填充数据到 ByteBuf
           buffer.writeBytes(bytes);
           return buffer;
    }


}
