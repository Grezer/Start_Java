/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesinjava;
import org.json.simple.JSONObject;

/**
 *
 * @author Grezer
 */
public class FigureCreator {
    
    static Figure fromJSON(JSONObject inputJSON) {  
        String type = (String)inputJSON.get("type");
        switch (type) {
           case  ("Circle"):
               return Circle.fromJSON(inputJSON);
            case  ("Parallelogram"):
               return Parallelogram.fromJSON(inputJSON);
            case  ("Rectangle"):
               return Rectangle.fromJSON(inputJSON);
            case  ("Rhombus"):
               return Rhombus.fromJSON(inputJSON);
            case  ("Triangle"):
               return Triangle.fromJSON(inputJSON);   
            default:
               return null;
        }
    }
        
    static JSONObject toJSON(Figure inputFigure) {
        switch (inputFigure.type) {
           case  ("Circle"):               
               return Circle.toJSON(inputFigure);
            case  ("Parallelogram"):
               return Parallelogram.toJSON(inputFigure);
            case  ("Rectangle"):
               return Rectangle.toJSON(inputFigure);
            case  ("Rhombus"):
               return Rhombus.toJSON(inputFigure);
            case  ("Triangle"):
               return Triangle.toJSON(inputFigure);   
            default:
               return null;
        }
    }         
}