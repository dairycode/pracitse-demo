package com.github.dairycode.netty.dubborpc.provider;

import com.github.dairycode.netty.dubborpc.netty.NettyServer;

// ServerBootstrap会启动一个服务提供者，就是NettyServer
public class ServerBootstrap {
    public static void main(String[] args) {
        // 代码待填...
        NettyServer.startServer("127.0.0.1", 7000);
    }
}
