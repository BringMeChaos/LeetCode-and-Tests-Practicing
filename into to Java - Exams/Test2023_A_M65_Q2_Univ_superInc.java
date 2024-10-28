public class Test2023_A_M65_Q2_Univ_superInc{
    // given a supper acending array where each element in the array is bigger
    // than the sum of all the previous numbers.
    // given this array and an integer K, find if there is a sub-group of the 
    // array where the sum of them will give K exactly.
    //
    // Example:
    // <2,3,8,27>
    // for K = 30 there is a sub group {3,27}
    // But for K = 7 there is no sub group, since {2,2,3} is not a valid option.
    //
    // write a boolean method the gets an int[] arr and int K.

    public static boolean superInc(int[] arr, int K){
        int currValue = arr.length;

        while (K > 0 && currValue >= 0) {
            if (arr[currValue] <= K){
                K -= (arr[currValue]);
            }
            currValue--;
        }
        if(K == 0){
            return true;
        } 
        else{
            return false;
        }
    }
}