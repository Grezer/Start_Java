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

public class Circle extends Figure
{
    Circle(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = this.getClass().getName();
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
}

class FigureCreator {
    static Figure fromJSON(String json) {
        if (json.type == "Triangle") {
            return Triangle.fromJSON(json);
        }
    }
}


[
    {
        "x": 93,
        "y": 102,
        "x2": 90,
        "y2": 99,
        "x3": 90,
        "y3": 99,
        "type": "Triangle"
    },
    "Figure 1: ": [
        "x: 211",
        "y: 233",
        "height: 71",
        "width: 326",
        "type: Parallelogram"
    ],
    "Figure 0: ": [
        "x: 146",
        "y: 106",
        "height: 139",
        "width: 215",
        "type: Circle"
    ]
]