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
// абстрактный класс фигуры
abstract class Figure{
    int x;
    int y;
    Figure(int x, int y){
        this.x=x;
        this.y=y;
    }

    public abstract double getPerimeter();    
    public abstract double getArea();    
    public abstract void draw(Graphics g);
}