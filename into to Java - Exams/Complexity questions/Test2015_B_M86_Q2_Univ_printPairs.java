public class Test2015_B_M86_Q2_Univ_printPairs {

    /* Question: 
     * given an array ordred in acending order (smallest to largest)
     * and given positiv int k, print all the paris in that array where
     * k is the difference between them. 
     * 
     * for example:
     * {-3,0,1,3,5,12}
     * 
     * output should be:
     * Pair Found: (1,3)
     * Pair Found: (3,5)
     */

    public static void main(String[] args) {
        int a[] = {-7,-3,-1,0,1,3,5,12,14,17,19,25,30};
        int k = 2;
        printParis(a, k);
    }
    
    // test answer starts here: ==============================================

    // Time complexity: O(n)
    // space complexity: O(2) = O(1)

    public static void printParis(int []a, int k){
        int currCompare = 1;
        int i = 0;

        // two pointers 
        // while loop
        // or a for loop that will go over the array -1.
        // the second pointer will be ahead of the first for loop
        // initiating ints outside of loop to save space complexity
        // curr compare = 1 since it will compare to i within the loop

        // {1,3,4,5,10}
        // {0,1,2,3,4}
        // {3,10,12}
        // {1,2,3,4,5}
        // {-7,-3,-1,0,1,3,5,12,14,17,19,25,30}

        //for(int i = 0; i < a.length-1; i++){

        while(currCompare <= a.length-1){ // -1 to avoid out of bounds error, we dont have a[a.length]
            // starting with i = 0, curr = 1 so: a[1] - a[0]
            // check currCompare to i:  (a[currCompare] - a[i] == 2):
                // if difference is 2 - print.
                // increse i by 1.
                // if i = curr then increse curr by 1

            // else if: (if difference is a[currCompare] - a[i] < 2):
            // increse curr by 1
            // so i = a[0] and curr is a[2] 
            // dont print, just check again from the top.

            // else if: ( if difference id > 2, a[currCompare] - a[i] > 2)
            // increse i by 1
            // increse currCompare by 1

            if(a[currCompare] - a[i] == k){
                System.out.println("Found Pair: (" + a[i] + "," + a[currCompare] + ")");
                i++;
                currCompare++;
            }

            else if(a[currCompare] - a[i] < k){
                currCompare++;   
                }

            else if(a[currCompare] - a[i] > k){
                i++;
            }

            // I think this should be somwhere but not sure where.
            // looks like it works without this condition:
            // becuse if currCompare == i then the difference will be < k
            // and in that case we increse currCompare anyways.

            // if(currCompare == i){ 
            //     currCompare++;
            // }
        }
    }
}
