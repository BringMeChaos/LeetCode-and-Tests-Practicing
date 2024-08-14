public class Test2017_A_M86_Q2_Univ_countTriplets {
    public static void main(String[] args) {
        int[] arr1 = {-2,0,1,3};
        int[] arr2 = {1,3,4,5,7};
        System.out.println(countTriples(arr1,2));
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
}
