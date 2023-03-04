package com.it.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.it.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据的增删改查
 */
public class BrandTest {

    /**
     * 查询所有
     */
    @Test
    public void testSelectAll() throws Exception {
        //1.获取connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4.获取连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql = "select * from tb_brand";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数

        //5.执行sql
        ResultSet rs = pstmt.executeQuery();

        //6.处理结果
        Brand brand = null;
        List<Brand> brands = new ArrayList<>();
        while (rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            //封装brand对象
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            //装载集合
            brands.add(brand);
        }

        System.out.println(brands);
        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();


    }




    /**
     * 添加
     */
    @Test
    public void testAdd() throws Exception {
        //接受页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;


        //1.获取connection
        Properties prop = new Properties();

        prop.load(new FileInputStream("src/druid.properties"));
        //4.获取连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        //5.执行sql
        int count = pstmt.executeUpdate();

        //6.处理结果
        System.out.println(count>0);

        //7.释放资源
        pstmt.close();
        conn.close();


    }




    /**
     * 修改
     */
    @Test
    public void testUpdate() throws Exception {
        //接受页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;


        //1.获取connection
        Properties prop = new Properties();

        prop.load(new FileInputStream("src/druid.properties"));
        //4.获取连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        //5.执行sql
        int count = pstmt.executeUpdate();

        //6.处理结果
        System.out.println(count>0);

        //7.释放资源
        pstmt.close();
        conn.close();


    }
}
