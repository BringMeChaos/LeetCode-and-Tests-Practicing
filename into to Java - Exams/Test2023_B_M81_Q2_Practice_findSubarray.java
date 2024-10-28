public class Test2023_B_M81_Q2_Practice_findSubarray {
 
    
    public static void main(String[] args) {
        int[] arr = {0};
        int target = 8;
        findSubarray(arr, target);
    }

    public static void findSubarray(int[] arr, int target){
        // sliding window 

        int i = 0;
        int j = 0;
        int sum = 0;
        boolean found = false;
        //int smallestIndex = Integer.MAX_VALUE;

        while(j <= arr.length-1){
            sum += arr[j];

            // good condition - found subarray
            if (sum == target){
                System.out.println("Target found in: i=" + i + " j=" + j);
                found = true;

                // checking if i is at the end of arr to avoid out of bound err
                if(i == arr.length-1){
                    break;
                }
                break;

                // leaving this part in for future referance:

                // subarray found, increasing i and j, reseting sum 
                // i++;
                // j = i;
                // sum = 0;
                
                // not sure increse is needed, if we found the first subarray, 
                // it's indexes are garantesed to be the first smallest.
            }

            // sum is smaller than target - need to increase j
            if (sum < target){
                // checking if j is at the end of arr, then increse i
                if (j == arr.length-1){
                    if(i == arr.length-1){
                        break;
                    }
                    i++;
                }
                j++;
            }

            //if sum is bigger then target, increae i and reset sum and j
            if(sum > target){
                if(i == arr.length-1){
                    break;
                }
                i++;
                j = i;
                sum = 0;
            }
        }
        if (found == false) {
            System.err.println("No subarray found.");
        }

    }
}
