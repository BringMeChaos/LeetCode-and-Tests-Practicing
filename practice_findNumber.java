public interface practice_findNumber {

    public static void main(String[] args) {
        int arr[] = {80,79,78};
        System.out.println(findNumber(arr));
    }

    public static int findNumber(int[] a){
        // go over the array liniarly, 
        // sliding window
        // check if i - (i+1) is indeed arr[i] -1
        // so, if 80-1 = 79, if 70 is in the next cell.
        // if we didnt get the expecte value - there is a gap and we can give this numbr.
        // 

        int expected;
        int i = 0;
        int result = Integer.MIN_VALUE;

        while(i <= a.length-2){
            // j = i+1;
            expected = a[i] - 1; // 79 this is an ecpected value, 80 -1 is 79, in cell a[j] can show up

            if(expected > a[i+1]){
                // there is a gap betwerrn a[i] and a[i+1], we should print it.
                result = a[i] - 1;
                return result;
            }

            if (expected == a[i+1]){
                i++;
            }
        }
        return result;
    }
    
}
