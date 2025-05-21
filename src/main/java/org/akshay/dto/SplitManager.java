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
    public   Transaction addTransaction(int userId, int groupId, double amount,int splitType, String description){
        Group group = this.groups.get(groupId);
        User user = this.users.get(userId);
        if(splitType==SplitType.EQUAL.typeId()){
            double amountPerUser = amount/group.users.size();
            for(User user1  : group.users){
                if(user.equals(user1)) continue;
            }
            List<SplitAmount>splitAmounts = group.users.stream()
                    .filter(user1 -> !user1.equals(user))
                    .map(user1 -> new SplitAmount(user1,amountPerUser))
                    .toList();

            return group.addTransaction(user,amount,splitAmounts,description);

        }
        return  null;
    }

    public User addUserInGroup(int userId, int groupId){
        return  this.groups.get(groupId).addUser(this.users.get(userId));
    }
}
