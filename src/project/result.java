package project;


 import project.landingpage;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class result {

    Color color  = new Color(255, 255, 255);
    Font font = new Font("Monospace",Font.BOLD,50);
    Font fonts = new Font("Monospace",Font.BOLD,17);

    JLabel semester = new JLabel();
    JButton button = new JButton("OK");
    JComboBox textS = new JComboBox();
    JLabel Roll = new JLabel("Attendance_Mark");
    JComboBox box = new JComboBox();

    public int ee;
    public int m;
    public int s;
    public int u;
    LocalDateTime dates = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    JComboBox departmentS = new JComboBox();
    String date=dates.format(formatter);

    JFrame f = new JFrame();
    JTextArea rshow = new JTextArea();
    JLabel label = new JLabel("Attendance_Check");
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
//    JLabel department = new JLabel();

    result (){
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

        Roll.setBounds(20,200-50,150,20);
        Roll.setText("Registration_Number");
        Roll.setFont(fonts);
        Roll.setForeground(color);

        text.setBounds(200,200-50,150,20);
        text.setFont(new Font("arial",Font.BOLD,15));
//               it's the text where id we defined
// from here

        semester.setBounds(20,250-50,150,20);
        semester.setText("Semester");
        semester.setFont(fonts);
        semester.setForeground(color);

        textS.setBounds(200,250-50,150,20);
        textS.setFont(new Font("arial",Font.BOLD,15));
        String array []={"Select","1th","2th"};
        for (int i = 0; i < array.length; i++) {
            textS.addItem(array[i]);
        }
        department.setBounds(20,300-50,150,20);
        department.setText("Department");
        department.setFont(fonts);
        department.setForeground(color);
        departmentS.setBounds(200,300-50,150,20);
        departmentS.setFont(new Font("arial",Font.BOLD,15));
        String arrays []={"Select","Information_Technology","Computer Science"};
        for (int i = 0; i < arrays.length; i++) {
            departmentS.addItem(arrays[i]);
        }
        box.setBounds(20,350-50,150,20);
        box.setFont(new Font("arial",Font.BOLD,15));
        box.addItem("Select");
        box.addItem("Attendance Check");
        box.addItem("Result Check");
        box.addItem("Paper marks");
        box.addItem("Registration Check");
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource()==box){
                    if (box.getSelectedIndex()==1){
                        label.setText("Attendance_Check");
                    }
                    if (box.getSelectedIndex()==2){
                        label.setText("Result_Check");
                    }
                    if (box.getSelectedIndex()==3){
                        label.setText("Paper_Mark");
                    }
                    if (box.getSelectedIndex()==4){
                        label.setText("Registration Check");


                    }


                }
            }
        });

        button.setBounds(20,400-50,80,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button){
                    if (text.getText().length()<1){
                        JOptionPane.showMessageDialog(f,"Registration number = nul","Null",WARNING_MESSAGE);
                    }
                    else if (textS.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(f,"Select Semester","Select",WARNING_MESSAGE);
                    }
                    else if (departmentS.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(f,"Select Department","Select",WARNING_MESSAGE);
                    }
                    else if (box.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(f,"Select ComboBox","Select",WARNING_MESSAGE);
                    }

                    if (box.getSelectedIndex()==3){
                        String roll = text.getText();
                        m=Integer.valueOf(matht.getText());
                        u=Integer.valueOf(urdut.getText());
                        s=Integer.valueOf(sciencet.getText());
                        ee=Integer.valueOf(englisht.getText());

                        try{
                            Connection conn = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                            Statement statement = conn.createStatement();
                            String sql = "SELECT * FROM sm.rform where id='" + text.getText() + "'";
                            ResultSet resultSet = statement.executeQuery(sql);

                            if (resultSet.next() ){
                                int id = resultSet.getInt("id");
                                String name = resultSet.getString("name");
                                String semester = resultSet.getString("semester");
                                String department = resultSet.getString("depart");
                                ee=Integer.valueOf(englisht.getText());
                                m=Integer.valueOf(matht.getText());
                                u=Integer.valueOf(urdut.getText());
                                s=Integer.valueOf(sciencet.getText());
                                int percentage =(ee+m+u+s)*100/400;
                                String p = String.valueOf(percentage);

                                String add =
                                        "INSERT INTO `sm`.`papercheck` " +
                                                "(`id`,`name`,`semester`,`depart`,`english`,`urdu`,`math`,`science`,`percentage`,`date`) " +
                                                "VALUES ('"+id+"','"+name+"','"+semester+"','"+department+"','"+englisht.getText()+"','"+urdut.getText()+"','"+matht.getText()+"','"+sciencet.getText()+"','"+p+"','"+date+"')";
                                statement.executeUpdate(add);
                                rshow.setText("");
                                rshow.append("English= "+englisht.getText());
                                rshow.append("\nUrdu= "+urdut.getText());
                                rshow.append("\nMath= "+matht.getText());
                                rshow.append("\nScience= "+sciencet.getText());
                                int  obtain =(ee+m+u+s);

                                rshow.append("\nObtain number ="+obtain);
                                rshow.append("\nTotal number ="+400);
//                                rshow.append("\nPercentae number ="+400);
                                rshow.append("\nPercentage= "+percentage);
                                 JOptionPane.showMessageDialog(f,"Successful","Paper Mark",JOptionPane.PLAIN_MESSAGE);
                            }else {
                                JOptionPane.showMessageDialog(f,"Registration number invalid","Paper Mark",JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        catch (NumberFormatException | SQLException exception){
                            JOptionPane.showMessageDialog(f,"Check the input if its wrong","invalid input",JOptionPane.ERROR_MESSAGE);
                            System.out.println(exception);
                        }
                    }
                }
                if (box.getSelectedIndex()==2){

                    try {
                        Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                        Statement statement = conn.createStatement();
                        String sql = "SELECT * FROM sm.papercheck where id='" +text.getText()+ "'";
                        ResultSet resultSet = statement.executeQuery(sql);
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String name = resultSet.getString("name");
                            String semester = resultSet.getString("semester");
                            String department = resultSet.getString("depart");
                            String english = resultSet.getString("english");
                            String urdu = resultSet.getString("urdu");
                            String math = resultSet.getString("math");
                            String science = resultSet.getString("science");
                            String percentage = resultSet.getString("percentage");
                            String dates = resultSet.getString("date");
                            rshow.setLineWrap(true);
                            rshow.setText("");
                            rshow.append("Registration number    : "+id+"\n");
                            rshow.append("Name                           : "+name+"\n");
                            rshow.append("semester                      : "+semester+"\n");
                            rshow.append("department                   : "+department+"\n");
                            rshow.append("english                          :"+english+"\n");
                            rshow.append("urdu                             : "+urdu+"\n");
                            rshow.append("Math                             : "+math+"\n");
                            rshow.append("Science                        : "+science+"\n");
                            rshow.append("Percentage                   : "+percentage+"\n");
                        }

                    }
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(f,"SomeThing Went Wrong","error",JOptionPane.ERROR_MESSAGE);
                        System.out.println(exception);
                    }

                }

//        it first

                if (box.getSelectedIndex()==1){
                    if (textS.getSelectedIndex() == 1 && departmentS.getSelectedIndex()==1) {
                        int size=0;
                        String record[]= new String[100];
                        try {
                            rshow.setText("");
                            Connection conn = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                            Statement statement = conn.createStatement();
                            String sql = "SELECT * FROM sm.itfst where roll='" +text.getText()+ "'";
                            ResultSet resultSet = statement.executeQuery(sql);
                            while (resultSet.next()) {
                                int id = resultSet.getInt("roll");
                                String att = resultSet.getString("attend");
                                String dates = resultSet.getString("date");
                                rshow.setLineWrap(true);
                                rshow.append("Roll no: "+id+", Attendance: "+att+", Date: "+dates+"\n");
                                record[size]=att;
                                size++;
                            }
                            rshow.append("\n\nTotal Attendance:  "+size);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(f,"SomeThing Went Wrong","error",JOptionPane.ERROR_MESSAGE);
                            System.out.println(exception);

                        }
                    }
                }

//it second

                if (e.getSource()==button&&box.getSelectedIndex()==1) {
                    if (textS.getSelectedIndex() == 2 && departmentS.getSelectedIndex() == 1) {
                        int size = 0;
                        String record[] = new String[100];
                        try {
                            rshow.setText("");

                            Connection conn = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                            Statement statement = conn.createStatement();
                            String sql = "SELECT * FROM sm.itsecnd where roll='" + text.getText() + "'";
                            ResultSet resultSet = statement.executeQuery(sql);
                            while (resultSet.next()) {
                                int id = resultSet.getInt("roll");
                                String att = resultSet.getString("attendance");
                                String dates = resultSet.getString("date");
                                rshow.setLineWrap(true);
                                rshow.append("Roll no: " + id + ", Attendance: " + att + ", Date: " + dates + "\n");
                                record[size] = att;
                                size++;
                            }
                            rshow.append("\n\nTotal Attendance:  " + size);
                        } catch (Exception exception) {
                            System.out.println(exception);
                        }
                    }
                }
//    cs first

                if (e.getSource()==button&&box.getSelectedIndex()==1) {
                    if (textS.getSelectedIndex() == 1 && departmentS.getSelectedIndex() == 2) {
                        int size = 0;
                        String record[] = new String[100];
                        try {                            rshow.setText("");

                            Connection conn = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                            Statement statement = conn.createStatement();
                            String sql = "SELECT * FROM sm.csfst where id='" + text.getText() + "'";
                            ResultSet resultSet = statement.executeQuery(sql);
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String att = resultSet.getString("attend");
                                String dates = resultSet.getString("date");
                                rshow.setLineWrap(true);
                                rshow.setBounds(360,150-10,300,400);
                                rshow.append("Roll no: " + id + ", Attendance: " + att + ", Date: " + dates + "\n");
                                record[size] = att;
                                size++;
                            }
                            rshow.append("\n\nTotal Attendance:  " + size);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(f,"SomeThing Went Wrong","error",JOptionPane.ERROR_MESSAGE);
                            System.out.println(exception);

                        }
                    }
                }

