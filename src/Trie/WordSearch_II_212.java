package Trie;
import java.util.*;

public class WordSearch_II_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> output = new ArrayList<>();

        //用words build trie tree
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                int index = ch - 'a';
                if(curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }
            curr.word = word;
        }

        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dfs(i, j, root, board, n, m, output);
            }
        }
        return output;
    }

    private void dfs(int i, int j, TrieNode curr, char[][] board, int n, int m, List<String> output){
        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '-')
            return;

        char ch = board[i][j];
        int index = ch - 'a';

        if(curr.children[index] == null)
            return;
        curr = curr.children[index];
        if(curr.word != null){
            output.add(curr.word);
            curr.word = null; //把已经加到output的word删掉
        }

        board[i][j] = '-';
        dfs(i+1, j, curr, board, n, m, output);
        dfs(i-1, j, curr, board, n, m, output);
        dfs(i, j+1, curr, board, n, m, output);
        dfs(i, j-1, curr, board, n, m, output);

        board[i][j] = ch;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26]; //用array来存children，可以不用hashmap（当然也可以用就是了）
    String word; //以这个点结尾能表达的word
}

//用各个word来build trie tree，然后用dfs遍历
