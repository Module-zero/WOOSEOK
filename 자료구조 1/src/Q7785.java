/*
회사에 있는 사람

https://www.acmicpc.net/problem/7785
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-18
 * Time: 오후 5:44
 */

public class Q7785
{
    static class Name implements Comparable<Name>
    {
        String name;

        public Name(String name)
        {
            this.name = name;
        }

        @Override
        public int compareTo(Name name)
        {
            return -this.name.compareTo(name.name);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TreeSet<Name> set = new TreeSet<>();
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String state = st.nextToken();
            switch(state)
            {
                case "enter":
                    set.add(new Name(name));
                    break;
                case "leave":
                    set.remove(new Name(name));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Name name : set)
            sb.append(name.name).append('\n');

        System.out.print(sb.toString());
    }
}
