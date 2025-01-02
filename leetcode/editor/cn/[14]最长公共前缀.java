//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3243 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int ans = 0;

        while (true) {
            if (ans >= strs[0].length()) {
                break;
            }

            char target = strs[0].charAt(ans);
            boolean gg = false;
            for (int i = 1; i < strs.length; i++) {
                if (ans >= strs[i].length()) {
                    gg = true;
                    break;
                }
                if (strs[i].charAt(ans) != target) {
                    gg = true;
                    break;
                }
            }
            if (gg) {
                break;
            }
            ans++;
        }
        return strs[0].substring(0, ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
