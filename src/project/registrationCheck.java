package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class registrationCheck {
    Color color  = new Color(255, 255, 255);
    Font font = new Font("Monospace",Font.BOLD,50);
    Font fonts = new Font("Monospace",Font.BOLD,22);

    JLabel semester = new JLabel();
    JButton button = new JButton("OK");
    JComboBox textS = new JComboBox();
    JLabel Roll = new JLabel("Registration_Check");
    JComboBox box = new JComboBox();

    JFrame f = new JFrame();
    JTextArea rshow = new JTextArea();
    JLabel label = new JLabel("Registration_Check");
    JTextArea text = new JTextArea();
    JButton back = new JButton();
    JLabel urdu= new JLabel();
    JLabel english = new JLabel();
    JLabel math = new JLabel();
    JLabel department = new JLabel();
    JLabel science = new JLabel();

    JTextArea  englisht = new JTextArea();
    JTextArea urdut = new JTextArea();
    JTextArea matht= new JTextArea();
    JTextArea sciencet = new JTextArea();

    registrationCheck(){
        f.setLayout(null);
        f.setSize(700, 600);
        f.setTitle("Management");
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(135,99,211));
        f.setLocationRelativeTo(null);

        label.setBounds(100,50,500,100);
        label.setFont(font);
        label.setForeground(Color.white);

        Roll.setBounds(20,150,200,40);
        Roll.setText("Registration_Check");
        Roll.setFont(fonts);
        Roll.setForeground(color);

        text.setBounds(20,210,200,30);
        text.setFont(new Font("arial",Font.BOLD,25));

        rshow.setLineWrap(true);
        rshow.setBounds(360,150-10,300,400);

        button.setBounds(20,400-50,80,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rshow.setText("");
                registrationChecks();
            }
        });


        back.setBounds(550+20, 10, 100, 20);
        back.setText("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result r = new result();
                f.setVisible(false);
            }
        });
        f.add(label);
        f.add(button);
        f.add(rshow);
        f.add(Roll);
        f.add(back);
        f.add(textS);
        f.add(text);
                f.setVisible(true);

    }
    public void registrationChecks(){
        Connection conn;
        Statement statement;

        try {

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
            statement = conn.createStatement();
            String sql = "SELECT * FROM sm.rform where name='" + text.getText() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            String lengths = text.getText();
        try{
            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String depart = resultSet.getString("depart");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                String semester = resultSet.getString("semester");
                rshow.append("RNo:    " + id + "\n");
                rshow.append("Name:    " + name + "\n");
                rshow.append("Department:    " + depart + "\n");
                rshow.append("D_o_B:    " + dob + "\n");
                rshow.append("Address:    " + address + "\n");
                rshow.append("Gender:    " + gender + "\n");
                rshow.append("Semester:    " + semester + "\n\n");
                JOptionPane.showMessageDialog(f, "SuccessFul", "SuccessFul", JOptionPane.PLAIN_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(f,"Not found","Not Found",JOptionPane.WARNING_MESSAGE);
        }



        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        registrationCheck r = new registrationCheck();
    }
}
