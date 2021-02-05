/*
마인크래프트

https://www.acmicpc.net/problem/18111
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-05
 * Time: 오후 10:46
 */

public class Q18111
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] cnt = new int[257];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
            {
                int num = Integer.parseInt(st.nextToken());
                cnt[num]++;
            }
        }

        int min = Integer.MAX_VALUE;
        int height = 0;
        for(int i=0; i<=256; i++)
        {
            int time = 0;
            int need = B;

            for(int j=0; j<=256; j++)
            {
                if(cnt[j] == 0 || i == j)
                    continue;

                int diff = j - i;
                if(diff < 0)
                    diff = -diff;

                if(j > i)
                {
                    // 블록당 2초의 시간이 들며 인벤토리에 블록이 추가된다.
                    time += 2 * diff * cnt[j];
                    need += diff * cnt[j];
                }
                else
                {
                    // 블록당 1초의 시간이 들며 인벤토리에서 블록이 제거된다.
                    time += diff * cnt[j];
                    need -= diff * cnt[j];
                }
            }

            // 인벤토리에 블록이 모자라면 넘어간다.
            if(need < 0)
                continue;

            if(time < min)
            {
                min = time;
                height = i;
            }
            else if(time == min && i > height)
                height = i;
        }

        System.out.println(min + " " + height);
    }
}
