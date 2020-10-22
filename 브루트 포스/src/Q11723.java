/*
집합

https://www.acmicpc.net/problem/11723
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오후 3:56
 */

public class Q11723
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int S = 0;

        // all의 결과물을 미리 저장
        int allRes = 1;
        for(int i=1; i<20; i++)
        {
            int tmp = allRes << 1;
            allRes |= tmp;
        }

        while(M-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            // all이나 empty면
            if (str.equals("all"))
                S = allRes;
            else if(str.equals("empty"))
                S = 0;
            else
            {
                int bit = 1;

                int x = Integer.parseInt(st.nextToken());
                for (int i = 1; i < x; i++)
                    bit <<= 1;

                switch (str)
                {
                    case "add":
                    {
                        // S에 x가 없으면 추가한다.
                        if ((S & bit) == 0)
                            S |= bit;
                        // 이미 존재하면 무시

                        break;
                    }
                    case "remove":
                    {
                        // S에 x가 있으면 제거
                        if ((S & bit) != 0)
                            S ^= bit;
                        // S에 x가 이미 없으면 연산을 무시

                        break;
                    }
                    case "check":
                    {
                        // S에 x가 있으면 1을, 없으면 0을 출력한다.
                        if ((S & bit) == 0)
                            sb.append("0\n");
                        else
                            sb.append("1\n");

                        break;
                    }
                    case "toggle":
                    {
                        // S에 x가 존재하지 않으면 추가
                        if ((S & bit) == 0)
                            S |= bit;
                        // S에 x가 존재하면 제거
                        else
                            S ^= bit;

                        break;
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }
}
