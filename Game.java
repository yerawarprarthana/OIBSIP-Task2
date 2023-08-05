package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Game extends JFrame implements ActionListener{
    JTextField text;
    int attempts=0;
    int gen;
    JLabel hint;

    Game(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocation(325,100);
        setTitle("NUMBER GUESSING GAME");

        JLabel guess=new JLabel("GUESS THE NUMBER");
        guess.setForeground(Color.blue);
        guess.setBounds(250, 10, 500, 100);
        guess.setFont(new Font(Font.SERIF,Font.BOLD,25));
        add(guess);

        text=new JTextField();
        text.setBounds(270, 100, 100, 20);
        add(text);

        JButton submit=new JButton("SUBMIT");
        submit.setBounds(400, 100, 90, 20);
        submit.addActionListener(this);
        add(submit);

        hint=new JLabel();
        hint.setBounds(270, 0, 500, 500);
        hint.setForeground(Color.RED);
        add(hint);

        Random random=new Random();
        gen=random.nextInt(100)+1;


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        int GuessingNumber;
        try{
            GuessingNumber=Integer.parseInt(text.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(Game.this, "Invalid input. Please enter number");
            text.setText("");
            return;
        }
        attempts++;

        if(attempts == 5){
            JOptionPane.showMessageDialog(Game.this ,"You have completed all your attempts. BETTER LUCK NEXT TIME");
            JOptionPane.showMessageDialog(Game.this, "The number is "+gen);
            setVisible(false);
            new Welcome();
        }
        else if(GuessingNumber == gen){
            JOptionPane.showMessageDialog(Game.this, "Congratulations! You have guessed the correct number "+GuessingNumber+" in "+attempts+" attempts");
            setVisible(false);
            new Welcome();
        }
        else if(GuessingNumber < gen){
           hint.setText("Your guess is low. Try heiger");
        }
        else{
            hint.setText("Your guess is high. Try low");
        }

        text.setText("");

    }


    public static void main(String[] args) {
        new Game();
        
    }
    
}
