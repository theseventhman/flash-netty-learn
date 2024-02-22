package com.tj.exercise.flash.netty.learn.protocol.request;

import com.tj.exercise.flash.netty.learn.protocol.Packet;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.HEARTBEAT_REQUEST;

/**
 * @Author: tj
 * @Date: 2024/2/22 21:54
 */
public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
