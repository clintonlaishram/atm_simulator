import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton close;
    JLabel t1, t2, t3, t4, t5, logo;
    String cardNo;;

    MiniStatement(String cardNo){

        this.cardNo=cardNo;
        setLayout(null);

        t1 = new JLabel("Mini Statement");
        t1.setFont(new Font("Helvetica", Font.BOLD, 14));
        t1.setForeground(Color.BLACK);
        t1.setBounds(170, 0,300, 100);
        add(t1);

        t2 = new JLabel("State Bank of India");
        t2.setFont(new Font("Helvetica", Font.BOLD, 24));
        t2.setForeground(Color.BLACK);
        t2.setBounds(120, 60,300, 40);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/sbi_logo.png"));
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        logo = new JLabel(i3);
        logo.setBounds(85, 62, 30, 30);
        add(logo);

        t3 = new JLabel();
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from login where card_no = '"+cardNo+"'");
            while(rs.next()){
                t3.setText("Card Number:    " + rs.getString("card_no").substring(0, 4) + "XXXXXXXX" + rs.getString("card_no").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        t3.setFont(new Font("Helvetica", Font.BOLD, 14));
        t3.setForeground(Color.BLACK);
        t3.setBounds(30, 110,300, 40);
        add(t3);

        t4 = new JLabel();
        t5 = new JLabel(); 
        
        try{
            int balance = 0;
            Conn c2  = new Conn();
            ResultSet rs = c2.s.executeQuery("select * from bank where card_no = '"+cardNo+"' order by date desc limit 8");
            while(rs.next()){
                t4.setText(t4.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            t5.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            System.out.println(e);
        }

        t4.setFont(new Font("Helvetica", Font.BOLD, 14));
        t4.setForeground(Color.BLACK);
        t4.setBounds(30, 170,400, 270);
        add(t4);

        t5.setFont(new Font("Helvetica", Font.BOLD, 14));
        t5.setForeground(Color.BLACK);
        t5.setBounds(30, 450,300, 40);
        add(t5);


        close = new JButton("Close");
        close.setOpaque(true);
        close.setBackground(Color.WHITE);
        close.setForeground(Color.BLACK);
        close.setBorder(BorderFactory.createEmptyBorder());
        close.setFont(new Font("Arial", Font.BOLD, 16));
        close.setBounds(370,510,50,25);
        close.addActionListener(this);
        add(close);

        getContentPane().setBackground(Color.WHITE);

        setSize(430, 550);
        setLocation(270, 100);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
    public static void main (String ards[]){
        new MiniStatement("null").setVisible(true);
    }

}
