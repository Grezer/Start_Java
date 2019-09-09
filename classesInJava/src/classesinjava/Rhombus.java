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
    private int width;
    private int height;

// конструктор с обращением к конструктору класса Figure
    Rhombus(int x, int y, int width, int height){
    super(x,y);
    this.width = width;
    this.height = height;
}
    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }    
}
