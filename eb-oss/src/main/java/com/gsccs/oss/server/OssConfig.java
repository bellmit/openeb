package com.gsccs.oss.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 开发存储配置参数
 * 
 * @author x.d zhang
 * 
 */
public class OssConfig {

	public static String IP;
	public static int PORT;
	public static String BASE_PATH;
	public static int THUMB_MAX_WIDTH = 100;
	public static int THUMB_MAX_HEIGHT = 100;

	public void init(String filePath) {

		Properties pps = new Properties();
		try {
			if (null != filePath) {
				FileInputStream fin = new FileInputStream(new File(filePath));
				pps.load(fin);
			} else {
				pps.load(ClassLoader
						.getSystemResourceAsStream("config.properties"));
			}
			String portStr = pps.getProperty("server.port");
			String THUMB_MAX_WIDTH = pps.getProperty("thumb.max.witdth");
			String THUMB_MAX_HEIGHT = pps.getProperty("thumb.max.height");
			int port = 8080;
			if (null != portStr && !portStr.isEmpty()) {
				port = Integer.valueOf(portStr);
			}
			this.PORT = port;
			this.BASE_PATH = pps.getProperty("server.base");
			this.IP = pps.getProperty("server.ip");
			this.THUMB_MAX_WIDTH = Integer
					.valueOf(null == THUMB_MAX_WIDTH ? "100" : THUMB_MAX_WIDTH);
			this.THUMB_MAX_HEIGHT = Integer
					.valueOf(null == THUMB_MAX_HEIGHT ? "100"
							: THUMB_MAX_HEIGHT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
