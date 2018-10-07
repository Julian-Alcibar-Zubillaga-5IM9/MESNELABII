/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ipn.cecyt9.mesnelab.utils;
import java.sql.*;
/**
 *
 * @author Julian
 */
public class BD {
    private String usr;
    private String password;
    private String dbName;
    private String port;
    private String driverClassName;
    private String host;
    private Statement statement;
    private Connection Connection;

    public BD(){
        usr = "root";
        password = "n0m3l0";
        dbName = "Tienda";
        port="3306";
        host = "192.168.20.136";
        driverClassName = "com.mysql.jdbc.Driver";
    }
    
    
    
    public BD(String usr, String password, String dbName, String port, String driverClassName, String host, Statement statement) {
        this.usr = usr;
        this.password = password;
        this.dbName = dbName;
        this.port = port;
        this.driverClassName = driverClassName;
        this.host = host;
        this.statement = statement;
    }
    public void Connection(){
        String url = "jdbc:mysql://"+host+":"+port+"/"+dbName;
        try{
            Class.forName(this.driverClassName).newInstance();
            this.Connection = DriverManager.getConnection(url, this.usr, this.password);
        }
        catch(Exception e){
             e.printStackTrace();
             System.out.println("Error"+e.getMessage());
                }
    }
    
    public void CloseConnection() throws SQLException{
       this.Connection.close();
    }
    
    public ResultSet query (String query) throws SQLException{
        this.statement = (Statement) Connection.createStatement();
        return this.statement.executeQuery(query);
        
    }
    public void update(String update) throws SQLException{
        this.statement = (Statement) Connection.createStatement();
        this.statement.executeUpdate(update);
    }
   
    public void delete(String delete) throws SQLException{
        this.statement = (Statement) Connection.createStatement();
        this.statement.executeUpdate(delete);
        
    }
    
    public void insert(String insert) throws SQLException {
        this.statement = (Statement) Connection.createStatement();
        this.statement.executeUpdate(insert);
    }
        
    
    public CallableStatement procedure(String procedure) throws SQLException {
        return this.Connection.prepareCall(procedure);
    }
}
