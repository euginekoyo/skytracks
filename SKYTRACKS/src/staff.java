import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class staff {
    staff(){
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

        JLabel l1=new JLabel(" STAFF");
        l1.setFont(new Font("Algerian", Font.BOLD,36));
        l1.setBounds(38,232,150,50);
        l1.setForeground(Color.black);

        JButton b1=new JButton("BOOK FLIGHT",new ImageIcon("src/icons/icons8-booking-64.png"));
        b1.setBounds(200,120,180,70);
        b1.setFont(new Font("Arial", Font.BOLD,12));
        b1.setForeground(Color.black);
        b1.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){

                                      ;

                                 }
                             }
        );
        JButton b2=new JButton(" SEARCH FLIGHT",new ImageIcon("src/icons/icons8-search-48.png"));
        b2.setBounds(200,210,180,70);
        b2.setFont(new Font("Arial", Font.BOLD,12));
        b2.setForeground(Color.black);
        b2.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){


                                 }
                             }
        );
        JButton b3=new JButton("CHECK IN",new ImageIcon("src/icons/icons8-check-48.png"));
        b3.setBounds(200,300,180,70);
        b3.setFont(new Font("Arial", Font.BOLD,12));
        b3.setForeground(Color.black);
        b3.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){


                                 }
                             }
        );
        JButton b4=new JButton("STATUS REPORT",new ImageIcon("src/icons/icons8-statistics-report-64.png"));
        b4.setBounds(400,120,200,70);
        b4.setFont(new Font("Arial", Font.BOLD,12));
        b4.setForeground(Color.black);
        b4.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){

                                     ;

                                 }
                             }
        );
        JButton b5=new JButton(" VIEW BOOKINGS",new ImageIcon("src/icons/icons8-view-64.png"));
        b5.setBounds(400,210,200,70);
        b5.setFont(new Font("Arial", Font.BOLD,12));
        b5.setForeground(Color.black);
        b5.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){


                                 }
                             }
        );
        JButton b6=new JButton("CANCEL FLIGHT",new ImageIcon("src/icons/icons8-cancel-64.png"));
        b6.setBounds(400,300,200,70);
        b6.setFont(new Font("Arial", Font.BOLD,12));
        b6.setForeground(Color.black);
        b6.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){


                                 }
                             }
        );
        JButton b7=new JButton("QUIT",new ImageIcon("src/icons/icons8-exit-64.png"));
        b7.setBounds(480,430,150,55);
        b7.setFont(new Font("Arial", Font.BOLD,12));
        b7.setForeground(Color.black);
        b7.addActionListener(new ActionListener(){
                                 public void actionPerformed(ActionEvent e){
                                        new Login();

                                 }
                             }
        );


        bg.add(l1);
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        bg.add(b4);
        bg.add(b5);
        bg.add(b6);
        bg.add(b7);
        bg.add(r);
        f.add(bg);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(650,650);
        f.setVisible(true);
        f.setLayout(null);
    }
}
