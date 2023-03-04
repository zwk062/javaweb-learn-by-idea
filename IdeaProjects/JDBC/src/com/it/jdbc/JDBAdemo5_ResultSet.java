package com.it.jdbc;
import com.it.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBAdemo5_ResultSet {
    /**
     * 执行DQL语句
     * @throws Exception
     */
    @Test
    public void TestResultSet() throws Exception {
        String url = "jdbc:mysql:///db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "226030226030zwkZ";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql语句
        String sql = "select * from account;";

        //4.获取statement对象
        Statement stmt = conn.createStatement();

        //5. 执行sql语句
        ResultSet rs = stmt.executeQuery(sql);

        //6.处理结果，遍历rs中的所有数据
        //6.1光标向下移动一行，并且判断当前行是否有数据
        while (rs.next())
        {//6.2获取数据
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double money = rs.getDouble(3);

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("-------------");
        }
        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


    /**
     * 1.定义实现实体类Account
     * 2.查询数据，封装到Accout对象中
     * 3.将Account对象存入ArrayList里
     *
     * @throws Exception
     */
    @Test
    public void TestResultSet2() throws Exception {
        String url = "jdbc:mysql:///db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "226030226030zwkZ";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql语句
        String sql = "select * from account;";

        //4.获取statement对象
        Statement stmt = conn.createStatement();

        //5. 执行sql语句
        ResultSet rs = stmt.executeQuery(sql);

        //6.处理结果，遍历rs中的所有数据
        //6.1光标向下移动一行，并且判断当前行是否有数据

        //创建集合
        List<Account> list = new ArrayList<>();
        while (rs.next())
        {
            Account account = new Account();
            //6.2获取数据
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double money = rs.getDouble(3);

            //赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            list.add(account);
        }
        System.out.println(list);
        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

}

