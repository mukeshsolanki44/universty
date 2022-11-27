package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
public class landingpage implements MouseListener {
     Color c = new Color(0, 0, 0, 255);
    JPanel left = new JPanel();
    Font font = new Font("monospace",Font.CENTER_BASELINE,40);
    JPanel right = new JPanel();
    GridLayout layout = new GridLayout();
    int redL=135;int blueL= 211;int greenL= 99;
    int redR=50;int blueR= 50;int greenR= 86;

    JLabel registers = new JLabel();
    JLabel results = new JLabel();
    JLabel attendances = new JLabel();
    JLabel libraries = new JLabel();

    public JFrame f = new JFrame();
    JButton register = new JButton("");
    JButton attendance = new JButton("");
    JButton result = new JButton("");
    JButton libraryy = new JButton("");


    ImageIcon icon1 = new ImageIcon("personal.png");
    Image image = icon1.getImage();
    Image imageScale = image.getScaledInstance(150,150, Image.SCALE_SMOOTH);
    ImageIcon scaled = new ImageIcon(imageScale);

    ImageIcon iconR = new ImageIcon("research.png");
    Image imageR = iconR.getImage();
    Image imageScaleR = imageR.getScaledInstance(150,150, Image.SCALE_SMOOTH);
    ImageIcon scaledR = new ImageIcon(imageScaleR);

    ImageIcon iconA = new ImageIcon("checking-attendance.png");
    Image imageA = iconA.getImage();
    Image imageScaleA = imageA.getScaledInstance(150,150, Image.SCALE_SMOOTH);
    ImageIcon scaledA = new ImageIcon(imageScaleA);

    ImageIcon iconL = new ImageIcon("library.png");
    Image imageL = iconL.getImage();
    Image imageScaleL = imageL.getScaledInstance(150,150, Image.SCALE_SMOOTH);
    ImageIcon scaledL = new ImageIcon(imageScaleL);

    public landingpage(){
        f.setLayout(layout);
        f.setSize(700, 600);
        f.setTitle("Management");
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.gray.brighter());
        f.setLocationRelativeTo(null);


        register.setIcon(scaled);
        register.setBackground(c);
        register.setCursor(new Cursor(Cursor.HAND_CURSOR));
        register.setOpaque(false);
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        register.setBorderPainted(false);

        result.setIcon(scaledR);
        result.setBackground(c);
        result.setCursor(new Cursor(Cursor.HAND_CURSOR));
        result.setOpaque(false);
        result.setContentAreaFilled(false);
        result.addMouseListener(this);
        result.setBorderPainted(false);

        attendance.setIcon(scaledA);
        attendance.setBackground(c);
        attendance.setCursor(new Cursor(Cursor.HAND_CURSOR));
        attendance.setOpaque(false);
        attendance.setContentAreaFilled(false);
        attendance.addMouseListener(this);
        attendance.setBorderPainted(false);

        libraryy.setIcon(scaledL);
        libraryy.setBackground(c);
        libraryy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        libraryy.setOpaque(false);
        libraryy.setContentAreaFilled(false);
        libraryy.addMouseListener(this);
        libraryy.setBorderPainted(false);
        f.setVisible(false);

        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result result = new result();
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==register){
                    r_form r = new r_form();
                    f.setVisible(false);
                    r.display();
                }
            }
        });
        libraryy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==libraryy){
                    library l = new library();
                    l.frame();
                    f.setVisible(false);
                    l.f.setVisible(true);
                }
            }
        });
        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==attendance){
                    attendance_mark attendanceMark = new attendance_mark();
                    f.setVisible(false);
                }
            }
        });

        left.setBackground(new Color(redL,greenL,blueL));
        left.setLayout(null);
        right.setLayout(null);
        right.setBackground(new Color(50, 50, 86));

        registers.setText("Register");
        registers.setForeground(Color.white);
        registers.setFont(font);
        registers.setBounds(110,30,200,50);
        register.setBounds(100,100,160,160);
        left.add(register);
        left.add(registers);

        results.setText("Result");
        results.setForeground(Color.white);
        results.setFont(font);
        results.setBounds(110,290,200,50);
        result.setBounds(100,350,160,160);
        left.add(result);
        left.add(results);

        attendances.setText("Attendance");
        attendances.setForeground(Color.white);
        attendances.setFont(font);
        attendances.setBounds(65,30,230,50);
        attendance.setBounds(100,100,160,160);
        right.add(attendance);
        right.add(attendances);

        libraries.setText("Library");
        libraries.setForeground(Color.white);
        libraries.setFont(font);
        libraries.setBounds(110,290,200,50);
        libraryy.setBounds(100,300+50,160,160);
        right.add(libraryy);
        right.add(libraries);




        System.out.println("landing page");
        f.add(left);
        f.add(right);
        f.setVisible(true);

        int a =0;
        boolean b = true;
        try {
//                Thread.sleep(1000);
//                if (b==true){
//                    a++;
////                    registers.setBounds(110,a+30,200,50);
////                    results.setBounds(110,a+290,200,50);
////                    attendances.setBounds(65+a,30,230,50);
////                    libraries.setBounds(110+a,290,200,50);
//                }
//                else  {
//                    a--;
////                    libraries.setBounds(110+a,290,200,50);
////                    registers.setBounds(110,a+30,200,50);
////                    results.setBounds(110,a+290,200,50);
////                    attendances.setBounds(65+a,30,230,50);
//                }if (a>10){b=false;}
//                else if (a<1){b=true;}
        }
        catch (Exception exception){
            System.out.println(exception);}}

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==register){
            System.out.println("click");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==register){
            System.out.println("pressed");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource()==register){

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==register){
            registers.setForeground(Color.red);
        }
        if (e.getSource()==result){
            results.setForeground(Color.red);
        }if (e.getSource()==libraryy){
            libraries.setForeground(Color.red);
        }if (e.getSource()==attendance){
            attendances.setForeground(Color.red);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==register){
            registers.setForeground(Color.white);
        }
        if (e.getSource()==result){
            results.setForeground(Color.white);
        }
        if (e.getSource()==libraryy){
            libraries.setForeground(Color.white);
        }
        if (e.getSource()==attendance){
            attendances.setForeground(Color.white);
        }

    }


