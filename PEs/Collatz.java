public class Collatz {
    /*
    Shengjun Xi CS1331 PE02
    */
    public static void main(String[] args){
        int collatzNum = 12;
        int numSteps = 0;
        int highestNumReached = collatzNum;
        int initValue = collatzNum;
        System.out.println(collatzNum);
        while (collatzNum != 1) {
            if ((collatzNum%2) == 0){
                collatzNum = (collatzNum/2);
            }else{
                collatzNum = (collatzNum*3 +1);
            }

            if(collatzNum>highestNumReached){
                highestNumReached = collatzNum;
            }
            System.out.println(collatzNum);
            numSteps++;
            
        }
        System.out.println("Initial Value:" + " " + initValue);
        System.out.println("Number of steps:" + " " + numSteps);
        System.out.println("Highest Number Reached:" + " " + highestNumReached);
        
        switch(numSteps){
            case 0 :
                System.out.println("No steps required");
                break;
            case 1 :
                System.out.println("Only took one step!");    
                break;
            case 2 :
                System.out.println("Two steps"); 
                break;  
            case 3 :
                System.out.println("Three steps");
                break;
            case 4 :
                System.out.println("Four steps");
                break;
            default:
                System.out.println("Wow,"+" "+numSteps+" steps was a lot of steps!");     
        }

    }
    
}
