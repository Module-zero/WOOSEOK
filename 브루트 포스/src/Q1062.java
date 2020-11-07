/*
가르침

https://www.acmicpc.net/problem/1062
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-08
 * Time: 오전 12:10
 */

public class Q1062
{
    static int N;
    static int K;
    static String[] strs = new String[51];
    static int max = Integer.MIN_VALUE;
    static boolean[] word = new boolean[26];

    public static void foo(int index, int k)
    {
        if(k < 0)
            return;

        if(index == 26)
        {
            int cnt = 0;

            for(int i=0; i<N; i++)
            {
                String str = strs[i];

                boolean isOk = true;
                for(int j=0; j<str.length(); j++)
                {
                    char ch = str.charAt(j);

                    // 배우지 않은 단어면 종료
                    if(!word[ch - 'a'])
                    {
                        isOk = false;
                        break;
                    }
                }

                if(isOk)
                    cnt++;
            }

            if(max < cnt)
                max = cnt;

            return;
        }

        // 가르쳤을 때
        word[index] = true;
        foo(index+1, k-1);
        word[index] = false;
        // 가르치지 않았을 때
        if(index != 'a' - 'a' || index != 'n' - 'a' || index != 't' - 'a' || index != 'i' - 'a' || index != 'c' - 'a')
            foo(index+1, k);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
            strs[i] = br.readLine();

        // anta, tica가 알파벳 5개
        if(K < 5)
            System.out.println(0);
        else
            foo(0, K);

        System.out.println(max);
    }
}
