package com.tj.exercise.flash.netty.learn.client.console;

import com.tj.exercise.flash.netty.learn.protocol.request.CreateGroupRequestPacket;
import io.netty.channel.Channel;
import lombok.Data;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: tj
 * @Date: 2024/2/19 10:25
 */

public class CreateGroupConsoleCommand implements ConsoleCommand {
    private static final String USER_ID_SPLITER = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();

        System.out.print("【拉人群聊】输入 userId 列表，userId 之间英文逗号隔开：");
        String userIds = scanner.next();
        createGroupRequestPacket.setUserIdList(Arrays.asList(userIds.split(USER_ID_SPLITER)));
        channel.writeAndFlush(createGroupRequestPacket);
    }
}
