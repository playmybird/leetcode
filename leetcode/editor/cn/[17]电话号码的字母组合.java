//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2980 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
import java.util.function.Function;

class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, Character[]> keys = new HashMap<>();
        keys.put(2, new Character[]{'a', 'b', 'c'});
        keys.put(3, new Character[]{'d', 'e', 'f'});
        keys.put(4, new Character[]{'g', 'h', 'i'});
        keys.put(5, new Character[]{'j', 'k', 'l'});
        keys.put(6, new Character[]{'m', 'n', 'o'});
        keys.put(7, new Character[]{'p', 'q', 'r', 's'});
        keys.put(8, new Character[]{'t', 'u', 'v'});
        keys.put(9, new Character[]{'w', 'x', 'y', 'z'});

        StringBuilder stack = new StringBuilder(digits.length());
        List<String> ans = new ArrayList<>();
        if (!digits.isEmpty()){
            dfs(digits, 0, keys, stack, ans);
        }
        return ans;
    }

    private void dfs(String digits, int cur, Map<Integer, Character[]> keys, StringBuilder stack,List<String> ans){
        if (cur>=digits.length()){
            ans.add(stack.toString());
            return;
        }

        for (var k:keys.get(digits.charAt(cur)-'0')){
            stack.append(k);
            dfs(digits, cur+1, keys, stack, ans);
            stack.deleteCharAt(stack.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}