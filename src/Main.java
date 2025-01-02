class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            max = Math.max((r - l) * h, max);

            if (height[l] < height[r]) {
                int t = height[l];
                while (l < r && height[l] <= t) {
                    l++;
                }
            } else {
                int t = height[r];
                while (l < r && height[r] <= t) {
                    r--;
                }
            }
        }

        return max;
    }
}