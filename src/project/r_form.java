package project;



import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class r_form {

    String name,dob,dep,gen,adrs,phone;
    JFrame f = new JFrame();
    Font font = new Font("Monospace",Font.BOLD,20);
    Font fonts = new Font("Monospace",Font.BOLD,15);
    JInternalFrame Iframe = new JInternalFrame("Warning", false, false, false);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    JButton buttons = new JButton("ok");
    JLabel warnL = new JLabel();
    JLabel rgf = new JLabel();
    JLabel nameL = new JLabel();
    JLabel mobileL = new JLabel();
    JLabel dobl = new JLabel();
    JLabel reg = new JLabel();
    JLabel addressl = new JLabel();
    JLabel genderl = new JLabel();
    JLabel departl = new JLabel();
    JLabel semester = new JLabel();

    JTextArea namet = new JTextArea();
    JComboBox departt = new JComboBox();
    JTextArea mobilet = new JTextArea();
    JComboBox semestert = new JComboBox();

    JButton back = new JButton();
    JTextArea addresst = new JTextArea();
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup gendert = new ButtonGroup();
    JComboBox day = new JComboBox();
    JComboBox months = new JComboBox();
    JComboBox year = new JComboBox();
    JCheckBox cbox = new JCheckBox();
    JButton button = new JButton();
    JTextArea record = new JTextArea();

    public void display() {

        f.setLayout(null);
        f.setSize(700, 600);
        f.setTitle("RegistrationForm");
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.gray.brighter());
        f.getContentPane().setBackground(new Color(135,99,211));
        int redR=50;int blueR= 50;int greenR= 86;

        rgf.setBounds(100, 35, 450+250*20/100, 60);
        rgf.setFont(new Font("Monospace", Font.CENTER_BASELINE, 50));
        rgf.setForeground(new Color(255, 255, 255));
        rgf.setText("Registration Form");

        nameL.setBounds(30, 130, 100+100*10/100, 20+20*10/100);
        nameL.setForeground(Color.white);
        nameL.setFont(font);
        nameL.setText("Name");
        namet.setBounds(130, 70+10+50, 150+150*10/100, 20+20*10/100);
        namet.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 18));


        mobileL.setBounds(30, 100+10+50, 100+100*10/100, 20+20*10/100);
        mobileL.setFont(font);
        mobileL.setForeground(Color.white);
        mobileL.setText("Mobile");
        mobilet.setBounds(130, 100+10+50, 150+150*10/100, 20+20*10/100);
        mobilet.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 18));

        dobl.setBounds(30, 130+10+50, 100+100*10/100, 20+20*10/100);
        dobl.setForeground(Color.white);
        dobl.setFont(font);
        dobl.setText("D_O_B");
        day.setBounds(130, 130+10+50, 60+60*10/100, 20+20*10/100);
        day.setCursor(cursor);
        months.setBounds(192, 130+10+50, 60+60*10/100, 20+20*10/100);
        months.setCursor(cursor);
        year.setBounds(254, 130+10+50, 60+60*10/100, 20+20*10/100);
        year.setCursor(cursor);

        String days[] = {"Days", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        for (int i = 0; i < days.length; i++) {
            day.addItem(days[i]);
        }
        String month[] = {"Month", "JAN", "FEB", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPT", "NOVM", "DEC"};
        for (int i = 0; i < month.length; i++) {
            months.addItem(month[i]);
        }
        String years[] = {"Years", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022",};
        for (int i = 0; i < years.length; i++) {
            year.addItem(years[i]);
        }

        genderl.setBounds(30, 160+10+50, 100+100*10/100, 20+20*10/100);
        genderl.setText("Gender");
        genderl.setFont(font);
        genderl.setForeground(Color.white);
        gendert.add(male);
        gendert.add(female);
        male.setBounds(130, 160+10+50, 70+20*10/100, 20+20*10/100);
        male.setCursor(cursor);
        male.setSelected(true);
        female.setBounds(200, 160+10+50, 70+70*10/100, 20+20*10/100);
        female.setCursor(cursor);

        departl.setBounds(30, 200+50, 100+100*10/100, 20+20*10/100);
        departl.setText("Depart");
        departl.setForeground(Color.white);
        departl.setFont(font);

        departt.setBounds(130, 200+50, 150+150*10/100, 20+20*10/100);
        departt.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 18));
        departt.addItem("Select");
        departt.addItem("BS IT");
        departt.addItem("BS CS ");

        semester.setBounds(30, 230+50, 100+100*10/100, 20+20*10/100);
        semester.setForeground(Color.white);
        semester.setFont(font);
        semester.setText("Semester");
        semestert.setBounds(130, 230+50, 150+150*10/100, 20+20*10/100);
        semestert.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 18));
        String [] array={"1","2"};
        for (int i = 0; i < array.length; i++) {
            semestert.addItem(array[i]);

        }

        addressl.setBounds(30, 190+80+50, 100+100*10/100, 20+20*10/100);
        addressl.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 18));
        addressl.setText("Address");
        addressl.setFont(font);
        addressl.setForeground(Color.white);
        semester.setForeground(Color.white);
        addresst.setBounds(130, 320, 200+200*10/100, 50+50*10/100);
        addresst.setLineWrap(true);

        cbox.setBounds(40, 280+70+50, 300, 20+20*10/100);
        cbox.setText("Confirm!!!");
        cbox.setCursor(cursor);

        button.setBounds(130, 450, 100+100, 25+25*10/100);
        button.setCursor(cursor);
        button.setText("Register");
        back.setBounds(550+20, 10, 100, 30);
        back.setCursor(cursor);
        back.setText("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                landingpage l = new landingpage();
                l.f.setVisible(true);
            }
        });

        record.setBounds(370, 130, 200+200*10/100+50, 350+250*10/100);
        record.setFont(fonts);
        record.setFocusable(false);
        record.setLineWrap(true);
        button.addActionListener(new ActionListener() {
            Connection connection;
            Statement statement;
            ResultSet resultSet;
            @Override
            public void actionPerformed(ActionEvent e) {
                record.setText("");
                if (e.getSource()==button&&cbox.isSelected()){



                    if (namet.getText().length()<1){
                        JOptionPane.showMessageDialog(f,"Add Name"  ,"Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    else if (day.getSelectedIndex()==0||months.getSelectedIndex()==0||year.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(f,"Select "+" \"Day\""+" \"Month\""+" \"Year\""  ,"Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    else if (departt.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(f,"Select Department"  ,"Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    else if (addresst.getText().length()<1){
                        JOptionPane.showMessageDialog(f,"Add Address"  ,"Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        dep= (String) departt.getSelectedItem();
                        adrs=addresst.getText();
                        name=namet.getText();
                        dob= day.getSelectedItem()+"_"+months.getSelectedItem()+"_"+year.getSelectedItem();
                        phone=mobilet.getText();
                        if (male.isSelected()) {
                            gen = male.getText();
                        } else if (female.isSelected()) {
                            gen = female.getText();
                        }
                        String number =mobilet.getText();
                        for (int i = 0; i < number.length(); i++) {
                            char a = number.charAt(i);
                            if (number.charAt(i)=='1' || a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a=='0'){
                                 try {
   record.setText( nameL.getText() + ": " + namet.getText() + "\n" + mobileL.getText() + ": " + mobilet.getText() + "\n" + dobl.getText() + ": " + dob + "\n" + genderl.getText() + ": " + gen + "\n" +departl.getText()+": "+departt.getSelectedItem()+ "\n" + addressl.getText() + ": " + addresst.getText());


                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }

                                try {
             connection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3307/sm", "root", "123456789");
                statement = connection.createStatement();
            String records =
  "INSERT INTO `sm`.`rform` (`name`,`dob`,`gender`,`depart`,`address`,`semester`) VALUES ('"+name+"', '"+dob+"','"+gen+"','"+dep+"','"+adrs+"','"+semestert.getSelectedItem()  +"')";
    statement.executeUpdate(records);
       String sql = "SELECT * FROM sm.rform where name='" + namet.getText() + "'";
        ResultSet resultSets = statement.executeQuery(sql);
           if (resultSets.next()) {
              String id = resultSets.getString("id");
                record.setText(
   "Registration no: " + id + "\n" + nameL.getText() + ": " + namet.getText() + "\n" + mobileL.getText() + ": " + mobilet.getText() + "\n" + dobl.getText() + ": " + dob + "\n" + genderl.getText() + ": " + gen + "\n" + departl.getText() + ": " + departt.getSelectedItem() + "\n" + addressl.getText() + ": " + addresst.getText()+"\n"+semester.getText()+": "+semestert.getSelectedItem());
                  }
                   JOptionPane.showMessageDialog(f,"Registered"  ,"Done",JOptionPane.PLAIN_MESSAGE);
                                    namet.setText("");
                                    mobilet.setText("");
                                    addresst.setText("");
                                }
                                catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            else
                                JOptionPane.showMessageDialog(f,"Invalid Number"  ,"Warning",JOptionPane.WARNING_MESSAGE);
                            button.setSelected(false);
                            break;
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(f,"Check the box","Warning",JOptionPane.WARNING_MESSAGE);
                }
                if (name.length()>0&&phone.length()>0&&adrs.length()>0&&dep.length()>0&&semestert.getSelectedIndex()>0){
                    namet.setText("");
                    addresst.setText("");
                    mobilet.setText("");
                    JOptionPane.showMessageDialog(f,"Successful","Registration Successful",JOptionPane.PLAIN_MESSAGE );
                }
            }
        });

        f.add(Iframe);
        f.add(rgf);
        f.add(nameL);
        f.add(dobl);
        f.add(addressl);
        f.add(genderl);
        f.add(mobileL);
        f.add(namet);
        f.add(mobilet);
        f.add(addresst);
        f.add(male);
        f.add(female);
        f.add(day);
        f.add(months);
        f.add(semester);
        f.add(semestert);
        f.add(year);
        f.add(cbox);
        f.add(button);
        f.add(back);
        f.add(record);
        f.add(reg);
        f.add(departl);
        f.add(departt);
        f.setVisible(true);


        int a =0;
        boolean b = true;
            try {
//        while (true) {
//                Thread.sleep(20);
//
//                if (b == true) {
//                    a=a+2;
//                    rgf.setForeground(new Color(a, a, a));
//                } else {
//                    a=a-2;
//                    rgf.setForeground(new Color(a, a, a));
//                }
//                if (a > 249) {
//                    b = false;
//                } else if (a < 1) {
//                    b = true;
//                }
            }catch (Exception e) {
                System.out.println(e);
            }


    }
    public static void main(String [] args){
        r_form r = new r_form();
        r.display();
    }
}
