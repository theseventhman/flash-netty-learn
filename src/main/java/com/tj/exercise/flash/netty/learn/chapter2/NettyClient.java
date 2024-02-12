package com.tj.exercise.flash.netty.learn.chapter2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.util.Date;


/**
 * @Author: tj
 * @Date: 2024/2/12 11:40
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException{
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected  void initChannel(Channel ch){
                        ch.pipeline().addLast(new StringDecoder());
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1",8000).channel();
        while(true){
            channel.writeAndFlush(new Date() +": hello world!");
            Thread.sleep(2000);
        }
    }
}
