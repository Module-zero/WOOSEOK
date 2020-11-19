import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-19
 * Time: 오후 11:19
 */

public class Main
{
    static int N;
    static int[] ary = new int[100001];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        for(int d1 = -1; d1 <= 1; d1++)
        {
            for(int d2 = -1; d2 <= 1; d2++)
            {
                int cnt = 0;

                if(d1 != 0)
                    cnt++;
                if(d2 != 0)
                    cnt++;

                int a = ary[0] + d1;
                int diff = (ary[1] + d2) - a;

                int an = a + diff;
                for(int i=2; i<N; i++)
                {
                    an += diff;

                    if(an == ary[i])
                        continue;

                    if(an == ary[i]+1)
                        cnt++;
                    else if(an == ary[i]-1)
                        cnt++;
                    else
                    {
                        cnt = Integer.MAX_VALUE;
                        break;
                    }
                }

                if(cnt < min)
                    min = cnt;
            }
        }

        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }
}
