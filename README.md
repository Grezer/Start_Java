
# Рисовалка для фигур с возможностью сохранения и загрузки в формате JSON

---

## Где что лежит
В файле [Figure](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Figure.java) описан абстрактный класс для фигурок  
От него наследуются 5 классов: [Circle](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Circle.java), [Rectangle](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Rectangle.java), [Rhombus](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Rhombus.java), [Parallelogram](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Parallelogram.java) и [Triangle](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/Triangle.java)   
В [FileTypeFilter](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/FileTypeFilter.java) описан фильтр для форматов файла (нужен для окна сохранения файла)    
В [FigureCreator](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/FigureCreator.java) два метода для конвертации фигуры в формат JSON и обратно    
В [sqLite](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/sqLite.java) описаны методы для взаимодействия с БД
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
    
    public String getType() {
        return this.getClass().getName();
    }
    
    public abstract double getPerimeter();    
    public abstract double getArea();    
    public abstract void draw(Graphics g);
    public abstract JSONObject toJSON(); 
}
```
В этом классе также объявлены методы рисования и получения периметра и площади: ```getPerimeter(); getArea(); draw(Graphics g);``` 
Так же описаны методы получения типа фигуры ```getType();``` и конвертации в JSON объект ```toJSON();``` 

Для каждого типа фигур описан свой класс:
```java
public class Circle extends Figure
{
    Circle(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        this.type = this.getClass().getSimpleName();        
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
    
    public JSONObject toJSON(){
        JSONObject objectFigure = new JSONObject();
        objectFigure.put("x", this.x);
        objectFigure.put("y", this.y);
        objectFigure.put("height", this.height);
        objectFigure.put("width", this.width);
        return objectFigure;   
    }
    
    public static Circle fromJSON(JSONObject inputJSON){
        long x = (long)inputJSON.get("x");
        long y = (long)inputJSON.get("y");
        long width = (long)inputJSON.get("width");
        long height = (long)inputJSON.get("height");
        Circle newFigure = new Circle((int)x, (int)y, (int)width, (int)height); 
        return newFigure;
    }
}
```
---

## События 
Для рисования используем 5 JRadioButton объединённых в группу и три события на jPanel (mouseDragged, mousePressed, mouseReleased). А для треугольника ещё MouseClicked.
Все фигуры хранятся в глобальном списке ```ArrayList<Figure> listOfFigures = new ArrayList<Figure>();```

### mousePressed
Записываем координаты события в глобальную переменную ```Point start;``` и очищаем лейблы для периметра и площади.
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



### mouseMoved
В данном событии мы обрабатываем ситуацию возникающую при отрисовке треугольника (ведь он у нас особенный). Суть в том, что мы проверяем "а есть ли что то в стартовых точках start1 и start2?". 

Если в start2 ничего нет смотрим start1, а если есть, то рисуем треугольник от start1, start2 и координат курсора.

Если в start1 что то есть, а в start2 - ничего, тогда рисуем линию от start1 до курсора.

В конце рисуем все фигуры

```java
Graphics g = this.jPanel1.getGraphics();      
if(start2 != null) {
    jPanel1.removeAll();
    jPanel1.repaint();
    Triangle tri = new Triangle((int)start1.getX(), (int)start1.getY(), 
                    (int)start2.getX(), (int)start2.getY(), 
                    evt.getX(), evt.getY());
    tri.draw(g);
} else if (start1 != null){
    jPanel1.removeAll();
    jPanel1.repaint();
    Triangle.drawLine(g, start1, evt.getPoint());
}        
for (Figure i:listOfFigures) 
   i.draw(g);  
```
### mouseClicked
В данном событии мы обрабатываем ситуацию возникающую при клике мыши. 
Если в start1 ничего нет - записываем туда координаты клика.
Если в start2 ничего нет, но что то есть в start1 - записываем в start2 координаты клика.
Если и в start1 и в start2 что то есть - создаём новый треугольник по координатам из start1, start2 и курсора.
Затем обнуляем start1 и start2.
```java
if(start1 == null)
    start1 = new Point(evt.getPoint());
else if(start2 == null && start1 != null)
    start2 = new Point(evt.getPoint());
else
{
    Triangle tri = new Triangle((int)start1.getX(), (int)start1.getY(), 
                                (int)start2.getX(), (int)start2.getY(),
                                evt.getX(), evt.getY());
    jLabel5.setText("Perimetr: " + tri.getPerimeter());
    jLabel6.setText("Area: " + tri.getArea());     
    listOfFigures.add(tri); 
    start1 = start2 = null;
}  
```
---

## Сохранение и загрузка JSON
Для формирования и чтения JSON используется библиотека [JSON-Simple](https://code.google.com/archive/p/json-simple/downloads) версии 1.1.1  
Для подключения к проекту можно просто закинуть файлик .jar в папку с проектом  
Затем в NetBeans перейти в Файл -> Свойства  
Выбрать в дереве пункт "Библиотеки" и нажать "Добавить файл JAR/папку" и просто выбрать наш файлик

![addJar.png](https://github.com/Grezer/Start_Java/blob/master/addJar.png)



### Сохранение
Создаём массив JSON ```figureJSON ``` и для каждой фигуры в listOfFigures вызываем метод конвертирующий её в JSONObject.
Затем вызываем ```JFileChooser``` и пишем наш массив в созданный файлик.
```java
JSONArray figureJSON = new JSONArray();
for (Figure i:listOfFigures)    
    figureJSON.add(FigureCreator.toJSON(i));         
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
        pw.print(figureJSON.toJSONString());
        pw.close();
    } catch(Exception e) { }  
}   
```
Тут важный момент в 6 строчке   
Дело в том, что класса ```FileTypeFilter();``` в Java не существует  
Поэтому его надо [написать](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/FileTypeFilter.java) :)  

В итоге получается файлик в формате JSON
```
[
    {
        "x": 119,
        "width": 200,
        "y": 107,
        "type": "Circle",
        "height": 64
    },
    {
        "x": 216,
        "width": 147,
        "y": 94,
        "type": "Rhombus",
        "height": 155
    },
    {
        "x": 401,
        "y": 112,
        "y2": 211,
        "x2": 273,
        "y3": 254,
        "x3": 429,
        "type": "Triangle"
    }
]
```

### Загрузка
Призываем великий и ужасный ```JFileChooser``` и если диалог удался ```if (ret == JFileChooser.APPROVE_OPTION)``` идём удалять всё из listOfFigures и читать файлик.  
Далее объявляем парсер ```JSONParser parser = new JSONParser();``` и сохраняем фигурки в ```listOfFigures``` обернув всё в ```try catch```
```java
JFileChooser fileChooser = new JFileChooser();
int ret = fileChooser.showDialog(null, "Open File");                
if (ret == JFileChooser.APPROVE_OPTION) {
    listOfFigures.removeAll(listOfFigures);
    File file = fileChooser.getSelectedFile();  
    JSONParser parser = new JSONParser();
    try (FileReader reader = new FileReader(file))
    {
        Object obj = parser.parse(reader);
        JSONArray rootArray = (JSONArray) obj;
        Iterator figures = rootArray.iterator();
        while (figures.hasNext()) {                    
            JSONObject test = (JSONObject) figures.next();
            listOfFigures.add(FigureCreator.fromJSON(test));
        }
    } catch (Exception e) { System.out.println(e.getMessage()); }   
    jPanel1.removeAll();
    jPanel1.repaint(); 
    for (Figure i:listOfFigures) 
        i.draw(this.jPanel1.getGraphics());
}
```
В конце чистим панельку и рисуем все фигурки из списка

---
## Сохранение и загрузка в sqLite
### Установка и создание базы
Для того что бы sqLite заработал вам нужны только эти три [файла](https://github.com/Grezer/Start_Java/tree/master/sql)  
Я закинул их прямо в папку с проектом, и вам советую  
Далее запускаем sqlite3.exe  
Первым делом открываем базу командой .open (если базы нет, то она создаётся) и создаём таблички  
.headers on включает отображение заголовков, а .mode column или line задаёт стиль отображения ответов  
![sql.png](https://github.com/Grezer/Start_Java/blob/master/sql.png)
Для обращения к базе из java нужен [драйвер](https://github.com/Grezer/Start_Java/tree/master/classesInJava/src/classesinjava/SQLLite)  
Он ставится так же как и JSON-Simple

### Методы
Метод создающий соединение с файлом БД и передающий его в глобальную переменную ```Connection Con;```
```java
public void getCon() {
	try{
	     Class.forName("org.sqlite.JDBC");
	     Con = DriverManager.getConnection (
	     "jdbc:sqlite:C:\\Users\\pc\\Desktop\\Учёба\\Java\\classesInJava\\src\\classesinjava\\figures.db");
	     System.out.println("Connected");
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
}
```

Метод закрывающий соединение
```java
public void close() {
	try{
	    Con.close();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
}
```
Метод получающий массив названий картинок
```java
public ArrayList<String> getPicturesName() {
    try{
        ArrayList<String> pictureNames = new ArrayList<String>();
        getCon();
        Statement statement = Con.createStatement();
        String query  = "SELECT name "
                      + "FROM Pictures";            
        ResultSet result = statement.executeQuery(query);
        while(result.next()){
            pictureNames.add(result.getString("name"));
        }
        close();
        return pictureNames;         
    } catch (Exception e){
        System.out.println("Here "  + e.getMessage());
        return null;
    }        
}
```
Получение картинки
```java
public String getPicture(String name) {
public String getPicture(String name) {
    try{
        getCon();
        String Picture;
        Statement statement = Con.createStatement();
        String query  = "SELECT jsonFigures "
                      + "FROM Pictures WHERE name = '" + name + "'";            
        ResultSet result = statement.executeQuery(query);  
        Picture = result.getString("jsonFigures");
        close();
        return Picture;         
    } catch (Exception e){
        System.out.println(e.getMessage());
        return null;
    }        
}
```
Метод сохраняющий картинки в бд
```java
public void savePicture(String name, String jsonFigures){
    try{            
        getCon();
        String query  = "INSERT INTO Pictures (name, jsonFigures) "
                      + "VALUES ('" + name + "', '" + jsonFigures + "')";
        Statement statement = Con.createStatement();
        statement.executeUpdate(query);
        close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
```
Обращение к этим методам смотрите [тут](https://github.com/Grezer/Start_Java/blob/master/classesInJava/src/classesinjava/NewJFrame.java)
