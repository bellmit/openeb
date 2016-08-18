import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2016/5/17.
 */
public class FastdfsTest {
    private static Logger log = Logger.getLogger(FastdfsTest.class.getName());

    private static final String FAST_DFS_CONF_FILE = "D:\\goshop\\goshop-parent\\goshop-common-attachment\\src\\main\\resources\\client.conf";


    @Test
    public void testUpload() throws Exception{
       /* //加载配置文件
        ClientGlobal.init("");
        //创建TrackerClient_client
        //TrackerClient trackerClient = new TrackerClient();
        //创建trackerService
        TrackerServer trackerServer = ClientGlobal.getG_tracker_group().getConnection();
        //创建StorageServer
        StorageServer storageServer = null;
        //创建StorageClient
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);

        String[] sArray=storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\2.jpg","jpg",null);

        for(String s:sArray){
            System.out.print(s);
        }*/
        ClientGlobal.setG_charset("ISO8859-1");
        ClientGlobal.setG_network_timeout(30);
        TrackerGroup tg = new TrackerGroup(new InetSocketAddress[]{new InetSocketAddress("192.168.36.129", 22122)});
        TrackerClient tc = new TrackerClient(tg);

        TrackerServer trackerServer = tc.getConnection();
        Assert.assertNotNull("getConnection return null",trackerServer);

        StorageServer storageServer = tc.getStoreStorage(trackerServer);
        Assert.assertNotNull("getConnection return null",storageServer);

        StorageClient storageClient = new StorageClient(trackerServer,storageServer);

        NameValuePair[] meta_list = null;
        String[] sArray=storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\1.jpg","jpg",meta_list);

        for(String s:sArray){
            System.out.print(s);
        }
    }
    /**
     * 获取存储服务器连接
     *
     * @return
     * @throws IOException
     */
    private static StorageClient getStorageClient() throws IOException {

        // 建立tracker server 的连接
        /*
         * TrackerGroup tg = new TrackerGroup( new InetSocketAddress[] { new
         * InetSocketAddress( TRACKER_SERVER_IP, TRACKER_SERVER_PORT) });
         */

        // TrackerClient tc = new TrackerClient();
        TrackerServer ts = ClientGlobal.getG_tracker_group().getConnection();
        if (ts == null) {
            System.out.println("getConnection return null");
            return null;
        }

        // 建立存储服务器的连接
        StorageServer ss = null;// tc.getStoreStorage(ts);
        /*
         * if (ss == null) { System.out.println("getStoreStorage return null");
         * return null; }
         */

        // 建立存储客户端
        StorageClient sc = new StorageClient(ts, ss);

        /* for test only */
        // System.out.println("active test to storage server: " +
        // ProtoCommon.activeTest(ss.getSocket()));
        // ss.close();
        /* for test only */
        // System.out.println("active test to tracker server: " +
        // ProtoCommon.activeTest(ts.getSocket()));
        // ts.close();

        /* for test only */
        System.out.println("active test to storage server: " + ProtoCommon.activeTest(ss.getSocket()));
        ss.close();
        /* for test only */
        System.out.println("active test to tracker server: " + ProtoCommon.activeTest(ts.getSocket()));
        ts.close();

        return sc;
    }

    /**
     * 上传文件
     *
     * @return
     */
    public static String[] uploadFile(String fileName, String fileExt, byte[] contents) {
        try {
            if (fileName == null || contents == null) {
                System.out.println("Upload file[" + fileName + "] is null");
                return null;
            }

            long startTime = System.currentTimeMillis();
            System.out.println("Upload file[" + fileName + "] startTime::" + startTime);

            // TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = ClientGlobal.getG_tracker_group().getConnection();
            StorageServer storageServer = null;
            StorageClient client = new StorageClient(trackerServer, storageServer);

            NameValuePair[] meta_list = new NameValuePair[1];
            meta_list[0] = new NameValuePair("filename", fileName);
            String[] fileInfo = client.upload_file(contents, fileExt, meta_list);

            System.out.println("Upload file[" + fileName + "] ok");
            System.out.println(fileInfo[0]);// 文件存储所在的组 如：group1 group2等
            System.out.println(fileInfo[1]);// 文件在服务器上的路径及文件名
            // 如：M00/00/00/eWXds1DJpzCASX0oAAAAA4i3nNI382.txt

            long endTime = System.currentTimeMillis();
            System.out.println("Upload file[" + fileName + "] endTime::" + endTime);
            return fileInfo;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
