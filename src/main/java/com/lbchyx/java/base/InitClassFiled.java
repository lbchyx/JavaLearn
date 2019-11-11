package com.lbchyx.java.base;

import com.lbchyx.extend.test.Father;

public class InitClassFiled {
    //如果字段是某个对象的引用，那么必须初始化该引用，以便使其与一个实际的对象相关联
    private String filed;
    private Father father;

    public static void main(String[] args) {
        InitClassFiled filed = new InitClassFiled();
        Father father = filed.father;
    }

    public void test(){
        String s = father.s;
    }


}
