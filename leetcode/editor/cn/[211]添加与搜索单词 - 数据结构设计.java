//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 25 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 10⁴ 次 addWord 和 search 
// 
//
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 599 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class WordDictionary {
    class Node {
        Node[] children;
        boolean leaf;
    }

    private final Node top;

    public WordDictionary() {
        top = new Node();
    }

    public void addWord(String word) {
        var indexes = word.chars().map(c -> c - 'a').toArray();
        var cur = top;
        for (var idx : indexes) {
            if (cur.children == null) {
                cur.children = new Node[26];
            }
            if (cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.leaf = true;
    }

    public boolean search(String word) {
        var cur = top;
        var indexes = word.chars().map(c -> c - 'a').toArray();
        return search(indexes, 0, cur);
    }

    private boolean search(int[] indexes, int start, Node node) {
        if (start>=indexes.length){
            return node.leaf;
        }

        for (int cur = start; cur < indexes.length; cur++) {
            if (node.children == null) {
                return false;
            }

            int c = indexes[cur];
            int point = '.' - 'a';
            if (c == point) {
                start = cur + 1;
                for (int i = 0; i < 26; i++) {
                    var child = node.children[i];
                    if (child != null) {
                        if (search(indexes, start, child)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            if (node.children[c] == null) {
                return false;
            }

            node = node.children[c];
        }

        return node.leaf;
    }

    public static void main(String[] args) {
        var w = new WordDictionary();
        w.addWord("at");
        w.addWord("and");
        w.addWord("an");
        w.addWord("add");

        System.out.println(w.search("a"));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
