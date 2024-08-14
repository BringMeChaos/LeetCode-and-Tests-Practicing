public class Test2023_B_M83_Q2_findSmallestSubarrayLen {
    // given an array of integers (not sorted) find the subarrays where their sum is bigger than num.
    // the subarrays should be the smallest possible, meaning:
    // when an array that it's sum bigger than num, there is no need to continue summing the rest of the array
    // since it's obviouse they all will be bigger than the sub array we already found.
    // print out the limits (indexes) of those subarrays as such:
    // "Subarray found: [0-3]"
    // return the number of cells for smallest subarray that asnwers on the condition. (for example: 2)  

    // Time complexity: O(n)
    // Space complexity: O(6) = O(1)
    public static void main(String [] args){
        int[] arr = {20};
        //{2,6,1,9,7,3,1,4,1,8}
        //
        int num = 15;
        findSmallestSubarrayLen2(arr, num);
    }

    public static int findSmallestSubarrayLen(int[] arr, int num){
        int i = 0;
        int j = 1;
        int res;
        int smallestI = Integer.MAX_VALUE;
        int smallestJ = Integer.MAX_VALUE;
        int smallesrSubarray = Integer.MAX_VALUE;

        res = arr[i] + arr[j];

        // while loop to use sliding window
        while (j < arr.length) {

            // if we found a subarray, we want to:
            // print it
            // check if subarray is smaller is size to previous arrays
            // increse i, and reset j and res
            if(res > num){
                System.out.println("Subarray found: " + "[" + i + "-" + j + "]");
                
                if (j - i < smallesrSubarray){
                    smallesrSubarray = j - i;
                    smallestI = i;
                    smallestJ = j;
                }

                // we found a pair, now there is no need to keep counting it, increse i, 
                // reset j, and reset res, otherwise it will add all previouse sums.
                i++;
                j = i+1;
                res = arr[i] + arr[j];

                // check if were at the end of array to avoid out of bound err.
                if (j == arr.length-1 || i == arr.length-1){ 
                    break;
                }         
            }

            // if the res is smaller or == to num, we want to keep increasing j and adding it to the res
            if(res <= num){
                // check if were at the end of array to avoid out of bound err,
                // since we want to increase j next step
                if (j == arr.length-1){ 
                    break;
                }
                j++;
                res+= arr[j];
            }
        }
        // checking if we didnt find any paris, and returning 0 with print
        if(smallesrSubarray == Integer.MAX_VALUE){
            System.out.println("No subarray exist");
            return 0;
        }
        // printing the response if we did find any paris
        else{
            System.out.println("Smallest subarray found: "+ "[" + smallestI + "-" + smallestJ + "]");
            System.out.println(smallesrSubarray);
            return smallesrSubarray;
        }
    }


    // another solution #======================================================================================================
    public static int findSmallestSubarrayLen2(int[] arr, int num){
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;
        String smallestSubaray = "";

        for(int end = 0; end < arr.length; end++){
            currentSum += arr[end];

            while (currentSum > num){
                if (end - start + 1 < minLength){ // +1
                    minLength = end - start + 1;
                    smallestSubaray = "[" + start + "-" + end + "]";
                }
                System.out.println("subarry found [" + start + "-" + end + "]");
                currentSum -= arr[start];
                start++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            System.out.println("No subarray found");
            return 0;
        } else{
            System.out.println("Smallest subarray: " + smallestSubaray);
            return minLength;
        }
    }
}
