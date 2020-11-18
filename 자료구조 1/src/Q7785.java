/*
회사에 있는 사람

https://www.acmicpc.net/problem/7785
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-18
 * Time: 오후 5:44
 */

public class Q7785
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new TreeSet<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String person = st.nextToken();
            String state = st.nextToken();

            switch(state)
            {
                case "enter":
                    set.add(person);
                    break;
                case "leave":
                    set.remove(person);
                    break;
            }
        }
    }
}
