//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 1123 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String removeDuplicateLetters(String s) {
//        char[] buf = s.toCharArray();
//
//        // 统计出现的次数，判断后面是否还会有该字母
//        int[] count = new int[26];
//        for (char value : buf) {
//            count[value - 'a']++;
//        }
//
//        // 结果 && 标记去重，已经在结果中的字母可以直接忽略，因为即使插入也是之前的位置，没有意义啊
//        StringBuilder ans = new StringBuilder();
//        boolean[] has = new boolean[26];
//
//        // 遍历每个字母
//        for (char c : buf) {
//            int idx = getIndex(c);
//
//            // 空结果，就直接放进来啊
//            if (ans.isEmpty()) {
//                ans.append(c);
//                has[idx] = true;
//                count[idx]--;
//            } else {
//                // 是否在结果中，在的话就忽略
//                if (has[idx]) {
//                    count[idx]--;
//                    continue;
//                }
//
//                // 不在结果中，说明当前这个字母必须要append到ans中了
//                // 但是为了保证最小的字典序，所以要检查左侧的字母是否比当前插入的这个大
//                // 如果大，且后面还有（说明后面还有机会进入到结果中），就弹出
//                //        后面没有了（没机会了），人家都木有机会了，踢了就没办法出现在结果中了
//                // 如果小，那就直接插入啊，无需额外判断，已经满足最小字典序，把问题留给后面的hhh
//                char last = getLast(ans);
//                if (last < c) {
//                    ans.append(c);
//                    has[idx] = true;
//                    count[idx]--;
//                } else if (last > c) {
//                    while (last > c && count[getIndex(last)] > 0) {
//                        has[getIndex(last)] = false;
//                        removeLast(ans);
//                        if (ans.isEmpty()){
//                            break;
//                        }
//
//                        last = getLast(ans);
//                    }
//
//                    ans.append(c);
//                    has[idx] = true;
//                    count[idx]--;
//                }
//            }
//        }
//
//        return ans.toString();
//    }
//
//    private int getIndex(char c){
//        return c-'a';
//    }
//
//    private char getLast(StringBuilder sb){
//        return sb.charAt(sb.length()-1);
//    }
//
//    private void removeLast(StringBuilder sb){
//        sb.deleteCharAt(sb.length()-1);
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().removeDuplicateLetters("bbcaac"));
//    }
//}

class Solution {
    public String removeDuplicateLetters(String s) {
        char[] buf = s.toCharArray();

        // 统计出现的次数，判断后面是否还会有该字母
        int[] count = new int[26];
        for (char value : buf) {
            count[value - 'a']++;
        }

        // 结果 && 标记去重，已经在结果中的字母可以直接忽略，因为即使插入也是之前的位置，没有意义啊
        StringBuilder ans = new StringBuilder();
        boolean[] has = new boolean[26];

        // 遍历每个字母
        for (char c : buf) {
            int idx = getIndex(c);
            count[idx]--;

            // 是否在结果中，在的话就忽略
            if (has[idx]) {
                continue;
            }

            // 空结果，就直接放进来啊
            if (ans.isEmpty()) {
                ans.append(c);
                has[idx] = true;
                continue;
            }


            // 不在结果中，说明当前这个字母必须要append到ans中了
            // 但是为了保证最小的字典序，所以要检查左侧的字母是否比当前插入的这个大
            // 如果大，且后面还有（说明后面还有机会进入到结果中），就弹出
            //        后面没有了（没机会了），人家都木有机会了，踢了就没办法出现在结果中了
            // 如果小，那就直接插入啊，无需额外判断，已经满足最小字典序，把问题留给后面的hhh
            char last = getLast(ans);
            if (last < c) {
                // do nothing
            } else if (last == c) {
                // skip
                continue;
            } else {// pop last
                // check has another in right
                while (last > c && count[getIndex(last)] > 0) {
                    has[getIndex(last)] = false;
                    removeLast(ans);
                    if (ans.isEmpty()) {
                        break;
                    }

                    last = getLast(ans);
                }
            }
            ans.append(c);
            has[idx] = true;
        }

        return ans.toString();
    }

    private int getIndex(char c) {
        return c - 'a';
    }

    private char getLast(StringBuilder sb) {
        return sb.charAt(sb.length() - 1);
    }

    private void removeLast(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bbcaac"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
