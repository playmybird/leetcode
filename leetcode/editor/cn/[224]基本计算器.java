//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
//
// Related Topics 栈 递归 数学 字符串 👍 1096 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int calculate(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        List<Integer> ans = new ArrayList<>();
        List<Character> flags = new ArrayList<>();
        boolean isNumber = false;
        boolean firstFlag = true;
        int op = 0;

        for (var c : s.toCharArray()) {
            switch (c) {
                case '+', '-':
                    if (isNumber) {
                        ans.add(op);
                        op = 0;
                        isNumber = false;
                    } else if (firstFlag) {
                        ans.add(0);
                    }

                    firstFlag = false;
                    sumOrSub(ans, flags);
                    flags.add(c);
                    break;

                case '(':
                    firstFlag = true;
                    flags.add(c);
                    break;

                case ' ':
                    break;

                case ')':
                    if (isNumber) {
                        ans.add(op);
                        op = 0;
                        isNumber = false;
                    }
                    sumOrSub(ans, flags);
                    flags.removeLast();
                    sumOrSub(ans, flags);
                    break;

                default:
                    isNumber = true;
                    firstFlag = false;
                    op = op * 10 + c - '0';
            }
        }

        if (isNumber) {
            ans.add(op);
            sumOrSub(ans, flags);
        }
        return ans.getLast();
    }

    private void sumOrSub(List<Integer> num, List<Character> flags) {
        if (flags.isEmpty() || flags.getLast() == '(') {
            return;
        }

        var op2 = num.removeLast();
        var op1 = num.removeLast();
        var f = flags.removeLast();
        if (f == '+') {
            num.add(op1 + op2);
        } else {
            num.add(op1 - op2);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(1+(-4+5+2)-3)+(6+8)"));
    }
}




//leetcode submit region end(Prohibit modification and deletion)
