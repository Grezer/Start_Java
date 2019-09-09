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
    private int width;
    private int height;

// конструктор с обращением к конструктору класса Figure
    Triangle(int x, int y, int width, int height){
    super(x,y);
    this.width = width;
    this.height = height;
}
    public void draw(Graphics g) {
        int[] arrX = {0, width, (width/2), 0};
        int[] arrY = {height, height, 0, height};
        g.setColor(Color.BLACK);
        g.drawPolyline(arrX, arrY, 4);        
    }
}