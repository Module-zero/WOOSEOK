/*
나이순 정렬

https://www.acmicpc.net/problem/10814
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-09
 * Time: 오후 7:32
 */

public class Q10814
{
    static Member[] members = new Member[100001];
    static Member[] tmp = new Member[100001];

    static class Member implements Comparable<Member>
    {
        int age;
        String name;
        int order;

        public Member(int age, String name, int order)
        {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public int compareTo(Member o)
        {
            if(age < o.age)
                return -1;
            else if(age == o.age)
            {
                if(order < o.order)
                    return -1;
                else if(order == o.order)
                    return 0;
                else
                    return 1;
            }
            else
                return 1;
        }
    }

    public static void sort(int start, int end)
    {
        if(start >= end)
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
            if(members[i].compareTo(members[j]) == -1)
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
        int age;
        String name;
        int order = 0;
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();

            members[i] = new Member(age, name, order++);
        }

        sort(0, N-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
            sb.append(members[i].age).append(' ').append(members[i].name).append('\n');

        System.out.print(sb.toString());
    }
}
