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

public class Rectangle extends Figure
{    
    Rectangle(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = "Rectangle";
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
}