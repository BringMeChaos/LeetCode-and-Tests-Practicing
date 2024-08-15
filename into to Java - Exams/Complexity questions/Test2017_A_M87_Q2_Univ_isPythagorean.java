public class Test2017_A_M87_Q2_Univ_isPythagorean {
    

    public static void main(String[] args){
        int [] arr = {1,3,4,5,6};
        // {1,3,4,5,6} //this should return true, because 3^2 + 4^2 = 5^2
        // {4,5,6,10,12} // this should return false
        System.out.println(isPythagorean(arr));
        
    }
    /*
     * Time complexity: O(n^2)
     * space complexity: O(4) = O(1)
     */


    public static boolean isPythagorean(int[] arr){
        // sliding window with 3 pointers
        int start = 0;
        int j = 1;
        int k = 2;
        int leftRes;

        for(int i = start; i < arr.length; i++){
            // reseting the location of j and k based of the new location of i
            j = i+1;
            k = i+2;

            while (k < arr.length){
                leftRes = (arr[i] * arr[i]) + (arr[j] * arr[j]);

                if(leftRes == (arr[k]* arr[k])){
                    System.out.println("Found at: [" + i + "-" + j + "-" + k + "]" );
                    return true;
                }

                else{
                    // if k at the end - increase j and reset k to be j+1
                    if(k == arr.length-1){ 
                        
                        // but if j is also at the end at arr.length-2, we need to break,
                        // to avoid out of bound err
                        if(j == arr.length-2){
                            break;
                        }
                        // otherwise, if k and j are not in the end, we can increse them
                        else{
                            j++;
                            k = j+1;
                        }
                    }
                    // we need to increase k, untill k got to the end of arr
                    else{
                        k++;
                    }
                }

            }
        }

        return false;
    }
}
