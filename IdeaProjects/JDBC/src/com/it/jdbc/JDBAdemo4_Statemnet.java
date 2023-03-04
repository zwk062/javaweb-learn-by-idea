package com.it.jdbc;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBAdemo4_Statemnet {
    /**
     * 执行DML语句
     * @throws Exception
     */
    @Test
    public void TestDML() throws Exception {
        //1.注册驱动(mysql5之后可以不用）
        //Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8.0用这个驱动

        //2.获取链接:如果连接的是本机的mysql并且端口是默认的3306可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false&serverTimezone=UTC";
//        //localhost ip（域名）3306 端口 useSSL=false 不使用ssl连接
        String username = "root";
        String password = "226030226030zwkZ";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "update account set money =8000 where id = 5";

        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //JDBC中的Statement对象用于向数据库发送SQL语句，想完成对数据库的增删改查，只需要通过这个对象向数据库发送增删改查语句即可。

        //5. 执行sql
        int count = stmt.executeUpdate(sql);//执行完DML语句后受影响的行数。

        //6. 打印结果
        if(count>0)
        {
            System.out.println("修改成功");

        }
        else
        {
            System.out.println("修改失败");
        }

        //7. 释放资源
        stmt.close();
        conn.close();
    }
    /**
     * 执行DDL语句
     * @throws Exception
     */
    @Test
    public void TestDDL() throws Exception {
        //1.注册驱动(mysql5之后可以不用）
        //Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8.0用这个驱动

        //2.获取链接:如果连接的是本机的mysql并且端口是默认的3306可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false&serverTimezone=UTC";
//        //localhost ip（域名）3306 端口 useSSL=false 不使用ssl连接
        String username = "root";
        String password = "226030226030zwkZ";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "create database db2";

        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //JDBC中的Statement对象用于向数据库发送SQL语句，想完成对数据库的增删改查，只需要通过这个对象向数据库发送增删改查语句即可。

        //5. 执行sql
        int count = stmt.executeUpdate(sql);//执行完DML语句后受影响的行数。

        //6. 打印结果
        if(count>0)
        {
            System.out.println("修改成功");

        }
        else
        {
            System.out.println("修改失败");
        }

        //7. 释放资源
        stmt.close();
        conn.close();
    }
    }

