import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class customer {
    customer(){
        JFrame f=new JFrame("DASHBOARD");
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        JSeparator r=new JSeparator();
        r.setBounds(0,40,650,5);

        //This code is for inserting a background picture
        JLabel bg=new JLabel(new ImageIcon("src/pics/login.jpg"));
        bg.setLayout(null);

        JLabel l1=new JLabel(" CUSTOMER");
        l1.setFont(new Font("Algerian", Font.BOLD,36));
        l1.setBounds(0,232,200,50);
        l1.setForeground(Color.black);

        JButton b1=new JButton("RESERVE A FLIGHT",new ImageIcon("src/icons/icons8-reservation-64.png"));
        b1.setBounds(200,160,190,70);
        b1.setFont(new Font("Arial", Font.BOLD,12));
        b1.setForeground(Color.black);
        b1.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){

                                     ;

                                 }
                             }
        );
        JButton b2=new JButton(" SEARCH FLIGHT",new ImageIcon("src/icons/icons8-search-48.png"));
        b2.setBounds(200,240,190,70);
        b2.setFont(new Font("Arial", Font.BOLD,12));
        b2.setForeground(Color.black);
        b2.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){


                                 }
                             }
        );
        JButton b3=new JButton("CANCEL FLIGHT",new ImageIcon("src/icons/icons8-cancel-64.png"));
        b3.setBounds(400,160,220,70);
        b3.setFont(new Font("Arial", Font.BOLD,12));
        b3.setForeground(Color.black);
        b3.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){


                                 }
                             }
        );
        JButton b4=new JButton("VIEW AVAILABLE ROUTES",new ImageIcon("src/icons/icons8-view-64.png"));
        b4.setBounds(400,240,220,70);
        b4.setFont(new Font("Arial", Font.BOLD,12));
        b4.setForeground(Color.black);
        b4.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){

                                     ;

                                 }
                             }
        );
        JButton b8=new JButton("QUIT",new ImageIcon("src/icons/icons8-download-64.png"));
        b8.setBounds(420,500,180,60);
        b8.setForeground(Color.red);
        b8.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                     new   Dashboard();

                                 }
                             }
        );
        bg.add(l1);
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        bg.add(b4);
        bg.add(b8);
        bg.add(r);
        f.add(bg);
        f.setSize(650,650);
        f.setVisible(true);
        f.setLayout(null);
    }
}
