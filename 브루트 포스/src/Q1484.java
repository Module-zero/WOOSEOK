import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-02
 * Time: 오후 3:50
 */

public class Q1484
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        long[] ary = new long[50001];
        for(int i=1; i<=50000; i++)
            ary[i] = (long)i*i;

        int rem = 1;
        int cur = 2;
        StringBuffer sb = new StringBuffer();
        while(rem < cur)
        {
            if(cur > 50000)
                break;

            long g = ary[cur] - ary[rem];

            if(g < G)
                cur++;
            else if(g == G)
            {
                sb.append(cur).append('\n');
                cur++;
            }
            else
                rem++;
        }
        if(sb.toString().equals(""))
            System.out.println(-1);
        else
            System.out.print(sb.toString());
    }
}
