package project;

import javax.sound.midi.Track;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class login_or_signup implements CaretListener {
    LocalDateTime dates = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String date=dates.format(formatter);
    Font fonts = new Font("Monospace",Font.BOLD,18);
    Boolean b = true;
    Connection conn;
    Statement statement;
    boolean bool;

    String warning = null;
    int redL=135;int blueL= 211;int greenL= 99;
    int redR=50;int blueR= 50;int greenR= 86;


    ImageIcon icon1 = new ImageIcon("logo.png");
    JLabel logo = new JLabel ();
    Image image = icon1.getImage();
    Image imageScale = image.getScaledInstance(200,200, Image.SCALE_SMOOTH);
    ImageIcon scaled = new ImageIcon(imageScale);
    Font font = new Font("monospace",Font.CENTER_BASELINE,30);

    JFrame f = new JFrame("login");
    JTextField textField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton();
    JButton signUp = new JButton();
    JButton show = new JButton();
    JLabel label = new JLabel("Sign Up or Login");
    JPanel left = new JPanel();
    JPanel right = new JPanel();
    GridLayout gridLayout = new GridLayout();
    JLabel la = new JLabel("sign_up Successful");

    public void login() {
        f.setLayout(gridLayout);
        f.setSize(700, 600);
        f.setTitle("Management");
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.gray.brighter());
        f.setLocationRelativeTo(null);

        label.setForeground(Color.WHITE);
        label.setFont(font);
        textField.setFont(new Font("monospace", Font.CENTER_BASELINE, 18));

        passwordField.setEchoChar('*');
        passwordField.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        passwordField.addCaretListener(this);

        show.setText("Show");
        show.addActionListener(new ActionListener() {
            boolean b = true;

            //        Using anonymous
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == show) {
                    if (b == true) {
                        passwordField.setEchoChar((char) 0);
                        b = false;
                        show.setText("Hide");
                    } else if (b == false) {
                        passwordField.setEchoChar('*');
                        show.setText("Show");
                        b = true;
                    }
                }
            }
        });

        loginButton.setText("Login");
        loginButton.setFont(new Font("Arial", Font.ITALIC, 15));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logining_up();

            }
        });

        signUp.setText("sign Up");
        signUp.setFont(new Font("Arial", Font.ITALIC, 15));
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signing_up();
            }
        });


        left.setBackground(new Color(redL, greenL, blueL));

        left.setLayout(null);
        left.setBackground(new Color(redL, greenL, blueL));
        right.setBackground(new Color(50, 50, 86));
        right.setBounds(0, 0, 450, 600);
        right.setLayout(null);

        logo.setIcon(scaled);
//        logo.setBounds(50, 100, 200, 200);
        logo.setBackground(Color.white);
        left.add(logo);

//        label.setBounds(20, 170, 250, 40);
        right.add(label);

        textField.setBounds(20, 250, 200, 30);
        textField.setBackground(new Color(redL, greenL, blueL));
        textField.setForeground(Color.white);
        textField.setText("Email");
        right.add(textField);

        passwordField.setBounds(20, 290, 200, 30);
        passwordField.setBackground(new Color(redL, greenL, blueL));
        passwordField.setText("Password");
        passwordField.setForeground(Color.white);
        right.add(passwordField);

        show.setBounds(230, 290, 70, 30);
        show.setBackground(new Color(redL, greenL, blueL));
        textField.addCaretListener(this);
        if (b == false) {
            textField.setText(textField.getText());
        }
        show.setForeground(Color.white);


        right.add(show);
        loginButton.setBounds(30, 340, 180, 30);
        loginButton.setBackground(new Color(redL, greenL, blueL));
        loginButton.setFont(fonts);
        loginButton.setForeground(Color.white);
        right.add(loginButton);

        signUp.setBounds(30, 380, 180, 30);
        signUp.setBackground(new Color(redL, greenL, blueL));
        signUp.setForeground(Color.white);
        signUp.setFont(fonts);
        right.add(signUp);

        la.setBounds(30, 50, 300, 40);
        la.setFont(new Font("monospace", Font.CENTER_BASELINE, 30));
        la.setForeground(Color.white);
        la.setVisible(false);
        right.add(la);

        f.add(left);
        f.add(right, BorderLayout.LINE_END);
        f.setVisible(true);


        int a = 0;
        int mile = 30;
        boolean check = true;
        System.out.println("Error 404 Logical Exception");

        while (true) {
            try {
                Thread.sleep(mile);
                if (check) {
                    a++;
                    label.setBounds(a + 20, 150, 250, 40);
                    logo.setBounds(50, a+100, 200, 200);

                } else {
                    label.setBounds(a + 20, 150, 250, 40);
                    logo.setBounds(50, a+100, 200, 200);

                    a--;
                }
                if (a > 50) {
                    check = false;
                    a = 50;
                    label.setForeground(Color.red);
                }
                if (a < 1) {
                    check = true;
                    label.setForeground(Color.white);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void signing_up(){
        Connection conn;
        Statement statement;
        String id = textField.getText();
        String passing = passwordField.getText();
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/sm","root","123456789");
            statement = conn.createStatement();
            String record = "INSERT INTO `sm`.`login` (`id`, `pass`,`date`) VALUES ('"+id+"', '"+passing+"',' "+date+"')";
            statement.executeUpdate(record);


        }
        catch (SQLIntegrityConstraintViolationException exception){
            JOptionPane.showMessageDialog(f,"Duplicate Entry","Warning",JOptionPane.ERROR_MESSAGE);

        }
        catch (Exception e3) {
            JOptionPane.showMessageDialog(f,"Something Went Wrong, Try again","Check your input",JOptionPane.ERROR_MESSAGE);
            System.out.println(e3);
        }
        textField.setText(null);
        passwordField.setText(null);
    }
    public  void logining_up(){
        try {
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/sm","root","123456789");

            statement = conn.createStatement();
            String sql = "SELECT * FROM sm.login where id='" + textField.getText() + "' and pass='" + passwordField.getText().toString() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            String lengths = textField.getText();
            if (resultSet.next()) {
                landingpage lander = new landingpage();
                f.setVisible(false);
            }
            else if (resultSet.next()) {
                String a = lengths;
                if (a == null || a == "") {
                    System.out.println("false");
                } else {
                    System.out.println("true");
                }
            } else {
                JOptionPane.showMessageDialog(f,"Invalid Input","Check your input",JOptionPane.WARNING_MESSAGE);
            }
        }  catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(f,"Invalid Input","Check your input",JOptionPane.WARNING_MESSAGE);

        }
    }

    //                     Caret Listener

    public void caretUpdate(CaretEvent e) {
        if (e.getSource()==textField){
            try {
                textField.setText("");
                b=false;
                textField.addCaretListener(null);
            }
            catch (Exception exs){
                System.out.println("Working password");
            }
        }
    }
    login_or_signup(){
        login();
    }
    public static  void main(String arguments []){
        login_or_signup r = new login_or_signup();

    }
}
