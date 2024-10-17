# Matador-Dice-Game
This is a simple dice game played in the terminal for my Java class.

## Rules
* The game is played between the player and the computer.
* The player's score and the computer's score each begin at 0.
* The object of the game is to be the first to reach 121 points.
* The player and the computer take turns. One each turn:
    1) The player / computer chooses a number between 2 and 6
    2) The player / computer rolls 2 dice. Determine the results for the player / computer (depending on who is rolling):
        * if a 1 appears on both dice, their score is reset to 0 and it becomes the other's turn
        * if a 1 appears on only one die, nothing is added to their score and it becomes the other's turn
        * if a 1 does not appear on either die, the sum of the two dice is added to the roller's socre.
            * if their chosen number appears on only one die, they roll again
            * if their chosen number appears on both die, they win the game
            * if their chosen number did not appear on either die, it becomes the other's turn
    
    * The first to reach 121 wins the game.
