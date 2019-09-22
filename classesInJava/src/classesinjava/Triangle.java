/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesinjava;
import java.awt.*;

/**
*
* @author Grezer
*/

public class Triangle extends Figure
{
    Triangle(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = "Triangle";
    }
    
    public void draw(Graphics g) {
        int[] arrX = {x, width + x, (width/2) + x, x};
        int[] arrY = {height + y, height + y, y, height + y};
        g.setColor(Color.BLACK);
        g.drawPolyline(arrX, arrY, 4);        
    }
    
    public double getPerimeter(){         
        return Math.sqrt(Math.pow(height, 2.0) + Math.pow(width / 2, 2.0)) * 2 + width ;
    }
     
    public double getArea(){         
        return width / 2 + height;
    }
}