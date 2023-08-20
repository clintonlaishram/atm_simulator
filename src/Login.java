
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton signin, clear, signup;
    JTextField cardTextField, pinTextField;
    JLabel bck_img,text, cardno, pin, cr;
    JPasswordField pinTexField;
    

    Login(){

        setTitle("SBI AMT");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        bck_img = new JLabel(i3);
        bck_img.setBounds(0, 0, 800, 600);
        add(bck_img);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/sbi-logo.png"));
        Image i5 = i4.getImage().getScaledInstance(150, 35, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label = new JLabel(i6);
        label.setBounds(70, 102, 150, 35);
        bck_img.add(label);

        text = new JLabel("Welcome to SBI Bank");
        text.setFont(new Font("Helvetica", Font.BOLD, 40));
        text.setBounds(250, 75, 450, 100);
        bck_img.add(text);

        cardno = new JLabel("Card No   :");
        cardno.setFont(new Font("Arial", Font.BOLD, 26));
        cardno.setBounds(90, 220, 200, 50);
        bck_img.add(cardno);

        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Arial", Font.PLAIN, 18)); 
        cardTextField.setBounds(230, 225, 300, 40);
        bck_img.add(cardTextField);

        pin = new JLabel("Enter Pin :");
        pin.setFont(new Font("Arial", Font.BOLD, 26));
        pin.setBounds(90, 290, 200, 50);
        bck_img.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(230, 295, 300, 40);
        bck_img.add(pinTextField);

        signin = new JButton("SIGN IN");
        signin.setBorderPainted(false);
        signin.setOpaque(true);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setFont(new Font("Arial", Font.BOLD, 18));
        signin.setBounds(230,390,140,35);
        signin.addActionListener(this);
        bck_img.add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBorderPainted(false);
        clear.setOpaque(true);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 18));
        clear.setBounds(390,390,140,35);
        clear.addActionListener(this);
        bck_img.add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBorderPainted(false);
        signup.setOpaque(true);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Arial", Font.BOLD, 18));
        signup.setBounds(230,470,300,35);
        signup.addActionListener(this);
        bck_img.add(signup);

        cr = new JLabel("\u00A9 Powered by Clinton.Pvt.Ltd");
        cr.setFont(new Font("Arial", Font.BOLD, 8));
        cr.setBounds(680, 580, 200, 10);
        bck_img.add(cr);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 600);
        setLocation(250, 100);
        setUndecorated(true);
        setVisible(true);

    }
 
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == signin){
            Conn c = new Conn();
            String cardNo = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "select * from login where card_no = '"+cardNo+"' and Pin = '"+pin+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(cardNo).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                } 
            } catch (Exception e){
                System.out.println(e);
            }

        }
        else {
            setVisible(false);
            new Signup1().setVisible(true);
        }
        
    }
    public static void main(String args[]){
        new Login();
    }   
}