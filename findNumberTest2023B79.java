public class findNumberTest2023B79 {
    // Question 2:
    // given an array in decending order, find an element that 
    // is larger than the smallest element and smaller then the largest 
    // element, and that is not fount in the array!
    // for example {60,50,4,3}, cam return 5, 6, 51, 52 etc.

    // O(n) - sliding window 
    // location O(1)
    // but this can be done in O(log(n)) using binary search

    public static void main(String[] args) {
        int[] arr = {20,9,8,7,6,5,4,3};
        System.out.println(findNumber(arr));
    }

    public static int findNumber(int[] arr){
        int left = arr.length-2;
        int right = arr.length-1;
        // int newValue = Integer.MIN_VALUE;

        while(left >= 0){
            
            if((arr[right] + 1) < arr[left] ){
                return arr[right]+1;
            }
            else {
                right -=1; 
            }
            left -=1;
        }
        return -1;
    }
}
