public class Test2013_B_M92_Q2_Univ_sortMod{
    // Question:
    // given an array of positive numbers, and a int k, 
    // sort the array with k modulu.
    // do not use new arrays.


    // Time complexity: O(n * k) = O(n)
    // Space complecity: O(4) = O(1)

    public static void main(String[] args){
        int a[] = {39,2,6,0,81};
        int k = 10;
        
        sortMod(a,k);

        // for loop to print the result array
        for (int L = 0; L < a.length; L++){
            System.out.println(a[L]);
        }
    }

    // the answer to the test starting here
    public static void sortMod(int a[], int k){

        int curr = 0; // counting the swaped position
        int temp; // temp initiated outside of loop, to use in swap later
        //int j = 0; // can initiate j outside the loop because of space complexity

        for(int i = 0; i < k; i++){ // this loop is going from 0 to k
            for(int j = 0; j < a.length; j++){ // this loop is going thru the array
                // check liniarli if we have items that result in i (0 to k) when modded
                // if found need to swap with the curr counter place
                
                if(i == a[j]%k){
                    // swap a[j] with a[curr]
                    temp = a[j];
                    a[j] = a[curr];
                    a[curr] = temp;

                    // curr++. if we didnt swap, no need to increment curr.
                    curr++;
                }
            }
        }
    }
}