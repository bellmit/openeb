package com.gsccs.oss.client;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.oss.util.FileUtils;

public class OssClientTest {

	public static void main(String[] args) {
		//File file = new File("E:\\DSC_4623.JPG");
		
		uploadtest();
	}
	
	
	private static void uploadtest(){
		try {
			OssClient client = new OssClient("127.0.0.1", 7001);
			File file = new File("E:\\DSC_4623.JPG");
			byte[] content = FileUtils.getByte(file);

			ObjectMetadata.ExtensionType exten = ObjectMetadata.ExtensionType.png;
			ObjectMetadata metadata = new ObjectMetadata();
			//metadata.setFileid("10245");
			metadata.setDomain("http://img.titles.top/");
			metadata.setSchema("1002");
			metadata.setPath("1000");
			metadata.setType(".jpg");
			metadata.setContent(content);

			JSONObject obj = client.putObject(metadata);
			String filePath = obj.get("url").toString();
			System.out.println(filePath);

		} catch (Exception ex) {
			Logger.getLogger(OssClient.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

}
