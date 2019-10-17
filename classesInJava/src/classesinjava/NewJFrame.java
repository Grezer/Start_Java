/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesinjava;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author Grezer
 */
public class NewJFrame extends javax.swing.JFrame {    
    Point start;
    Point start1; // for trianle
    Point start2; // for trianle
    ArrayList<Figure> listOfFigures = new ArrayList<Figure>();
      
    public NewJFrame() {
        initComponents();
        jRadioButton1.setActionCommand("Circle");
        jRadioButton2.setActionCommand("Rectangle");
        jRadioButton3.setActionCommand("Rhombus");
        jRadioButton4.setActionCommand("Parallelogram");
        jRadioButton5.setActionCommand("Triangle");         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        jButton2.setText("Сlear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("-");

        jLabel6.setText("-");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setLabel("Circle");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setLabel("Rectangle");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setLabel("Rhombus");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setActionCommand("фыв");
        jRadioButton4.setLabel("Parallelogram");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setLabel("Triangle");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Load");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton4.setText("Save in DB");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Get pictures");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Load");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton5))
                            .addComponent(jRadioButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 29, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41)))
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton5)
                            .addComponent(jButton1)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton4)
                            .addComponent(jLabel6)
                            .addComponent(jButton3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listOfFigures.removeAll(listOfFigures);
        jPanel1.removeAll();
        jPanel1.repaint(); 
        jLabel5.setText("-");
        jLabel6.setText("-");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        start = new Point(evt.getX(), evt.getY());    
        jLabel5.setText("-");
        jLabel6.setText("-");        
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        Graphics g = this.jPanel1.getGraphics(); 
        String nowFigure  = buttonGroup1.getSelection().getActionCommand();        
        switch(nowFigure) {
            case "Circle":
                Circle cir = new Circle((int)Math.min(start.getX(), evt.getX()), 
                                (int)Math.min(start.getY(), evt.getY()),
                                (int)Math.abs(start.getX() - evt.getX()), 
                                (int)Math.abs(start.getY() - evt.getY()));
                jLabel5.setText("Perimetr: " + cir.getPerimeter());
                jLabel6.setText("Area: " + cir.getArea());  
                listOfFigures.add(cir);
                start = null;                
            break;            
            case "Rectangle":
                Rectangle rec = new Rectangle((int)Math.min(start.getX(), evt.getX()), 
                                (int)Math.min(start.getY(), evt.getY()),
                                (int)Math.abs(start.getX() - evt.getX()), 
                                (int)Math.abs(start.getY() - evt.getY()));
                jLabel5.setText("Perimetr: " + rec.getPerimeter());
                jLabel6.setText("Area: " + rec.getArea()); 
                listOfFigures.add(rec);  
                start = null;
            break;
            case "Rhombus":
                Rhombus rmb = new Rhombus((int)Math.min(start.getX(), evt.getX()), 
                                (int)Math.min(start.getY(), evt.getY()),
                                (int)Math.abs(start.getX() - evt.getX()), 
                                (int)Math.abs(start.getY() - evt.getY()));
                jLabel5.setText("Perimetr: " + rmb.getPerimeter());
                jLabel6.setText("Area: " + rmb.getArea()); 
                listOfFigures.add(rmb);  
                start = null;                
            break;
            case "Parallelogram":
                Parallelogram par = new Parallelogram((int)Math.min(start.getX(), evt.getX()), 
                                (int)Math.min(start.getY(), evt.getY()),
                                (int)Math.abs(start.getX() - evt.getX()), 
                                (int)Math.abs(start.getY() - evt.getY()));
                jLabel5.setText("Perimetr: " + par.getPerimeter());
                jLabel6.setText("Area: " + par.getArea());
                start = null;
                listOfFigures.add(par);                 
            break;   
          default:           
        }          
        for (Figure i:listOfFigures) 
            i.draw(g);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        Graphics g = this.jPanel1.getGraphics(); 
        String nowFigure  = buttonGroup1.getSelection().getActionCommand();     
        jPanel1.removeAll();
        jPanel1.repaint(); 
        for (Figure i:listOfFigures) 
           i.draw(g); 

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
                Rectangle rec = new Rectangle((int)Math.min(start.getX(), evt.getX()), 
                                (int)Math.min(start.getY(), evt.getY()),
                                (int)Math.abs(start.getX() - evt.getX()), 
                                (int)Math.abs(start.getY() - evt.getY()));
                rec.draw(g);
                jLabel5.setText("Perimetr: " + rec.getPerimeter());
                jLabel6.setText("Area: " + rec.getArea());
            break;
            case "Rhombus":
                Rhombus rmb = new Rhombus((int)Math.min(start.getX(), evt.getX()), 
                                (int)Math.min(start.getY(), evt.getY()),
                                (int)Math.abs(start.getX() - evt.getX()), 
                                (int)Math.abs(start.getY() - evt.getY()));
                rmb.draw(g);
                jLabel5.setText("Perimetr: " + rmb.getPerimeter());
                jLabel6.setText("Area: " + rmb.getArea()); 
            break;
            case "Parallelogram":
                Parallelogram par = new Parallelogram((int)Math.min(start.getX(), evt.getX()), 
                                (int)Math.min(start.getY(), evt.getY()),
                                (int)Math.abs(start.getX() - evt.getX()), 
                                (int)Math.abs(start.getY() - evt.getY()));
                par.draw(g);
                jLabel5.setText("Perimetr: " + par.getPerimeter());
                jLabel6.setText("Area: " + par.getArea());
            break;
          default:           
        }  
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        //Супер костыль, что бы нормально рисовалось
        //Можешь закоментить и посмотреть чё будет
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
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Save to JSON file
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Load from JSON file
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // Monitoring mouse clicks for a triangle
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
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Save picture to data base
        String name = jTextField1.getText();
        JSONArray figureJSON = new JSONArray();
        for (Figure i:listOfFigures)    
            figureJSON.add(FigureCreator.toJSON(i));        
        sqLite mySqLiteClass= new sqLite();
        String jsonFiures = figureJSON.toString();        
        mySqLiteClass.savePicture(name, jsonFiures);
        jList1.removeAll();    
        ArrayList<String> pictureNames = mySqLiteClass.getPicturesName();        
        DefaultListModel DLM = new DefaultListModel();
        pictureNames.forEach(x -> DLM.addElement(x));
        jList1.setModel(DLM);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Get pictures name from data base
        jList1.removeAll();
        sqLite mySqLiteClass= new sqLite();        
        ArrayList<String> pictureNames = mySqLiteClass.getPicturesName();        
        DefaultListModel DLM = new DefaultListModel();
        pictureNames.forEach(x -> DLM.addElement(x));
        jList1.setModel(DLM);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // load picture from data base
        try{
            listOfFigures.removeAll(listOfFigures);
            String name = jList1.getSelectedValue();
            sqLite mySqLiteClass= new sqLite();
            String reader = mySqLiteClass.getPicture(name);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONArray rootArray = (JSONArray) obj;
            Iterator figures = rootArray.iterator();
            while (figures.hasNext()) {                    
                JSONObject test = (JSONObject) figures.next();
                listOfFigures.add(FigureCreator.fromJSON(test));
            }
            jPanel1.removeAll();
            jPanel1.repaint();  
            for (Figure i:listOfFigures) 
                i.draw(jPanel1.getGraphics());            
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_jButton6ActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {       
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
