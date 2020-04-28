/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Celestine Akpanoko WIUC/09/0345
 */
public class Wiuc090345_e3 extends JFrame {
    public static void main (String[] args){
        new Wiuc090345_e3();
    }
    public Wiuc090345_e3(){
        setTitle("Font og farver");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //specifies frame should appear in the middle of the screen
        createWindow();
        setVisible(true);
    }// the 0s values are the width and height that are ignored but controlled by the frame
    private void createWindow(){
        add(createLabel("North", Color.blue, Color.white, new Font("Liberation Sans", Font.BOLD, 16), 0, 30),
                BorderLayout.NORTH);
        add(createLabel("South", Color.green, new Color(0, 50, 0), new Font("Liberation Serif", Font.BOLD, 36), 0, 50),
                BorderLayout.SOUTH);
        add(createLabel("West", Color.magenta, Color.white, new Font("Liberation Serif", Font.ITALIC, 48), 100, 0),
                BorderLayout.WEST);
        add(createLabel("East", Color.red, Color.yellow, new Font("Liberation Serif", Font.ITALIC, 24), 60, 0),
                BorderLayout.EAST);
        add(createLabel("Center", new Color(128, 120, 100), new Color(128, 128, 128), new Font("Liberation Serif", Font.BOLD, 96), 0, 0),
                BorderLayout.CENTER);
    }
    //over here label took 6 parameters for the (text, bg color, text color, font, width and height of each label
    private JLabel createLabel(String text, Color bg, Color fg, Font font, int width, int height){
        JLabel label = new JLabel(text);
        label.setOpaque(true); //label naturally appears transparent, so this helps to avoid that.
        label.setBackground(bg);
        label.setForeground(fg);
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(width, height));
        return label;
    }
}
