//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1270 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(Math.max(a.length(), b.length()) + 2);
        int incNext = 0;
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++, ia--, ib--) {
            int sum = a.charAt(ia) + b.charAt(ib) + incNext - '0';
            if (sum > '1') {
                sum -= 2;
                incNext = 1;
            } else {
                incNext = 0;
            }

            sb.appendCodePoint(sum);
        }

        if (ia < 0) {
            ia = ib;
            a = b;
        }
        while (ia >= 0) {
            int sum = a.charAt(ia) + incNext;
            ia--;
            if (sum > '1') {
                sum -= 2;
                incNext = 1;
            } else {
                incNext = 0;
            }

            sb.appendCodePoint(sum);
        }
        if (incNext > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
