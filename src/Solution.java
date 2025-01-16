import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> stack = new ArrayList<>(k);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(1, n, k, stack, ans);
        return ans;
    }

    private void dfs(int start, int end, int k, List<Integer> stack, List<List<Integer>> ans){
        if (end-start+1<k){
            return;
        }

        k--;
        for (int i = start; i <= end; i++) {
            stack.add(i);
            if (k==0){
                ans.add(new ArrayList<>(stack));
                stack.removeLast();
                continue;
            }

            dfs(i+1, end, k, stack, ans);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}