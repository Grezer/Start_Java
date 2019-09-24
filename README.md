# Рисовалка для фигур с возможностью сохранения и загрузки в формате JSON

---

## Где что лежит
В файле [Figure](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Figure.java) описан абстрактный класс для фигурок  
От него наследуются 5 классов: [Circle](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Circle.java), [Rectangle](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Rectangle.java), [Rhombus](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Rhombus.java), [Parallelogram](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Parallelogram.java) и [Triangle](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Triangle.java)   
В [FileTypeFilter](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/FileTypeFilter.java) описан фильтр для форматов файла (нужен для окна сохранения файла)  
Ну и в [NewJFrame](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/NewJFrame.java) вся логика

---

## Классы
Для фигур есть абстрактный класс Figure, описывающий общие свойства фигур (координаты, высота, ширина и тип).
```java
abstract class Figure{
    String type;
    int x;
    int y;
    int width;
    int height;
    Figure(int x, int y){
        this.x=x;
        this.y=y;
    }
    public abstract double getPerimeter();    
    public abstract double getArea();    
    public abstract void draw(Graphics g);
}
```
В этом класе также объявлены методы рисования и получения периметра и площади: ```getPerimeter(); getArea(); draw(Graphics g);``` 

Для каждого типа фигур описан свой класс:
```java
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
```
---

## События 
Для рисования используем 5 JRadioButton объединённых в группу кнопок и три события на jPanel (mouseDragged, mousePressed, mouseReleased).
Все фигуры хранятся в глобальном списке ```ArrayList<Figure> listOfFigures = new ArrayList<Figure>();```

### mousePressed
Записываем координаты события в глобальную переменную ```Point start;``` и очищем лейблы для периметра и площади.
### mouseDragged
Получаем тип фигуры  ```String nowFigure  = buttonGroup1.getSelection().getActionCommand();``` 
Затем очищаем jPanel и рисуем все фигуры заново:
```java
for (Figure i:listOfFigures) 
    i.draw(g); 
```
После чего определяем тип фигуры и рисуем его:
```java
switch(nowFigure) {
    case "Circle":
        Circle cir = new Circle((int)Math.min(start.getX(), evt.getX()), 
                        (int)Math.min(start.getY(), evt.getY()),
                        (int)Math.abs(start.getX() - evt.getX()), 
                        (int)Math.abs(start.getY() - evt.getY()));
        cir.draw(g);
        jLabel5.setText("Perimetr: " + cir.getPerimeter());
        jLabel6.setText("Area: " + cir.getArea());  
    break;
    case "Rectangle":
    ...
    break;
        default:           
} 
```
### mouseReleased
В принципе здесь всё тоже самое что и в mouseDragged, только вместо отрисовки новой фигуры она добавляется в список фигур:
```java
listOfFigures.add(tri);  
```
И отрисовка всех фигур происходит в конце метода

---

