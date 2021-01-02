/*
텀 프로젝트

https://www.acmicpc.net/problem/9466
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-25
 * Time: 오후 11:09
 */

public class Q9466
{
    static int[] ary;
    static boolean[] check;
    static boolean[] finished;
    static int ans;

    public static void dfs(int id)
    {
        check[id] = true;

        // 다음 타겟으로
        if(!check[ary[id]])
            dfs(ary[id]);
        // 이미 방문했을 경우
        else
        {
            // 이미 연산이 끝났을 경우 자신은 싸이클에 해당하지 않음
            if(finished[ary[id]])
            {
                finished[id] = true;
                ans++;
            }
            // 싸이클일 경우
            else
            {
                int start = id;
                int next = id;

                // 싸이클에 해당하는 모든 정점의 finished를 true로 바꾼다.
                while(true)
                {
                    finished[next] = true;
                    next = ary[next];

                    if(start == next)
                        break;
                }
            }
        }

        // 싸이클에 해당하지 않았을 경우
        if(!finished[id])
        {
            finished[id] = true;
            ans++;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            ans = 0;
            ary = new int[100001];
            check = new boolean[100001];
            finished = new boolean[100001];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            for(int i=1; i<=n; i++)
            {
                if(!check[i])
                    dfs(i);
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
