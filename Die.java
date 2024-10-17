import java.util.Random;

public class Die {
   // Instantiate our random variable class
   Random randGen = new Random();
   private int rollNum;

   // set the roll
   public void setRoll(int rollNumber) {
      this.rollNum = rollNumber;
   }

   // get the roll and return its value
   public int roll() {
      this.setRoll(rollNum);
      // this will make it where each time the roll method is called it will always generate a random number because otherwise they end up being the same number everytime the method is called
      rollNum = 1 + randGen.nextInt(6);
      return rollNum; // return the roll number
   }
}
