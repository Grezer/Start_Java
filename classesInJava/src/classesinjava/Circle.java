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
        this.type = this.getClass().getSimpleName();        
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
        objectFigure.put("x", this.x);
        objectFigure.put("y", this.y);
        objectFigure.put("height", this.height);
        objectFigure.put("width", this.width);
        return objectFigure;   
    }
    
    public static Circle fromJSON(JSONObject inputJSON){
        long x = (long)inputJSON.get("x");
        long y = (long)inputJSON.get("y");
        long width = (long)inputJSON.get("width");
        long height = (long)inputJSON.get("height");
        Circle newFigure = new Circle((int)x, (int)y, (int)width, (int)height); 
        return newFigure;
    }
}