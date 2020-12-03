/*
새로운 하노이 탑

https://www.acmicpc.net/problem/12906
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-17
 * Time: 오후 4:38
 */

public class Q12906
{
    static class Hanoy implements Comparable<Hanoy>
    {
        String A;
        String B;
        String C;
        int cnt;

        public Hanoy(String A, String B, String C, int cnt)
        {
            this.A = A;
            this.B = B;
            this.C = C;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Hanoy o)
        {
            if(A.equals(o.A))
            {
                if(B.equals(o.B))
                {
                    if(C.equals(o.C))
                        return 0;
                    else
                        return C.compareTo(o.C);
                }
                else
                    return B.compareTo(o.B);
            }
            else
                return A.compareTo(o.A);
        }
    }

    public static boolean check(Hanoy h)
    {
        for(int i=0; i<h.A.length(); i++)
        {
            if(h.A.charAt(i) != 'A')
                return false;
        }

        for(int i=0; i<h.B.length(); i++)
        {
            if(h.B.charAt(i) != 'B')
                return false;
        }

        for(int i=0; i<h.C.length(); i++)
        {
            if(h.C.charAt(i) != 'C')
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] state = new String[3];
        for(int i=0; i<3; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) > 0)
                state[i] = st.nextToken();
            else
                state[i] = "";
        }

        Hanoy hanoy = new Hanoy(state[0], state[1], state[2], 0);
        if(check(hanoy))
        {
            System.out.println(0);
            return;
        }

        Queue<Hanoy> queue = new LinkedList<>();
        queue.add(hanoy);

        TreeSet<Hanoy> set = new TreeSet<>();
        set.add(hanoy);

        while(!queue.isEmpty())
        {
            Hanoy tmp = queue.poll();
            if(check(tmp))
            {
                System.out.println(tmp.cnt);
                return;
            }

            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    String[] str = {tmp.A, tmp.B, tmp.C};

                    if(i == j || str[i].length() == 0)
                        continue;

                    // 맨 위의 원판을 집는다.
                    char ch = str[i].charAt(str[i].length()-1);
                    // 다른 탑으로 옮긴다.
                    StringBuilder sb = new StringBuilder(str[j]).append(ch);
                    str[j] = sb.toString();
                    str[i] = str[i].substring(0, str[i].length()-1);

                    Hanoy newHanoy = new Hanoy(str[0], str[1], str[2], tmp.cnt + 1);

                    // 원래 존재했다면 false
                    if(set.add(newHanoy))
                        queue.add(newHanoy);
                }
            }
        }
    }
}
