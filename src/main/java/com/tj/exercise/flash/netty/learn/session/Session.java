package com.tj.exercise.flash.netty.learn.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: tj
 * @Date: 2024/2/16 20:38
 */
@Data
@NoArgsConstructor
public class Session {
    // 用户唯一标识
    private String userId;
    private String userName;

    public Session(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString(){
        return userId +":" + userName;
    }
}
