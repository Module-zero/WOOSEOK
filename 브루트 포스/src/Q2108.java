/*
통계학

https://www.acmicpc.net/problem/2108
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 4:15
 */

public class Q2108
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int[] cnt = new int[8001];
        int[] ary = new int[500001];
        ArrayList<Integer> list = new ArrayList<>();
        int listCnt = 0;
        int sum = 0;
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(br.readLine());
            if(ary[i] > max)
                max = ary[i];
            if(ary[i] < min)
                min = ary[i];

            sum += ary[i];
            cnt[ary[i]+4000]++;

            if(cnt[ary[i]+4000] > listCnt)
            {
                listCnt = cnt[ary[i]+4000];
                list = new ArrayList<>();
                list.add(ary[i]);
            }
            else if(cnt[ary[i]+4000] == listCnt)
                list.add(ary[i]);
        }

        Arrays.sort(ary, 0, N);
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        int ref = (list.size() >= 2) ? list.get(1) : list.get(0);
        double avg = Math.round((double)sum/N);

        sb.append((int)avg).append('\n').append(ary[N/2]).append('\n').append(ref).append('\n').append(max-min);
        System.out.println(sb.toString());
    }
}
