class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        //1.check if it contains 1
        int contains = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                contains++;
                break;
            }
        }
        //if it does not contain 1, then the minimum missing positive is 1
        if(contains == 0){
            return 1;
        }
        //if contains == 1 and len == 1, then return the minimum missing positive 2
        //nums = [1]
        if(n == 1){
            return 2;
        }
        
        
        //2.go through the whole array, turn negative number and number larger than len to 1
        for(int i = 0; i < n; i++){
            if((nums[i] <= 0) || (nums[i] > n)){
                nums[i] = 1;
            }
        }
        //* Use index as a hash key and number sign as a presence detector.*
        //for example, if nums[1] is negative that means that number '1' is present in the array
        //if nums[2] is positive then number 2 is missing in the array
        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            if(a == n){
                nums[0] = - Math.abs(nums[0]);
            }else{
                nums[a] = - Math.abs(nums[a]);
            }
        }
        
        //now the index of the first positive number 
        //is equal to first missing positive
        for(int i = 1; i < n; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        
        if(nums[0] > 0){
            return n;
        }
        
        return n+1;
    }
}

//time O(n)
//space O(1)
