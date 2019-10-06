/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package classesinjava;
import java.awt.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
*
* @author Grezer
*/

public class Circle extends Figure
{
    Circle(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = this.getClass().getName().split("java.")[1];        
    }
    
    public void draw(Graphics g) {
        g.drawOval(x, y, width, height);
    }
    
    public double getPerimeter(){  
        return 2 * Math.PI * Math.sqrt((width ^ 2 + height ^ 2)/8);
    }
     
    public double getArea(){         
        return Math.PI * (width / 2 + height / 2);
    }
    
    public JSONObject toJSON(){
        JSONObject objectFigure = new JSONObject();
        objectFigure.put("x", x);
        objectFigure.put("y", y);
        objectFigure.put("height", height);
        objectFigure.put("width", width);
        objectFigure.put("type", getClass().getName().split("java.")[1]);
        return objectFigure;   
    }
    
    public Circle fromJSON(JSONObject obj){
        Circle newFigure = new Circle(Integer.parseInt((String)obj.get("x")), 
                Integer.parseInt((String)obj.get("y")), 
                Integer.parseInt((String)obj.get("width")), 
                Integer.parseInt((String)obj.get("height")));
        return newFigure;
    }
}