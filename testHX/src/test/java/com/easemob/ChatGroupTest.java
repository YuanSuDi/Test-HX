package com.easemob;

import com.easemob.server.example.api.impl.EasemobChatGroup;
import io.swagger.client.model.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by easemob on 2017/3/22.
 */
public class ChatGroupTest {
    private EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
    private static final Logger logger = LoggerFactory.getLogger(ChatGroupTest.class);

    @Test
    public void getChatGroups() {
        Long limit = 5L;
        String cursor = "";
        Object result = easemobChatGroup.getChatGroups(limit, cursor);
        logger.info(result.toString());
    }

    /**
     * 根据组id获取组的详细信息
     */
    @Test
    public void getGroupsInfo() {
        String[] grousIds = new String[2];
        grousIds[0] = "27327018893314";
        grousIds[1] = "27326993727489";
        Object result = easemobChatGroup.getChatGroupDetails(grousIds);
        logger.info(result.toString());
    }

    
    /**
     * 创建用户组
     * groupname 组名称
     * groupdesc 组描述
     * owner 创建者     
     */
    @Test
    public void createGroup() {
        Group group = new Group();
        group.groupname("groupA").desc("a new group2")._public(true).maxusers(50).approval(false).owner("xiaowang355");
        Object result = easemobChatGroup.createChatGroup(group);
        logger.info(result.toString());
    }

    /**
     * 修改群组的信息
     * groupId
     * 
     */
    @Test
    public void changeGroupInfo() {
        ModifyGroup group = new ModifyGroup();
        String groupId = "11361107116036";
        group.description("change group info").groupname("changed group").maxusers(300);
        Object result = easemobChatGroup.modifyChatGroup(groupId, group);
        logger.info(result.toString());
    }

    /**
     * 将用户添加进群组
     * 需要的参数
     * 	groupid 组id 
     * 	userids 多个用户id数组
     */
    @Test
    public void addUsers() {
        String groupId = "27327018893314";
        UserNames userNames = new UserNames();
        UserName userList = new UserName();
        userList.add("aaaa123456139");
        userList.add("aaa123456149");
        userNames.usernames(userList);
        Object result = easemobChatGroup.addBatchUsersToChatGroup(groupId, userNames);
        logger.info(result.toString());
    }

    /**
     * 将用户从群组中移除
     * 需要的参数 
     * 	groupid 组id 
     * 	userids 多个用户id数组
     */
    @Test
    public void removeUsersFromGroup() {
        String groupId = "11361107116036";
        String[] userIds = new String[2];
        userIds[0] = "aaa123456149";
        //userIds[1] = "qwqwqww";
        Object result = easemobChatGroup.removeBatchUsersFromChatGroup(groupId, userIds);
        logger.info(result.toString());
    }

    /**
     * 获取组中用户名和身份
     */
    @Test
    public void getUsersFromGroup() {
        String groupId = "27327018893314";
        Object result = easemobChatGroup.getChatGroupUsers(groupId);
        logger.info(result.toString());
    }

    /**
     * 修改组的owner
     * 原来的owner会变成member
     */
    @Test
    public void transferGroupOwner() {
        String groupId = "27327018893314";
        NewOwner newOwner = new NewOwner();
        newOwner.newowner("aaa123456149");
        Object result = easemobChatGroup.transferChatGroupOwner(groupId, newOwner);
        logger.info(result.toString());
    }

    /**
     * 禁言
     */
    @Test
    public void addBlockUsers() {
        String groupId = "27327018893314";
        UserNames userNames = new UserNames();
        UserName userList = new UserName();
        userList.add("xiaowang355");
        userList.add("aaaa123456139");
        userNames.usernames(userList);
        Object result = easemobChatGroup.addBatchBlockUsersToChatGroup(groupId, userNames);
        logger.info(result.toString());
    }

    
    @Test
    public void removeBlockUser() {
        String groupId = "27327018893314";
        String[] userIds = new String[2];
        userIds[0] = "xiaowang355";
       userIds[1] = "aaaa123456139";
        Object result = easemobChatGroup.removeBatchBlockUsersFromChatGroup(groupId, userIds);
        logger.info(result.toString());
    }
}
