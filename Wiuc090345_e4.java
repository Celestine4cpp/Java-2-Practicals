/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.stream.IntStream;
import javax.lang.model.element.Name;
import javax.swing.*;
/**
 *
 * @author Celestine Akpanoko WIUC/09/0345
 */
public class Wiuc090345_e4 extends JDialog {
    private DefaultListModel model;
    private JTextField firstName = new JTextField();
    private JTextField lastName = new JTextField();
    
 
    
    public Wiuc090345_e4(DefaultListModel model){
        super(null, "Enter a name", Dialog.ModalityType.APPLICATION_MODAL);
        this.model = model;
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        createView();
        setVisible(true);
        
    }
    private void createView(){
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout(0, 20));
        panel.setBorder(new EmptyBorder(20,20,20,20));
        panel.add(createTop(), BorderLayout.NORTH);
        panel.add(createBottom());
        add(panel);
    }
    private JPanel createTop(){
        JPanel panel = new JPanel(new GridLayout(2,1,0,10));
        panel.add(createLine("First Name", firstName));
        panel.add(createLine("Last Name", lastName));
        return panel;
    }
    private JPanel createBottom(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0,0));
        panel.add(createButton("OK", 90, 25, this::ok));
        panel.add(createSpace());
        panel.add(createButton("Close", 90, 25, this::close));
        return panel;
        
    }
    private JPanel createLine(String text, JTextField field){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(90, 22));
        panel.add(label, BorderLayout.WEST);
        panel.add(field);
        return panel;
    }
    private JButton createButton(String text, int width, int height, ActionListener listener){
        JButton btn = new JButton(text);
        btn.addActionListener(listener);
        btn.setPreferredSize(new Dimension(width, height));
        return btn;
    }
    private JLabel createSpace(){
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(10,20));
        return label;
    }
    private void clear(){
        firstName.setText("");
        lastName.setText("");
        firstName.requestFocus();
        
    }
    private void ok(ActionEvent e){
        String fname = firstName.getText().trim();
        String lname = lastName.getText().trim();
        if (fname.length() > 0 && lname.length() > 0){
            model.addElement(new NameImpl(fname, lname));
            clear();
        }
        else{
            JOptionPane.showMessageDialog(this, "You must enter both first and last name", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void close(ActionEvent e){
        dispose();
    }

    private static class NameImpl implements Name {

        public NameImpl() {
        }

        private NameImpl(String fname, String lname) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int length() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public char charAt(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public CharSequence subSequence(int i, int i1) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean contentEquals(CharSequence cs) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public IntStream chars() {
            return Name.super.chars(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public IntStream codePoints() {
            return Name.super.codePoints(); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
    


