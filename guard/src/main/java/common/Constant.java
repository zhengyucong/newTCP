package common;

/**
 * @author zhengyucong
 * @date 2020/4/11 23:03
 */
public interface Constant {
    /**
     * socket IP地址
     */
    String HOST = "127.0.0.1";
    /**
     * socket 端口号
     */
    int PORT = 7733;
    /**
     * socket 服务端inputSteam处理长度
     */
    int SERVER_SOCKET_STEAM_LENGTH = 1024;
    /**
     * socket服务端核心线程池大小
     */
    int SERVER_SOCKET_CORE_POOL_SIZE = 0;
    /**
     * socket服务端最大线程池大小
     */
    int SERVER_SOCKET_MAXIMUM_POOL_SIZE = Integer.MAX_VALUE;
    /**
     * socket服务端线程无任务停止时间
     */
    long SERVER_SOCKET_KEEP_ALIVE_TIME = 10L;
    /**
     * socket 字符集
     */
    String SOCKET_CHARSET = "GBK";
    /**
     * socket退出标记
     */
    String SOCKET_EXIT ="EXIT";
}
