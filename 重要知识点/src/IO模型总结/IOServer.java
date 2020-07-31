package IO模型总结;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    // TODO 服务端处理客户端连接请求
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);

        new Thread(()->{
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println(Thread.currentThread().getName() + "与客户端建立连接");
                    new Thread(() -> {
                        int len = 0;
                        byte[] data = new byte[1024];
                        try {
                            InputStream inputStream = socket.getInputStream();
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
