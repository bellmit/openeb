package com.gsccs.b2c.solr.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gsccs.b2c.api.domain.Brand;

public class ProductDataInit {

	public void addData() throws SQLException {
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
        String url = "jdbc:mysql://61.178.78.89:3306/b2c_db?"
                + "user=jyjy&password=jyjy@2013&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "select * from shop_product_1001";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            	String id = rs.getString("id");
            	System.out.println(id);
            	TestGoods g1 = new TestGoods();
    			g1.setId(rs.getString("id"));
    			g1.setBrandid("1000");
    			g1.setBrandstr("1000-暴风魔镜");
    			g1.setPrice((float) 203.2);
    			
    			g1.setSiteid("1001");
    			g1.setCateid("1010");
    			g1.setCatestr("1010-测试类目1010");
    			g1.setTitle("暴风影音魔镜暴风魔镜2 虚拟现实眼镜 头戴3D魔镜虚拟现实手机头盔 包邮 正品保障");
    			
    			g1.setAttrid(new String[] { "101", "102" });
    			g1.setAttrstr(new String[] { "101-功能", "102-适用人群" });
    			g1.setAttrvalid(new String[] { "101_103", "102_102" });
    			g1.setAttrvalstr(new String[] { "101_103-其它", "102_102-大众通用" });
    			//list.add(g1);
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
	}
	
}
