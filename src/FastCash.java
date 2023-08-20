import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{

    JButton b1, b2, b3, b4, b5, b6, back;
    JLabel image, text;
    Image img;
    String cardNo;

    FastCash(String cardNo){

        this.cardNo = cardNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        text = new JLabel("Select Withdrawl Amount");
        text.setFont(new Font("Helvetica", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(195, 170,320, 30);
        image.add(text);

        b1 = new JButton("Rs 100");
        b1.setOpaque(true);
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setForeground(Color.BLACK);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setBounds(145,285,130,25);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs 500");
        b2.setOpaque(true);
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setForeground(Color.BLACK);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setBounds(320,285,135,25);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setOpaque(true);
        b3.setBackground(Color.LIGHT_GRAY);
        b3.setForeground(Color.BLACK);
        b3.setBorder(BorderFactory.createEmptyBorder());
        b3.setFont(new Font("Arial", Font.BOLD, 16));
        b3.setBounds(145,320,130,25);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setOpaque(true);
        b4.setBackground(Color.LIGHT_GRAY);
        b4.setForeground(Color.BLACK);
        b4.setBorder(BorderFactory.createEmptyBorder());
        b4.setFont(new Font("Arial", Font.BOLD, 16));
        b4.setBounds(320,320,135,25);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setOpaque(true);
        b5.setBackground(Color.LIGHT_GRAY);
        b5.setForeground(Color.BLACK);
        b5.setBorder(BorderFactory.createEmptyBorder());
        b5.setFont(new Font("Arial", Font.BOLD, 16));
        b5.setBounds(145,355,130,25);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setOpaque(true);
        b6.setBackground(Color.LIGHT_GRAY);
        b6.setForeground(Color.BLACK);
        b6.setBorder(BorderFactory.createEmptyBorder());
        b6.setFont(new Font("Arial", Font.BOLD, 16));
        b6.setBounds(320,355,135,25);
        b6.addActionListener(this);
        image.add(b6);

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

    public void actionPerformed(ActionEvent ae) {
        try {

            String amount = ((JButton)ae.getSource()).getText().substring(3); 
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where card_no = '"+cardNo+"'");
            int balance = 0;
            
            if (ae.getSource() == back) {
                this.setVisible(false);
                new Transaction(cardNo).setVisible(true);
            }
            else{
                while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                else {
                        Date date = new Date();
                        c.s.executeUpdate("insert into bank values('"+cardNo+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                        JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully\n Please collect the cash.");
                            
                        setVisible(false);
                        new Transaction(cardNo).setVisible(true);
                    }
                }
            } 

        catch(Exception e){
            System.out.println(e);
        }
        
    }

    public static void main (String args[]){
        new FastCash("").setVisible(true);
    }

}
