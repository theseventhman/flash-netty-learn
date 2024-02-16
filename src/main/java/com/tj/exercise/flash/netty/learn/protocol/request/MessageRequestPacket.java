package com.tj.exercise.flash.netty.learn.protocol.request;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.MESSAGE_REQUEST;

/**
 * @Author: tj
 * @Date: 2024/2/16 20:23
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message){
        this.toUserId = toUserId;
        this.message = message;
    }
    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
