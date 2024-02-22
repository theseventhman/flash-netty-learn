package com.tj.exercise.flash.netty.learn.protocol.request;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/22 10:58
 */
@Data
public class GroupMessageRequestPacket extends Packet {
    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
