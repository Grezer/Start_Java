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
    static Figure fromJSON(String inputJSON) {
        // parse here? yep
        // Parse JSON and create figure
        if (json.type == "Triangle") {
            return Triangle.fromJSON(json);
        }
    }
    
    static JSONObject toJSON(Figure inputFigure) {
        // Switch figure and create JSONobject
        if (json.type == "Triangle") {
            return Triangle.fromJSON(json);
        }
    }
}