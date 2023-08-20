
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signup1  extends JFrame implements ActionListener{ 

    long random;
    JLabel formno, title, line, name, fatherName, motherName, dob, phone,email, gender, mstatus, address, city, state, pincode;
    JTextField tfName, tfFatherName, tfMotherName, tfPhone,tfEmail, tfAddress, tfCity, tfState, tfPincode;
    JRadioButton male, female;
    JDateChooser dateChooser;
    JComboBox<String> m_status;
    JButton next, back;

    Signup1() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong()%9000L +1000L);
        formno = new JLabel("APLICATION FORM NO: "  + random);
        formno.setFont(new Font("Arial", Font.BOLD, 32));
        formno.setBounds(180,20,500,50);
        add(formno);

        title = new JLabel("Page 1: Personal Details");
        title.setFont(new Font("Raleway", Font.BOLD, 18));
        title.setBounds(300, 55, 300, 50);
        add(title);

        line = new JLabel("___________________________");
        line.setFont(new Font("Raleway", Font.BOLD, 18));
        line.setBounds(290, 60, 340, 50);
        add(line);

        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(100, 130, 100, 20);
        add(name);

        tfName = new JTextField();
        tfName.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfName.setBounds(250, 125, 450, 30);
        add(tfName);

        fatherName = new JLabel("Father's Name: ");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 16));
        fatherName.setBounds(100, 170, 200, 20);
        add(fatherName);

        tfFatherName = new JTextField();
        tfFatherName.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfFatherName.setBounds(250, 165, 450, 30);
        add(tfFatherName);

        motherName = new JLabel("Mother's Name: ");
        motherName.setFont(new Font("Raleway", Font.BOLD, 16));
        motherName.setBounds(100, 210, 200, 20);
        add(motherName);

        tfMotherName = new JTextField();
        tfMotherName.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfMotherName.setBounds(250, 205, 450, 30);
        add(tfMotherName);

        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 16));
        dob.setBounds(100, 250, 200, 20);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(253, 250, 150, 25);
        add(dateChooser);

        phone = new JLabel("Contact No: ");
        phone.setFont(new Font("Raleway", Font.BOLD, 16));
        phone.setBounds(410, 250, 200, 20);
        add(phone);

        tfPhone = new JTextField();
        tfPhone.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfPhone.setBounds(515, 245, 185, 30);
        add(tfPhone);

        email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(100, 290, 200, 20);
        add(email);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfEmail.setBounds(250, 285, 450, 30);
        add(tfEmail);

        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        gender.setBounds(100, 330, 200, 20);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(247, 325, 75, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(325, 325, 150, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);
        
        mstatus = new JLabel("Marital Status: ");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 16));
        mstatus.setBounds(420, 330, 120, 20);
        add(mstatus);
        
        String status[]={"Single","Marreid","Unmarried","Divorced","Others"}; 
        m_status = new JComboBox<>(status);
        m_status.setBounds(540, 325,160,30);           
        add(m_status);
        
        address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        address.setBounds(100, 370, 200, 20);
        add(address);

        tfAddress = new JTextField();
        tfAddress.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfAddress.setBounds(250, 365, 450, 30);
        add(tfAddress);

        city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        city.setBounds(100, 410, 200, 20);
        add(city);

        tfCity = new JTextField();
        tfCity.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfCity.setBounds(250, 405, 450, 30);
        add(tfCity);

        state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 16));
        state.setBounds(100, 450, 200, 20);
        add(state);

        tfState = new JTextField();
        tfState.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfState.setBounds(250, 445, 200, 30);
        add(tfState);

        pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 16));
        pincode.setBounds(470, 450, 200, 20);
        add(pincode);

        tfPincode = new JTextField();
        tfPincode.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfPincode.setBounds(550, 445, 150, 30);
        add(tfPincode);
        
        next = new JButton("Next");
        next.setBorderPainted(false);
        next.setOpaque(true);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBounds(600,500,95,30);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBounds(450,500,95,30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 600);
        setLocation(250, 100);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){

        String formno = "" + random; // long
        String name = tfName.getText();
        String fatherName = tfFatherName.getText();
        String motherName = tfMotherName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String gender = "";
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        }
        String mstatus = (String)m_status.getSelectedItem(); 
        String address = tfAddress.getText();
        String city = tfCity.getText();
        String state = tfState.getText();
        String pincode = tfPincode.getText();

        try{
            if (ae.getSource() == back){

                Conn c = new Conn();
                String query2 = "delete from signup where formno=('"+formno+"')";
                String query = "delete from signupTwo where formno=('"+formno+"')";
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Login().setVisible(true);
            }
            else if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required!");
            }
            else if (fatherName.equals("")){
                JOptionPane.showMessageDialog(null, "Father name is required!");
            }
            else if (motherName.equals("")){
                JOptionPane.showMessageDialog(null, "Mother name is required!");
            }
            else if (dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth is required!");
            }
            else if (phone.equals("")){
                JOptionPane.showMessageDialog(null, "Contact number is required!");
            }
            else if (email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is required!");
            }
            else if (gender.equals("")){
                JOptionPane.showMessageDialog(null, "Gender is required!");
            }
            else if (address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required!");
            }
            else if (city.equals("")){
                JOptionPane.showMessageDialog(null, "City is required!");
            }
            else if (state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required!");
            }
            else if (pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Pincode is required!");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fatherName+"', '"+motherName+"', '"+dob+"', '"+phone+"', '"+email+"', '"+gender+"','"+mstatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
    } 
    public static void main(String args[]){
        new Signup1();
    }
}
