package http.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangjinchun
 * @date 2018/5/24
 */
public class MultiThreadWebServer implements Runnable{
    private static final Logger LOG = Logger.getLogger(MultiThreadWebServer.class);
    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

    public MultiThreadWebServer(int port){
        this.serverPort = port;
    }

    @Override
    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        LOG.info("Multi服务器开启");
        openServerSocket();
        while(true){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(
                    new WorkThread(
                            clientSocket, "mumubin's Multithreaded Server")
            ).start();
        }
    }
    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }
    public static void main(String[] args) {
        MultiThreadWebServer multiThreadWebServer = new MultiThreadWebServer(9090);
        new Thread(multiThreadWebServer).start();
    }

}
