/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
/**
 *
 * @author Ledesba
 */
public class MainView extends JFrame implements CloseListener{
    interface CloseListener{
        public void dialogClosed();
    }
   private DefaultListModel model = new DefaultListModel();
   private JButton btnShow;
   
   public MainView(){
       setTitle("Dialogs");
       setSize(200, 160);
       setResizable(false);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       createWindow();
       setVisible(true);
   }
   private void createWindow(){
       JPanel panel = new JPanel(new GridLayout(2,1,0,20));
       panel.setBorder(new EmptyBorder(20, 20, 20, 20));
       panel.add(createButton("Enter a name", this::openEnter));
       panel.add(btnShow = createButton("Open list", this::openShow));
       
   }
   private JButton createButton(String text, ActionListener listener){
       JButton btn = new JButton(text);
       btn.addActionListener(listener);
       return btn;
   }
   private void openEnter(ActionEvent e){
      new Exercise4(model); 
   }
   private void openShow(ActionEvent e){
       btnShow.setEnabled(false);
       new ShowView(model, (CloseListener) this);
   }
   public void dialogClosed(){
       btnShow.setEnabled(true);
   }
    
}
