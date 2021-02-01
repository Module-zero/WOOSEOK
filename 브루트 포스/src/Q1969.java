/*
DNA

https://www.acmicpc.net/problem/1969
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-01
 * Time: 오후 9:59
 */

public class Q1969
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] strs = new String[1001];
        for(int i=0; i<N; i++)
            strs[i] = br.readLine();

        int ans = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M; i++)
        {
            int[] cnt = new int[4];

            for(int j=0; j<N; j++)
            {
                char ch = strs[j].charAt(i);

                switch(ch)
                {
                    case 'A':
                        cnt[0]++;
                        break;
                    case 'C':
                        cnt[1]++;
                        break;
                    case 'G':
                        cnt[2]++;
                        break;
                    case 'T':
                        cnt[3]++;
                        break;
                }
            }

            int sum = cnt[0] + cnt[1] + cnt[2] + cnt[3];
            int index = 0;
            for(int k=1; k<4; k++)
            {
                if(cnt[k] > cnt[index])
                    index = k;
            }

            ans += sum - cnt[index];
            switch(index)
            {
                case 0:
                    sb.append('A');
                    break;
                case 1:
                    sb.append('C');
                    break;
                case 2:
                    sb.append('G');
                    break;
                case 3:
                    sb.append('T');
                    break;
            }
        }

        System.out.println(sb.toString());
        System.out.println(ans);
    }
}
