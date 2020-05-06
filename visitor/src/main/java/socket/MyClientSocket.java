package socket;

import common.Constant;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zhengyucong
 * @date 2020/4/11 23:01
 */
public class MyClientSocket {

    private Socket socket;
    private OutputStream outputStream;

    public void clientSocket(String msg){
        try {
            socket = new Socket(Constant.HOST,Constant.PORT);
            outputStream = socket.getOutputStream();
            if(msg != null){
                System.out.println("传输的值为"+msg);
                socket.getOutputStream().write(msg.getBytes(Constant.SOCKET_CHARSET));
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger("socket客户端处理消息异常");
        }
        finally {
            close();
        }
    }

    private void logger(String msg){
        System.out.println(msg);
    }

    private void close(){
        try {
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger("socket客户端关闭连接异常");
        }

    }
}
