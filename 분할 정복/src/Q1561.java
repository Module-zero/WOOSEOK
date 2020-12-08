/*
놀이 공원

https://www.acmicpc.net/problem/1561
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-08
 * Time: 오후 1:38
 */

public class Q1561
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ary = new int[10001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        long start = 0;
        long end = 2000000000L*30;
        while(start <= end)
        {
            long mid = (start + end) / 2;

            // 0분에 모든 놀이기구가 비어있으므로 놀이기구의 수만큼 탈 수 있음
            long cnt = M;
            long cur = 0;
            for(int i=0; i<M; i++)
            {
                cnt += mid / ary[i];

                // 현재(mid) 분에 탄 사람의 수
                if(mid % ary[i] == 0)
                    cur++;
            }

            long prev = cnt - cur;

            // mid - 1분까지 탄 사람의 수가 N보다 작고 mid분까지 탄 사람의 수가 N보다 같거나 클 경우 mid분이 정답
            if(prev < N)
            {
                // 현재 분까지 탄 사람이 N을 포함하면 몇 번째 놀이기구인지 찾는다.
                if(cnt >= N)
                {
                    for(int i=1; i<=M; i++)
                    {
                        if(mid % ary[i-1] == 0)
                            prev++;

                        if(prev == N)
                        {
                            System.out.println(i);
                            return;
                        }
                    }
                }

                start = mid + 1;
            }
            else
                end = mid - 1;
        }
    }
}
