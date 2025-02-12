//假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限
//，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。 
//
// 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。 
//
// 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。 
//
// 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。 
//
// 答案保证在 32 位有符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
//输出：4
//解释：
//由于你的初始资本为 0，你仅可以从 0 号项目开始。
//在完成后，你将获得 1 的利润，你的总资本将变为 1。
//此时你可以选择开始 1 号或 2 号项目。
//由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
//因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
// 
//
// 示例 2： 
//
// 
//输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10⁵ 
// 0 <= w <= 10⁹ 
// n == profits.length 
// n == capital.length 
// 1 <= n <= 10⁵ 
// 0 <= profits[i] <= 10⁴ 
// 0 <= capital[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 343 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class IPO {
        int profit;
        int capital;

        public IPO(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<IPO> ipo = new ArrayList<>(profits.length);
        for (int i = 0; i < profits.length; i++) {
            ipo.add(new IPO(profits[i], capital[i]));
        }

        ipo.sort(Comparator.comparingInt(o -> o.capital));
        PriorityQueue<IPO> maxHeap = new PriorityQueue<>(profits.length, (o1, o2) -> o2.profit - o1.profit);
        int index = 0;
        while (k > 0) {
            k--;
            while (index < ipo.size() && ipo.get(index).capital <= w) {
                maxHeap.add(ipo.get(index));
                index++;
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            var max = maxHeap.poll();
            w = w + max.profit;
        }

        return w;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
