/*
트리

https://www.acmicpc.net/problem/1068
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오후 12:12
 */

public class Q1068
{
    static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }

        public void add(int data)
        {
            if(left == null)
                left = new Node(data);
            else if(right == null)
                right = new Node(data);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Node tree = new Node(Integer.parseInt(st.nextToken()));
        for(int i=0; i<N-1; i++)
        {
            int data = Integer.parseInt(st.nextToken());
        }
    }
}
