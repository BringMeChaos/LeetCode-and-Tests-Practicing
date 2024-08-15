public class Test2015_A_M91_Q2_Univ_whatFisDoing {
    
    /* Question:
     * given the methods (f and what) bellow, answer the following questions:
     * 1. what does "what" doing given an array of positive integers? 
     * 2. what is the time complexity?
     * 3. re-write "what" such that it will run in better time complexity.
     * 4. what is the time complexity and space complexity of the method you have wrote?
     * 
     */

    public static int f(int[] a, int low, int high){
        int res = 0;
        for (int i = low; i < a.length; i++){
            res += a[i];
        }
        return res;
    }

    public static boolean what(int[] a, int num){
        for (int i = 0; i<a.length; i++){
            for (int j = i; j < a.length; j++){
                if(f(a,i,j) == num){
                    return true;
                }
            }
        }
        return false;
    }

    // solution for question 3: =================================================================
    
    public static boolean what2(int[] a, int num){
        int sum = 0;
        for (int i = 0; i<a.length; i++){
            for (int j = i; j < a.length; j++){
                sum += a[j];
                if(sum == num){
                    return true;
                }
            }
            sum = 0; //reset sum
        }
        return false;
    }



}
