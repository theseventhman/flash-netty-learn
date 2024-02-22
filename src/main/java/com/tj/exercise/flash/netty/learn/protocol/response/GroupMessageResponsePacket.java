package com.tj.exercise.flash.netty.learn.protocol.response;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import com.tj.exercise.flash.netty.learn.session.Session;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/22 11:08
 */
@Data
public class GroupMessageResponsePacket extends Packet {
    private String fromGroupId;
    private Session fromUser;
    private String message;
    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
