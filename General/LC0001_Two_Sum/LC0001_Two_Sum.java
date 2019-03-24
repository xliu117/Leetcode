import java.util.Arrays;
import java.util.HashMap;

public class LC0001_Two_Sum {
    //Solution1:Brute Force
    //Time:O(n^2)

    /***
     public static int[] twoSum(int[] nums, int target) {
     int[] res = new int[2];
     for (int i = 0; i < nums.length; i++) {
     for (int j = i; j < nums.length; j++) {
     if (nums[i] + nums[j] == target) {
     res[0] = i;
     res[1] = j;
     }
     }
     }
     return res;
     }
     */
    //Solution2:Hashmap
    //Time: O(n)
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] myIntArray = new int[]{2, 7, 11, 15};
        int myIntTarget = 9;
        System.out.println("Input Array is[2,7,11,15]");
        System.out.println("Target is 9");
        System.out.println("Indices of two numbers:" + Arrays.toString(twoSum(myIntArray, myIntTarget)));

    }

}
