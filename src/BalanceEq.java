import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEq extends JFrame implements ActionListener {

    JButton back;
    JLabel image, t1, t2;
    Image img;
    String cardNo;
    
    BalanceEq(String cardNo){

        this.cardNo = cardNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        int balance = 0;
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where card_no = '"+cardNo+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
        }
        catch(Exception e){
            System.out.println(e);
        }

        t1 = new JLabel("Your Current Account Balance is");
        t1.setFont(new Font("Helvetica", Font.BOLD, 16));
        t1.setForeground(Color.WHITE);
        t1.setBounds(150, 170,320, 20);
        image.add(t1);

        t2 = new JLabel("Rs "+balance);
        t2.setFont(new Font("Helvetica", Font.BOLD, 16));
        t2.setForeground(Color.WHITE);
        t2.setBounds(150, 200,320, 20);
        image.add(t2);

        back = new JButton("Back");
        back.setOpaque(true);
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.BLACK);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBounds(320,390,135,25);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 700);
        setLocation(250, 80);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
            this.setVisible(false);
            new Transaction(cardNo).setVisible(true);
    }

    public static void main(String args[]){
        new BalanceEq("").setVisible(true);
    }
}
