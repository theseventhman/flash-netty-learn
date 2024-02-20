package com.tj.exercise.flash.netty.learn.client.console;

import com.tj.exercise.flash.netty.learn.protocol.command.LoginRequestPacket;
import com.tj.exercise.flash.netty.learn.protocol.request.LogoutRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author: tj
 * @Date: 2024/2/19 10:21
 */
public class LogoutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }


}
