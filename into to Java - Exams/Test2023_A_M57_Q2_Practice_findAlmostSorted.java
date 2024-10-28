public class Test2023_A_M57_Q2_Practice_findAlmostSorted {
    /*
     * Question:
     * in an almost sorted array, find the location of num.
     * if num is not found, return -1.
     * 
     * 
     */


    public static void main(String[] args) {
        int[] arr = {60,80};
        int num = 80;

        System.out.println(findAlmostSorted2(arr,num));
    }

    // time complexity: O(log n)
    // space complexity: O(1)

    public static int findAlmostSorted(int[] arr, int num){
        // using binary search

        int start = 0;
        int mid;
        int end = arr.length-1;

        while (start <= end){
            mid = (start + end) / 2;

            // checking if mid is num
            if (arr[mid] == num){
                return mid;
                }

            // going to check mid + 1 and mid -1, need to make sure we are not at either ends of the array
            // or having array that is too small to avoid out of bound error.
            if (mid == arr.length-1 || mid == 0){
               // do nothing
            }

            // only if were not at a small array, we can check the adjecent items.
            else{

                if (arr[mid+1] == num){
                    return mid+1;
                }

                if (arr[mid-1] == num){
                    return mid-1;
                }
            }

            // moving start to half the array to the right
            if (mid < num){
                start = mid+1;
            }

            // moving end to half the array to the left
            if (mid > num){
                end = mid-1;
            }
        }

        // if the num is no founf in the array, returning -1
        return -1;
    }




    /* This is another test answer I found, not written by me, 
     * but this answer go the full 25 points even if it gets the out of bound err and there
     * are no checks for it.
     * 
     */
    public static int findAlmostSorted2(int[] arr, int num){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while (low <= high){
            mid = (low + high)/2;

            if (arr[mid] == num){
                return mid;
            }
            else if(arr[mid] < num){
                if(arr[mid-1] == num){
                    return mid -1;
                }
                else {
                    high = mid -2;
                }
            }
            else{
                if(arr[mid+1] == num){
                    return mid +1;
                }
                else{
                    low = mid +2;
                }
            }
        }
        return -1;
    }

}
