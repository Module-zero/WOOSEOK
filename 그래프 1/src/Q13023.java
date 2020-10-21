/*
ABCDE

https://www.acmicpc.net/problem/13023
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-20
 * Time: 오후 5:15
 */

public class Q13023
{
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> ary = new ArrayList<>();
    static boolean[] check;
    static int isThere = 0;

    public static void dfs(int n, int cnt)
    {
        // 겹치는 친구 관계가 없고 4번의 친구 관계가 증명되었으면 정답 도출
        if(cnt == 5)
        {
            isThere = 1;
            return;
        }

        for(int i=0; i<ary.get(n).size(); i++)
        {
            // 인접 리스트에서 연결된 점 하나를 꺼내온다.
            int target = ary.get(n).get(i);

            if(!check[target])
            {
                check[target] = true;
                dfs(target, cnt + 1);
                check[target] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N];

        for(int i=0; i<N; i++)
            ary.add(new ArrayList<>());

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int id1 = Integer.parseInt(st.nextToken());
            int id2 = Integer.parseInt(st.nextToken());

            // id1과 id2는 친구
            ary.get(id1).add(id2);
            ary.get(id2).add(id1);
        }

        for(int i=0; i<N; i++)
        {
            if(isThere == 1)
                break;

            check[i] = true;
            dfs(i, 1);
            check[i] = false;
        }

        System.out.println(isThere);
    }
}
