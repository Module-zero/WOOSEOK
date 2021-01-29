/*
이진 검색 트리

https://www.acmicpc.net/problem/5639
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오후 9:10
 */

public class Q5639
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
    }

    static class BST
    {
        Node root;

        public void insert(int data)
        {
            if(root == null)
                root = new Node(data);
            else
            {
                Node head = root;
                Node cur;

                while(true)
                {
                    cur = head;

                    if(head.data > data)
                    {
                        head = head.left;

                        if(head == null)
                        {
                            cur.left = new Node(data);
                            break;
                        }
                    }
                    else
                    {
                        head = head.right;

                        if(head == null)
                        {
                            cur.right = new Node(data);
                            break;
                        }
                    }
                }
            }
        }
    }

    static StringBuffer sb = new StringBuffer();

    public static void postorder(Node node)
    {
        if(node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.data).append('\n');
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BST bst = new BST();
        while(true)
        {
            String str = br.readLine();
            if(str == null)
            {
                postorder(bst.root);
                break;
            }

            if(bst.root == null)
                bst.root = new Node(Integer.parseInt(str));
            else
                bst.insert(Integer.parseInt(str));
        }

        System.out.print(sb.toString());
    }
}
