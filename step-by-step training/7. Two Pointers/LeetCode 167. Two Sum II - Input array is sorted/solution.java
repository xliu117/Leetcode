class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while( i < j){
            int sum = numbers[i] + numbers[j];
            if(sum < target){
                i++;
                continue;
            }
            if(sum > target){
                j--;
                continue;
            }
            if(sum == target){
                return new int[] {i+1, j+1};
            }
        }
        return new int[] {-1,-1};
    }
}
