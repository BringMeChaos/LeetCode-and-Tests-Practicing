public class Test2017_B_M93_Q2_Univ_findNum {

    // The following part is not something we are expected to wrute during the exam as
    // an answer, but this will help the code to actually run and  will help to test it.
    // in the exam we are expected to white only the method "findNum", the rest is 
    // given or assumed is implamented for us.


    public static void main(String[] args){
        Range P1 = new Range(4, 1);
        Range P2 = new Range(12,0);
        Range P3 = new Range(20,1);
        Range P4 = new Range(102,2);

        System.out.println("Center: " + P1._center + "  Radius: " + P1._radius);
        
        // creating an array from the new objects
        Range [] arr = {P1, P2, P3, P4};
        
        // need a for loop to pring out the array
        for(int i = 0; i < arr.length; i++){
            System.out.print("Obj: " + arr[i].getCenter() + " ," + arr[i].getRadius() + "\n");
        }

        System.out.println(findNum(arr, 104));
        
        // int test = (2 + 3) /2;
        // System.out.println(test);
    }
    
    // given method from the exam question:
    // in the question it didnt have "static" but I had to add it for this to work in one file
    // otherwise I cannot create new obj from the void main.
    public static class Range{
        private int _center, _radius;

        public Range(int c, int r){
            _center = c;
            _radius = r;
        }

        public int getCenter(){
            return _center;
        }

        public int getRadius(){
            return _radius;
        }
    }

    public static int findNum(Range rangeA[], int num){
            
        // using binary search to find if num is within the array rangeA, and 
        // if so, return it's index, if not, return -1.

        int low = 0;
        int high = rangeA.length-1;
        int mid;

        // calculate the highest number within the object
        int currRangeHigh;

        // calculate the lowest number within the object
        int currRangeLow;

        while(low <= high){
            mid = (low + high)/2;
            currRangeHigh = rangeA[mid].getCenter() + rangeA[mid].getRadius();
            currRangeLow = rangeA[mid].getCenter() - rangeA[mid].getRadius();

            // if num is within range
            if(num >= currRangeLow && num <= currRangeHigh){
                // return obj this index
                return mid;
            }

            if(num < currRangeLow){
                // number is out of this obj range, need to go lower
                high = mid -1;
            }

            if(num > currRangeHigh){
                // number is out of this obj range, need to go higher
                low = mid +1;
            }
        }

        // num was not found in any of the given ranges
        return -1;
    }
}
