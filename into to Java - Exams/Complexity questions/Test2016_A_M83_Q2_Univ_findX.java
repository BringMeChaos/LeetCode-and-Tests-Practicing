public class Test2016_A_M83_Q2_Univ_findX {
    
    /*
     * Question:
     * For an "alsomst sorted array", where all even and uneven indexes are sorted seperatly,
     * find a adjesent pair, where num is it's sum.
     * return true if such a pair exsit, if not return false.
     * 
     */

    public static void main(String[] args) {
        int[] a = {1,2,5,3,6,10,9};
        int n = 8;
        System.out.println(findX(a, n));
    }

    public static boolean findX(int[] arr, int num){
        // using binary search

        int low = 0;
        int high = arr.length-1;
        int mid;

        while(low <= high){
            mid = (low + high)/2;

            if(mid == 0){
                return false;
            }
            // can use an or to combine the next to if to one if:
                if(arr[mid] + arr[mid+1] == num){ // checking pairs of mid and it's adjeicent right
                    return true;
                }
                if(arr[mid] + arr[mid-1] == num){ // checking pairs of mid and it's adjeicent left
                    return true;
                }

                else if(arr[mid] + arr[mid+1] < num){ // if sum is small, moving to the right
                    low = mid+1;
                }

                else if(arr[mid] + arr[mid+1] > num){ // is sum is bigger than num, moving to the left
                    high = mid-1;
                }
            }
        return false;
    }


    // another solution from lecture, the idea is the same, but is a bit different.
    // the code attached to the lecture (here bellow) is not what the instructor wrote in the lecture.. 
    // there are lines added, like checking if arr is null, that in the question it's mentioned to not check
    // such things..

    public static boolean findX2(int[] arr, int val) { // binary search implementation
        if (arr == null || arr.length == 1)
            return false;
        int low = 0;
        int high = arr.length - 1;

        while (low != high) { // O(log(n))
            int m = (low + high) / 2;
            if (m - 1 < 0 && arr[m] + arr[m + 1] != val)
                return false;
            if (m + 1 > arr.length - 1 && arr[m] + arr[m - 1] != val)
                return false;
            if (arr[m] + arr[m - 1] == val || arr[m] + arr[m + 1] == val)
                return true;
            if (arr[m] + arr[m - 1] > val)
                high = m - 1;
            else
                low = m + 1;
        }
        return false;
    }
}
