import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    JLabel image, text, text1, text2;
    JPasswordField tf1, tf2, tf3;
    JButton change, back;
    String cardNo;

    PinChange(String cardNo){

        this.cardNo = cardNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        text = new JLabel("CHANGE YOUR PIN ");
        text.setFont(new Font("Helvetica", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(220, 160,300, 30);
        image.add(text);

        text1 = new JLabel("Enter New PIN: ");
        text1.setFont(new Font("Helvetica", Font.BOLD, 16));
        text1.setForeground(Color.WHITE);
        text1.setBounds(150, 200,300, 30);
        image.add(text1);

        tf1 = new JPasswordField();
        tf1.setFont(new Font("Helvetica", Font.BOLD, 18));
        tf1.setBounds(150, 230,200, 25);
        tf1.addActionListener(this);
        image.add(tf1);

        text2 = new JLabel("Re-Enter New PIN: ");
        text2.setFont(new Font("Helvetica", Font.BOLD, 16));
        text2.setForeground(Color.WHITE);
        text2.setBounds(150, 260,300, 30);
        image.add(text2);

        tf2 = new JPasswordField();
        tf2.setFont(new Font("Helvetica", Font.BOLD, 18));
        tf2.setBounds(150, 290,200, 25);
        tf2.addActionListener(this);
        image.add(tf2);

        change = new JButton("Confirm");
        change.setOpaque(true);
        change.setBackground(Color.LIGHT_GRAY);
        change.setForeground(Color.BLACK);
        change.setBorder(BorderFactory.createEmptyBorder());
        change.setFont(new Font("Arial", Font.BOLD, 16));
        change.setBounds(320,355,135,25);
        change.addActionListener(this);
        image.add(change);

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

            String npin = String.valueOf(tf1.getPassword());
            String rpin = String.valueOf(tf2.getPassword());
            
            if(ae.getSource()==change){
                if (String.valueOf(tf1.getPassword()).equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                else if (String.valueOf(tf2.getPassword()).equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                else if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
                }
                else{
                Conn c = new Conn();
                String q1 = "update login set Pin = '"+rpin+"' where card_no = '"+cardNo+"' ";
                String q2 = "update signupThree set Pin = '"+rpin+"' where cardNo = '"+cardNo+"' ";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

                }
            
            }
            
            else {
                setVisible(false);
                new Transaction(cardNo).setVisible(true);
            }

        } 
        catch(Exception e) {
            System.out.println(e);
        } 
        
    }

    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
