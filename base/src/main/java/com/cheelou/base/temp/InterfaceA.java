package com.cheelou.base.temp;

public interface InterfaceA {
    default  void zzz(){
        System.out.println("zzz");
    }

    default  void aaa(){
        System.out.println("zzz");
    }

    void bbb();
}
