//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 764 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.Arrays;

class Solution {
    public int firstUniqChar(String s) {
        // 字母映射到数组下标
        // val保存首次下标
        // so：[0,s.length) is unique index, [2*s.length, 3*s.length) is more than 1 count
        int[] indexFlag = new int[128];

        Arrays.fill(indexFlag, Integer.MAX_VALUE);
        var stringBuf = s.toCharArray();
        for (int i = 0; i < stringBuf.length; i++) {
            int idx = stringBuf[i];
            if (indexFlag[idx] == Integer.MAX_VALUE) {
                indexFlag[idx] = i;
            } else {
                indexFlag[idx] = stringBuf.length;
            }
        }
        int min = Arrays.stream(indexFlag).min().getAsInt();
        return min < s.length() ? min : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
