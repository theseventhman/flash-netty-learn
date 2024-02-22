package com.tj.exercise.flash.netty.learn.protocol.response;

import com.tj.exercise.flash.netty.learn.protocol.Packet;

import static com.tj.exercise.flash.netty.learn.protocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * @Author: tj
 * @Date: 2024/2/22 21:57
 */
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
