import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RPS {

  // all the fields being used in the program

  Random random = new Random(); // random number generator from 1 to 3

  int compScore = 0; // global cpu score
  int playScore = 0; // global player score
  int tieScore = 0; // global tie tracker

  private JFrame frame; // the entire frame window

  // initializes my frame through a constructor and calls the initialize method
  public RPS() {
    initialize();
  }

  // executes the frame through methods and catches any exceptions
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RPS window = new RPS();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  // initialize method which creates everything on the window
  private void initialize() {

    // creates the frame
    frame = new JFrame("ROCK PAPER SCISSORS");
    frame.pack();
    frame.getContentPane().setBackground(Color.DARK_GRAY);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);

    // win or lose each round message
    JLabel gameMessage = new JLabel("");
    gameMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
    gameMessage.setForeground(Color.WHITE);
    gameMessage.setBounds(70, 122, 280, 14);
    frame.getContentPane().add(gameMessage);

    // user score label
    JLabel userScore = new JLabel("");
    userScore.setFont(new Font("Tahoma", Font.PLAIN, 12));
    userScore.setForeground(Color.WHITE);
    userScore.setBounds(33, 33, 104, 14);
    frame.getContentPane().add(userScore);

    // computer score label
    JLabel cpuScore = new JLabel("");
    cpuScore.setFont(new Font("Tahoma", Font.PLAIN, 12));
    cpuScore.setForeground(Color.WHITE);
    cpuScore.setBounds(33, 58, 104, 14);
    frame.getContentPane().add(cpuScore);

    // keeps track of all the ties
    JLabel userTieScore = new JLabel("");
    userTieScore.setForeground(Color.WHITE);
    userTieScore.setFont(new Font("Tahoma", Font.PLAIN, 12));
    cpuScore.setForeground(Color.WHITE);
    userTieScore.setBounds(33, 83, 104, 14);
    frame.getContentPane().add(userTieScore);

    // win or lose message
    JLabel endMessage = new JLabel("");
    endMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
    endMessage.setForeground(Color.WHITE);
    endMessage.setBounds(70, 220, 280, 14);
    frame.getContentPane().add(endMessage);

    // scissors button settings
    JButton scissors = new JButton("SCISSORS");
    scissors.setBackground(Color.WHITE);
    scissors.setForeground(Color.BLACK);
    scissors.setBounds(320, 164, 104, 23);
    frame.getContentPane().add(scissors);

    // rock button settings
    JButton rock = new JButton("ROCK");
    rock.setBackground(Color.WHITE);
    rock.setForeground(Color.BLACK);
    rock.setBounds(10, 164, 104, 23);
    frame.getContentPane().add(rock);

    // paper button settings
    JButton paper = new JButton("PAPER");
    paper.setBackground(Color.WHITE);
    paper.setForeground(Color.BLACK);
    paper.setBounds(165, 164, 104, 23);
    frame.getContentPane().add(paper);

    // play again button settings
    JButton playAgain = new JButton("PLAY AGAIN");
    playAgain.setBackground(Color.WHITE);
    playAgain.setForeground(Color.BLACK);
    playAgain.setFont(new Font("Tahoma", Font.PLAIN, 12));
    playAgain.setBounds(291, 24, 133, 23);
    frame.getContentPane().add(playAgain);

    // the action listener for the rock button (buttonClicked)
    rock.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // random number every time it is clicked to avoid redundancy
        int cpuChoice = 1 + random.nextInt(3);

        // win or lose conditional statements and label text setters
        if (cpuChoice == 1) {
          gameMessage.setText("It's a tie, no points are awarded");
          tieScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        } else if (cpuChoice == 2) {
          gameMessage.setText("The CPU chose PAPER, you've lost this round");
          compScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        } else {
          gameMessage.setText("The CPU chose SCISSORS, you've won this round!");
          playScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        }

        // if a certain player wins, this code will execute
        // buttons disable as soon as someone wins
        // must press play again button to enable them
        if (compScore == 5) {
          endMessage.setText("The CPU has won, better luck next time!");
          paper.setEnabled(false);
          rock.setEnabled(false);
          scissors.setEnabled(false);
          playAgain.setEnabled(true);
        } else if (playScore == 5) {
          endMessage.setText("Congratulations! You Won!");
          paper.setEnabled(false);
          rock.setEnabled(false);
          scissors.setEnabled(false);
          playAgain.setEnabled(true);
        }
      }
    });

    // action listener for scissors, same format as rock

    scissors.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        int cpuChoice = 1 + random.nextInt(3);

        if (cpuChoice == 1) {
          gameMessage.setText("The CPU chose ROCK, you've lost this round");
          compScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        } else if (cpuChoice == 2) {
          gameMessage.setText("The CPU chose PAPER, you've won this round!");
          playScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        } else {
          gameMessage.setText("It's a tie, no points are awarded");
          tieScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        }

        if (compScore == 5) {
          endMessage.setText("The CPU has won, better luck next time!");
          paper.setEnabled(false);
          rock.setEnabled(false);
          scissors.setEnabled(false);
          playAgain.setEnabled(true);
        } else if (playScore == 5) {
          endMessage.setText("Congratulations! You Won!");
          paper.setEnabled(false);
          rock.setEnabled(false);
          scissors.setEnabled(false);
          playAgain.setEnabled(true);
        }
      }
    });

    // same action listener format as the rock and scissors button

    paper.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        int cpuChoice = 1 + random.nextInt(3);

        if (cpuChoice == 1) {
          gameMessage.setText("The CPU chose ROCK, you've won this round!");
          playScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        } else if (cpuChoice == 2) {
          gameMessage.setText("It's a tie, no points are awarded");
          tieScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        } else {
          gameMessage.setText("The CPU chose SCISSORS, you've lost this round");
          compScore++;
          userScore.setText("Your score: " + playScore);
          cpuScore.setText("CPU Score: " + compScore);
          userTieScore.setText("Ties: " + tieScore);
        }

        if (compScore == 5) {
          endMessage.setText("The CPU has won, better luck next time!");
          paper.setEnabled(false);
          rock.setEnabled(false);
          scissors.setEnabled(false);
          playAgain.setEnabled(true);
        } else if (playScore == 5) {
          endMessage.setText("Congratulations! You Won!");
          paper.setEnabled(false);
          rock.setEnabled(false);
          scissors.setEnabled(false);
          playAgain.setEnabled(true);
        }
      }
    });

    // the play again button remains disabled throughout the entire game

    playAgain.setEnabled(false);

    // action listener for the play again button
    // when clicked: rock, paper, and scissors become enabled,
    // scores reset to 0
    // label text are set to null
    // and the button then disables itself again after click

    playAgain.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        paper.setEnabled(true);
        rock.setEnabled(true);
        scissors.setEnabled(true);

        endMessage.setText(null);
        cpuScore.setText(null);
        userScore.setText(null);
        gameMessage.setText(null);
        userTieScore.setText(null);

        compScore = 0;
        playScore = 0;
        tieScore = 0;

        playAgain.setEnabled(false);
      }
    });
  }
}