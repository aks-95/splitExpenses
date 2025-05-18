package org.akshay.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class SplitManager {
    List<User>users;
    List<Group>groups;
    public SplitManager(){
        this.users  = new ArrayList<>();
        this.groups = new ArrayList<>();
    }
    public User addUser(String userName){
        User user = new User(this.users.size(),userName);
        this.users.add(user);
        return user;
    }
    public  Group addGroup(int userid,String groupName){
        Group group = new Group(this.groups.size(),this.users.get(userid),groupName);
        this.groups.add(group);
        return  group;
    }
    private   Transaction addTransaction(int userId, int groupId, double amount,List<SplitAmount>splitAmounts, String description){
        Group group = this.groups.get(groupId);
        User user = this.users.get(userId);
        return group.addTransaction(user,amount,splitAmounts,description);
    }
    private  Transaction addTransaction(int userId, int groupId, double amount,int splitType, String description){
        if(splitType==SplitType.EQUAL.typeId()){

        }
    }
}
