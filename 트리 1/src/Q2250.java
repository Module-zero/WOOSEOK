/*
트리의 높이와 너비

https://www.acmicpc.net/problem/2250
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-24
 * Time: 오후 10:44
 */

public class Q2250
{
    static int[] parents = new int[10001];
    static int[] lefts = new int[10001];
    static int[] rights = new int[10001];
    static int[] lMax = new int[10001];
    static int[] rMax = new int[10001];
    static int width = 0;
    static int maxLevel = 0;

    public static void inorder(int data, int level)
    {
        if(data == -1)
            return;

        // 반복문을 돌리기 위한 최대 레벨 조사
        if(maxLevel < level)
            maxLevel = level;

        inorder(lefts[data], level+1);

        width++;
        // 해당 레벨의 가장 왼쪽 열이 아직 기록되지 않았으면 기록(해당 레벨에서 제일 처음 방문하는 노드가 가장 왼쪽)
        if(lMax[level] == 0)
            lMax[level] = width;

        // 해당 레벨의 가장 오른쪽 열을 기록(해당 레벨에서 제일 나중에 방문하는 노드가 가장 오른쪽)
        if(width > rMax[level])
            rMax[level] = width;

        inorder(rights[data], level+1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            lefts[parent] = left;
            if(left != -1)
                parents[left] = parent;

            rights[parent] = right;
            if(right != -1)
                parents[right] = parent;
        }

        // 루트를 조사
        int root = 0;
        for(int i=1; i<=N; i++)
        {
            if(parents[i] == 0)
            {
                root = i;
                break;
            }
        }

        inorder(root, 1);

        int ans = 0;
        int maxDiff = 0;
        for(int lv=1; lv<=maxLevel; lv++)
        {
            int diff = rMax[lv] - lMax[lv] + 1;

            if(maxDiff < diff)
            {
                maxDiff = diff;
                ans = lv;
            }
        }

        System.out.println(ans + " " + maxDiff);
    }
}
