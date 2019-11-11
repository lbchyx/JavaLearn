package com.lbchyx.mysql;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;

public class IconDataBase {
    //Todo:最原始的方式链接数据库
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "com.mysql.jdbc.Driver";
    public static String USERNAME = "";
    public static String PASSWORD = "";

    //数据库连接对象
    private Connection connection;
    private Statement statement;

    @Before
    public void setUp() throws Exception {
        //注册JDBC驱动
        Class.forName(JDBC_DRIVER);
        //打开链接
        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        //实例化Statement对象
        statement = connection.createStatement();
    }

    @After
    public void setDown(){
        // 关闭资源
        try{
            if(statement!=null) statement.close();
        }catch(SQLException se2){
        }// 什么都不做
        try{
            if(connection!=null) connection.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }


    @Test
    public void search() throws Exception {
        String sql_search = "select id, name, url form websites";
        ResultSet resultSet = statement.executeQuery(sql_search);
        //展开结果集数据库
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + name);
        }
        resultSet.close();

    }


    @Test
    public void insert(){

    }



    @Test
    public void upsert(){

    }





}
