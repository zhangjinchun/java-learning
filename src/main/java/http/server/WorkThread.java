package http.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WorkThread implements Runnable {
    protected Socket clientSocket = null;
    protected String serverText = null;

    public WorkThread(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    public void doPost()
    {
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(("HTTP/1.1 200 OK\n\nWorkerThread: " +
                    "this is by post").getBytes());
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void doGet()
    {
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(("HTTP/1.1 200 OK\n\nWorkerThread: " +
                    "this is by get").getBytes());
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            byte[] byteBuffer = new byte[1000];

            input.read(byteBuffer);
            for (byte a :byteBuffer)
                System.out.print((char)a);

            if(byteBuffer[0] == 'G' && byteBuffer[1] == 'E' && byteBuffer[2] == 'T')
            {
                doGet();
            }
            else {
                doPost();
            }
            input.close();
            System.out.println("接收到请求");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
