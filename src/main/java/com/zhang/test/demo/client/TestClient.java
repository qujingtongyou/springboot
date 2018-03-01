package com.zhang.test.demo.client;

import com.zhang.test.demo.handler.TestClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by 15939 on 2018/3/1.
 * 客户端
 * @author xiaohei
 * @date 2018/3/1 15:04
 */
public class TestClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new TestClientHandler());
                    }
                });
        ChannelFuture future = bootstrap.connect("127.0.0.1", 8379).sync();
        future.channel().writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));
        future.channel().closeFuture().sync();
        workerGroup.shutdownGracefully();
    }

}
