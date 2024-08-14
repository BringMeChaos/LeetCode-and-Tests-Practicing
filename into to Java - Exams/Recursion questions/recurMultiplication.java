
public class recurMultiplication
{   
    public static void main(String[] args){
        what(8,3);
    }

    public static int what(int num, int times){
        // this will multiply numbers using recursion.
           
            return what(num, times, 0);
            //System.out.println("Hi, im " + times );
        }

        private static int what(int num, int times, int res){
        if(times == 0){
            return res;
        }
        return what(num, times-1, num+res);
        }
}
