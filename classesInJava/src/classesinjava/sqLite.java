/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesinjava;
import java.sql.*;
import java.util.*;

/**
 *
 * @author pc
 */

public class sqLite {    
    Connection Con;
    public void getCon() {
        try{
             Class.forName("org.sqlite.JDBC");
             Con = DriverManager.getConnection (
             "jdbc:sqlite:C:\\Users\\pc\\Desktop\\Учёба\\Java\\classesInJava\\src\\classesinjava\\figures.db");
             System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void close() {
        try{
            Con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String> getPicturesName() {
        try{
            ArrayList<String> pictureNames = new ArrayList<String>();
            getCon();
            Statement statement = Con.createStatement();
            String query  = "SELECT name "
                          + "FROM Pictures";            
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                pictureNames.add(result.getString("name"));
            }
            close();
            return pictureNames;         
        } catch (Exception e){
            System.out.println("Here "  + e.getMessage());
            return null;
        }        
    }
    
    public String getPicture(String name) {
        try{
            getCon();
            String Picture;
            Statement statement = Con.createStatement();
            String query  = "SELECT jsonFigures "
                          + "FROM Pictures WHERE name = '" + name + "'";            
            ResultSet result = statement.executeQuery(query);  
            Picture = result.getString("jsonFigures");
            close();
            return Picture;         
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }        
    }
    
    public void savePicture(String name, String jsonFigures){
        try{            
            getCon();
            String query  = "INSERT INTO Pictures (name, jsonFigures) "
                          + "VALUES ('" + name + "', '" + jsonFigures + "')";
            Statement statement = Con.createStatement();
            statement.executeUpdate(query);
            close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
