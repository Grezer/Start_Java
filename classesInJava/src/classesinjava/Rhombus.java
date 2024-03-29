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

public class Rhombus  extends Figure
{   
    Rhombus(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = this.getClass().getSimpleName();
    }
    
    public void draw(Graphics g) {
        int[] arrX = {(int)(x + width * 0.5), (x + width), (int)(x + width * 0.5), x, (int)(x + width * 0.5)};
        int[] arrY = {y, (int)(y + height * 0.5), (y + height), (int)(y + height * 0.5), y};
        g.setColor(Color.BLACK);
        g.drawPolyline(arrX, arrY, 5);     
    }

    public double getPerimeter(){         
        return Math.sqrt(Math.pow(width / 2, 2.0) + Math.pow(height / 2, 2.0)) * 4;
    }
     
    public double getArea(){         
        return width * height / 2;
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
    
    public static Rhombus fromJSON(JSONObject inputJSON){
        long x = (long)inputJSON.get("x");
        long y = (long)inputJSON.get("y");
        long width = (long)inputJSON.get("width");
        long height = (long)inputJSON.get("height");
        Rhombus newFigure = new Rhombus((int)x, (int)y, (int)width, (int)height); 
        return newFigure;
    }   
}
