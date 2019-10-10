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

public class Rectangle extends Figure
{    
    Rectangle(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = this.getClass().getName().split("java.")[1];
    }
    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }
    public double getPerimeter(){         
        return width * 2 + height * 2;
    }
     
    public double getArea(){         
        return width * height;
    }
    
    public JSONObject toJSON(){
        JSONObject objectFigure = new JSONObject();
        objectFigure.put("x", this.x);
        objectFigure.put("y", this.y);
        objectFigure.put("height", this.height);
        objectFigure.put("width", this.width);
        //objectFigure.put("type", inputFigure.getClass().getName().split("java.")[1]);
        return objectFigure;   
    }
    
    public static Rectangle fromJSON(JSONObject inputJSON){
        long x = (long)inputJSON.get("x");
        long y = (long)inputJSON.get("y");
        long width = (long)inputJSON.get("width");
        long height = (long)inputJSON.get("height");
        Rectangle newFigure = new Rectangle((int)x, (int)y, (int)width, (int)height); 
        return newFigure;
    }   
}