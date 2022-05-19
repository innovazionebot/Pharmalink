import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui implements ActionListener{
    private int count=0;
    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    public Gui(){
        frame = new JFrame();
        JButton button = new JButton("Button");
        button.addActionListener(this);
        label = new JLabel("Numero di click: 0");
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setTitle("Pharmalink");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String args[]){
        new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        count++;
        label.setText("Numero di click: " + count);
    }
}