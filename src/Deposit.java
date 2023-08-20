import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JLabel image, text;
    JTextField amt;
    JButton dep, back;
    String cardNo;

    Deposit(String cardNo){

        this.cardNo = cardNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        text = new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("Helvetica", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(155, 170,300, 30);
        image.add(text);

        amt = new JTextField();
        amt.setFont(new Font("Helvetica", Font.BOLD, 18));
        amt.setBounds(155, 200,280, 25);
        image.add(amt);

        dep = new JButton("Deposit");
        dep.setOpaque(true);
        dep.setBackground(Color.LIGHT_GRAY);
        dep.setForeground(Color.BLACK);
        dep.setBorder(BorderFactory.createEmptyBorder());
        dep.setFont(new Font("Arial", Font.BOLD, 16));
        dep.setBounds(320,355,135,25);
        dep.addActionListener(this);
        image.add(dep);

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
        try{        
            String amount = amt.getText();
            Date date = new Date();
            if(ae.getSource()==dep){
                if(amt.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }
                else{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bank values('"+cardNo+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(cardNo).setVisible(true);
                }
            }else {
                    setVisible(false);
                    new Transaction(cardNo).setVisible(true);
                }
        } catch(Exception e){
            System.out.println(e);
        }
        
    }

    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
