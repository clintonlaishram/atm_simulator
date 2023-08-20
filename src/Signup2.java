import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2  extends JFrame implements ActionListener{ 

    JLabel title, religion, category, income, education, qualification, occupation, pan, aadhar, sr_citizen, exist_acc;
    JComboBox<String> reli, cat, edu, inc, occ;
    JTextField tfpan, tfaadhar;
    JRadioButton s_yes, s_no, acc_yes, acc_no;
    JButton next, back;
    String formno;

    Signup2(String formno) {

        this.formno = formno;

        setLayout(null);

        title = new JLabel("Page 2: Additional Details");
        title.setFont(new Font("Raleway", Font.BOLD, 18));
        title.setBounds(300, 40, 300, 50);
        add(title);

        religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 16));
        religion.setBounds(100, 110, 100, 20);
        add(religion);

        String valReligion[] = {"Hindu", "Christain", "Muslim", "Sikh", "Jain", "Other"};
        reli = new JComboBox<>(valReligion);
        reli.setBounds(250, 105, 450, 30);
        add(reli);

        category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 16));
        category.setBounds(100, 150, 200, 20);
        add(category);

        String valCat[] = {"General", "SC", "ST", "OBC"};
        cat = new JComboBox<>(valCat);
        cat.setBounds(250, 145, 450, 30);
        add(cat);

        income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 16));
        income.setBounds(100, 190, 200, 20);
        add(income);

        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        inc = new JComboBox<>(valIncome);
        inc.setBounds(250, 185, 450, 30);
        add(inc);
        
        education = new JLabel("Education ");
        education.setFont(new Font("Raleway", Font.BOLD, 16));
        education.setBounds(100, 230, 200, 20);
        add(education);
        
        qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 16));
        qualification.setBounds(100, 250, 200, 20);
        add(qualification);

        String valEdu[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        edu = new JComboBox<>(valEdu);
        edu.setBounds(250, 235, 450, 30);
        add(edu);
        
        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 16));
        occupation.setBounds(100, 290, 200, 20);
        add(occupation);

        String valOcc[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occ = new JComboBox<>(valOcc);
        occ.setBounds(250, 285, 450, 30);
        add(occ);

        pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 16));
        pan.setBounds(100, 335, 200, 20);
        add(pan);

        tfpan = new JTextField();
        tfpan.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfpan.setBounds(250, 330, 450, 30);
        add(tfpan);

        aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        aadhar.setBounds(100, 380, 200, 20);
        add(aadhar);

        tfaadhar = new JTextField();
        tfaadhar.setFont(new Font("Raleway", Font.PLAIN, 16)); 
        tfaadhar.setBounds(250, 375, 450, 30);
        add(tfaadhar);

        sr_citizen = new JLabel("Senior Citizen: ");
        sr_citizen.setFont(new Font("Raleway", Font.BOLD, 16));
        sr_citizen.setBounds(100, 425, 200, 20);
        add(sr_citizen);

        s_yes = new JRadioButton("Yes");
        s_yes.setBounds(250, 420, 100, 30);
        s_yes.setBackground(Color.WHITE);
        add(s_yes);

        s_no = new JRadioButton("No");
        s_no.setBounds(350, 420, 100, 30);
        s_no.setBackground(Color.WHITE);
        add(s_no);

        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(s_yes);
        citizenGroup.add(s_no);

        exist_acc = new JLabel("Existing Account: ");
        exist_acc.setFont(new Font("Raleway", Font.BOLD, 16));
        exist_acc.setBounds(100, 470, 200, 20);
        add(exist_acc);

        acc_yes = new JRadioButton("Yes");
        acc_yes.setBounds(250, 465, 100, 30);
        acc_yes.setBackground(Color.WHITE);
        add(acc_yes);

        acc_no = new JRadioButton("No");
        acc_no.setBounds(350, 465, 100, 30);
        acc_no.setBackground(Color.WHITE);
        add(acc_no);

        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(acc_yes);
        accGroup.add(acc_no);

        next = new JButton("Next");
        next.setBorderPainted(false);
        next.setOpaque(true);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBounds(600,515,95,30);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setBorderPainted(false);
        back.setOpaque(true);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBounds(450,515,95,30);
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(Color.WHITE);

        setSize(800, 600);
        setLocation(250, 100);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){

        String religion = (String)reli.getSelectedItem(); 
        String category = (String)cat.getSelectedItem();
        String income = (String)inc.getSelectedItem();
        String education = (String)edu.getSelectedItem();
        String occupation = (String)occ.getSelectedItem();
        
        String pan = tfpan.getText();
        String aadhar = tfaadhar.getText();
        
        String scitizen = "";
        if(s_yes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(s_no.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(acc_yes.isSelected()){ 
            eaccount = "Yes";
        }else if(acc_no.isSelected()){ 
            eaccount = "No";
        }

        try{
            if (ae.getSource() == back){

                setVisible(false);
                new Signup1().setVisible(true);
            }
            else if (pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN Number is required!");
            }
            else if (aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar Number is required!");
            }
            else if (scitizen.equals("")){
                JOptionPane.showMessageDialog(null, "Senior Citizen Status is required!");
            }
            else if (eaccount.equals("")){
                JOptionPane.showMessageDialog(null, "Existing Account is required!");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+scitizen+"', '"+eaccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup3(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
    } 
    public static void main(String args[]){
        new Signup2("");
    }
}
