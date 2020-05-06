package socket;


import common.Constant;
import thread.ServerSocketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengyucong
 *
 * @date 2020/4/11 20:42
 */
public class MyServerSocketPool {

    private ServerSocket serverSocket;
    private Socket socket = null;
    public void myServer(){
        try {
            serverSocket = new ServerSocket(Constant.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                Constant.SERVER_SOCKET_CORE_POOL_SIZE,
                Constant.SERVER_SOCKET_MAXIMUM_POOL_SIZE,
                Constant.SERVER_SOCKET_KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),new NameThread() ,new MyIgnorePolicy());
        logger("初始化socket线程池成功，等待连接");
        while(true){
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                logger("socket服务端阻塞异常");
            }
            pool.submit(new ServerSocketThread(socket));
        }
    }

    private void logger(String logger){
        System.out.println(logger);
    }

    private static class NameThread implements ThreadFactory{

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r,"My-SocketServer-Thread-"+mThreadNum.getAndIncrement());
        }
    }
    private static class MyIgnorePolicy implements RejectedExecutionHandler {

        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            //TODO 处理
        }

    }
}
