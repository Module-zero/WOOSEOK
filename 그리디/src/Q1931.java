/*
회의실배정

https://www.acmicpc.net/problem/1931
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-01
 * Time: 오후 4:02
 */

public class Q1931
{
    static class Semina implements Comparable<Semina>
    {
        int sTime;
        int fTime;

        public Semina(int sTime, int fTime)
        {
            this.sTime = sTime;
            this.fTime = fTime;
        }

        @Override
        public int compareTo(Semina o)
        {
            if(fTime > o.fTime)
                return 1;
            else if(fTime == o.fTime)
            {
                if(sTime == o.sTime)
                    return 0;
                else if(sTime > o.sTime)
                    return 1;
                else
                    return -1;
            }
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Semina[] ary = new Semina[100000];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary[i] = new Semina(a, b);
        }

        Arrays.sort(ary, 0, N);

        int cnt = 0;
        int time = 0;
        for(int i=0; i<N; i++)
        {
            if(ary[i].sTime >= time)
            {
                time = ary[i].fTime;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
