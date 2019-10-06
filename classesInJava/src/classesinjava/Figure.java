/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package classesinjava;
import java.awt.*;
import org.json.simple.JSONObject;
/**
*
* @author Grezer
*/
// абстрактный класс фигуры
abstract class Figure{
    String type;
    int x;
    int y;
    int width;
    int height;
    Figure(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public String getType() {
        return this.getClass().getName();
    }
    
    public abstract double getPerimeter();    
    public abstract double getArea();    
    public abstract void draw(Graphics g);
    public abstract JSONObject toJSON();  
    public abstract Figure fromJSON(JSONObject obj); 
}