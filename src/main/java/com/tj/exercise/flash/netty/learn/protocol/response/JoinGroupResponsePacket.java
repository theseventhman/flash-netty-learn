package com.tj.exercise.flash.netty.learn.protocol.response;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.JOIN_GROUP_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/20 12:46
 */
@Data
public class JoinGroupResponsePacket extends Packet {
    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_RESPONSE;
    }
}
