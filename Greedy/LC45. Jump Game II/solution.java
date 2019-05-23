class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int near = 0;
        int far = 0;
        for(int i = 0; i < nums.length; ++i){
            if(i > near){
                ++steps;
                near = far;
            }
            far = Math.max(far, i + nums[i]);
        }
        return steps;
    }
}

