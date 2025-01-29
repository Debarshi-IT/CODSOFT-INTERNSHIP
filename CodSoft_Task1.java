import java.util.*;

public class CodSoft_Task1 {
    public static int getrandN(int min,int max){
        return (int)(Math.random()*(max-min+1)+min);
    } 
        public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int chance=6;
        int finals=0;
        boolean pa=true;
        System.out.println("Welcome Sir!!!");
        System.out.println("Hello you have "+chance+" to win the game.");
        while(pa){
            int r=getrandN(1,100);
            boolean g=false;
            for(int i=0;i<chance;i++){
                System.out.println("Chance "+(i+1)+" Please enter your guess number: ");
                int u = sc.nextInt();
                if(u==r){
                    g=true;
                    finals+=1;
                    System.out.println("Congratulations you Win the game!!!!!");
                    break;
                }
                else if(u>r){
                    System.out.println("Too High");
                }
                else{
                    System.out.println("Too Low");
                }
            }
            if(g==false){
                System.out.println("Sorry Sir you lost the game!!!!!");
                System.out.println("The number is: "+r);
            }
            System.out.println("Do you want to play again? ");
            System.out.println("If you want to play again then please press 'y' otherwise press 'n'. ");
            String p=sc.next();
            pa=p.equalsIgnoreCase("y");
        }
        System.out.println("Thank you..Hope you enjoyed it.");
        System.out.println("Here is your score: "+finals);
    
    }
}
