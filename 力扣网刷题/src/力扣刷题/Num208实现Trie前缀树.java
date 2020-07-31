package 力扣刷题;

public class Num208实现Trie前缀树 {
    class Trie {
        private class TrieNode{
            boolean isEnd;
            TrieNode[] next;

            public TrieNode() {
                isEnd = false;
                next = new TrieNode[26];
            }
        }
        //根节点
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }


        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if(node.next[c-'a']==null) return false;
                node = node.next[c - 'a'];
            }
            return node.isEnd;
        }


        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if(node.next[c-'a']==null) return false;
                node = node.next[c - 'a'];
            }
            return true;
        }
    }
}
