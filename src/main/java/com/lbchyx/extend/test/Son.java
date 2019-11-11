package com.lbchyx.extend.test;

import java.util.ArrayList;
import java.util.List;

public class Son extends Father {
    public Son(){
        super(5);
    }

    public static void main(String[] args) {
        Son son1 = new Son();
        Son son = son1;
        System.out.println(son.getS());
        son1.setS("lib");
        System.out.println(son.getS());

        boolean s = 44 == 44.01;
        System.out.println(s);


        List<Son> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list);
    }
}
