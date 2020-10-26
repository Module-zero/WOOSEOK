/*
트리 순회

https://www.acmicpc.net/problem/1991
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-24
 * Time: 오후 9:46
 */

public class Q1991
{
    static int[] lefts = new int[26];
    static int[] rights = new int[26];
    static StringBuilder sb = new StringBuilder();

    public static void preorder(int index)
    {
        if(index == -1)
            return;

        sb.append((char)(index + 'A'));
        preorder(lefts[index]);
        preorder(rights[index]);
    }

    public static void inorder(int index)
    {
        if(index == -1)
            return;

        inorder(lefts[index]);
        sb.append((char)(index + 'A'));
        inorder(rights[index]);
    }

    public static void postorder(int index)
    {
        if(index == -1)
            return;

        postorder(lefts[index]);
        postorder(rights[index]);
        sb.append((char)(index + 'A'));
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.')
                lefts[parent - 'A'] = -1;
            else
                lefts[parent - 'A'] = left - 'A';

            if(right == '.')
                rights[parent - 'A'] = -1;
            else
                rights[parent - 'A'] = right - 'A';

        }

        // 전위
        preorder('A' - 'A');
        sb.append("\n");

        // 중위
        inorder('A' - 'A');
        sb.append("\n");

        // 후위
        postorder('A' - 'A');
        sb.append("\n");

        System.out.print(sb.toString());
    }
}
