package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author haozt
 * @since 2020/7/8
 * 客户端启动类
 */
public class AppClientHello {

    private final String host;

    private final int port;

    private EventLoopGroup eventLoopGroup;

    private ChannelFuture channelFuture;

    public AppClientHello(String host, int port) {
        this.host = host;
        this.port = port;
    }



    public void run () throws Exception{
        eventLoopGroup =  new NioEventLoopGroup();//IO线程池
        Bootstrap bootstrap  = new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
        .remoteAddress(new InetSocketAddress(host,port))
        .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new HandlerClientHello());
            }
        });
        channelFuture =  bootstrap.connect().sync();
//            channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer("HelloWorld",CharsetUtil.UTF_8));
//            channelFuture.channel().closeFuture().sync();

//        finally {
//            eventLoopGroup.shutdownGracefully().sync();
//        }
    }


    public void sendMsg (String msg,boolean stopSendMsg) throws Exception {
        if(channelFuture != null){
            channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(msg,CharsetUtil.UTF_8));
        }

        if(stopSendMsg && !eventLoopGroup.isShutdown()){
            eventLoopGroup.shutdownGracefully().sync();
            channelFuture.channel().closeFuture().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        AppClientHello hello = new AppClientHello("127.0.0.1", 18080);
        hello.run();
        Scanner scanner = new Scanner(System.in);
        System.out.println("客户端已启动成功，可以发送消息");
        int i = 0;
        while (true){
            i++;
            String s = scanner.next();
            if(i < 10){
                hello.sendMsg(s,false);
            }else {
                hello.sendMsg(s,true);
                break;
            }
        }
    }
}