public static void main(String [] ars){
    landingpage l = new landingpage();
}

}
//
//    landingpage(){
//        f.setLayout(layout);
//        f.setSize(700, 600);
//        f.setTitle("Management");
//        f.setResizable(false);
//        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
//        f.getContentPane().setBackground(Color.gray.brighter());
//        f.setLocationRelativeTo(null);
//
//        register.setIcon(scaled);
//        register.setBackground(c);
//        register.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        register.setOpaque(false);
//        register.setContentAreaFilled(false);
//        register.addMouseListener(this);
//        register.setBorderPainted(false);
//
//        result.setIcon(scaledR);
//        result.setBackground(c);
//        result.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        result.setOpaque(false);
//        result.setContentAreaFilled(false);
//        result.addMouseListener(this);
//        result.setBorderPainted(false);
//
//        attendance.setIcon(scaledA);
//        attendance.setBackground(c);
//        attendance.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        attendance.setOpaque(false);
//        attendance.setContentAreaFilled(false);
//        attendance.addMouseListener(this);
//        attendance.setBorderPainted(false);
//
//        libraryy.setIcon(scaledL);
//        libraryy.setBackground(c);
//        libraryy.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        libraryy.setOpaque(false);
//        libraryy.setContentAreaFilled(false);
//        libraryy.addMouseListener(this);
//        libraryy.setBorderPainted(false);
//
//        result.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                schoolManagement.result result1 = new schoolManagement.result();
//                System.out.println("result");
//            }
//        });
//
//        register.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource()==register){
////
////                    r_form r = new r_form();
////                    r.display();
//                    System.out.println("Rform");
//                }
//            }
//        });
//        libraryy.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource()==libraryy){
////                    library l = new library();
////                    l.frame();
////                    l.f.setVisible(true);
//                    System.out.println("library");
//                    System.out.println("ok");
//                }
//            }
//        });
//        attendance.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource()==attendance){
////                    attendance_mark attendanceMark = new attendance_mark();
//                    System.out.println("attendanceMark");
//                }
//            }
//        });
//
//        left.setBackground(new Color(redL,greenL,blueL));
//        left.setLayout(null);
//        right.setLayout(null);
//        right.setBackground(new Color(50, 50, 86));
//
//        registers.setText("Register");
//        registers.setForeground(Color.white);
//        registers.setFont(font);
//        registers.setBounds(110,30,200,50);
//        register.setBounds(100,100,160,160);
//        left.add(register);
//        left.add(registers);
//
//        results.setText("Result");
//        results.setForeground(Color.white);
//        results.setFont(font);
//        results.setBounds(110,290,200,50);
//        result.setBounds(100,350,160,160);
//        left.add(result);
//        left.add(results);
//
//        attendances.setText("Attendance");
//        attendances.setForeground(Color.white);
//        attendances.setFont(font);
//        attendances.setBounds(65,30,230,50);
//        attendance.setBounds(100,100,160,160);
//        right.add(attendance);
//        right.add(attendances);
//
//        libraries.setText("Library");
//        libraries.setForeground(Color.white);
//        libraries.setFont(font);
//        libraries.setBounds(110,290,200,50);
//        libraryy.setBounds(100,300+50,160,160);
//        right.add(libraryy);
//        right.add(libraries);
//
//
//        f.add(left);
//        f.add(right);
//        f.setVisible(true);
//
//        int a =0;
//        boolean b = true;
//        while (true){
//            try {
//                Thread.sleep(100);
//                if (b==true){
//                    a++;
////                    registers.setBounds(110,a+30,200,50);
////                    results.setBounds(110,a+290,200,50);
////                    attendances.setBounds(65+a,30,230,50);
////                    libraries.setBounds(110+a,290,200,50);
//                }
//                else  {
//                    a--;
////                    libraries.setBounds(110+a,290,200,50);
////                    registers.setBounds(110,a+30,200,50);
////                    results.setBounds(110,a+290,200,50);
////                    attendances.setBounds(65+a,30,230,50);
//                }if (a>10){b=false;}
//                else if (a<1){b=true;}}
//            catch (Exception exception){
//                System.out.println(exception);}}
//    }
//    public static void main(String[] args) {
//        landingpage landing_page = new landingpage();
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        if (e.getSource()==register){
//            System.out.println("click");
//        }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        if (e.getSource()==register){
//            System.out.println("pressed");
//        }
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        if (e.getSource()==register){
//
//        }
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        if (e.getSource()==register){
//            registers.setForeground(Color.red);
//        }
//        if (e.getSource()==result){
//            results.setForeground(Color.red);
//        }if (e.getSource()==libraryy){
//            libraries.setForeground(Color.red);
//        }if (e.getSource()==attendance){
//            attendances.setForeground(Color.red);
//        }
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        if (e.getSource()==register){
//            registers.setForeground(Color.white);
//        }
//        if (e.getSource()==result){
//            results.setForeground(Color.white);
//        }
//        if (e.getSource()==libraryy){
//            libraries.setForeground(Color.white);
//        }
//        if (e.getSource()==attendance){
//            attendances.setForeground(Color.white);
//        }
//
//    }
//
//}