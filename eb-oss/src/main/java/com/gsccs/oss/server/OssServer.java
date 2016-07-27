package com.gsccs.oss.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 开放存储服务端
 * 
 * @author x.d zhang
 */
public class OssServer {

	private final int port;

	public OssServer(int port) {
		this.port = port;
	}
	
	
	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new OssServerInitializer());

			Channel ch = b.bind(port).sync().channel();
			Logger.getLogger(OssServerHandler.class.getName()).log(
					Level.ALL, "服务启动端口:" + port + '.');
			ch.closeFuture().sync();

		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
	
	
	public void start() {
		
		EventLoopGroup bossGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("NETTY-BOSS"));
		EventLoopGroup workGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("NETTY-WORKER"));
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workGroup)
				.channel(NioServerSocketChannel.class)
				.localAddress(new InetSocketAddress(port))
	            .option(ChannelOption.SO_KEEPALIVE, true)
	            .option(ChannelOption.SO_REUSEADDR, true)
	            .childHandler(new OssServerInitializer());
			
			//log.debug("server start");
			ChannelFuture f = bootstrap.bind(new InetSocketAddress(port)).sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			//log.error("run error", e);
		} finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
	}

	
	public static void main(String[] args) throws Exception {
		OssConfig config = new OssConfig();
		if (null != args && args.length>0){
			config.init(args[0]);
		}else{
			config.init(null);
		}
		new OssServer(OssConfig.PORT).run();
	}
	
	
}
