package com.tj.exercise.flash.netty.learn.server;

import com.tj.exercise.flash.netty.learn.codec.PacketDecoder;
import com.tj.exercise.flash.netty.learn.codec.PacketEncoder;
import com.tj.exercise.flash.netty.learn.codec.Spliter;
import com.tj.exercise.flash.netty.learn.handler.inbound.InBoundHandlerA;
import com.tj.exercise.flash.netty.learn.handler.inbound.InBoundHandlerB;
import com.tj.exercise.flash.netty.learn.handler.inbound.InBoundHandlerC;
import com.tj.exercise.flash.netty.learn.handler.outbound.OutBoundHandlerA;
import com.tj.exercise.flash.netty.learn.handler.outbound.OutBoundHandlerB;
import com.tj.exercise.flash.netty.learn.handler.outbound.OutBoundHandlerC;
import com.tj.exercise.flash.netty.learn.server.handler.AuthHandler;
import com.tj.exercise.flash.netty.learn.server.handler.LoginRequestHandler;
import com.tj.exercise.flash.netty.learn.server.handler.MessageRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @Author: tj
 * @Date: 2024/2/12 10:37
 */
public class NettyServer {
    public static void main(String[] args){

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup,workerGroup)
                       .channel(NioServerSocketChannel.class)
                       .childHandler(new ChannelInitializer<NioSocketChannel>() {
                           @Override
                           protected  void initChannel(NioSocketChannel ch){

                               ch.pipeline().addLast(new Spliter());
                               ch.pipeline().addLast(new PacketDecoder());
                               ch.pipeline().addLast(new LoginRequestHandler());
                               ch.pipeline().addLast(new AuthHandler());
                               ch.pipeline().addLast(new MessageRequestHandler());
                               ch.pipeline().addLast(new PacketEncoder());
                           }
                       });
       bind(serverBootstrap,8000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port){
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("端口 [" +port +"]"+"绑定成功!");
                } else{
                    System.out.println("端口 [" +port +"]"+"绑定失败!");
                    bind(serverBootstrap, port+1);
                }

            }
        });
    }
}


