package com.tj.exercise.flash.netty.learn.chapter2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: tj
 * @Date: 2024/2/11 21:31
 */
public class NIOServer {
    public static void main(String[] args) throws IOException{
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread( () ->{
            try{
                // 对应IO编程中的服务端启动

                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(8000));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                while(true){
                    //监测是否有新连接， 这里的1指阻塞时间为1ms
                    if(serverSelector.select(1) >0){
                        Set<SelectionKey> set = serverSelector.selectedKeys();

                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while(keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if(key.isAcceptable()){
                                try{
                                    //每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                    SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector,SelectionKey.OP_READ);
                                } finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (IOException ignored){

            }

        }).start();

        new Thread(() ->{
            try{
                while (true){
                    //批量轮询哪些连接有数据可读，这里的1指阻塞的时间为1ms
                    if(clientSelector.select(1) >0){
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while(keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if(key.isReadable()){
                                try{
                                    SocketChannel clientChannel = (SocketChannel) key.channel();

                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                                    // 面向Buffer
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                } finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            } catch (IOException ignored){

            }
        }).start();
    }
}
