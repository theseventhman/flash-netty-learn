package com.tj.exercise.flash.netty.learn.protocol.response;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/21 11:44
 */
@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_RESPONSE;
    }
}
