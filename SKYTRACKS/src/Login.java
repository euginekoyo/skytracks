import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {
            Login(){


                JFrame f=new JFrame("Login");
                JSeparator r=new JSeparator();
                r.setBounds(0,90,650,10);
//Icon ico=new ImageIcon("src/search.gif");
                JLabel j=new JLabel(new ImageIcon("src/pics/login.jpg") );
                j.setLayout(null);
                JLabel fv=new JLabel(new ImageIcon(""));
                fv.setLocation(0,10);
                JLabel j1=new JLabel("LOGIN");
                j1.setBounds(230,50,200,50);
                j1.setFont(new Font("Showcard Gothic",Font.BOLD,36));
                j1.setForeground(Color.blue);

                JLabel j2=new JLabel("USERNAME");
                j2.setFont(new Font("Showcard Gothic",Font.BOLD,25));
                j2.setBounds(150,150,150,40);
                j2.setForeground(Color.black);
                JLabel j3=new JLabel("PASSCODE");
                j3.setFont(new Font("Showcard Gothic",Font.BOLD,25));
                j3.setBounds(150,200,250,40);
                j3.setForeground(Color.black);
                JTextField t1=new JTextField(10);
                t1.setBounds(300,150,200,30);
                t1.setFont(new Font("Arial",Font.BOLD,18));
                JPasswordField t2=new JPasswordField(10);
                t2.setBounds(300,200,200,30);

                JButton b=new JButton(new ImageIcon("src/icons/icons8-login-64 (1).png"));
                b.setBounds(380,300,120,60);
                b.setFont(new Font("Stencil",Font.BOLD,20));
                b.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if(t1.getText().equals("admin") && t2.getText().equals("0000")){
                            f.hide();
                            new administrator();
                        }else if(t1.getText().equals("staff") && t2.getText().equals("0000")){
                            f.hide();
                            new staff();

                        } else if(t1.getText().equals("customer") && t2.getText().equals("0000")){
                            f.hide();
                            new customer();
                        }else {
                            JOptionPane.showMessageDialog(null,"Please enter the correct login details!! ");
                        }
                    }

                });
                JButton b8=new JButton("BACK",new ImageIcon("src/icons/icons8-logout-64.png"));
                b8.setBounds(190,300,150,60);
                b8.setForeground(Color.red);
                b8.addActionListener(new ActionListener(){
                                         public void actionPerformed(ActionEvent e){
                                             new   Dashboard();

                                         }
                                     }
                );
                j.add(fv);
                j.add(b8);
                j.add(r);
                j.add(j1);
                j.add(j2);
                j.add(j3);
                j.add(t1);
                j.add(t2);
                j.add(b);
                f.add(j);

                f.setSize(650,650);
                f.setVisible(true);
                f.setLayout(null);

            }
        }


