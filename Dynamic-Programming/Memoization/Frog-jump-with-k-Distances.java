class Solution {

     public static int frogs(int idx,int []dp,int []h,int k){
        if(idx==0){
            return 0;
        }

        if(dp[idx]!=-1) return dp[idx];
        int val=Integer.MAX_VALUE,res=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if((idx-i)>=0){
            val =frogs(idx-i,dp,h,k)+Math.abs(h[idx]-h[idx-i]);
        }
        res=Math.min(val,res);
        }
        return dp[idx]=res;  
         }
    public int frogJump(int[] heights, int k) {
         int n=heights.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return frogs(n-1,dp,heights,k);
    }
}


/*Approach

In this problem, we are given a height array and an integer k, which represents the maximum number of positions the frog can jump.

For example, if we are currently at index 5 and k = 3, the frog can make any of these jumps:

5 → 4 — 1 jump
5 → 3 — 2 jumps
5 → 2 — 3 jumps

So, at every position, we need to consider all possible jumps from 1 to k.

I use recursion with dynamic programming (memoization) to solve this problem.

First, for every index, I loop from 1 to k to check all the possible jump distances. For each jump, I check whether the previous index idx - i is valid, meaning it should be greater than or equal to 0.

If the jump is valid, I recursively calculate the minimum cost to reach that previous position and add the cost of the current jump:

|heights[idx] - heights[idx - i]|

Among all the possible jumps, I take the minimum cost and store it in the dp array.

The dp array helps us avoid calculating the same position again. If a position has already been calculated, we directly return its stored value.

The base case is idx == 0, because the frog is already at the starting position, so the cost is 0.

Time Complexity

There are n positions, and for each position we try at most k possible jumps.

Time Complexity: O(n × k)

Space Complexity

The dp array requires O(n) space, and the recursion stack can go up to O(n) in the worst case.

Space Complexity: O(n)

So overall:

Time: O(n × k)
Space: O(n)*/
