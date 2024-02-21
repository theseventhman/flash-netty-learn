package com.tj.exercise.flash.netty.learn.protocol.request;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * @Author: tj
 * @Date: 2024/2/21 11:56
 */
@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
