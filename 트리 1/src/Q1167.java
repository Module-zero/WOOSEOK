/*
트리의 지름

https://www.acmicpc.net/problem/1167
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-25
 * Time: 오전 12:54
 */

public class Q1167
{
    static ArrayList<ArrayList<int[]>> ary;
    static boolean[] check;
    static int V;
    static int ans = 0;
    static int ansIndex = 0;

    public static void foo(int index, int sum)
    {
        check[index] = true;

        if(sum > ans)
        {
            ans = sum;
            ansIndex = index;
        }

        int size = ary.get(index).size();
        for(int i=0; i<size; i++)
        {
            int[] tmp = ary.get(index).get(i);

            if(!check[tmp[0]])
                foo(tmp[0], sum + tmp[1]);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점의 개수
        V = Integer.parseInt(br.readLine());

        // 인접 리스트 생성
        ary = new ArrayList<>();
        for(int i=0; i<=V; i++)
            ary.add(new ArrayList<>());

        // 트리 정보 입력
        int i = V;
        while(i-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 정점 번호
            int num = Integer.parseInt(st.nextToken());

            // 다른 정점
            int target = Integer.parseInt(st.nextToken());
            while(target != -1)
            {
                // 그 정점까지의 거리
                int dist = Integer.parseInt(st.nextToken());

                // [0] : 정점, [1] : 거리
                ary.get(num).add(new int[]{target, dist});

                target = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[100001];
        foo(1, 0);
        check = new boolean[100001];
        foo(ansIndex, 0);

        System.out.println(ans);
    }
}
