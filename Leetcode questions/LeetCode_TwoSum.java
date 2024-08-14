import java.util.Arrays;

public class LeetCode_TwoSum {

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(arr, target)));
        
    }

        public static int[] twoSum(int[] nums, int target) {
            for(int i = 0; i <= nums.length-1; i++){
                for(int j = i+1; j <= nums.length-1; j++){
                    if(nums[i] + nums[j] == target){
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
        }
    }


