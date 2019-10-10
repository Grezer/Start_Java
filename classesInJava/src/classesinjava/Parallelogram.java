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

public class Parallelogram extends Figure
{
    
    Parallelogram(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = this.getClass().getName().split("java.")[1];
    }
    public void draw(Graphics g) {
        int[] arrX = {x, (int)(x + width* 0.8), (x + width), (int)(x + width* 0.2), x};
        int[] arrY = {y, y, (y + height), (y + height), y};
        g.setColor(Color.BLACK);
        g.drawPolyline(arrX, arrY, 5);     
    }
    
    public double getPerimeter(){   
        double a = Math.sqrt(Math.pow((0.2 * width), 2.0) + Math.pow(height, 2.0));
        double P = 2 * a + 1.6 * height;
        return P;
    }
     
    public double getArea(){         
        return (0.6 * width * height) + (0.2 * width * height);
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
    
    public static Parallelogram fromJSON(JSONObject inputJSON){
        long x = (long)inputJSON.get("x");
        long y = (long)inputJSON.get("y");
        long width = (long)inputJSON.get("width");
        long height = (long)inputJSON.get("height");
        Parallelogram newFigure = new Parallelogram((int)x, (int)y, (int)width, (int)height); 
        return newFigure;
    }  
}
