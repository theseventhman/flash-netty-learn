package com.tj.exercise.flash.netty.learn.protocol.response;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.CREATE_GROUP_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/19 11:05
 */
@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;
    private String groupId;
    private List<String> userNameList;
    @Override
    public Byte getCommand() {
        return  CREATE_GROUP_RESPONSE;
    }
}
