class Solution {
    public int lengthOfLIS(int[] nums) {

        int n =  nums.length;
        int[] T =  new int[n];

        for (int i = 1; i < n; i++) {
            T[i] = 0;

            for  (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    T[i] = Math.max(T[i], 1 + T[j]);
                }
            }
        }

        int max = 0;
        for(int x : T){
            max = Math.max(max, x);
        }

        return max + 1;
    }
}