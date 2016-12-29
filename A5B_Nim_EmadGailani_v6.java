// Emad al-Gailani
// the nim game assighment
// 26/10/2014
// the reflection is in the other file 
// there are two mode easy and hard on the game , the easy one the user can win whikle the hard one the user can not win 

import java.net.*; // for image
import javax.swing.*; // for image
import javax.swing.JOptionPane; // to let the out put come as a windoes 
import java.awt.Toolkit; //for error sounding
import java.awt.*; // for the color
import java.util.Random; // for the random number 
public class A5B_Nim_EmadGailani_v6// class name
{
  public static void main(String[] args) throws Exception// public static, throws Exception is for the imagees 
  { //main program begin 
    
// All variables    
    String[] dif = { "Easy " , " Hard" };
    String[] play = { "Rules" , " Play"}; // variable for the play 
    String[] again = { "YES" , "Exit"}; // variable to exit or play again
    String[] options = {"Exit", "1" , "2", "3", }; //variable for the number of sticks 
    String sticks[] = { "13",  "25" , " 37" , "49" , "61" , "73" , "85" }; // variable to aloow the user how many sticks he want to begin the game with 
    int difficulty  = 0; // for the diffuculty 
    int userInput = 0;  // for the userinput
    int wrong = 0; //  if it doesnt equal 1,,2,3 
    int computer = 0;  // the one who play against the user
    int numberSticks = 0; // for the number of stickes
    int  anotherTime = -1; // to play another time
    int counter = 0; //  to plsy snother time from the begininng of the game
    
// intrudoction input asking for ruules and play    
    final ImageIcon icon = new ImageIcon(new URL("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSbW1AUP1p-sHi74ohNXWtG9HroW-WUnplj6lYM7uQEaAcvxtq6nw"));
    userInput = JOptionPane.showOptionDialog(null, " \n Hello, today we will play a game named Nim" , "play" ,0,JOptionPane.QUESTION_MESSAGE, icon, play, 0); 
    
    if (userInput == 0) // if ther user want to know the rules:
    {// beginnning
      UIManager.put("OptionPane.messageForeground", Color.pink); // color change to pink 
      JOptionPane.showMessageDialog(null,"Nim Game Rules \n 1. You have to take the number of sticks that is avalibale to pick to begin the game \n 2. You can take up to 3 sticks each turn \n 3. You will play against the computer \n 4. The last one take the last stick lose \n \n Thats all enjoy playing");  
    }// end 
    
    do // do for the hole game
    { //begininnig for do 
      difficulty = JOptionPane.showOptionDialog(null, "please choose the difficulty" , "play" ,0,JOptionPane.QUESTION_MESSAGE, null,dif, 0); 
      if(difficulty == 0)
      {
        do // do while loop for the number of sticks
        { // beginiing of do for the number of sticks 
          if(counter == 0 ||  anotherTime == 0) // the program will run if it is equal to 0
// number of sticks             
          { //input for the number of sticks to begin the game
            JOptionPane.showMessageDialog(null, " You choose the Easy difficulty");
            UIManager.put("OptionPane.messageForeground", Color.blue); //color change to blue 
            numberSticks = JOptionPane.showOptionDialog(null," please indicate how many sticks you want to begin the game with", "sticks" ,0,JOptionPane.QUESTION_MESSAGE, null, sticks, 0); 
            if(numberSticks == 0) // if the user picked the first choise
              numberSticks = 13; // first choise equal to 13
            else if(numberSticks == 1) // if the user picked the 2 choise
              numberSticks = 25; // 2 choise equal to 25
            if(numberSticks == 2) // if the user picked the 3 choise
              numberSticks = 37; // 3 choise equal to 37
            else if(numberSticks == 3) // if the user picked the 4 choise
              numberSticks = 49; // 4 choise equal to 49
            if(numberSticks == 4) // if the user picked the 5 choise
              numberSticks = 61; // 5 choise equal to 61
            else if(numberSticks == 5) // if the user picked the 6 choise
              numberSticks = 73; // 6 choise equal to 73
            if(numberSticks == 6) // if the user picked the 7 choise
              numberSticks = 85; // 7 choise equal to 85
            while(numberSticks < 0 || numberSticks > 85); // to exit
            counter++;  // to end the choises
            anotherTime = -1;  // to end choises
          } // end  to end the choises of the beginning
          
          do // do of the rest of the game
          {// beginning of do 
            wrong++; // if it wasnt equal to 1,2,3 
            if(wrong != 1 && userInput < 1 || userInput > 3) // between 1 and 3
            {// beginning of exit message
              Toolkit.getDefaultToolkit().beep(); // give a deep sound extra thing
              UIManager.put("OptionPane.messageForeground", Color.red);// color change to red 
              JOptionPane.showMessageDialog(null,"lets see you want to exit because you think you will loose \n\t\t\tok no problem chicken \n\t\t\t\t  bye", "Warning", JOptionPane.ERROR_MESSAGE);
              return; // finish the gam
            } // end of wrong
            
            UIManager.put("OptionPane.messageForeground", Color.green); /// color change to green 
            userInput = JOptionPane.showOptionDialog(null,"how many sticks do you want to take", "options" ,0,JOptionPane.QUESTION_MESSAGE, null, options, 0); // options for stick
          } // end of do 
          while(userInput < 1 || userInput > 3); // if the nuser intered 1,2,3 
          Random rn = new Random(); // randon number so the user can  win 
          UIManager.put("OptionPane.messageForeground", Color.black);// color change to black 
          if(userInput == 1 || userInput == 2 || userInput == 3) // if user input was a number between 1 to 3
          { //beginning
            computer = rn.nextInt(2) + 1; ;  // computer takes 3
            numberSticks = numberSticks - userInput - computer; // to list the remaing sticks 
            JOptionPane.showMessageDialog(null,"You took " + userInput + "  \n lets see, I will take " + computer + "  \nThe remaing number of sticks is: " +  numberSticks + ""); // meassage
          }//end
          
          
          if(numberSticks == 1) // if the remaing sticks is 1
          {// beginning
            final ImageIcon icon1 = new ImageIcon(new URL("http://thumb7.shutterstock.com/display_pic_with_logo/247744/247744,1317877577,1/stock-vector-loser-86053264.jpg")); // photo 
            JOptionPane.showMessageDialog(null,"you will have to take the last stick \n      computer wins loser", "Loser", JOptionPane.ERROR_MESSAGE ); 
            JOptionPane.showMessageDialog(null, "", " Loser" ,JOptionPane.ERROR_MESSAGE , icon1 );
            anotherTime = JOptionPane.showOptionDialog(null, "would you like to loose again " ," again" ,0,JOptionPane.QUESTION_MESSAGE, null, again, 0); // message
          } // end
          
          else if(numberSticks <= 0)
          { // if the user wins 
            final ImageIcon icon2 = new ImageIcon(new URL("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcT4fWwccOeQ-zdH1i-nwl36CdAHj4_BBWGj2cjNGx35n_vLCFHfcw")); // photo 
            JOptionPane.showMessageDialog(null,"You won, congartulations"); 
            JOptionPane.showMessageDialog(null, "", " Winner" ,JOptionPane.ERROR_MESSAGE , icon2 );
            anotherTime = JOptionPane.showOptionDialog(null, "would you like to play again \n Trt the hard difficulty, I dare you to beat it  " ," again" ,0,JOptionPane.QUESTION_MESSAGE,null, again, 0); // message to play again 
          } //  end of themessage 
          
        } // end of do while loop
        while(numberSticks > 1);  // to paly the game another time 
      }
      
//difficult mode os hard  and the user can not win 
      
      else if(difficulty == 1)
      { //beginning of the hard mode 
        do // do while loop for the number of sticks
        { // beginiing of do 
          if(counter == 0 ||  anotherTime == 0) // the program will run if it is equal to 0
          { //input for the number of sticks to begin the game
            JOptionPane.showMessageDialog(null, " You choose the Hard difficulty");
            UIManager.put("OptionPane.messageForeground", Color.blue); // color chanfge t blue 
            numberSticks = JOptionPane.showOptionDialog(null," please indicate how many sticks you want to begin the game with", "sticks" ,0,JOptionPane.QUESTION_MESSAGE, null, sticks, 0); 
// choises for the number of sticks            
            if(numberSticks == 0) // if the user picked the first choise
              numberSticks = 13; // first choise equal to 13
            else if(numberSticks == 1) // if the user picked the 2 choise
              numberSticks = 25; // 2 choise equal to 25
            if(numberSticks == 2) // if the user picked the 3 choise
              numberSticks = 37; // 3 choise equal to 37
            else if(numberSticks == 3) // if the user picked the 4 choise
              numberSticks = 49; // 4 choise equal to 49
            if(numberSticks == 4) // if the user picked the 5 choise
              numberSticks = 61; // 5 choise equal to 61
            else if(numberSticks == 5) // if the user picked the 6 choise
              numberSticks = 73; // 6 choise equal to 73
            if(numberSticks == 6) // if the user picked the 7 choise
              numberSticks = 85; // 7 choise equal to 85
            while(numberSticks < 0 || numberSticks > 85); // to exit
            counter++;  // to end the choises
            anotherTime = -1;  // to end choises
          } // end  to end the choises of the beginning
          
          do // do of the rest of the game
          {// beginning of do0
            wrong++; // if it wasnt equal to 1,2,3 
            if(wrong != 1 && userInput < 1 || userInput > 3) // between 1 and 3
            {// beginning of wrong
              Toolkit.getDefaultToolkit().beep(); // give a deep sound extra thing
              UIManager.put("OptionPane.messageForeground", Color.red);
              JOptionPane.showMessageDialog(null,"lets see you want to exit because you think you will loose \n\t\t\tok no problem chicken \n\t\t\t\tBye", "Warning", JOptionPane.ERROR_MESSAGE);
              return; // to finish the game 
            } // end of wrong
            UIManager.put("OptionPane.messageForeground", Color.green); // change color to green 
            userInput = JOptionPane.showOptionDialog(null,"how many sticks do you want to take", "options" ,0,JOptionPane.QUESTION_MESSAGE, null, options, 0); // options for stick
          } // end of do 
          while(userInput < 1 || userInput > 3); // if the nuser intered 1,2,3
          UIManager.put("OptionPane.messageForeground", Color.black); // change color to black 
          if(userInput == 1) // if user input was 1
          { //beginning
            computer = 3;  // computer takes 3
            numberSticks = numberSticks - userInput - computer; // to list the remaing sticks 
            JOptionPane.showMessageDialog(null,"You took " + userInput + " I know you want the game to remain longer \nI will take " + computer + " ,so we can end the game faster \nThe remaing number of sticks is: " +  numberSticks + ""); // meassage
          }//end
          else if(userInput == 2)// if the user input was 2
          { // beginnig 
            computer = 2;  // computer takes 2
            numberSticks = numberSticks - userInput - computer; // to list the remaing sticks 
            JOptionPane.showMessageDialog(null,"You took " + userInput + " Tring to be smart \nlets see I will take  " + computer + " as well\n the remaing number of sticks is: " +  numberSticks + "" );  // meassage
          } // end\
          else if(userInput == 3) // if the user input was 3
          { // beginning
            computer = 1; // computer takes 1
            numberSticks = numberSticks - userInput - computer;  // to list the remaing sticks 
            JOptionPane.showMessageDialog(null,"You took " + userInput + " WOW you took too much \nlets see mmmm I will take only " + computer + " \nThe remaing number of sticks is: " +  numberSticks + ""); // message
          } // end 
          
          if(numberSticks == 1) // if the remaing sticks is 1 then the computer wins 
          {// beginning
            final ImageIcon icon1 = new ImageIcon(new URL("http://thumb7.shutterstock.com/display_pic_with_logo/247744/247744,1317877577,1/stock-vector-loser-86053264.jpg"));
            JOptionPane.showMessageDialog(null,"you will have to take the last stick \n      computer wins loser", "Loser", JOptionPane.ERROR_MESSAGE ); 
            JOptionPane.showMessageDialog(null, "", " Loser" ,JOptionPane.ERROR_MESSAGE , icon1 );
            anotherTime = JOptionPane.showOptionDialog(null, "would you like to loose again " ," again" ,0,JOptionPane.QUESTION_MESSAGE, null, again, 0); // message
          } // end
          
        } // end of do while loop
        
        while(numberSticks > 1);  // to paly the game another time
      }
    } while(anotherTime == 0); // end of do and to begin the game from the beginning  
// if the user entered exit     
    String exit;
    exit = "Thanks for playing the game  \nThe maker of the game is Emad Al-Gailani";
    JLabel resLabel = new JLabel(exit);
    resLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
    JOptionPane.showMessageDialog(null, resLabel, "Exit", JOptionPane.PLAIN_MESSAGE );
  } // end method
} // end class