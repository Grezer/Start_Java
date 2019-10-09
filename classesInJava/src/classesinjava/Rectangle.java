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
    
    public static JSONObject toJSON(Figure inputFigure){
        JSONObject objectFigure = new JSONObject();
        objectFigure.put("x", inputFigure.x);
        objectFigure.put("y", inputFigure.y);
        objectFigure.put("height", inputFigure.height);
        objectFigure.put("width", inputFigure.width);
        objectFigure.put("type", inputFigure.getClass().getName().split("java.")[1]);
        return objectFigure;   
    }
    
    public static Rectangle fromJSON(JSONObject inputJSON){
        Rectangle newFigure = new Rectangle(Integer.parseInt((String)inputJSON.get("x")), 
                Integer.parseInt((String)inputJSON.get("y")), 
                Integer.parseInt((String)inputJSON.get("width")), 
                Integer.parseInt((String)inputJSON.get("height")));
        return newFigure;
    }    
}