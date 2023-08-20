
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{

    JButton dep, wit, fcash, msat, pinChange, balEq, exit;
    JLabel image, text, cardno, pin;
    Image img;
    String cardNo;

    Transaction(String cardNo){

        this.cardNo = cardNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        text = new JLabel("Please select Your Transaction");
        text.setFont(new Font("Helvetica", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        text.setBounds(165, 130,300, 100);
        image.add(text);

        dep = new JButton("Deposit");
        dep.setOpaque(true);
        dep.setBackground(Color.LIGHT_GRAY);
        dep.setForeground(Color.BLACK);
        dep.setBorder(BorderFactory.createEmptyBorder());
        dep.setFont(new Font("Arial", Font.BOLD, 16));
        dep.setBounds(145,285,130,25);
        dep.addActionListener(this);
        image.add(dep);

        wit = new JButton("Cash Withdrawl");
        wit.setOpaque(true);
        wit.setBackground(Color.LIGHT_GRAY);
        wit.setForeground(Color.BLACK);
        wit.setBorder(BorderFactory.createEmptyBorder());
        wit.setFont(new Font("Arial", Font.BOLD, 16));
        wit.setBounds(320,285,135,25);
        wit.addActionListener(this);
        image.add(wit);

        fcash = new JButton("Fast Cash");
        fcash.setOpaque(true);
        fcash.setBackground(Color.LIGHT_GRAY);
        fcash.setForeground(Color.BLACK);
        fcash.setBorder(BorderFactory.createEmptyBorder());
        fcash.setFont(new Font("Arial", Font.BOLD, 16));
        fcash.setBounds(145,320,130,25);
        fcash.addActionListener(this);
        image.add(fcash);

        msat = new JButton("Mini Statement");
        msat.setOpaque(true);
        msat.setBackground(Color.LIGHT_GRAY);
        msat.setForeground(Color.BLACK);
        msat.setBorder(BorderFactory.createEmptyBorder());
        msat.setFont(new Font("Arial", Font.BOLD, 16));
        msat.setBounds(320,320,135,25);
        msat.addActionListener(this);
        image.add(msat);

        pinChange = new JButton("Pin Change");
        pinChange.setOpaque(true);
        pinChange.setBackground(Color.LIGHT_GRAY);
        pinChange.setForeground(Color.BLACK);
        pinChange.setBorder(BorderFactory.createEmptyBorder());
        pinChange.setFont(new Font("Arial", Font.BOLD, 16));
        pinChange.setBounds(145,355,130,25);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balEq = new JButton("Balance Enquiry");
        balEq.setOpaque(true);
        balEq.setBackground(Color.LIGHT_GRAY);
        balEq.setForeground(Color.BLACK);
        balEq.setBorder(BorderFactory.createEmptyBorder());
        balEq.setFont(new Font("Arial", Font.BOLD, 16));
        balEq.setBounds(320,355,135,25);
        balEq.addActionListener(this);
        image.add(balEq);

        exit = new JButton("Exit");
        exit.setOpaque(true);
        exit.setBackground(Color.LIGHT_GRAY);
        exit.setForeground(Color.BLACK);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setBounds(320,390,135,25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800, 700);
        setLocation(250, 80);
        setUndecorated(true);
        setVisible(true);

    }
 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==dep){ 
            setVisible(false);
            new Deposit(cardNo).setVisible(true);
        }else if(ae.getSource()==wit){ 
            setVisible(false);
            new Withdrawl(cardNo).setVisible(true);
        }else if(ae.getSource()==fcash){ 
            setVisible(false);
            new FastCash(cardNo).setVisible(true);
        }else if(ae.getSource()==msat){ 
            new MiniStatement(cardNo).setVisible(true);
        }else if(ae.getSource()==pinChange){ 
            setVisible(false);
            new PinChange(cardNo).setVisible(true);
        }else if(ae.getSource()==balEq){ 
            this.setVisible(false);
            new BalanceEq(cardNo).setVisible(true);
        }else { 
            System.exit(0);
        }
    }
    public static void main(String args[]){
        new Transaction("").setVisible(true);
    }   
}