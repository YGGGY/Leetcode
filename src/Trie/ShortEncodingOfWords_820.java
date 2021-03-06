package Trie;
import java.util.*;

public class ShortEncodingOfWords_820 {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        List<TrieNode> leaves = new ArrayList<>();

        HashSet<String> set = new HashSet<>(Arrays.asList(words));//把String[]转成list再加入set（将list看成Collection所以能加进去）
        //这一步去掉words里重复的word
        //将一个个word插入trie
        for(String w : set){
            TrieNode curr = root;  //从root开始遍历&插
            for(int i = w.length()-1; i >= 0; i--){//从后往前遍历word，利用前缀树
                char ch = w.charAt(i);
                if(!curr.children.containsKey(ch))  //curr的子节点们(curr.children)（HashMap来表示）没有这个字母
                    curr.children.put(ch, new TrieNode()); //把这个字母加到root的子节点上
                curr = curr.children.get(ch); //走下一个TrieNode
            }
            curr.depth = w.length()+1; //叶子节点的depth：word长度 + 1(1为root的#)
            leaves.add(curr); //把这个word的叶子节点加到leaves里
        }

        int ans = 0;
        for(TrieNode leaf : leaves){
            if(leaf.children.isEmpty()) //说明leaf是个叶子节点（因为单个word的叶子节点不一定确实是个叶子节点，有可能有更长的
                ans += leaf.depth;  //把所有叶子节点的depth加起来就是答案
        }
        return ans;
    }
}

class TrieNode{
    int depth;
    HashMap<Character, TrieNode> children = new HashMap<>(); //Trie基于HashMap实现，所以可以用HashMap的function
}

//先建一个Trie，children表示节点的子节点们，是个HashMap<Character, TrieNode>
//root设为#，高度为1
//把所有word倒序加入Trie（这样后缀匹配就变成前缀匹配
//答案就是把所有叶子节点的depth加在一起 --- 用leaves来保存所有word的叶子节点方便计算，判断确实是叶子节点后把depth加上去