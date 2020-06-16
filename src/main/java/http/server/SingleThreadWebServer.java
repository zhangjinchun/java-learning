package http.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangjinchun
 * @date 2018/5/24
 */
public class SingleThreadWebServer implements Runnable{
    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected Thread       runningThread= null;

    public SingleThreadWebServer(int port){
        this.serverPort = port;
    }

    @Override
    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        System.out.println("Web服务器开启了");
        while(true){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                processClientRequest(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void processClientRequest(Socket clientSocket)
            throws IOException {
        InputStream input  = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();
        long time = System.currentTimeMillis();

        output.write(("HTTP/1.1 200 OK\n\n<html><body>" +
                "木木彬的singleThreadWebServer: " +
                time +
                "</body></html>").getBytes());
        output.close();
        input.close();
        System.out.println("接收到请求: " + time);
    }



    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }

    public static void main(String[] args) {
        SingleThreadWebServer singleThreadWebServer = new SingleThreadWebServer(9000);
        new Thread(singleThreadWebServer).start();
    }
}
