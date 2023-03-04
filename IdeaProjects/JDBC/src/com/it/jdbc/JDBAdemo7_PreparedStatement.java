package com.it.jdbc;
import org.junit.Test;

import java.sql.*;

public class JDBAdemo7_PreparedStatement {
    @Test //不通过main就能运行起来
    public void TestPreparedStatement () throws Exception {
        String url = "jdbc:mysql:///db1?useSSL=false&serverTimezone=UTC&useServerPrepStmts=true";
        String username = "root";
        String password = "226030226030zwkZ";
        Connection conn = DriverManager.getConnection(url, username, password);
        String name = "zhangsan";
        String pwd = "123";
        //定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置？的值
        pstmt.setString(1,name);//将'转译为\'解决sql注入
        pstmt.setString(2,pwd);

        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        rs.close();
        pstmt.close();
        conn.close();
    }
}

