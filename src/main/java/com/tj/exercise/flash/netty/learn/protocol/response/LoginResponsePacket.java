package com.tj.exercise.flash.netty.learn.protocol.response;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/14 22:35
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
