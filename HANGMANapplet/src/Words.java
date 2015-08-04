
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hazim Hanif
 */
public class Words {
 static String p;
 static String d;
 static int rand;
 static int length;
 static String guess;
 static char c;
 static int error;
 static int correct;
 static int position;
 static char[] guesschar;
 static int score;
 static int deduct;
 static String used;

   
   public void getphrase() throws FileNotFoundException{
       
       Edit_admin ea = new Edit_admin();
    
       Scanner sc = new Scanner(new FileInputStream("/Hangman The Game/admin/phrase.txt"));
       Random r = new Random();
       do{
       this.rand = r.nextInt(ea.phrasecount+1);
       }while(this.rand==0);
       
       for(int i=1;i<=this.rand;i++){
           this.p = sc.nextLine();
       }
       sc.close();
}
   
   public void getdesc() throws FileNotFoundException{
       
       Edit_admin ea = new Edit_admin();
    
       Scanner sc = new Scanner(new FileInputStream("/Hangman The Game/admin/description.txt"));
       for(int i=1;i<=this.rand;i++){
           this.d = sc.nextLine();
       }
       sc.close();
}
   
   public void getlength()
   {
        this.length = this.p.length();
   }
    
   public void getspace()
   {
       this.guess = "";
       for(int i=1;i<=this.length;i++)
       {
        this.guess = this.guess + "_";   
       }
   }
   
   public void compare()
   {
        Words w = new Words();
   int flags=0;
       for(int i=0;i<this.length;i++)
         if(this.p.charAt(i)==c)
          { 
             this.position= i;
             w.replace();
             flags=1;
             correct++;
             this.score= this.score+5;
             System.out.println(score);
             
              switch(c){
                  
                  case 'a': this.deduct= this.deduct+3 ; 
                            break;
                      
                  case 'e': this.deduct= this.deduct+3 ; 
                            break;
                  
                  case 'i': this.deduct= this.deduct+3 ; 
                            break;
                      
                  case 'o': this.deduct= this.deduct+3 ;     
                            break;
                      
                  case 'u': this.deduct= this.deduct+3 ; 
                            break;
                      
                  default :
              }
            
              System.out.println(deduct);
             
          }
        
       
       if(flags==0)
            {
             this.error++;
             }
       
       }
   
   public void replace(){
       this.guesschar= this.guess.toCharArray();
       this.guesschar[this.position] = c;
       this.guess = String.valueOf(this.guesschar);
       System.out.println(this.guess);
     
   }
  
   public void printscore() throws FileNotFoundException{
       Edit_admin ea = new Edit_admin();
       
            PrintWriter p = new PrintWriter(new FileOutputStream("/Hangman The Game/player/"+ea.uunew+"/score.txt",true));
            p.println(this.score-this.deduct);
            p.close();
       
   }
   
   
   
}


