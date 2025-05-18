package org.akshay.dto;


import java.util.Arrays;

public enum SplitType {
    PERCENTAGE(0),
    AMOUNT(1),
    EQUAL(2);
    final int type;
    SplitType(int type){
        this.type = type;
    }
    public  int typeId(){
        return type;
    }
}
