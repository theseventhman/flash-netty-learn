package com.tj.exercise.flash.netty.learn.client.console;

import com.tj.exercise.flash.netty.learn.protocol.request.JoinGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author: tj
 * @Date: 2024/2/20 12:33
 */
public class JoinGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();
        System.out.println("输入 groupId, 加入群聊: ");
        String groupId = scanner.next();

        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
