/*
개미

https://www.acmicpc.net/problem/3048
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-24
 * Time: 오후 4:33
 */

public class Q3048
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        String g1 = br.readLine();
        int N2 = Integer.parseInt(st.nextToken());
        String g2 = br.readLine();
        int T = Integer.parseInt(br.readLine());

        g1 = new StringBuffer(g1).reverse().toString();
        int[] g1Id = new int[N1];
        for(int i=0; i<N1; i++)
            g1Id[i] = i;

        int[] g2Id = new int[N2];
        for(int i=0; i<N2; i++)
            g2Id[i] = i + N1;

        for(int k=1; k<=T; k++)
        {
            for(int l=N1-1; l>=0; l--)
            {
                // 앞으로 이동
                if(l >= N1 - k && l < N1 + N2 - k)
                    g1Id[l]++;
            }

            for(int l=0; l<N2; l++)
            {
                if(l >= k - N1 && l < k)
                    g2Id[l]--;
            }
        }

        int i=0;
        int j=0;
        StringBuffer sb = new StringBuffer();
        while(i < N1 && j < N2)
        {
            if(g1Id[i] < g2Id[j])
                sb.append(g1.charAt(i++));
            else
                sb.append(g2.charAt(j++));
        }

        while(i < N1)
            sb.append(g1.charAt(i++));
        while(j < N2)
            sb.append(g2.charAt(j++));

        System.out.println(sb.toString());
    }
}
