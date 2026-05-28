class Solution {

    // Trie node
    class TrieNode {

        // stores children
        TrieNode[] child = new TrieNode[26];

        // best index for this suffix
        int idx = -1;
    }

    TrieNode root = new TrieNode();

    String[] words;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        words = wordsContainer;

        // insert all container words into trie
        for(int i = 0; i < wordsContainer.length; i++) {

            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // answer each query
        for(int i = 0; i < wordsQuery.length; i++) {

            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    // insert reversed word into trie
    void insert(String word, int idx) {

        TrieNode node = root;

        // update root answer
        update(node, idx);

        // traverse from back
        // because suffix problem
        for(int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            // create node if absent
            if(node.child[ch] == null) {
                node.child[ch] = new TrieNode();
            }

            node = node.child[ch];

            // update best index
            update(node, idx);
        }
    }

    // store shortest word index
    void update(TrieNode node, int idx) {

        // first word
        if(node.idx == -1) {
            node.idx = idx;
            return;
        }

        String oldWord = words[node.idx];
        String newWord = words[idx];

        /*
        choose:
        1. smaller length
        2. if same length,
           earlier index already stored
        */

        if(newWord.length() < oldWord.length()) {
            node.idx = idx;
        }
    }

    // search longest matching suffix
    int search(String word) {

        TrieNode node = root;

        // default answer
        int ans = root.idx;

        // traverse from back
        for(int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            // suffix not found
            if(node.child[ch] == null) {
                break;
            }

            node = node.child[ch];

            // latest matched suffix answer
            ans = node.idx;
        }

        return ans;
    }
}