//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
// 
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
//
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 923 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    class Node {
        Node[] children;
        boolean leaf;
        String val;
    }

    private final Node top = new Node();
    private final Set<String> ans = new HashSet<>();
    private int rows;
    private int cols;
    private final int[][] step = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;
        for (var w : words) {
            insert(w);
        }

        var walk = new boolean[rows][cols];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                search(board, walk, x, y, top);
            }
        }
        return ans.stream().toList();
    }

    private void insert(String w) {
        var indexes = w.chars().map(c -> c - 'a').toArray();
        Node cur = top;
        for (var c : indexes) {
            if (cur.children == null) {
                cur.children = new Node[26];
            }
            if (cur.children[c] == null) {
                cur.children[c] = new Node();
            }

            cur = cur.children[c];
        }

        cur.leaf = true;
        cur.val = w;
    }

    private void search(char[][] board, boolean[][] walk, int x, int y, Node node) {
        if (node.children == null) {
            return;
        }

        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return;
        }

        if (walk[x][y]) {
            return;
        }

        var c = board[x][y] - 'a';
        if (node.children[c] == null) {
            return;
        }

        node = node.children[c];
        if (node.leaf) {
            ans.add(node.val);
        }

        walk[x][y] = true;

        for (int[] offset : step) {
            int xx = x + offset[0];
            int yy = y + offset[1];
            search(board, walk, xx, yy, node);
        }


        walk[x][y] = false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findWords(new char[][]{
                {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}
        }, new String[]{"oath","pea","eat","rain"}));
    }
}




//leetcode submit region end(Prohibit modification and deletion)
