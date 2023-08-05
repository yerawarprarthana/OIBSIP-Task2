package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Welcome extends JFrame implements ActionListener{

    JButton play;
    JButton close;

    Welcome (){

        setLayout(null);

        setSize(1200,500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("logo2.jpg"));
        JLabel Image=new JLabel(I);
        Image.setBounds(0, 0,500,500);
        add(Image);

        JLabel Heading=new JLabel("GUESS THE NUMBER");
        Heading.setBounds(700, 10, 500, 50);
        Heading.setFont(new Font(Font.SERIF,Font.BOLD,30));
        Heading.setForeground(Color.BLUE);
        add(Heading);

        JLabel data=new JLabel("Hello there..! I have choosen a number from range 1 to 100.");
        data.setBounds(600, 50, 1000, 150);
        data.setFont(new Font("Viner Hand ",Font.BOLD,18));
        add(data);

        JLabel data1=new JLabel("Can you guess the it ? You have only 5 attempts");
        data1.setBounds(600, 70, 1000, 200);
        data1.setFont(new Font("Viner Hand",Font.BOLD,18));
        add(data1);

        play=new JButton("PLAY");
        play.setBounds(600, 300, 120, 25);
        play.setBackground(Color.BLACK);
        play.setForeground(Color.WHITE);
        play.addActionListener(this);
        add(play);

        close=new JButton("CLOSE");
        close.setBounds(950, 300, 120, 25);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);


        setTitle("NUMBER GUESSING GAME");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == play){
            setVisible(false);
            new Game();

        }else if(ae.getSource() == close){
            dispose();
        }

    }



    public static void main(String[] args) {
        new Welcome();
    }
}