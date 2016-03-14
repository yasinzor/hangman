import java.util.Random;
import java.util.Scanner;

public class Proje {

	public static void main(String[] args) {
		
		System.out.println("Enter Your Name : ");
		Scanner input = new Scanner(System.in);
		String playerName = input.next();
		System.out.println("Welcome the game "+ playerName);
		int score = 0;
		int life = 6;
		System.out.println("Score:"+score );
		System.out.println("Guess left:"+ life);
		Start(score);
		
		
	}
		public static void Start(int score){
		String words[] = new String[5];
	    String hints[] = new String[5];
	    words[0] = "cat";
        hints[0] = "Animal";
        words[1] = "dog";
        hints[1] = "Animal";
        words[2] = "book";
        hints[2] = "Reading";
        words[3] = "computer";
        hints[3] = "techonoloji";
        words[4] = "eagle";
        hints[4] = "fledgling";
        String word;
        Random rand = new Random();
        int l1 = rand.nextInt(5);
        word = words[l1];
        String hint = hints[l1];
        String guess = "";
        int ll = word.length()+1;
        for(int i=1;i<ll;i++)
        {
          guess += "-";
        }
        int guessLeft = 6;
        boolean canPlay = true;
        Game(guess, guessLeft, canPlay, word, hint, score);
		}
        public static void Game(String guess, int guessLeft, boolean canPlay, String word, String hint, int score){
        	if(guessLeft==0)
            {
                canPlay = false;
                Lose(score); 
            }
        	else{
        		char g1[] = guess.toCharArray();
                char w2[] = word.toCharArray();
                for(int x=0;x<g1.length;x++)
                {
                  System.out.print(g1[x]);
                }
				System.out.println("\nEnter a letter: ");

                Guess(guess, guessLeft, canPlay, word, g1, w2, hint, score);
        		}
        }
        public static void Guess(String guess, int guessLeft, boolean canPlay, String word, char g1[], char w2[], String hint, int score){
        	String tg1 = new String(g1);
            String tg2 = new String(w2);
            if(tg1.equals(tg2))
            {
            Win(score);
            }
            else{
            	if(guessLeft == 0)
            	{
            		System.out.println("\nYou Lost! The word was: "+word);   
            		Lose(score);
            	}
            	else{
            		Scanner input = new Scanner(System.in);
            		System.out.print("Hint : " +hint);
            		String letter = input.next();
            		/*String hint1 = input.next();
                    if(hint1.equals("1") || hint1.equals("1"))
                    {
                    	char aChar = letter.charAt(0);
                    	g1[1] = aChar;
                    }*/
            		if(word.contains(letter))
            		{
            			if(guess.contains(letter))
            			{
            				guessLeft -=1;
            				System.out.println("Wrong!");
            			}
            			else{
            				int wl = word.length();
            				for(int i=0;i<wl;i++)
            				{
            					char aChar = letter.charAt(0);
            					char bChar = w2[i];
            					if(bChar==aChar)
            					{
            						g1[i] = aChar;
            						score += 50;	
            					}
            				}
            			}
            		}
            		else{
            			guessLeft -=1;
            			System.out.println("Wrong!");
            			guess += letter;
            		}
            		for(int x=0;x<g1.length;x++)
            		{
            			System.out.print(g1[x]);
            		}
            		System.out.println("\nGuess left:"+ guessLeft);
					System.out.println("Score="+score);
            		System.out.println("\nEnter a letter: ");
            		Guess(guess, guessLeft, canPlay, word, g1, w2, hint, score);
            	}
            }	
        }
        public static void Lose(int score)
        {
          Scanner input1 = new Scanner(System.in);
          System.out.print("\nDo you Play Again?(Y/N): ");
          String ya1 = input1.next();
          if(ya1.contains("y") || ya1.contains("Y"))
          {
            Start(score);
          }
          if(ya1.contains("n") || ya1.contains("N"))
          {
            System.out.println("good bye :)");
          }
          
        }
        public static void Win(int score)
        {
        System.out.println("\n\n\\o/\n | \n/ \\");
          System.out.println("You Won!\n");
          score += 100;
          System.out.println("Score="+score);
          Scanner input2 = new Scanner(System.in);
          System.out.print("\nPlay Again?(Y/N): ");
          String ya = input2.next();
          if(ya.contains("y") || ya.contains("Y"))
          {
            Start(score);
          }
          if(ya.contains("n") || ya.contains("N"))
          {
            System.out.println("good bye :)");
          }
          
        }
		}

