import java.util.*;

class CodSoft_Task2{
    public static void main(String[] args){
        int i,sum=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the number of subject: ");
        int n=sc.nextInt();
        System.out.println("Enter the marks of all Subjects (Out of 100): ");

        for(i=0;i<n;i++){
            System.out.print("Enter the marks of particular subject: ");
            int m=sc.nextInt();
            sum += m;
        }

        System.out.println("Total Marks: "+sum);
        float ap=(float)sum/n;
        System.out.println("Average Percentage: "+ap);

        if(ap>=90.0){
            System.out.println("Grade is: A+");
        }
        else if(ap>=80.0 && ap<90.0){
            System.out.println("Grade is: A");
        }
        else if(ap>=70.0 && ap<80.0){
            System.out.println("Grade is: B");
        }
        else if(ap>=60.0 && ap<70.0){
            System.out.println("Grade is: C");
        }
        else if(ap>=50.0 && ap<60.0){
            System.out.println("Grade is: D");
        }
        else if(ap>=40.0 && ap<50.0){
            System.out.println("Grade is: E");
        }
        else{
            System.out.println("Grade is: Fail");
        }
    }
}