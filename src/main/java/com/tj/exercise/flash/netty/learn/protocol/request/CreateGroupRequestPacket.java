package com.tj.exercise.flash.netty.learn.protocol.request;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * @Author: tj
 * @Date: 2024/2/19 10:27
 */
@Data
public class CreateGroupRequestPacket extends Packet {
    private List<String> userIdList;
    @Override
    public Byte getCommand() {
       return CREATE_GROUP_REQUEST;
    }
}
