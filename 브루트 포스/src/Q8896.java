/*
가위 바위 보

https://www.acmicpc.net/problem/8896
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-30
 * Time: 오후 10:13
 */

public class Q8896
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());

            char[][] ary = new char[11][31];

            int k=0;
            for(int i=0; i<N; i++)
            {
                String str = br.readLine();
                k = str.length();

                for(int j=0; j<k; j++)
                    ary[i][j] = str.charAt(j);
            }

            // 탈락한 로봇
            boolean[] fail = new boolean[31];
            // 탈락하지 않은 수
            int alive = N;

            for(int round=0; round<k; round++)
            {
                if(alive == 1)
                    break;

                ArrayList<Integer> r = new ArrayList<>();
                ArrayList<Integer> s = new ArrayList<>();
                ArrayList<Integer> p = new ArrayList<>();

                for(int robot=0; robot<N; robot++)
                {
                    if(fail[robot])
                        continue;

                    switch(ary[robot][round])
                    {
                        case 'R':
                            r.add(robot);
                            break;
                        case 'S':
                            s.add(robot);
                            break;
                        case 'P':
                            p.add(robot);
                            break;
                    }
                }

                if(r.size() > 0 && s.size() > 0 && p.size() > 0)
                    continue;
                else if(r.size() > 0 && s.size() > 0)
                {
                    for(int i : s)
                    {
                        fail[i] = true;
                        alive--;
                    }
                }
                else if(r.size() > 0 && p.size() > 0)
                {
                    for(int i : r)
                    {
                        fail[i] = true;
                        alive--;
                    }
                }
                else if(s.size() > 0 && p.size() > 0)
                {
                    for(int i : p)
                    {
                        fail[i] = true;
                        alive--;
                    }
                }
            }

            if(alive > 1)
                sb.append(0).append('\n');
            else
            {
                for(int i=0; i<N; i++)
                {
                    if(!fail[i])
                    {
                        sb.append(i+1).append('\n');
                        break;
                    }
                }
            }
        }

        System.out.print(sb.toString());
    }
}
