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

public class Rhombus  extends Figure
{   
    Rhombus(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = this.getClass().getName().split("java.")[1];
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
}
