class Solution {
    public int removeDuplicates(int[] nums) {
        int last1 = Integer.MAX_VALUE;
        int last2 = Integer.MAX_VALUE;
        int[] ans = nums;
        int wr = 0;

        for (int cur : nums) {
            if (cur == last1 && cur == last2) {
                continue;
            }

            ans[wr] = cur;
            wr++;

            last2 = last1;
            last1 = cur;
        }

        return wr;
    }
}