public class Test2019_B_M83_Q2_Practice_howManyNegativeNumbers {
    
    /*
     * Question:
     * given a 2D array filled with negative and positive integers where: 
     * 1. each line in the array is sorted in ascending order (smallest to largest) with no repetitions.
     * 2. each column in the array is sorted in ascending order (smallest to largest) with no repetitions.
     * 
     * return how many negative integeres there are in the array.
     */


    public static void main(String[] args) {
        int[][] arr = {{-99, -72, -64, -55, -28, -10, -5},
                       {-72, -53, -46, -38, 11, 13, 22},
                       {-63, -48, -27, -12, 14, 16, 23},
                       {-44, -29, -10, 0, 18, 20, 28},
                       {0, 12, 14, 20, 28, 30, 35}};
        // 
        System.out.println(howManyNegativeNumbers(arr));

    }



    public static int howManyNegativeNumbers(int[][] arr){
        // binary search on each line

        int start = 0;
        int end = arr[0].length-1;
        int endOfMat = arr.length-1;
        int row = 0; // to increase rows
        int mid;
        int sum = 0;
        

        while (row <= endOfMat){
            mid = (start + end)/2;

            if(start == end){
                // check for if we found negative or nothing is negative
                // if we did find something, end -1 will be the last negative int.
                if(arr[row][end-1] < 0){
                    // end of binary search for this row
                    // count how many negative numbers are in array from 0 to end, += end;

                    System.out.println("found negativs at: row: " + row + "Column: " +  end );
                    sum += end; // not adding -1 since count starts from 0, it will nullefy.
                    System.out.println("new sum is: " + sum );
                    
                    // increase row
                    // check for if in the end of rows
                    if(row == endOfMat-1){
                        // were at the end of mat and cannot increase row,
                        break;
                    }
                    row++; 
                    start = 0; // ============================== had to reaset pointers
                    end = arr[row].length-1;
                }

                // if nothing, we landed at the arr[row][0] and it's a positive number
                // just increase row.
                // we will not find negative numbers anymore if we keep foing down.
                else {
                    row++;
                }
                
            }

            // good condition
            // if we start to mid is negative increase start till we found a positive or zero
            if (arr[row][mid] < 0){
                start = mid+1;
            }

            // mid is not a negative number, increse search to the right
            if (arr[row][mid] >= 0){
                end = mid-1;
            }
        }
        return sum;
    }




}