## Сохранение и загрузка JSON
Для формирования и чтения JSON используется библиотека [JSON-Simple](https://code.google.com/archive/p/json-simple/downloads) версии 1.1.1  
Для подключения к проекту можно просто закинуть файлик .jar в папку с проектом  
Затем в NetBeans перейти в Файл -> Свойства  
Выбрать в дереве пункт "Библиотеки" и нажать "Добавить файл JAR/папку" и просто выбрать наш файлик

![addJar.png](https://github.com/Grezer/Start_Java/blob/master/addJar.png)



### Сохранение
Создаём объект JSON ```objectFigure``` и для каждой фигуры формируем массив ```figureJSON```  
Заполняем его свойствами фигуры после чего пихаем массив в наш объект и даём ему имя ```objectFigure.put("Figure " + iterator + ": ", figureJSON);```  
Затем вызываем ```JFileChooser``` и пишем наш объект в созданный файлик  
```java
JSONObject objectFigure = new JSONObject();
int iterator = 0;
for (Figure i:listOfFigures) {
    JSONArray figureJSON = new JSONArray();
    figureJSON.add("x: " + i.x);
    figureJSON.add("y: " + i.y);
    figureJSON.add("height: " + i.height);
    figureJSON.add("width: " + i.width);
    figureJSON.add("type: " + i.type);      
    objectFigure.put("Figure " + iterator + ": ", figureJSON);
    iterator++;
}           
JFileChooser fileChooser = new  JFileChooser();
fileChooser.setDialogTitle("Save file");    
fileChooser.setFileFilter(new FileTypeFilter(".json", "JSON format"));
int result = fileChooser.showSaveDialog(null);
if (result == JFileChooser.APPROVE_OPTION){
    File file = fileChooser.getSelectedFile();
    try{            
        if(!file.exists()) 
            file.createNewFile();
        PrintWriter pw = new PrintWriter(file);
        pw.print(objectFigure.toJSONString());
        pw.close();
    } catch(Exception e) { }  
}   
```
Тут важный момент в 15 строчке   
Дело в том, что класса ```FileTypeFilter();``` у нас не существует  
Поэтому его надо написать :)  
```java
package classesinjava;
import java.io.File;
import javax.swing.filechooser.*;

public class FileTypeFilter extends FileFilter{
    private final String extension;
    private final String description;
    
    public FileTypeFilter(String extension, String description){
        this.extension = extension;
        this.description = description;
    }
    
    @Override
    public boolean accept(File file){
        if (file.isDirectory())
            return true;
        return file.getName().endsWith(extension);
    }
    
    @Override
    public String getDescription(){
        return description + String.format(" (*%s)", extension);
    }
}
```

В итоге получается файлик в формате JSON
```
{
    "Figure 2: ": [
        "x: 93",
        "y: 102",
        "height: 90",
        "width: 99",
        "type: Rectangle"
    ],
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
}
```

### Загрузка
Призываем великий и ужасный ```JFileChooser``` и если диалог удался ```if (ret == JFileChooser.APPROVE_OPTION)``` идём читать файлик и объявляем парсер
```java
File file = fileChooser.getSelectedFile();  
JSONParser parser = new JSONParser();
```
Затем парсим и сохраняем фигурки в ```listOfFigures``` обернув всё в ```try catch```
```java
try (FileReader reader = new FileReader(file))
{
    Object obj = parser.parse(reader);
    JSONObject rootElement = (JSONObject) obj;
    for (int numFigure = 0; numFigure < rootElement.size(); numFigure++) {
        int newX = 0;
        int newY = 0;
        int newWidth = 0;
        int newHight = 0;
        String newType = "";   
    JSONArray figureJSON = (JSONArray) rootElement.get("Figure " + numFigure + ": ");  
    Iterator properties = figureJSON.iterator();
    while (properties.hasNext()) {
        String test = (String) properties.next();
        if(test.charAt(0) == 'x') 
            newX = Integer.parseInt(test.split(" ")[1]); 
        if(test.charAt(0) == 'y') 
            newY = Integer.parseInt(test.split(" ")[1]);
        if(test.charAt(0) == 'h') 
            newHight = Integer.parseInt(test.split(" ")[1]);
        if(test.charAt(0) == 'w') 
            newWidth = Integer.parseInt(test.split(" ")[1]);
        if(test.charAt(0) == 't') 
            newType = test.split(" ")[1];                                                   
    }
    // add to list
    switch(newType) {
        case "Circle":
            Circle cir = new Circle(newX, newY, newWidth, newHight); 
            listOfFigures.add(cir);
        break;            
        case "Rectangle":
            Rectangle rec = new Rectangle(newX, newY, newWidth, newHight);
            listOfFigures.add(rec);
        break;
        case "Rhombus":
            Rhombus rmb = new Rhombus(newX, newY, newWidth, newHight);
            listOfFigures.add(rmb);
        break;
        case "Parallelogram":
            Parallelogram par = new Parallelogram(newX, newY, newWidth, newHight);
            listOfFigures.add(par);
        break;
        case "Triangle":
            Triangle tri = new Triangle(newX, newY, newWidth, newHight);
            listOfFigures.add(tri);
        break;
      default:           
    }
  }                
} catch (Exception e) { System.out.println(e.getMessage()); }
```
Далее чистим панельку и рисуем все фигурки из списка
```java
jPanel1.removeAll();
jPanel1.repaint(); 
for (Figure i:listOfFigures) 
    i.draw(this.jPanel1.getGraphics());
```
Глянуть как это всё работает можно [тут](https://www.youtube.com/watch?v=GoMTOFjzfdg)
