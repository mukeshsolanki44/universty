package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class attendance_mark{

    Font font = new Font("Monospace",Font.BOLD,50);
    Font fonts = new Font("Monospace",Font.BOLD,20);
    attendance_mark(){

        JFrame f = new JFrame();
        JLabel label = new JLabel("Attendance_Mark");
        JLabel semester = new JLabel();
        JComboBox textS = new JComboBox();
        JLabel Roll = new JLabel("Attendance_Mark");
        JComboBox box = new JComboBox();
        JTextArea text = new JTextArea();


        label.setBounds(100,50,500,100);
        label.setForeground(Color.white);
        label.setFont(font);
//    label.setFont(new Font("Arial", Font.BOLD, 50));

        Roll.setBounds(50,200,250,20);
        Roll.setText("Registration_Number");
        Roll.setFont(fonts);
        Roll.setForeground(Color.white);

        text.setBounds(250+20,200,200,25);
        text.setFont(new Font("arial",Font.BOLD,15));



        semester.setBounds(50,250,250,20);
        semester.setText("Semester");
        semester.setFont(fonts);
        semester.setForeground(Color.white);

        textS.setBounds(250+20,250,200,25);
        textS.setFont(new Font("arial",Font.BOLD,15));
        String array []={"Select","1","2",};

        for (int i = 0; i < array.length; i++) {
            textS.addItem(array[i]);
        }
        JLabel department = new JLabel();
        department.setBounds(50,300,250,20);
        department.setText("Department");
        department.setFont(fonts);
        department.setForeground(Color.white);

        JComboBox departmentS = new JComboBox();
        departmentS.setBounds(250+20,300,200,25);
        departmentS.setFont(new Font("arial",Font.BOLD,15));
        String arrays []={"Select","Information_Technology","Computer Science"};

        for (int i = 0; i < arrays.length; i++) {
            departmentS.addItem(arrays[i]);
        }

        box.setBounds(50,350,200,30);
        box.setFont(new Font("arial",Font.BOLD,15));
        box.addItem("Select");
        box.addItem("P");
        box.addItem("A");
        JButton button = new JButton("OK");
        button.setBounds(50,400,80,30);

        button.addActionListener(new ActionListener() {
            Connection connection;
            Statement statement;
            ResultSet resultSet;
            int r_id;
            String depart,semester,attendance,department;

            LocalDateTime dates = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String date=dates.format(formatter);

            @Override
            public void actionPerformed(ActionEvent e) {
                Statement statement;
                if (e.getSource()==button){
                    if (text.getText().length()<1){
                        JOptionPane.showMessageDialog(f,"Registration number = null","Warning",JOptionPane.WARNING_MESSAGE);
                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            System.out.println("ConnectionClose99");

                        }
                    }
                    else  if (textS.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(f,"Select Semester","Warning",JOptionPane.WARNING_MESSAGE);
                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            System.out.println("ConnectionClose107");
                        }
                    }
                    else  if (departmentS.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(f,"Select Department","Warning",JOptionPane.WARNING_MESSAGE);
                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            System.out.println("ConnectionClose114");
                        }

                    }
                    else  if (box.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(f,"Select Attendance","Warning",JOptionPane.WARNING_MESSAGE);
                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            System.out.println("ConnectionClose124");

                        }

                    }
                    if (e.getSource()==button){
                        if (departmentS.getSelectedIndex()==1&&textS.getSelectedIndex()==1){
                            try {
                                connection = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                                statement = connection.createStatement();
                                String sql = "SELECT * FROM sm.rform";
                                ResultSet resultSet = statement.executeQuery(sql);
                                if (resultSet.next()){
                                    String add = "INSERT INTO `sm`.`itfst` (`roll`,`attend`,`date`) VALUES ('"+ text.getText() +"','"+ box.getSelectedItem()+"','"+date+"')";
                                    statement.executeUpdate(add);
                                    text.setText("");
                                    JOptionPane.showMessageDialog(f,"done","done",JOptionPane.PLAIN_MESSAGE);

                                }

                            }
                            catch (Exception exception){
                                System.out.println(exception+" Line number 116" );
                            }
                        }
//                        it seconds

                        if (departmentS.getSelectedIndex()==1&&textS.getSelectedIndex()==2){
                            try {
                                connection = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                                statement = connection.createStatement();
                                String sql = "SELECT * FROM sm.rform";
                                ResultSet resultSet = statement.executeQuery(sql);
                                if (resultSet.next()){
                                    String add = "INSERT INTO `sm`.`itsecnd` (`roll`,`attendance`,`date`) VALUES ('"+ text.getText() +"','"+ box.getSelectedItem()+"','"+date+"')";
                                    statement.executeUpdate(add);
                                    text.setText("");
                                    JOptionPane.showMessageDialog(f,"done","done",JOptionPane.PLAIN_MESSAGE);

                                }

                            }
                            catch (Exception exception){
                                System.out.println(exception+" Line number 116" );
                            }
                        }
//                        cs first
                        if (departmentS.getSelectedIndex()==2&&textS.getSelectedIndex()==1){
                            try {
                                connection = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                                statement = connection.createStatement();
                                String sql = "SELECT * FROM sm.rform";
                                ResultSet resultSet = statement.executeQuery(sql);
                                if (resultSet.next()){
                                    String add =
                                            "INSERT INTO `sm`.`csfst` (`id`,`attend`,`date`) VALUES ('"+ text.getText() +"','"+ box.getSelectedItem()+"','"+date+"')";
                                    statement.executeUpdate(add);
                                    text.setText("");
                                    JOptionPane.showMessageDialog(f,"done","done",JOptionPane.PLAIN_MESSAGE);

                                }

                            }
                            catch (Exception exception){
                                System.out.println(exception+" Line number 116" );
                            }
                        }
//                        cs second
                        if (departmentS.getSelectedIndex()==2&&textS.getSelectedIndex()==2){
                            try {
                                connection = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                                statement = connection.createStatement();
                                String sql = "SELECT * FROM sm.rform";
                                ResultSet resultSet = statement.executeQuery(sql);
                                if (resultSet.next()){
                                    String add =
                                            "INSERT INTO `sm`.`cssend` (`id`,`attend`,`date`) VALUES ('"+ text.getText() +"','"+ box.getSelectedItem()+"','"+date+"')";
                                    statement.executeUpdate(add);
                                    text.setText("");
                                    JOptionPane.showMessageDialog(f,"done","done",JOptionPane.PLAIN_MESSAGE);
                                }

                            }
                            catch (Exception exception){
                                System.out.println(exception+" Line number 114" );
                            }
                        }
                    }
                }
//                if (e.getSource()==button){
//                    if (text.getText().length()<1){
//                        JOptionPane.showMessageDialog(f,"Registration number = null","Warning",JOptionPane.WARNING_MESSAGE);
//                    }
//                    else  if (textS.getSelectedIndex()==0){
//                        JOptionPane.showMessageDialog(f,"Select Semester","Warning",JOptionPane.WARNING_MESSAGE);
//                    }
//                    else  if (departmentS.getSelectedIndex()==0){
//                        JOptionPane.showMessageDialog(f,"Select Department","Warning",JOptionPane.WARNING_MESSAGE);
//                    }
//                    else  if (box.getSelectedIndex()==0){
//                        JOptionPane.showMessageDialog(f,"Select Attendance","Warning",JOptionPane.WARNING_MESSAGE);
//                    }
//
//                }
//                try {
//                    connection = DriverManager.getConnection(
//                            "jdbc:mysql://localhost:3306/sm", "root", "Wrqgwjkp@967@#5");
//                    statement = connection.createStatement();
//                    String sql = "SELECT * FROM sm.rform";
//                    ResultSet resultSet = statement.executeQuery(sql);
//
//                    while (resultSet.next()) {
//                        String a = "1";
//                        String cnic = resultSet.getString("id");
//                        String d = resultSet.getString("depart");
//                        semester = resultSet.getString("semester");
//                        int aa=Integer.parseInt(text.getText());
//                        int aaa=Integer.parseInt(cnic);
//                        int idea =1;
//                        int semester1=2;
//                        int semester2=1;
//
//                        if (aaa==aa&&idea==Integer.parseInt(semester)&& departmentS.getSelectedIndex()==1&&textS.getSelectedIndex()==1){
//                             connection = DriverManager.getConnection(
//                                    "jdbc:mysql://localhost:3306/sm", "root", "Wrqgwjkp@967@#5");
//                            statement = connection.createStatement();
//                            String add =
//                                    "INSERT INTO `sm`.`itfst` (`roll`,`attend`,`date`) VALUES ('"+ aa +"','"+ box.getSelectedItem()+"','"+date+"')";
//                            statement.executeUpdate(add);
//                            text.setText("");
//                            JOptionPane.showMessageDialog(f,"success","success",JOptionPane.PLAIN_MESSAGE);
//                             break;
//                        }
//                        else
//                        if (aaa==aa && semester1==Integer.parseInt(semester) && departmentS.getSelectedIndex()==1 && textS.getSelectedIndex()==2){
//                            connection = DriverManager.getConnection(
//                                    "jdbc:mysql://localhost:3306/sm", "root", "Wrqgwjkp@967@#5");
//                            statement = connection.createStatement();
//                            String add =
//                                    "INSERT INTO `sm`.`itsecnd` (`roll`,`attendance`,`date`) VALUES ('"+ text.getText() +"','"+ box.getSelectedItem()+"','"+date+"')";
//                            statement.executeUpdate(add);
//                            System.out.println("it second");
//                            JOptionPane.showMessageDialog(f,"Successful","Successful",JOptionPane.PLAIN_MESSAGE);
//                            text.setText("");
//                            break;
//                        }
//                        else
//                        if (aaa==aa && semester2==Integer.parseInt(semester) && departmentS.getSelectedIndex()==2 && textS.getSelectedIndex()==1){
//                            connection = DriverManager.getConnection(
//                                    "jdbc:mysql://localhost:3306/sm", "root", "Wrqgwjkp@967@#5");
//                            statement = connection.createStatement();
//                            String add =
//                                    "INSERT INTO `sm`.`csfst` (`id`,`attend`,`date`) VALUES ('"+ text.getText() +"','"+ box.getSelectedItem()+"','"+date+"')";
//                            statement.executeUpdate(add);
//                            System.out.println("it cs third");
//                            JOptionPane.showMessageDialog(f,"Successful","Successful",JOptionPane.PLAIN_MESSAGE);
//                            break;
//                        }
//                        else
//                        if (aaa==aa && semester1==Integer.parseInt(semester) && departmentS.getSelectedIndex()==2 && textS.getSelectedIndex()==2){
//                            connection = DriverManager.getConnection(
//                                    "jdbc:mysql://localhost:3306/sm", "root", "Wrqgwjkp@967@#5");
//                            statement = connection.createStatement();
//                            String add =
//                                    "INSERT INTO `sm`.`cssend` (`id`,`attend`,`date`) VALUES ('"+ text.getText() +"','"+ box.getSelectedItem()+"','"+date+"')";
//                            statement.executeUpdate(add);
//                            System.out.println("it cs 4th");
//                            JOptionPane.showMessageDialog(f,"Successful","Successful",JOptionPane.PLAIN_MESSAGE);
//                            break;
//                        }
//
////                                                  computer Science
//
//                        if (aaa==aa&&idea==Integer.parseInt(semester)&& departmentS.getSelectedIndex()==1&&textS.getSelectedIndex()==1){
//                            System.out.println("Second");
//                            connection = DriverManager.getConnection(
//                                    "jdbc:mysql://localhost:3306/sm", "root", "Wrqgwjkp@967@#5");
//                            statement = connection.createStatement();
//                            String add =
//                                    "INSERT INTO `sm`.`itfst` (`roll`,`attend`,`date`) VALUES ('"+ aa +"','"+ box.getSelectedItem()+"','"+date+"')";
//                            statement.executeUpdate(add);
//                            System.out.println("yes");
//                            JOptionPane.showMessageDialog(f,"Successful","Successful",JOptionPane.PLAIN_MESSAGE);
//                            break;
//                        }
//                        else
//                        if (aaa==aa && semester1==Integer.parseInt(semester) && departmentS.getSelectedIndex()==1 && textS.getSelectedIndex()==2){
//                            connection = DriverManager.getConnection(
//                                    "jdbc:mysql://localhost:3306/sm", "root", "Wrqgwjkp@967@#5");
//                            statement = connection.createStatement();
//                            String add =
//                                    "INSERT INTO `sm`.`itsecnd` (`roll`,`attendance`,`date`) VALUES ('"+ text.getText() +"','"+ box.getSelectedItem()+"','"+date+"')";
//                            statement.executeUpdate(add);
//                            JOptionPane.showMessageDialog(f,"Successful","Successful",JOptionPane.PLAIN_MESSAGE);
//                             break;
//                        }
////                        JOptionPane.showMessageDialog(f,"Invalid","invalid",JOptionPane.ERROR_MESSAGE);
//                    }
//                }catch (Exception exceptione){
//                    System.out.println(exceptione+"Error 420");
//                }

            }
        });

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.white);
            }
        });
        JButton back = new JButton();
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




        f.add(textS);
        f.add(department);
        f.add(departmentS);
        f.add(semester);
        f.add(label);
        f.add(back);
        f.add(button);
        f.add(box);
        f.add(Roll);
        f.add(text);
        f.setLayout(null);
        f.setSize(700, 600);
        f.setTitle("Management");
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(50,50,86));
        int redR=50;int blueR= 50;int greenR= 86;
        f.setVisible(true);
        f.setLocationRelativeTo(null);


/*
         int redL=135;int blueL= 211;int greenL= 99;
         right.setBackground(new Color(50, 50, 86));
         left.setBackground(new Color(redL, greenL, blueL));

         right = r50,g50,b86
         left  = r135,g99,b211

 */
        int a=0;
        int c =0;
        boolean b = true;
//        while (true){
//            try {
//                Thread.sleep(100);
//                if (b==true){
//                    label.setBounds(100+a,50+a,500,100);
//                    a++;
//
//                }
//                else {
//                    label.setBounds(100+a,50+a,500,100);
//                    a--;
//                }
//                if (a>10){
//
//                    b=false;
//                }
//                else if (a<1){
//
//                    b=true;
//                }
//            }catch (Exception e){
//                System.out.println(e);
//            }
//        }


    }
    public static void main(String[] args) {
        attendance_mark attendanceMark = new attendance_mark();
    }
}