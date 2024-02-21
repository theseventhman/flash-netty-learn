package com.tj.exercise.flash.netty.learn.protocol.response;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import com.tj.exercise.flash.netty.learn.session.Session;
import lombok.Data;

import java.util.List;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/21 15:26
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
