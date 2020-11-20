/*
계란으로 계란치기

https://www.acmicpc.net/problem/16987
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-21
 * Time: 오전 12:50
 */

public class Q16987
{
    static int N;
    static int[] S = new int[8];
    static int[] W = new int[8];
    static boolean[] isBroken = new boolean[8];
    static int max = Integer.MIN_VALUE;

    public static void foo(int index, int cnt)
    {
        // 마지막 계란이거나 더 이상 깰 계란이 없을 경우
        if(index == N || cnt == N-1)
        {
            if(cnt > max)
                max = cnt;

            return;
        }

        // 이미 깨졌으면 넘어간다.
        if(isBroken[index])
        {
            foo(index+1, cnt);
            return;
        }

        for(int i=0; i<N; i++)
        {
            // 자기 자신을 칠 수는 없으므로 넘어간다.
            // 이미 박살났으면 넘어간다.
            if(i == index || isBroken[i])
                continue;

            int tmp = 0;
            // 들고 있는 계란의 내구도 감소
            S[index] -= W[i];
            if(S[index] <= 0)
            {
                isBroken[index] = true;
                tmp++;
            }

            // 친 계란의 내구도 감소
            S[i] -= W[index];
            if(S[i] <= 0)
            {
                isBroken[i] = true;
                tmp++;
            }

            foo(index+1, cnt+tmp);

            // 원상복구
            S[index] += W[i];
            S[i] += W[index];
            isBroken[index] = false;
            isBroken[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        foo(0, 0);
        System.out.println(max);
    }
}
