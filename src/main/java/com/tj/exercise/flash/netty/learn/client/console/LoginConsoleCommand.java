package com.tj.exercise.flash.netty.learn.client.console;

import com.tj.exercise.flash.netty.learn.protocol.command.LoginRequestPacket;
import com.tj.exercise.flash.netty.learn.protocol.request.MessageRequestPacket;
import com.tj.exercise.flash.netty.learn.util.SessionUtil;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author: tj
 * @Date: 2024/2/19 10:53
 */
public class LoginConsoleCommand  implements ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

                    System.out.println("输入用户名登录: ");
                    loginRequestPacket.setUserName(scanner.nextLine());
                    loginRequestPacket.setPassword("pwd");


                    // 发送登录数据包
                    channel.writeAndFlush(loginRequestPacket);
                    waitForLoginResponse();
      }

    private static void waitForLoginResponse() {
        try{
            Thread.sleep(1000);
        } catch(InterruptedException ignored){

        }
    }

}
