import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {

        int n = pairs.length;

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int count = 1;
        int currentRight = pairs[0][1];

        for (int i = 1; i < n; i++){
            if (currentRight < pairs[i][0]){
                count++;
                currentRight = pairs[i][1];
            }
        }

        return count;
    }
}