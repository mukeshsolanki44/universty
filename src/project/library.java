package project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class library implements ItemListener, ActionListener{
    Font font = new Font("Monospace",Font.BOLD,50);
    Font fonts = new Font("Monospace",Font.BOLD,20);

    LinkedList<String> al=new LinkedList<String>();
    String [] array = new String[100];
    String set;
    int i;
    int size =0;
    Connection conn;
    Statement statement;

    LocalDateTime dates = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String date=dates.format(formatter);


    JTextArea trying = new JTextArea();
    JLabel name = new JLabel("Name");
    JLabel id = new JLabel("Name");
    JTextField namet=new JTextField();
    JTextField ids=new JTextField();

    JFrame f = new JFrame();
    JButton logOut = new JButton("OK");
    JLabel library= new JLabel("Library");
    JButton issueBook = new JButton("");
    JButton returnBook = new JButton("");
    JButton availableBook = new JButton("");
    JButton addBook = new JButton();
    JButton EditionButton = new JButton();
    JComboBox comboBox = new JComboBox();
    JTextArea textArea=new JTextArea("",0,TextArea.SCROLLBARS_VERTICAL_ONLY);
    JScrollPane scroll = new JScrollPane ();

    JLabel nameL=new JLabel();
    JLabel cnicL=new JLabel();
    JTextArea text = new JTextArea();
    JTextArea Searchbar = new JTextArea();

    public void frame(){

//        trying.set

        f.setLayout(null);
        f.setSize(700, 600);
        f.setTitle("Management");
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(50,50,86));
//            int redR=50;int blueR= 50;int greenR= 86;

        f.setLocationRelativeTo(null);
        System.out.println("Successful");
        library.setBounds(100,20,500,100);
        library.setText("Library Management");
        library.setForeground(Color.white);
        library.setFont(font);
        library.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);


        logOut.setBounds(550,10,100,30);
        logOut.setText("Back");
        logOut.setBackground(Color.white);
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if (e.getSource()==logOut){
                    f.setVisible(false);
                    landingpage l = new landingpage();
                    l.f.setVisible(true);
                }
            }
        });


        textArea.setBounds(400+20,150,200+50,300);
        textArea.setFont(new Font("Arial",Font.PLAIN,15));


        String box[]={"Select","Available","Return","Issue","Add","delete"};
        for (int b = 0; b < box.length; b++) {
            comboBox.addItem(box[b]);
        }
        comboBox.setBounds(100,300,300,30+10);
        comboBox.setFont(fonts);
        comboBox.addItemListener(this);

        text.setLineWrap(true);
        text.setBounds(100,360,300,30);
        text.setFont(new Font("courier",Font.PLAIN,20));

        EditionButton.setBounds(300,400,100,30);
        EditionButton.setText("Click");
        EditionButton.addActionListener(this);


        f.add(namet);
        f.add(nameL);
        f.add(ids);
        f.add(id);
        f.add(textArea);
        f.add(logOut);
        f.add(scroll);
        f.add(library);
        f.add(availableBook);
        f.add(issueBook);
        f.add(EditionButton);
        f.add(returnBook);
        f.add(text);
        f.add(comboBox);
        f.add(Searchbar);
        f.add(addBook);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (comboBox.getSelectedIndex()==0){
            textArea.setText("");
            nameL.setVisible(false);
            namet.setVisible(false);
            id.setVisible(false);
            ids.setVisible(false);
        }
        else if (comboBox.getSelectedIndex()==1){
            textArea.setText("");
            nameL.setVisible(false);
            namet.setVisible(false);
            id.setVisible(false);
            ids.setVisible(false);
        }
        else  if (comboBox.getSelectedIndex()==2){
            form();
            textArea.setText("");
        }
        else if (comboBox.getSelectedIndex()==3){
            form();
            textArea.setText("");
        }
        else  if (comboBox.getSelectedIndex()==4){
            nameL.setVisible(false);
            namet.setVisible(false);
            id.setVisible(false);
            ids.setVisible(false);
        }
        else  if (comboBox.getSelectedIndex()==5){
            nameL.setVisible(false);
            namet.setVisible(false);
            id.setVisible(false);
            ids.setVisible(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==EditionButton&&comboBox.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(f,"Select","Select",JOptionPane.PLAIN_MESSAGE);
            textArea.setText("");
        }else if (e.getSource()==EditionButton&&comboBox.getSelectedIndex()==1){
            availableBook();
        }else if (e.getSource()==EditionButton&&comboBox.getSelectedIndex()==2){
            returnBook();
        }else if (e.getSource()==EditionButton&&comboBox.getSelectedIndex()==3){
            issueBook();
        }else if (e.getSource()==EditionButton&&comboBox.getSelectedIndex()==4){
            addBook();
        }else if (e.getSource()==EditionButton&&comboBox.getSelectedIndex()==5){
            deleteRecord();
        }
    }




    public void returnBook(){

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
            statement = conn.createStatement();
            String sql = "SELECT * FROM sm.issuebook where name='" + namet.getText() + "' and cnic='" + ids.getText()+ "'";
            ResultSet resultSet = statement.executeQuery(sql);
//
            if (resultSet.next() ) {
                String delete=
                        "delete from  sm.issuebook where  issuebook=('"+text.getText()+"')";
                PreparedStatement preparedStmt = conn.prepareStatement(delete);
                preparedStmt.execute();

                String record =
                        "INSERT INTO `sm`.`available` (`available`) VALUES ('"+text.getText()+"')";
                statement.executeUpdate(record);
            }
            availableBook();
            JOptionPane.showMessageDialog(f,"Done","IssueBook",JOptionPane.PLAIN_MESSAGE);
            namet.setText("");
            ids.setText("");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }














    public void form(){
        Font font = new Font("arial",Font.PLAIN,30);
        nameL.setText("Name");
        nameL.setVisible(true);
        nameL.setBounds(100,100,300,30+10);
        nameL.setForeground(Color.white);
        nameL.setFont(font);


        namet.setFont(new Font("arial",Font.BOLD,20));
        namet.setVisible(true);
        namet.setBounds(100,200-50,300,30+10);

        id.setText("Registration No:");
        id.setVisible(true);
        id.setBounds(100,200-50+50,300,30+10);
        id.setForeground(Color.white);
        id.setFont(font);

        ids.setVisible(true);
        ids.setBounds(100,300-55,300,30+10);
        ids.setFont(new Font("arial",Font.BOLD,20));
    }










    public static void main(String[] args) {
        library l = new library();
        l.frame();
        l.f.setVisible(true);
    }
    public void availableBook(){
        try{
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
            statement = conn.createStatement();
            String sql = "SELECT * FROM sm.available ";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                set=resultSet.getString("available");
                textArea.append("\n "+set+"");
            }
        }
        catch (Exception e){
            System.out.printf(String.valueOf(e));
        }
    }
    public void addBook(){
        try{
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
            statement = conn.createStatement();
            String record = "INSERT INTO `sm`.`available` (`available`) VALUES ('"+text.getText()+"')";
            statement.executeUpdate(record);
            JOptionPane.showMessageDialog(f,"This book is add","AddBook",JOptionPane.PLAIN_MESSAGE);
            text.setText("");
            availableBook();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void deleteRecord(){

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
            statement = conn.createStatement();
            String delete=
                    "delete from  sm.available where  available=('"+text.getText()+"')";
            statement.executeUpdate(delete);
            PreparedStatement preparedStmt = conn.prepareStatement(delete);
            preparedStmt.execute();
            JOptionPane.showMessageDialog(f,"This book is delete from list","DeleteBook",JOptionPane.PLAIN_MESSAGE);
            text.setText("");
            textArea.setText("");
            conn.close();
            availableBook();
        }
        catch (Exception e){
            System.out.println(e);
                }

    }
    public void issueBook(){
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/sm", "root", "123456789");
            statement = conn.createStatement();
            String record =
                    "INSERT INTO `sm`.`issuebook` (`name`,`cnic`,`issuebook`,`date`) VALUES ('"+namet.getText()+"','"+ids.getText()+"','"+text.getText()+"','"+date+"')";
            statement.executeUpdate(record);
            deleteRecord();
            availableBook();
            JOptionPane.showMessageDialog(f,"Done","IssueBook",JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }



}