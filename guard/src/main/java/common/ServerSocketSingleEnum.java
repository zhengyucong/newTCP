package common;

import socket.MyServerSocketPool;

/**
 * @author zhengyucong
 * @date 2020/4/11 22:04
 */
public enum ServerSocketSingleEnum {

    //单例对象
    INSTANCE;
    public static ServerSocketSingleEnum getInstance(){
        return INSTANCE;
    }

    private MyServerSocketPool socket = new MyServerSocketPool();

    public MyServerSocketPool getMyServerSocket(){
        return socket;
    }
}
