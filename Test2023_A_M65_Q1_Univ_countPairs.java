public class Test2023_A_M65_Q1_Uni {
    public static void main(String[] args){
        System.out.println(countPairs(2));
    }
    // recursion starts here - Calling the overloaded method
    public static int countPairs(int n){
        return countPairs(n, 0, 0, "");
    }

    // calling the overloaded method with new variables.
    // right and left to count how many have we added for the good and bad 
    // exit statements. str to create the string and print it as requested in the question.
    
    /**
     * @param n
     * @param left
     * @param right
     * @param str
     * @return
     */
    private static int countPairs(int n, int left, int right, String str){
        // bad exit statment, return 0 and dont count.
        if(left > n || right > left){
            return 0;
        }
        // good exit statment, we want to count this, add 1. 
        if(right == n){
            System.out.println(str);
            return 1;
        }

        // smallest steps, 2 or more
        int addLeft = countPairs(n, left + 1, right, str + "(");
        int addRight = countPairs(n, left, right + 1, str + ")");

        // return smallest step + smllest step2 etc
        return addLeft + addRight;
    }
}
