public class Test2017_A_M86_Q2_Univ_countTriplets {
    // this answer is not finished yet.

    
    /* Question:
     * Given an array of integers in an proper decending order (smallest to largest with no repetitions)
     * and an integer num, find how many triplets there are in the array where their sum is smaller than num.
     * The triplets dont have to be next to each other.
     * No need to check if the array is empty.
     * 
     * For example:
     * Array = {-2, 0, 1, 3}
     * num = 2
     * we should find the triplets: (-2,0,3), (-2,0,1)
     * we should return 2 in this case.
     * 
     */


    public static void main(String[] args) {
        int[] arr1 = {-2,0,1,3};
        int[] arr2 = {1,2,3};
        int num = 2;
        System.out.println(countTriplets3(arr2,2));
    }



    public static int countTriples(int[] arr, int num){

        int count = 0;

        for(int i = 0; i < arr.length-1; i++){
            count += countPairs(arr, i, num-arr[i]);
            System.out.println("This is triplets count: " + count);
        }
        return count;
    }

    public static int countPairs(int[] arr, int i, int num){
        int count = 0; // will count how many triplets were found

        int j = arr.length-1;
        // int k = 2;

        while(i < j){
            System.out.println("in pairs current i and j are: " + i + " " + j);
            if(arr[i] + arr[j] < num){
                System.out.println("Paris are: " + arr[i] + " " + arr[j]);
                count += j-i;
                i++;
            }
            
            if(arr[i] + arr[j] >= num){
                j--;
            }
            
        }
        return count;
    }


    public static int countTriplets2(int[] arr, int num){
        int i = 0;
        int j = 1;
        int count = 0;
        int countIter = 0;

        while(j < arr.length-1){
            countIter ++;
        
            if(i == j){
                j++;
            }

            if(arr[i] + arr[j] < num){
                count++;
                System.out.println("Paris are: " + arr[i] + " " + arr[j]);
                j++;
            }

            else{
                if(i >= arr.length-1){
                    break;
                }
                

                i++;
                j = i+1;
            }
            System.out.println("Iteration is: " + countIter);
        }
        return count;
    }


    // practising this question after a while, I dont think the above answers were complete.

    public static int countTriplets3(int[] arr, int num){
        // using sliding window 

    // int i = 0; // initialize it in for loop
        int j = 1;
        int k = 2;
        int sum ;
        int count = 0;


        // {-2,0,1,3};
        // num = 2
        for(int i = 0; i < arr.length-2; i++){
            j = i+1;
            k = i+2;
            sum = arr[i] + arr[j];

            while(i <= arr.length-1){
                sum += arr[k];

                if (sum < num){
                    System.out.println("Found a sub array! : " + i + ", " + j + ", " + k);
                    count +=1;
                    
                    // going to increment indexes, need to check if were at the end of the array
                    // if k is at the end, we need to increment j, but first check if j is at the end.
                    // if j is at the end, need to increment i, so break from the while loop to get to the for loop.
                   
                    if (k == arr.length-1){
                        if (j == arr.length-2){
                            break;
                        }
                        j++;
                        k = j+1;
                        // k = j + 1;
                    }
                    else{
                        k++;
                    }
                    // reset sum.
                    sum = arr[i] + arr[j];
                }

                // if sum is bigger then num, then no need to keep checking, break to increase i.
                if (sum >= num){
                    break;
                }
            }
        }
        return count;
    }



}
