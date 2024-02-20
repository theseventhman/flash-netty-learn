package com.tj.exercise.flash.netty.learn.client.console;



import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author: tj
 * @Date: 2024/2/19 9:53
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
