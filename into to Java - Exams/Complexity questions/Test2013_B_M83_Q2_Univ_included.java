public class Test2013_B_M83_Q2_Univ_included {
    
    public static void main(String[] args){
        System.out.println(included(4342113, 45111));
    }

    // test answer starts here:
    public static int included(int x, int y){
        boolean[] arr = new boolean[10];
        int num;
        int count = 0;


        while(x > 0){
            num = x%10;
            arr[num] = true;
            x = x/10;
        }

        while(y > 0){
            num = y%10;
            arr[num] = false;
            y = y/10;
        }

        for(int i = 0; i < arr.length-1; i++){
            if (arr[i] == true){
                count++;
            }
        }

        return count;
    }
}