//cs second

                if (e.getSource()==button&&box.getSelectedIndex()==1) {
                    if (textS.getSelectedIndex() == 2 && departmentS.getSelectedIndex() == 2) {
                        int size = 0;
                        String record[] = new String[100];
                        try {
                            rshow.setText("");

                            Connection conn = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                            Statement statement = conn.createStatement();
                            String sql = "SELECT * FROM sm.cssend where id='" + text.getText() + "'";
                            ResultSet resultSet = statement.executeQuery(sql);
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String att = resultSet.getString("attend");
                                String dates = resultSet.getString("date");
                                rshow.setLineWrap(true);
                                rshow.append("Roll no: " + id + ", Attendance: " + att + ", Date: " + dates + "\n");
                                record[size] = att;
                                size++;
                            }
                            rshow.append("\n\nTotal Attendance:  " + size);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(f,"SomeThing Went Wrong","error",JOptionPane.ERROR_MESSAGE);
                            System.out.println(exception);

                        }
                    }
                }}});

        back.setBounds(550+20, 10, 100, 20);
        back.setText("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                landingpage l = new landingpage();
                l.f.setVisible(true);
            }
        });

        english.setText("English");
        english.setBounds(80,410,100,30);
        english.setFont(fonts);
        english.setForeground(color);
        englisht.setBounds(200,410,150,30);
        englisht.setFont(new Font("Arial",Font.BOLD,15));

        urdu.setText("Urdu");
        urdu.setBounds(80,450,100,30);
        urdut.setBounds(200,450,150,30);
        urdu.setFont(fonts);
        urdu.setForeground(color);
        urdut.setFont(new Font("Arial",Font.BOLD,15));

        math.setText("Math");
        math.setBounds(370,410,100,30);
        matht.setBounds(450+10,410,150,30);
        math.setFont(fonts);
        math.setForeground(color);
        matht.setFont(new Font("Arial",Font.BOLD,15));

        science.setText("Science");
        science.setBounds(370,450,100,30);
        sciencet.setBounds(460,450,150,30);
        science.setFont(fonts);
        science.setForeground(color);
        sciencet.setFont(new Font("Arial",Font.BOLD,15));

        english.setVisible(false);
        englisht.setVisible(false);
        urdu.setVisible(false);
        urdut.setVisible(false);
        math.setVisible(false);
        matht.setVisible(false);
        science.setVisible(false);
        sciencet.setVisible(false);

        rshow.setBounds(360,150-10,300,400);
        rshow.setVisible(false);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (box.getSelectedIndex()==1||box.getSelectedIndex()==2){
                    rshow.setVisible(true);
                }
                else {
                    rshow.setVisible(true);
                }
                if (box.getSelectedIndex()==2){
                }
                else {
                }
                if (box.getSelectedIndex()==3){
                    english.setVisible(true);
                    englisht.setVisible(true);
                    urdu.setVisible(true);
                    urdut.setVisible(true);
                    math.setVisible(true);
                    matht.setVisible(true);
                    science.setVisible(true);
                    sciencet.setVisible(true);
                    rshow.setBounds(360,150-10,300,250);

                }
                else {
                    english.setVisible(false);
                    englisht.setVisible(false);
                    urdu.setVisible(false);
                    urdut.setVisible(false);
                    math.setVisible(false);
                    matht.setVisible(false);
                    science.setVisible(false);
                    sciencet.setVisible(false);
                    rshow.setBounds(360,150-10,300,400);
                 }
                if (box.getSelectedIndex()==4){
                    registrationCheck r = new registrationCheck();
                }
            }
        });
        f.add(english);
        f.add(englisht);
        f.add(urdu);
        f.add(urdut);
        f.add(math);
        f.add(matht);
        f.add(science);
        f.add(sciencet);
        f.add(textS);
        f.add(rshow);
        f.add(department);
        f.add(departmentS);
        f.add(semester);
        f.add(label);
        f.add(back);
        f.add(button);
        f.add(box);
        f.add(Roll);
        f.add(text);
        f.setVisible(true);
    }
    public static void main(String [] args){
        
        result result = new result();
    }


}