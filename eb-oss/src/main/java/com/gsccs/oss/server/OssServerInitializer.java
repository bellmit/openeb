package com.gsccs.oss.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.cors.CorsConfig;
import io.netty.handler.codec.http.cors.CorsHandler;

public class OssServerInitializer extends ChannelInitializer<SocketChannel> {

	/**
	 * 
	 * 初始化pipeline
	 * 
	 * @param ch
	 * @throws Exception
	 */
	@Override
	public void initChannel(SocketChannel ch) throws Exception {

		CorsConfig corsConfig = CorsConfig.withAnyOrigin().build();
		ChannelPipeline pipeline = ch.pipeline();

		// Uncomment the following line if you want HTTPS
		// SSLEngine engine =
		// SecureChatSslContextFactory.getServerContext().createSSLEngine();
		// engine.setUseClientMode(false);
		// pipeline.addLast("ssl", new SslHandler(engine));

		pipeline.addLast("encoder", new HttpResponseEncoder());
		pipeline.addLast("decoder", new HttpRequestDecoder());
		pipeline.addLast("aggregator", new HttpObjectAggregator(8388608)); // 8MB
		//pipeline.addLast("aggregator", new StreamChunkAggregator(-1));
		//pipeline.addLast("chunkedWriter", new ChunkedWriteHandler());

		pipeline.addLast("cors", new CorsHandler(corsConfig));
		pipeline.addLast("handler", new OssServerHandler());
		//pipeline.addLast("handler", new OssServerAdaptorHandler());
	}
}
