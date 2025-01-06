import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> ans = new ArrayList<>();
        int cur = 0;
        for (cur = 0; cur < intervals.length; cur++) {
            var c = intervals[cur];
            if (c[1] >= newInterval[0]) {
                break;
            }
            ans.add(c);
        }

        if (cur < intervals.length) {
            if (newInterval[1] < intervals[cur][0]) {

            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[cur][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[cur][1]);

                cur++;
                for (; cur < intervals.length; cur++) {
                    if (newInterval[1] < intervals[cur][0]) {
                        break;
                    }
                    newInterval[1] = Math.max(newInterval[1], intervals[cur][1]);
                }
            }
        }
        ans.add(newInterval);

        for (; cur < intervals.length; cur++) {
            ans.add(intervals[cur]);
        }

        int[][] ret = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }

        return ret;
    }
}