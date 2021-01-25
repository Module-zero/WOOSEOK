/*
케빈 베이컨의 6단계 법칙

https://www.acmicpc.net/problem/1389
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오전 12:14
 */

public class Q1389
{
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int cntNum;
    static int[] sum = new int[101];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            queue.add(new int[]{i, 0});
            boolean[] check = new boolean[101];
            check[i] = true;

            while(!queue.isEmpty())
            {
                int[] tmp = queue.poll();

                int size = list.get(tmp[0]).size();
                for(int j=0; j<size; j++)
                {
                    int target = list.get(tmp[0]).get(j);
                    if(check[target])
                        continue;

                    sum[i] += (tmp[1]+1);
                    check[target] = true;
                    queue.add(new int[]{target, tmp[1]+1});
                }
            }

            if(sum[i] < min)
            {
                min = sum[i];
                cntNum = i;
            }
            else if(sum[i] == min && i < cntNum)
                cntNum = i;
        }

        System.out.println(cntNum);
    }
}
