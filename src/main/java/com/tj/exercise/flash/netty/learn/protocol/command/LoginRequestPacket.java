package com.tj.exercise.flash.netty.learn.protocol.command;

import com.tj.exercise.flash.netty.learn.protocol.Packet;
import lombok.Data;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.LOGIN_REQUEST;

/**
 * @Author: tj
 * @Date: 2024/2/13 21:55
 */
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String userName;

    private String password;
    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
