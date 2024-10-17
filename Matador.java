import java.util.Scanner;
import java.util.Random;

public class Matador {
  public static void main(String[] args) {
    Die die1 = new Die();
    Die die2 = new Die();
    Scanner scanner = new Scanner(System.in);
    Random randGen = new Random();

    // Initialize all the variables
    int playerScore = 0;
    int computerScore = 0;
    int playerChoice;
    int computerChoice = 2 + randGen.nextInt(5);
    int playerRoll1;
    int playerRoll2;
    int computerRoll1;
    int computerRoll2;
    // player goes first so it's true until their turn is over
    boolean playerTurn = true;
    // not the computer's turn yet so it won't run
    boolean computerTurn = false;

    // while neither score reaches 121 points the 2 inner while loops will keep
    // going back and forth
    while (playerScore < 121 && computerScore < 121) {

      // while the player makes their choices
      while (playerTurn) {
        // if the player chooses a number that isn't in between 2 and 6 it will ask them
        System.out.print("Pick a number between 2 and 6: ");
        playerChoice = scanner.nextInt();
        computerChoice = 2 + randGen.nextInt(5);
        System.out.println("The computer chose " + computerChoice);
        // to give a new number
        if (playerChoice < 2 || playerChoice > 6) {
          System.out.print("You must pick a number between 2 and 6: ");
          playerChoice = scanner.nextInt();
        } else { // otherwise move on with the game
          System.out.println("Both players will now roll the dice.");

          // roll the dice for player 1. I make them seperate so that way I can check for
          // each one indivdiually
          playerRoll1 = die1.roll();
          playerRoll2 = die2.roll();
          System.out.println("Player 1 just rolled the dice and got a " + playerRoll1 + " and a " + playerRoll2);

          // if your chosen number is on both die you automatically win the game
          if (playerRoll1 == playerChoice && playerRoll2 == playerChoice) {
            System.out.println("You rolled your choice on both die. You win the game!");
            break;
          } else {
            playerTurn = false;
            computerTurn = true;
          }

          // resets score if it's snake eyes
          if (playerRoll1 == 1 && playerRoll2 == 1) {
            System.out.println("You rolled snake eyes! Your score has been reset to 0.");
            playerScore = 0;
            playerTurn = false;
            computerTurn = true;
          }

          // if either of the dice roll a one it's the next player's turn
          else if (playerRoll1 == 1 || playerRoll2 == 1) {
            System.out.println("Sorry, but it's now the computer's turn");
            System.out.println("You have a score of " + playerScore);
            playerTurn = false;
            computerTurn = true;
          }

          // if neither are 1s then you can add the sum to the total
          else if (playerRoll1 != 1 && playerRoll2 != 1) {
            playerScore += (playerRoll1 + playerRoll2);
            System.out.println("A score of " + (playerRoll1 + playerRoll2)
                + " has now been added. You now have a score of " + playerScore);
            // if the player rolled their choice it'll allow them to role again before it's
            // the computer's turn
            if (playerRoll1 == playerChoice || playerRoll2 == playerChoice) {
              System.out.println("You can roll again");
              playerRoll1 = die1.roll();
              playerRoll2 = die2.roll();
              System.out.println("You just rolled the dice and got a " +
                  playerRoll1 + " and a " + playerRoll2);
              if (playerRoll1 == 1 || playerRoll2 == 1) {
                System.out.println("Sorry, but it's now the computer's turn");
                System.out.println("You have a score of " + playerScore);
                playerTurn = false;
                computerTurn = true;
              } else {
                playerScore += (playerRoll1 + playerRoll2);
                System.out.println("A score of " + (playerRoll1 + playerRoll2)
                    + " has now been added. You now have a score of " + playerScore);
              }
            }

          }

        }
      }

      // while it's the computer's turn
      while (computerTurn) {
        // roll the dice for player 2
        computerRoll1 = die1.roll();
        computerRoll2 = die2.roll();
        System.out.println("The computer just rolled the dice and got a " +
            computerRoll1 + " and a " + computerRoll2);

        // if your chosen number is on both die you automatically win the game
        if (computerRoll1 == computerChoice && computerRoll2 == computerChoice) {
          System.out.println("The computer rolled its choice on both die. The computer won the game!");
          playerTurn = false;
          computerTurn = false;
          break;
        } else {
          computerTurn = false;
          playerTurn = true;
        }

        // if the computer rolls snake eyes it resets score
        if (computerRoll1 == 1 && computerRoll2 == 1) {
          System.out.println("You rolled snake eyes! Your score has been reset to 0.");
          computerScore = 0;
          playerTurn = true;
          computerTurn = false;
        }

        // if the computer rolls either then it's the player's turn
        else if (computerRoll1 == 1 || computerRoll2 == 1) {
          System.out.println("Sorry, but it's now the player's turn");
          System.out.println("The computer has a score of " + computerScore);
          playerTurn = true;
          computerTurn = false;
        }

        // if the computer rolls neither then the score updates
        else if (computerRoll1 != 1 && computerRoll2 != 1) {
          computerScore += (computerRoll1 + computerRoll2);
          System.out.println("A score of " + (computerRoll1 + computerRoll2)
              + " has now been added. The computer now has a score of " + computerScore);
          if (computerRoll1 == computerChoice || computerRoll2 == computerChoice) {
            System.out.println("The computer can roll again");
            computerRoll1 = die1.roll();
            computerRoll2 = die2.roll();
            System.out.println("The computer just rolled the dice and got a " +
                computerRoll1 + " and a " + computerRoll2);
            if (computerRoll1 == 1 || computerRoll2 == 1) {
              System.out.println("Well you rolled a 1 so it's now the player's turn.");
              computerTurn = false;
              playerTurn = true;
            } else {
              computerScore += (computerRoll1 + computerRoll2);
              System.out.println("A score of " + (computerRoll1 + computerRoll2)
                  + " has now been added. The computer now has a score of " + computerScore);
            }
          }

        }
      }

      // if either score becomes at least 121 they win the game!
      if (playerScore >= 121) {
        System.out.println("You won the game!");
        break;
      } else if (computerScore >= 121) {
        System.out.println("The computer won the game!");
        break;
      }
    }

  }
}