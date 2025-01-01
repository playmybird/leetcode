class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[max] < height[i]) {
                max = i;
                left[i] = height[i];
            } else {
                left[i] = height[max];
            }
        }

        int[] right = new int[height.length];
        max = height.length - 1;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[max] < height[i]) {
                max = i;
                right[i] = height[i];
            } else {
                right[i] = height[max];
            }
        }

        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int water = Math.min(left[i], right[i]);
            if (water > height[i]) {
                ans += water - height[i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}