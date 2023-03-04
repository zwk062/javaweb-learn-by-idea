package com.it.jdbc;
import com.it.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBAdemo6_UserLogin {
    @Test //不通过main就能运行起来
    public void TestResultSet() throws Exception {
        String url = "jdbc:mysql:///db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "226030226030zwkZ";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql语句
        String name = "666";
        String pwd = "' or '1' = '1";
        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";
        System.out.println(sql);
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        if(rs.next()){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }
    }
}

