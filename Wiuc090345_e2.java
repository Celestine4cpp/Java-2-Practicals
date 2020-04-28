/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Celestine Akpanoko WIUC/09/0345
 */
public class Wiuc090345_e2 extends JFrame {
    public static void main (String [] args){
        new Wiuc090345_e2();
    }
    private JTextField field1 = new JTextField(10);
    private JTextField field2 = new JTextField(10);
    private JButton addB = new JButton("+");
    private JButton subB = new JButton("-");
    private JButton mulB = new JButton("*");
    private JButton divB = new JButton("/");
    private JButton clrB = new JButton("Clear");
    private JList list = new JList();
    private DefaultListModel model = new DefaultListModel();

   public Wiuc090345_e2(){
        setTitle("Netbeans Calculator");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(new Dimension(500, 310));
       createGUI();
       addListeners();
       setVisible(true);
   }
   private void createGUI(){
      JPanel panel = new JPanel(new BorderLayout(5,5));
      panel.setBorder(new EmptyBorder(10,10,10,10));
      panel.add(createTop(), BorderLayout.NORTH);
      panel.add(createBottom(), BorderLayout.SOUTH);
      panel.add(createCenter());
      add(panel);
   } 
   private JPanel operators(){
       JPanel panel = new JPanel(new FlowLayout());
       panel.add(addB);
       panel.add(subB);
       panel.add(mulB);
       panel.add(divB);
       return panel;
   }
   private JPanel textField(){
       JPanel panel = new JPanel(new GridLayout(1,2,10,0));
       panel.add(field1);
       panel.add(field2);
       return panel;
   }
   private JPanel createTop(){
       JPanel panel = new JPanel(new BorderLayout(10,10));
       panel.add(textField());
       panel.add(operators(), BorderLayout.EAST);
       return panel;
   }
   private JPanel createBottom(){
       JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       panel.add(clrB);
       return panel;
   }
   private JPanel createCenter(){
       JList list = new JList(model);
       JPanel panel = new JPanel(new BorderLayout());
       panel.add(new JScrollPane(list));
       return panel;
   }
   private void addListeners(){
       addB.addActionListener((ActionEvent e)->{
            String txtVal1 = field1.getText().trim();//obtain string from text field and assigns to name 
            String txtVal2 = field2.getText().trim();
            try{
            if (txtVal1.length() > 0 && txtVal2.length() > 0){ //checks if name is not empty
                double val1 = Double.parseDouble(txtVal1);
                double val2 = Double.parseDouble(txtVal2);
    
                    double addAns = val1 + val2;
                
                model.addElement(txtVal1 +" + " +txtVal2 +" = "+addAns); //displays on list box
                field1.setText("");//clears the text field
                field2.setText("");
                field1.requestFocus();// set cursor on text field for the next name
                field2.requestFocus();
                }
            }
            catch(NumberFormatException a){
                 model.addElement("Please input real numbers, "+a+" is not a real number.");
                 field1.setText("");//clears the text field
                field2.setText("");
                field1.requestFocus();// set cursor on text field for the next name
                field2.requestFocus();
            }
       });
          subB.addActionListener((ActionEvent e)->{
            String txtVal1 = field1.getText().trim();//obtain string from text field and assigns to name 
            String txtVal2 = field2.getText().trim();
            try{
            if (txtVal1.length() > 0 && txtVal2.length() > 0){ //checks if name is not empty
                double val1 = Double.parseDouble(txtVal1);
                double val2 = Double.parseDouble(txtVal2);
    
                    double subAns = val1 - val2;
                
                model.addElement(txtVal1 +" - " +txtVal2 +" = "+subAns); //displays on list box
                field1.setText("");//clears the text field
                field2.setText("");
                field1.requestFocus();// set cursor on text field for the next name
                field2.requestFocus();
                }
            }
            catch(NumberFormatException a){
                 model.addElement("Please input real numbers, "+a+" is not a real number.");
                 field1.setText("");//clears the text field
                field2.setText("");
                field1.requestFocus();// set cursor on text field for the next name
                field2.requestFocus();
            }
       });
             mulB.addActionListener((ActionEvent e)->{
            String txtVal1 = field1.getText().trim();//obtain string from text field and assigns to name 
            String txtVal2 = field2.getText().trim();
            try{
            if (txtVal1.length() > 0 && txtVal2.length() > 0){ //checks if name is not empty
                double val1 = Double.parseDouble(txtVal1);
                double val2 = Double.parseDouble(txtVal2);
    
                    double mulAns = val1 * val2;
                
                model.addElement(txtVal1 +" * " +txtVal2 +" = "+mulAns); //displays on list box
                field1.setText("");//clears the text field
                field2.setText("");
                field1.requestFocus();// set cursor on text field for the next name
                field2.requestFocus();
                }
            }
            catch(NumberFormatException a){
                model.addElement("Please input real numbers, "+a+" is not a real number.");
                field1.setText("");//clears the text field
                field2.setText("");
                field1.requestFocus();// set cursor on text field for the next name
                field2.requestFocus();
            }
       });
                divB.addActionListener((ActionEvent e)->{
            String txtVal1 = field1.getText().trim();//obtain string from text field and assigns to name 
            String txtVal2 = field2.getText().trim();
            try{
            if (txtVal1.length() > 0 && txtVal2.length() > 0){ //checks if name is not empty
                double val1 = Double.parseDouble(txtVal1);
                double val2 = Double.parseDouble(txtVal2);
    
                    double divAns = val1 / val2;
                
                model.addElement(txtVal1 +" / " +txtVal2 +" = "+divAns); //displays on list box
                field1.setText("");//clears the text field
                field2.setText("");
                field1.requestFocus();// set cursor on text field for the next name
                field2.requestFocus();
                }
            }
            catch(NumberFormatException a){
                 model.addElement("Please input real numbers, "+a+" is not a real number.");
                 field1.setText("");//clears the text field
                field2.setText("");
                field1.requestFocus();// set cursor on text field for the next name
                field2.requestFocus();
            }
       });
                clrB.addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(Exercise2.this, 
                "Are you sure you want to delete this?","Warning",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)  == JOptionPane.YES_OPTION)model.clear();
   });
   }
   
}
