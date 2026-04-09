class Solution {
    private Integer[] memo;
    private int[] nums;
    
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.memo = new Integer[nums.length];
        
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, solve(i));
        }
        
        return maxLength;
    }
    
    private int solve(int currentIndex) {
        if (memo[currentIndex] != null) {
            return memo[currentIndex];
        }
        
        int maxLen = 1;
        for (int j = 0; j < currentIndex; j++) {
            if (nums[j] < nums[currentIndex]) {
                maxLen = Math.max(maxLen, solve(j) + 1);
            }
        }
        
        memo[currentIndex] = maxLen;
        return maxLen;
    }
}
