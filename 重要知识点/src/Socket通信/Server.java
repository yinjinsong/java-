package Socket通信;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter pw = null;

        //1.创建server端，监听端口
        ServerSocket server = new ServerSocket(2000);
        Socket socket = server.accept();
        //获取输入流
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //获取输出流
        pw = new PrintWriter(socket.getOutputStream(), true);
        String s = br.readLine();
        System.out.println("server收到了" + s);
        pw.println(s);
        br.close();
        pw.close();
    }
}
