package com.tj.exercise.flash.netty.learn.protocol.response;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/16 20:31
 */
@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}
