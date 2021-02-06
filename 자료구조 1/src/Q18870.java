/*
좌표 압축

https://www.acmicpc.net/problem/18870
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-06
 * Time: 오전 12:28
 */

public class Q18870
{
    static class Temp implements Comparable<Temp>
    {
        int id;
        int value;

        public Temp(int id, int value)
        {
            this.id = id;
            this.value = value;
        }

        @Override
        public int compareTo(Temp o)
        {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        Temp[] ary = new Temp[1000001];
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());

            ary[i] = new Temp(i, num);
            set.add(num);
        }

        Arrays.sort(ary, 0, N, Collections.reverseOrder());
        int[] cnt = new int[1000001];
        int si = 0;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext())
        {
            int num = it.next();
            it.remove();

            int size = set.size();
            while(si < N && num == ary[si].value)
            {
                cnt[ary[si].id] = size;
                si++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
            sb.append(cnt[i]).append(' ');

        System.out.println(sb.toString());
        br.close();
    }
}
