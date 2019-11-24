package com.lbchyx.owner;

import org.aeonbits.owner.ConfigFactory;

public class TestOwner {

    public static void main(String[] args) throws Exception{

        ServerConfig serverConfig = ConfigFactory.create(ServerConfig.class);
        while(true){
            System.out.println("server.http.port : " + serverConfig.port());
            System.out.println("server.host.name : " + serverConfig.hostname());
            System.out.println("maxThreads : " + serverConfig.maxThreads());
            Thread.sleep(10000);
        }
    }
}
