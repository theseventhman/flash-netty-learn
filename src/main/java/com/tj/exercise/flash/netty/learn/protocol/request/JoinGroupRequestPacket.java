package com.tj.exercise.flash.netty.learn.protocol.request;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * @Author: tj
 * @Date: 2024/2/20 12:35
 */
@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }
}
