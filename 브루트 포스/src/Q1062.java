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
    static int[] word = new int[51];
    static int max = Integer.MIN_VALUE;
    static int bit = 0;

    public static boolean promise(int cnt)
    {
        // a, n, t, i, c와 K-5개보다 많은 알파벳을 배웠으면
        if(cnt > K-5)
            return false;

        return true;
    }

    public static void foo(int index, int cnt)
    {
        if(promise(cnt))
        {
            // a, n, t, i, c를 제외한 알파벳을 순회했으면 종료
            if(index == 26)
            {
                int i = 0;
                int wordCnt = 0;

                // 입력받은 단어가 끝날 때까지
                while(word[i] != 0)
                {
                    // 모두 배웠을 경우 카운트 증가
                    if((word[i] & bit) == word[i])
                        wordCnt++;

                    i++;
                }

                if(wordCnt > max)
                    max = wordCnt;

                return;
            }

            if(index != 'a' - 'a' && index != 'n' - 'a' && index != 't' - 'a' && index != 'i' - 'a' && index != 'c' - 'a')
            {
                // a, n, t, i ,c를 제외한 알파벳을 가르친다.
                bit |= (1 << index);
                foo(index + 1, cnt + 1);

                // 가르치지 않는다.
                bit &= ~(1 << index);
            }

            foo(index+1, cnt);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K < 5)
        {
            System.out.println(0);
            return;
        }

        bit |= (1 << 'a' - 'a');
        bit |= (1 << 'n' - 'a');
        bit |= (1 << 't' - 'a');
        bit |= (1 << 'i' - 'a');
        bit |= (1 << 'c' - 'a');

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<str.length(); j++)
                word[i] |= 1 << (str.charAt(j) - 'a');
        }

        foo(0, 0);
        System.out.println(max);
    }
}
