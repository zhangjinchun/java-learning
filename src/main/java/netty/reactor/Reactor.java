package netty.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangjinchun
 * @date 2021/3/16
 */
public class Reactor implements Runnable {
    public static final String SOCKET_SERVER_IP = "127.0.0.1";
    public static final int SOCKET_SERVER_PORT = 9898;
    Selector selector;
    ServerSocketChannel serverSocket;

    void EchoServerReactor() throws IOException {
        //打开选择器、serverSocket连接监听通道
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        InetSocketAddress address =
                new InetSocketAddress(SOCKET_SERVER_IP,
                        SOCKET_SERVER_PORT);
        serverSocket.socket().bind(address);
        //非阻塞
        serverSocket.configureBlocking(false);

        //分步处理,第一步,接收accept事件
        SelectionKey sk =
                serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //将新连接处理器作为附件，绑定到sk选择键
        sk.attach(new AcceptorHandler());
    }

    @Override
    public void run() {
        //选择器轮询
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()) {
                    //反应器负责dispatch收到的事件
                    SelectionKey sk = (SelectionKey) it.next();
                    dispatch(sk);
                }
                selected.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //反应器的分发方法
    void dispatch(SelectionKey k) {
        Runnable handler = (Runnable) (k.attachment());
        //调用之前绑定到选择键的handler处理器对象
        if (handler != null) {
            handler.run();
        }
    }

    // 新连接处理器
    class AcceptorHandler implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel channel = serverSocket.accept();
                if (channel != null)
                    new EchoHandler(selector, channel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //….
}

