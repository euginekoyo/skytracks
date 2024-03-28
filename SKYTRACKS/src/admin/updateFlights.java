package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateFlights {
    public updateFlights(){
        JFrame f=new JFrame("UPDATE FLIGHTS");
        JLabel bg, l1,l2,l3,l4,l5;
        bg=new JLabel(new ImageIcon("src/pics/login.jpg"));
        bg.setLayout(null);

                l1= new JLabel("Flight_No");
                l1.setBounds(90,100,150,30);
                l1.setFont(new Font("Arial",Font.BOLD,20));
                l2=new JLabel("Flight_Cat");
                l2.setBounds(90,150,150,30);
                l2.setFont(new Font("Arial",Font.BOLD,20));
                l3=new JLabel("Craft_Type");
                l3.setBounds(90,200,150,30);
                l3.setFont(new Font("Arial",Font.BOLD,20));
                l4=new JLabel("Time");
                l4.setBounds(350,100,150,30);
                l4.setFont(new Font("Arial",Font.BOLD,20));
                l5=new JLabel("Destination");
                l5.setBounds(350,150,150,30);
                l5.setFont(new Font("Arial",Font.BOLD,20));

        JTextField t1,t2,t3,t4,t5;
        t1=new JTextField(10);
        t1.setBounds(190,100,150,30);
        t1.setFont(new Font("Arial",Font.BOLD,16));
        t2=new JTextField(10);
        t2.setBounds(190,150,150,30);
        t2.setFont(new Font("Arial",Font.BOLD,16));
        t3=new JTextField(10);
        t3.setBounds(190,200,150,30);
        t3.setFont(new Font("Arial",Font.BOLD,16));
        t4=new JTextField(10);
        t4.setBounds(490,100,150,30);
        t4.setFont(new Font("Arial",Font.BOLD,16));
        t5=new JTextField(10);
        t5.setBounds(490,150,150,30);
        t5.setFont(new Font("Arial",Font.BOLD,16));

        JButton b=new JButton("UPDATE");
        b.setBounds(200,180,150,30);
        b.setFont(new Font("Arial",Font.BOLD,14));
        b.setForeground(Color.red);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    bg.add(l1);
    bg.add(l2);
        bg.add(l3);
        bg.add(l4);
        bg.add(l5);
        bg.add(t1);
        bg.add(t2);
        bg.add(t4);
        bg.add(t3);
        bg.add(t5);
        bg.add(b);
        f.add(bg);


    f.setSize(650,650);
    f.setVisible(true);
    f.setLayout(null);

    }
}
