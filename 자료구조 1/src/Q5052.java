/*
전화번호 목록

https://www.acmicpc.net/problem/5052
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-24
 * Time: 오후 9:57
 */

public class Q5052
{
    static class Trie
    {
        class Node
        {
            int[] children;
            boolean valid;

            public Node()
            {
                children = new int[10];
                for(int i=0; i<10; i++)
                    children[i] = -1;

                valid = false;
            }
        }

        ArrayList<Node> trie;
        int root;

        public Trie()
        {
            trie = new ArrayList<>();
            root = 0;
        }

        public int init()
        {
            trie.add(new Node());
            return trie.size() - 1;
        }

        public void add(int node, String str, int index)
        {
            if(index == str.length())
            {
                trie.get(node).valid = true;
                return;
            }

            int c = str.charAt(index) - '0';
            if(trie.get(node).children[c] == -1)
            {
                int next = init();
                trie.get(node).children[c] = next;
            }

            int child = trie.get(node).children[c];
            add(child, str, index+1);
        }

        public boolean search(int node, String str, int index)
        {
            if(node == -1)
                return false;

            if(index == str.length())
                return trie.get(node).valid;

            if(trie.get(node).valid)
                return false;

            int c = str.charAt(index) - '0';
            int child = trie.get(node).children[c];
            return search(child, str, index+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            trie.init();
            String[] strs = new String[10001];
            for(int i=0; i<n; i++)
            {
                strs[i] = br.readLine();

                trie.add(0, strs[i], 0);
            }

            int i=0;
            for(; i<n; i++)
            {
                if(!trie.search(0, strs[i], 0))
                {
                    sb.append("NO").append('\n');
                    break;
                }
            }

            if(i == n)
                sb.append("YES").append('\n');
        }

        System.out.print(sb.toString());
    }
}
