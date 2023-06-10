import java.util.*;
import java.util.HashMap;

class OasisInfobyteOnlineExam{
    HashMap<String,Integer> H = new HashMap <String,Integer>();
    Scanner scn = new Scanner(System.in);

    public void mainconceptofonlineexam()
    {
        System.out.println("\n1.START YOUR TEST\n2.UPDATE\n3.LOGGINGOUT");
        System.out.println("Enter what you want to do: ");
        int output=scn.nextInt();
        switch(output){
            case 1 : 
            	problem();
            	mainconceptofonlineexam();
            	break;
            case 2 : 
		H = Update();
            	mainconceptofonlineexam();
            	break;
            case 3 : 
            	System.exit(0);
            	break;
            
        }
    }

    public void loggingin()
    {
    	System.out.println("\n------- Welcome to ONLINE EXAM  -----------\n");
        System.out.println("Enter Your User-Id: ");
        String youruserID = scn.nextLine();
        System.out.println("Enter Strong Password: ");
        int yourpassword = scn.nextInt();
        H.put("Manav",123456);
	    H.put("John",78910);

        if (H.containsKey(youruserID) && H.get(youruserID) == yourpassword)
        {
            System.out.println("You have logged-In Successfully !!!");
            mainconceptofonlineexam();
        }
        else{
            System.out.println("OPPS!!!   Invalid!! Please Check your user or password...");
            loggingin();
        }
    }

    
    public void problem(){
        long begin = System.currentTimeMillis();
        long stop = begin + 120 * 1000;
        int yourscore = 0;
        int x = 0, y = 0;
        char answer;
        System.out.println("\n              Starting           ");
        System.out.println("You have 2 minutes for each question .Each question gives +10 marks for a correct answer and -2 mark for a wrong answer.");
        System.out.println("YOUR CHANCE TO PROVE GO ON...!!");

        while(System.currentTimeMillis()  < stop)
        {
            System.out.println("\nQ1. Which one of the following is an application of Stack Data Structure?");
            System.out.println("a.Managing function calls\nb.The stock span problem\nc.Arithmetic expression evaluation\nd.All of the above");
            System.out.println("Answer is:");
            answer = scn.next().charAt(0);
            if(answer == 'd')
            {
                x = x+10;
            }
            else
                y = y-2;

            System.out.println("\nQ2.Which of the following sorting algorithms can be used to sort a random linked list with minimum time complexity?");
            System.out.println("a.insertion sort\nb.quick sort\nc.heap sort\nd.merge sort");
            System.out.println("Answer is:");
            answer = scn.next().charAt(0);
            if(answer == 'd'){
                 x = x+10;
            }
            else
                y = y-2;

            System.out.println("\nQ3.Suppose the numbers 7, 5, 1, 8, 3, 6, 0, 9, 4, 2 are inserted in that order into an initially empty binary search tree. The binary search tree uses the usual ordering on natural numbers. What is the in-order traversal sequence of the resultant tree?");
            System.out.println("a.7 5 1 0 3 2 4 6 8 9\nb.0 2 4 3 1 6 5 9 8 7\nc.0 1 2 3 4 5 6 7 8 9\nd.9 8 6 4 2 3 0 1 5 7");
            System.out.println("Answer is:");
            answer = scn.next().charAt(0);
            if(answer == 'c')
            {
                x = x+10;
            }
            else
               y = y-2;

            
            break;
        }

        System.out.println("Congratulation Your Test Is Completed!!!");
        yourscore = (x  + y);
        System.out.println("Congratulations!! Your Have scored " + yourscore);
    }

      public HashMap<String,Integer> Update()
    {
        System.out.println("\n----- UPDATING-----");
        System.out.println("Enter YourUsername: ");

        Scanner scn = new Scanner(System.in);
        String userid = scn.nextLine();

        if (H.containsKey(userid))
        {
            System.out.println("Enter Your New Password: ");
            int yournewpassword = scn.nextInt();
            H.replace(userid,yournewpassword);
            System.out.println("Your Profile is Successfully changed!!!!");
        }
        else
        {
            System.out.println("Userid and password does not exist...   FAILED!!!");
        }
        return H;
    }

    public static void main(String args[]){
    	OasisInfobyteOnlineExam q = new OasisInfobyteOnlineExam();
        q.loggingin();
    }
}