import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class administrator {
    administrator(){
        JFrame f=new JFrame("ADMIN PAGE");
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        JLabel l=new JLabel("ADMINISTRATOR");
        l.setFont(new Font("Algerian", Font.BOLD,24));
        l.setBounds(0,210,250,70);
        l.setForeground(Color.black);
JLabel bg=new JLabel(new ImageIcon("src/pics/login.jpg"));
bg.setLayout(null);

        JSeparator r=new JSeparator();
        r.setBounds(0,45,650,5);
        JButton b1=new JButton("UPDATE FLIGHT",new ImageIcon("src/icons/icons8-update-64.png"));
        b1.setFont(new Font("Arial", Font.BOLD,12));
        b1.setBounds(210,110,180,70);
        b1.setForeground(Color.blue);
        b1.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                   new admin.updateFlights();

                                 }
                             }
        );

        JButton b2=new JButton("ASSIGN STAFF",new ImageIcon("src/icons/icons8-staff-64.png"));
        b2.setBounds(210,200,180,70);
        b2.setFont(new Font("Arial", Font.BOLD,12));
        b2.setForeground(Color.blue);
        b2.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                     new admin.AddFlights();
                                 }
                             }
        );


        JButton b3=new JButton("MANAGE STAFF",new ImageIcon("icons8-manage-48 (1).png"));
        b3.setBounds(210,290,180,70);
        b3.setFont(new Font("Arial", Font.BOLD,12));
        b3.setForeground(Color.blue);
        b3.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                     //new   deleteuser();

                                 }
                             }
        );
        JButton b4=new JButton("CARGO INFO",new ImageIcon("src/icons/icons8-cargo-64.png"));
        b4.setBounds(210,370,180,70);
        b4.setForeground(Color.blue);
        b4.setFont(new Font("Arial", Font.BOLD,12));
        b4.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                     //new   deleteuser();

                                 }
                             }
        );
        JButton b5=new JButton("ADD FLIGHT",new ImageIcon("src/icons/icons8-add.gif"));
        b5.setBounds(400,110,180,70);
        b5.setForeground(Color.red);
        b5.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                    // new   login ();

                                 }
                             }
        );
        JButton b6=new JButton("MANAGE ROUTE",new ImageIcon("src/icons/icons8-manage-48 (1).png"));
        b6.setBounds(400,200,180,70);
        b6.setForeground(Color.blue);
        b6.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                     // new   login ();

                                 }
                             }
        );
        JButton b7=new JButton("GENERATE REPORT",new ImageIcon("src/icons/icons8-download-64.png"));
        b7.setBounds(400,290,180,70);
        b7.setForeground(Color.blue);
        b7.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                     // new   login ();

                                 }
                             }
        );
        JButton b8=new JButton("QUIT",new ImageIcon("src/icons/icons8-download-64.png"));
        b8.setBounds(420,500,180,60);
        b8.setForeground(Color.blue);
        b8.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                      new Login();

                                 }
                             }
        );



        bg.add(l);
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        bg.add(b4);
        bg.add(b5);
        bg.add(b6);
        bg.add(b7);
        bg.add(b8);
        bg.add(r);
        f.add(bg);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(650,650);
        f.setVisible(true);
        f.setLayout(null);

    }

}


