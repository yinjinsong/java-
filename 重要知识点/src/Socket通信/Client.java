package Socket通信;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter pw = null;

        Socket socket = new Socket("localhost", 2000);


        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(),true);

        pw.println("hello world");
        String s = null;
        while (true) {
            s = br.readLine();
            if (s != null) {
                break;
            }
        }
        System.out.println(s);
        br.close();
        pw.close();

    }


}