package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddFlights {
    public AddFlights(){
        JFrame f=new JFrame("ADD FLIGHTS");
        JLabel bg, l1,l2,l3,l4,l5;
        bg=new JLabel(new ImageIcon("src/pics/login.jpg"));
        bg.setLayout(null);

        l1= new JLabel("Flight_No");
        l1.setBounds(20,50,150,30);
        l1.setFont(new Font("Arial",Font.BOLD,16));

        l3=new JLabel("Craft_Type");
        l3.setBounds(20,90,150,30);
        l3.setFont(new Font("Arial",Font.BOLD,16));
        l4=new JLabel("Time");
        l4.setBounds(250,50,150,30);
        l4.setFont(new Font("Arial",Font.BOLD,16));
        l5=new JLabel("Destination");
        l5.setBounds(250,90,150,30);
        l5.setFont(new Font("Arial",Font.BOLD,16));

        JTextField t1,t2,t3,t4;
        t1=new JTextField(10);
        t1.setBounds(100,50,150,30);
        t1.setFont(new Font("Arial",Font.BOLD,16));
        t2=new JTextField(10);
        t2.setBounds(100,90,150,30);
        t2.setFont(new Font("Arial",Font.BOLD,16));
        t3=new JTextField(10);
        t3.setBounds(400,50,150,30);
        t3.setFont(new Font("Arial",Font.BOLD,16));
        t4=new JTextField(10);
        t4.setBounds(400,90,150,30);
        t4.setFont(new Font("Arial",Font.BOLD,16));

        JButton b=new JButton("ADD");
        b.setBounds(200,180,150,30);
        b.setFont(new Font("Arial",Font.BOLD,14));
        b.setForeground(Color.red);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        bg.add(l1);
        bg.add(l3);
        bg.add(l4);
        bg.add(l5);
        bg.add(t1);
        bg.add(t2);
        bg.add(t4);
        bg.add(t3);
        f.add(bg);


        f.setSize(650,650);
        f.setVisible(true);
        f.setLayout(null);
    }
}
