package exercises;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Wic090345_e1 extends JFrame{ //Exercise1 inherits features (methods) of JFrame
    //declaration and initialization of instance variables of components
    public static void main (String [] args){
        new Wiuc090345_e1();
    }
    private JTextField field = new JTextField();
    private JButton addButton = new JButton("Add");
    private JButton clrButton = new JButton("Clear");
    private JList lstNames;
    private DefaultListModel model = new DefaultListModel();
    //The class's constructor
    public Wiuc090345_e1(){
        setTitle("Hello Swing Exercise"); //frame title
        setSize(500, 300); //frame size on default
        setDefaultCloseOperation(EXIT_ON_CLOSE); //operation when the X button is click
        addListeners(); // calls method that assigns functionalities to window's buttons
        createWindow(); // calls method to create components on window
        setVisible(true); // defines the window must be appear on the screen
    }
    // a method of class Wiuc090345_e1 that creates panels
    private void createWindow(){
        //The goal of the createLabel method over here is to create a margin of 10 
        //corresponding to the size of the components
        add(createLabel(), BorderLayout.NORTH); // calls createLabel to north
        add(createLabel(), BorderLayout.WEST); //calls createLabel to west
        add(createLabel(), BorderLayout.EAST); //calls createLabel to east
        add(createLabel(), BorderLayout.SOUTH); //calls createLabel to South
        JPanel panel = new JPanel(new BorderLayout());// panel, an instance of JPanel with a layout manager initilized
        panel.add(createTop(), BorderLayout.NORTH);// places createTop at the north of panel 
        panel.add(createBottom(), BorderLayout.SOUTH);//places createBottom at the north of panel
        panel.add(createCenter());
        add(panel); //places panel in the center of the window before adding createTop,Bottom,andCenter methods
    }
    // method of class Exercise1 called createLabel(); it defines the sizes of the labels
    private JLabel createLabel(){
        JLabel label = new JLabel(""); // label instance of class JLabel
        label.setPreferredSize(new Dimension(10, 10)); //the preferred size of the label
        return label; 
    }
    //the northern part of the window
    private JPanel createTop(){
        JPanel panel = new JPanel(new BorderLayout(10, 10)); //the parameters in the border layout specify spaces between components
        JLabel label = new JLabel("Enter a name: ");
        panel.add(label, BorderLayout.WEST); //label to the left(west)
        panel.add(addButton, BorderLayout.EAST);// button to the right(east)
        panel.add(field);//text field at the center
        return panel;
    }
    //the center of the window
    private JPanel createCenter(){
        lstNames = new JList(model);//data model which holds data to be displayed
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createLabel(), BorderLayout.NORTH);//creates empty space at the top
        panel.add(createLabel(), BorderLayout.SOUTH);//creates empty spcae at the bottom
        panel.add(new JScrollPane(lstNames));//places list box in the panel, encaplsulate with JScrollPane for scrolling
        return panel;
    }
    //creates the south panel
    private JPanel createBottom(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //aligns clear button component to the right bottom
        panel.add(clrButton);
        return panel;
    }
    private void addListeners(){
        addButton.addActionListener(new AddAction()); // addAddListener is a method of JButton class. 
        //this method refers to the instance variable of Exercise1, it is possible because AddAction is an inner class.
        clrButton.addActionListener(new ActionListener()// similar to the add button but functions differently, so
                //an anonymous class is created for a different function for the clear button.
        {public void actionPerformed(ActionEvent e){
            model.clear();
        }
        });
    }
    //events handler
    class AddAction implements ActionListener{ //a class AddAction that implements an interface ActionListener in a class Exercise1
        public void actionPerformed(ActionEvent e){//defines action to be performed
            String name = field.getText().trim();//obtain string from text field and assigns to name 
            if (name.length() > 0){ //checks if name is not empty
                model.addElement(name); //adds name to list box
                field.setText("");//clears the text field
                field.requestFocus();// set cursor on text field for the next name
            }
        }
        //AddAction implements the interface ActionListener means that an object of type AddAction
        //can be use as a listener of object button.
    }
}