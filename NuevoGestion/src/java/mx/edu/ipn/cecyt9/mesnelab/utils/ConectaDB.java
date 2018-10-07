package mx.edu.ipn.cecyt9.mesnelab.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adriana Islas Estrada
 */
public class ConectaDB {
    //Variables de conexion
    Connection con = null;
    Statement state;
    ResultSet res;
    
    public ConectaDB(){
        
    }
    public void conecta(){//Metodo para conectar
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost/Lab3","root","n0m3l0");
        System.out.println("Si conecta");
        
        }catch(Exception eeee){
            System.out.print("No conecta");
        }
    }
    public void cierra() throws SQLException{//Metodo para cerrar conexión
        con.close();
    }
    public Connection getConnection(){
        return con;
    }
    //Métodos para ejecutar sentencias SQL en la BD
    public int update(String update) throws SQLException{//Para hacer insert, update, o delete
        state = con.createStatement();
        return state.executeUpdate(update);
    }
    public ResultSet query(String query) throws SQLException{//Para hacer select
        state = con.createStatement();
        return state.executeQuery(query);
    }
}
