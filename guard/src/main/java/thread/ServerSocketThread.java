package thread;

import common.Constant;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 文件简介
 * 作者    zhengguodan
 * 时间    2020-04-26 23:30
 * 问题    无
 */
public class ServerSocketThread implements Runnable {

    private Socket socket = null;

    public ServerSocketThread(){}

    public ServerSocketThread(Socket socket){
        this.socket = socket;
    }

    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[Constant.SERVER_SOCKET_STEAM_LENGTH];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while((len = inputStream.read(bytes)) != -1){
                stringBuilder.append(new String(bytes,0,len,Constant.SOCKET_CHARSET));
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != inputStream){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
