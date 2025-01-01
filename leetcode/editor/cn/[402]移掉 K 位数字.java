//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 1088 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String removeKdigits(String num, int k) {
//        int len = num.length();
//        if (len<=k){
//            return "0";
//        } else if (len==1) {
//            return num;
//        }
//        StringBuilder sb = new StringBuilder(num);
//        int cur = 0;
//        while (k>0 && cur+1<sb.length()){
//            int c = sb.charAt(cur);
//            int next = sb.charAt(cur+1);
//            if (c>next){
//                sb.deleteCharAt(cur);
//                if (cur>0){
//                    cur--;
//                }
//                k--;
//            }else {
//                cur++;
//            }
//        }
//
//        if (k>0){
//            len = sb.length();
//            sb.delete(len-k, len);
//        }
//
//        int zeroFirstCount = 0;
//        for (int i = 0; i < sb.length(); i++) {
//            if (sb.charAt(i)!='0'){
//                break;
//            }
//            zeroFirstCount++;
//        }
//
//        if (zeroFirstCount==sb.length()){
//            return "0";
//        }else{
//            return sb.delete(0, zeroFirstCount).toString();
//        }
//
//    }
//}

class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        StringBuilder ans = new StringBuilder(num.length() - k);
        ans.append((char) ('0' - 1));   // min flag

        int visitedCount = 0;
        for (var c : num.toCharArray()) {
            while (k>0){
                char last = getLast(ans);
                if (last <= c) {
                    break;
                }
                removeLast(ans);
                k--;
            }

            visitedCount++;
            ans.append(c);
            if (k <= 0) {
                break;
            }
        }

        ans.deleteCharAt(0); // del flag
        if (k == 0) {
            if (visitedCount < num.length()) {
                ans.append(num.substring(visitedCount));
            }
        } else if (ans.length() > k) {
            ans.delete(ans.length() - k, ans.length());
        }

        int zeroCount = 0;
        while (zeroCount<ans.length()){
            if (ans.charAt(zeroCount)!='0'){
                break;
            }

            zeroCount++;
        }

        if (zeroCount>0){
            ans.delete(0, zeroCount);
        }
        if (ans.isEmpty()){
            return "0";
        }
        return ans.toString();
    }

    private char getLast(StringBuilder sb) {
        return sb.charAt(sb.length() - 1);
    }

    private void removeLast(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }
}


//leetcode submit region end(Prohibit modification and deletion)
