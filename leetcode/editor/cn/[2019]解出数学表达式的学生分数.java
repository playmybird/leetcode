//给你一个字符串 s ，它 只 包含数字 0-9 ，加法运算符 '+' 和乘法运算符 '*' ，这个字符串表示一个 合法 的只含有 个位数数字 的数学表达式（
//比方说 3+5*2）。有 n 位小学生将计算这个数学表达式，并遵循如下 运算顺序 ： 
//
// 
// 按照 从左到右 的顺序计算 乘法 ，然后 
// 按照 从左到右 的顺序计算 加法 。 
// 
//
// 给你一个长度为 n 的整数数组 answers ，表示每位学生提交的答案。你的任务是给 answer 数组按照如下 规则 打分： 
//
// 
// 如果一位学生的答案 等于 表达式的正确结果，这位学生将得到 5 分。 
// 否则，如果答案由 一处或多处错误的运算顺序 计算得到，那么这位学生能得到 2 分。 
// 否则，这位学生将得到 0 分。 
// 
//
// 请你返回所有学生的分数和。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：s = "7+3*1*2", answers = [20,13,42]
//输出：7
//解释：如上图所示，正确答案为 13 ，因此有一位学生得分为 5 分：[20,13,42] 。
//一位学生可能通过错误的运算顺序得到结果 20 ：7+3=10，10*1=10，10*2=20 。所以这位学生得分为 2 分：[20,13,42] 。
//所有学生得分分别为：[2,5,0] 。所有得分之和为 2+5+0=7 。
// 
//
// 示例 2： 
//
// 输入：s = "3+5*2", answers = [13,0,10,13,13,16,16]
//输出：19
//解释：表达式的正确结果为 13 ，所以有 3 位学生得到 5 分：[13,0,10,13,13,16,16] 。
//学生可能通过错误的运算顺序得到结果 16 ：3+5=8，8*2=16 。所以两位学生得到 2 分：[13,0,10,13,13,16,16] 。
//所有学生得分分别为：[5,0,0,5,5,2,2] 。所有得分之和为 5+0+0+5+5+2+2=19 。
// 
//
// 示例 3： 
//
// 输入：s = "6+0*1", answers = [12,9,6,4,8,6]
//输出：10
//解释：表达式的正确结果为 6 。
//如果一位学生通过错误的运算顺序计算该表达式，结果仍为 6 。
//根据打分规则，运算顺序错误的学生也将得到 5 分（因为他们仍然得到了正确的结果），而不是 2 分。
//所有学生得分分别为：[0,0,5,0,0,5] 。所有得分之和为 10 分。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 31 
// s 表示一个只包含 0-9 ，'+' 和 '*' 的合法表达式。 
// 表达式中所有整数运算数字都在闭区间 [0, 9] 以内。 
// 1 <= 数学表达式中所有运算符数目（'+' 和 '*'） <= 15 
// 测试数据保证正确表达式结果在范围 [0, 1000] 以内。 
// n == answers.length 
// 1 <= n <= 10⁴ 
// 0 <= answers[i] <= 1000 
// 
//
// Related Topics 栈 记忆化搜索 数组 数学 字符串 动态规划 👍 19 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
