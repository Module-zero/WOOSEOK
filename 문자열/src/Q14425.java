/*
문자열 집합

https://www.acmicpc.net/problem/14425
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-11
 * Time: 오후 8:15
 */

public class Q14425
{
    static class Trie
    {
        class Node
        {
            int[] children = new int[26];
            boolean valid;

            public Node()
            {
                for (int i = 0; i < 26; i++)
                    this.children[i] = -1;
                this.valid = false;
            }
        }

        ArrayList<Node> trie = new ArrayList<>();
        int root;

        public Trie()
        {
            root = init();
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

            int c = str.charAt(index) - 'a';
            if(trie.get(node).children[c] == -1)
            {
                int next = init();
                trie.get(node).children[c] = next;
            }

            int child = trie.get(node).children[c];
            add(child, str, index + 1);
        }

        public boolean search(int node, String str, int index)
        {
            if(node == -1)
                return false;
            if(index == str.length())
                return trie.get(node).valid;

            int c = str.charAt(index) - 'a';
            int child = trie.get(node).children[c];
            return search(child, str, index+1);
        }
    }


    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        while(N-- > 0)
        {
            String str = br.readLine();

            trie.add(trie.root, str, 0);
        }

        int cnt = 0;
        while(M-- > 0)
        {
            String str = br.readLine();

            if(trie.search(trie.root, str, 0))
                cnt++;
        }

        System.out.println(cnt);
    }
}
