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

public class Triangle extends Figure
{
    int x2, y2, x3, y3;   

    Triangle(int x, int y, int x2, int y2, int x3, int y3){
        super(x,y);        
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.type = this.getClass().getSimpleName();
    }
    
    public void draw(Graphics g) {
        int[] arrX = {x, x2, x3, x};
        int[] arrY = {y, y2, y3, y};
        g.setColor(Color.BLACK);
        g.drawPolyline(arrX, arrY, 4); 
    }
    
    public static void drawLine(Graphics g, Point p0, Point p1) {
        int[] arrX = {p0.x, p1.x};
        int[] arrY = {p0.y, p1.y};
        g.setColor(Color.BLACK);
        g.drawPolyline(arrX, arrY, 2); 
    }
    
    public double getPerimeter(){   
        double L1 = Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
        double L2 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        double L3 = Math.sqrt(Math.pow((x - x3), 2) + Math.pow((y - y3), 2));
        return L1 + L2 + L3;
    }
     
    public double getArea(){       
        double area = Math.abs((x*(y2-y3)+x2*(y3-y)+x3*(y-y2))/2);
        return area;
    }
    
    public JSONObject toJSON(){
        JSONObject objectFigure = new JSONObject();
        objectFigure.put("x", this.x);
        objectFigure.put("y", this.y);
        objectFigure.put("x2", this.x2);
        objectFigure.put("y2", this.y2);
        objectFigure.put("x3", this.x3);
        objectFigure.put("y3", this.y3);
        return objectFigure;   
    }
    
   public static Triangle fromJSON(JSONObject inputJSON){
        long x = (long)inputJSON.get("x");
        long y = (long)inputJSON.get("y");
        long x2 = (long)inputJSON.get("x2");
        long y2 = (long)inputJSON.get("y2");
        long x3 = (long)inputJSON.get("x3");
        long y3 = (long)inputJSON.get("y3");
        Triangle newFigure = new Triangle((int)x, (int)y, (int)x2, (int)y2, (int)x3, (int)y3); 
        return newFigure;
    }   
}