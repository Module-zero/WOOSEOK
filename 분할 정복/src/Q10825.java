/*
국영수

https://www.acmicpc.net/problem/10825
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-09
 * Time: 오후 7:46
 */

public class Q10825
{
    static Member[] members = new Member[100001];
    static Member[] tmp = new Member[100001];

    static class Member implements Comparable<Member>
    {
        String name;
        int kor;
        int eng;
        int math;

        public Member(String name, int kor, int eng, int math)
        {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Member o)
        {
            if(kor < o.kor)
                return 1;
            else if(kor == o.kor)
            {
                if(eng < o.eng)
                    return -1;
                else if(eng == o.eng)
                {
                    if(math < o.math)
                        return 1;
                    else if(math == o.math)
                        return name.compareTo(o.name);
                    else
                        return -1;
                }
                else
                    return 1;
            }
            else
                return -1;
        }
    }

    public static void sort(int start, int end)
    {
        if(start == end)
            return;

        int mid = (start + end) / 2;

        sort(start, mid);
        sort(mid + 1, end);
        merge(start, end);
    }

    public static void merge(int start, int end)
    {
        int mid = (start + end) / 2;

        int i = start;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end)
        {
            if(members[i].compareTo(members[j]) < 0)
                tmp[k++] = members[i++];
            else
                tmp[k++] = members[j++];
        }

        while(i <= mid)
            tmp[k++] = members[i++];
        while(j <= end)
            tmp[k++] = members[j++];

        for(int a=start; a<=end; a++)
            members[a] = tmp[a - start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String name;
        int kor;
        int eng;
        int math;

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            kor = Integer.parseInt(st.nextToken());
            eng = Integer.parseInt(st.nextToken());
            math = Integer.parseInt(st.nextToken());

            members[i] = new Member(name, kor, eng, math);
        }

        sort(0, N-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
            sb.append(members[i].name).append('\n');

        System.out.print(sb.toString());
    }
}
