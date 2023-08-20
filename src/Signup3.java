import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    
    JLabel title, accType, card, cardno, cardLen, pin, pinno, pinLen, serReq; 
    JRadioButton t1, t2, t3, t4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7; 
    JButton submit, cancel;  
    String formno;

    Signup3 (String formno) {

        this.formno = formno;
        setLayout(null);

        title = new JLabel("Page 3: Account Details");
        title.setFont(new Font("Raleway", Font.BOLD, 18));
        title.setBounds(300, 30, 300, 50);
        add(title);

        accType = new JLabel("Account Type : ");
        accType.setFont(new Font("Raleway", Font.BOLD, 18));
        accType.setBounds(100, 90, 200, 30);
        add(accType);

        t1 = new JRadioButton("Saving Account");
        t1.setFont(new Font("Raleway", Font.PLAIN, 14));
        t1.setBounds(100, 125, 150, 30);
        t1.setBackground(Color.WHITE);
        add(t1);

        t2 = new JRadioButton("Fixed Deposit Account");
        t2.setFont(new Font("Raleway", Font.PLAIN, 14));
        t2.setBounds(350, 125, 200, 30);
        t2.setBackground(Color.WHITE);
        add(t2);

        t3 = new JRadioButton("Current Account");
        t3.setFont(new Font("Raleway", Font.PLAIN, 14));
        t3.setBounds(100, 160, 150, 30);
        t3.setBackground(Color.WHITE);
        add(t3);

        t4 = new JRadioButton("Joint Account");
        t4.setFont(new Font("Raleway", Font.PLAIN, 14));
        t4.setBounds(350, 160, 200, 30);
        t4.setBackground(Color.WHITE);
        add(t4);

        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(t1);
        accGroup.add(t2);
        accGroup.add(t3);
        accGroup.add(t4);

        card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100, 210, 200, 20);
        add(card);

        cardLen = new JLabel("Your 16 digits Card Number");
        cardLen.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardLen.setBounds(100, 230, 200, 10);
        add(cardLen);

        cardno = new JLabel("XXXX-XXXX-XXXX-2298");
        cardno.setFont(new Font("Raleway", Font.BOLD, 18));
        cardno.setBounds(300, 215, 250, 20);
        add(cardno);

        pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100, 260, 200, 20);
        add(pin);

        pinLen = new JLabel("Your 4 digit Pincode");
        pinLen.setFont(new Font("Raleway", Font.PLAIN, 12));
        pinLen.setBounds(100, 280, 200, 10);
        add(pinLen);

        pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway", Font.BOLD, 18));
        pinno.setBounds(300, 265, 200, 20);
        add(pinno);

        serReq = new JLabel("Service Required :");
        serReq.setFont(new Font("Raleway", Font.BOLD, 18));
        serReq.setBounds(100, 310, 200, 20);
        add(serReq);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.PLAIN, 14));
        c1.setBounds(100, 340, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.PLAIN, 14));
        c2.setBounds(350, 340, 200, 30);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Cheque Book");
        c3.setFont(new Font("Raleway", Font.PLAIN, 14));
        c3.setBounds(100, 370, 150, 30);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alert");
        c4.setFont(new Font("Raleway", Font.PLAIN, 14));
        c4.setBounds(350, 370, 200, 30);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Moblie Banking");
        c5.setFont(new Font("Raleway", Font.PLAIN, 14));
        c5.setBounds(100, 400, 150, 30);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.PLAIN, 14));
        c6.setBounds(350, 400, 200, 30);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hearby declared that the above details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.PLAIN, 16));
        c7.setBounds(80, 455, 700, 30);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBorderPainted(false);
        submit.setOpaque(true);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial", Font.BOLD, 18));
        submit.setBounds(220,505,120,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBorderPainted(false);
        cancel.setOpaque(true);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 18));
        cancel.setBounds(420,505,120,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,600);
        setLocation(250,100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        String accGroup = "";
        if(t1.isSelected()){ 
            accGroup = "Saving Account";
        }
        else if(t2.isSelected()){ 
            accGroup = "Fixed Deposit Account";
        }
        else if(t3.isSelected()){ 
            accGroup = "Current Account";
        }else if(t4.isSelected()){ 
            accGroup = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long num1 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardNo = "" + Math.abs(num1);
        
        long num2 = (ran.nextLong() % 9000L) + 1000L;
        String Pin = "" + Math.abs(num2);
        
        String facility = "";
        if(c1.isSelected()){ 
            facility = facility + " ATM Card,";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking,";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking,";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL Alerts,";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book,";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }

        Boolean b = false;
        if(c7.isSelected()){
            b = true;
        }

        try{
            if (ae.getSource() == cancel){
                 
                Conn c = new Conn();
                String query2 = "delete from signup where formno=('"+formno+"')";
                String query = "delete from signupTwo where formno=('"+formno+"')";
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Login().setVisible(true);
                
                //System.exit(0);
            }
            else if (accGroup.equals("")){
                JOptionPane.showMessageDialog(null, "Account Type is required!");
            }
            else if (facility.equals("")){
                JOptionPane.showMessageDialog(null, "Click all the required services!");
            }
            else if (b.equals(false)){
                JOptionPane.showMessageDialog(null, "Mark the concent");
            }
            else /*submit*/{

                Conn c1 = new Conn();
                String q1 = "insert into signupThree values('"+formno+"','"+accGroup+"','"+cardNo+"','"+Pin+"','"+facility+"')";  
                String q2 = "insert into login values('"+formno+"','"+cardNo+"','"+Pin+"')";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardNo + "\n Pin:"+ Pin);
                
                setVisible(false);
                new Deposit(cardNo).setVisible(true);

            }
        } catch(Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]){
        new Signup3("");
    }
}
