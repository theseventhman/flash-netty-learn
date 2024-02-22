package com.tj.exercise.flash.netty.learn.server.handler;

import com.tj.exercise.flash.netty.learn.protocol.request.CreateGroupRequestPacket;
import com.tj.exercise.flash.netty.learn.protocol.response.CreateGroupResponsePacket;
import com.tj.exercise.flash.netty.learn.util.IDUtil;
import com.tj.exercise.flash.netty.learn.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tj
 * @Date: 2024/2/19 11:22
 */
@ChannelHandler.Sharable
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    public static final CreateGroupRequestHandler INSTANCE = new CreateGroupRequestHandler();

    private CreateGroupRequestHandler() {

    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) throws Exception {
        List<String> userIdList = createGroupRequestPacket.getUserIdList();

        List<String> userNameList = new ArrayList<>();
        // 1. 创建一个channel分组
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());

        // 2. 筛选出待加入群聊的用户的channel 和 userName
        for(String userId : userIdList){
            Channel channel = SessionUtil.getChannel(userId);
            if(channel != null) {
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }

        // 3. 创建群聊创建结果的响应
        String groupId = IDUtil.randomId();
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(groupId);
        createGroupResponsePacket.setUserNameList(userNameList);

        // 4. 给每个客户端发送拉群通知
        channelGroup.writeAndFlush(createGroupResponsePacket);

        System.out.println("群创建成功, id为{" + createGroupResponsePacket.getGroupId() +"], ");
        System.out.println("群里面有: " + createGroupResponsePacket.getUserNameList());

        // 5. 保存群组相关的信息
        SessionUtil.bindChannelGroup(groupId, channelGroup);
    }
}
