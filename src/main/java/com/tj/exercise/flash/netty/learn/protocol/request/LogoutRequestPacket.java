package com.tj.exercise.flash.netty.learn.protocol.request;

import com.tj.exercise.flash.netty.learn.protocol.Packet;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.LOGOUT_REQUEST;

/**
 * @Author: tj
 * @Date: 2024/2/19 11:48
 */
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}
