public class Test2016_A_M87_Q2_Univ_passingCars {
    
    public static void main(String[] args){
        int arr[] = {0,1,0,1,1,0,0,0,1};

        System.out.println(passingCars(arr));
    }


    // Time O(n^2)
    // Space = O(1)

    public static int passingCars(int []a){
        int count = 0; // count to add pairs to
        int eastCar = 0;
        // int westCar = 1; // in the loop, i can represent this

        while (eastCar <= a.length-1){
            if (a[eastCar] == 0){
                for(int i = eastCar+1; i < a.length; i++){
                    if(a[i] == 1){
                        count++;
                    }
                }
                eastCar++;
            }

            if (a[eastCar] == 1){
                eastCar++;
            }

        }
        return count;
    }
}

        
