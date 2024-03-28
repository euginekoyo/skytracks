
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    Dashboard(){
        JFrame f=new JFrame("Dashboard");
        JSeparator r=new JSeparator();
        r.setBounds(0,90,600,10);
        JLabel lh=new JLabel("DASHBOARD");
        lh.setBounds(30,50,250,50);
        lh.setFont(new Font("Algerian",Font.BOLD,36));
        lh.setForeground(Color.BLACK);
JLabel l=new JLabel(new ImageIcon("src/pics/pexels-pixabay-62623.jpg"));
l.setSize(600,600);
l.setLayout(null);
JButton b1,b2,b3;
b1=new JButton("ADMIN",new ImageIcon("src/icons/icons8-remove-administrator-50.png"));
b1.setBounds(30,130,250,60);
b1.setFont(new Font("Stencil",Font.BOLD,20));
        b1.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                   new Login();

                                 }
                             }
        );
b2=new JButton("STAFF",new ImageIcon("src/icons/icons8-staff-64.png"));
        b2.setBounds(30,220,250,60);
        b2.setFont(new Font("Stencil",Font.BOLD,20));
        b2.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                     new   Login();

                                 }
                             }
        );
        b3=new JButton("CUSTOMER",new ImageIcon("src/icons/icons8-customer-64.png"));
        b3.setBounds(30,310,250,60);
        b3.setFont(new Font("Stencil",Font.BOLD,20));
        b3.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                     new   customer();

                                 }
                             }
        );
        l.add(lh);
        l.add(r);
        l.add(b1);
        l.add(b2);
        l.add(b3);
f.add(l);
f.setSize(650,650);
f.setVisible(true);
f.setLayout(null);
    }
}
