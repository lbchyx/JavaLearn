package com.lbchyx.extend.test;

public class Father {
    private int i = 999;
    public String s = "sjldfjlsk";
    public String s1 = new String("sjldfjlsk");
    public StringBuilder sb = new StringBuilder();
    public Father(int a){
        System.out.println("father");
    }
    public int getSum(int a){
        return a + i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }
}
