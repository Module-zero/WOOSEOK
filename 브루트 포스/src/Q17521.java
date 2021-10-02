import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-28
 * Time: 오후 10:39
 */

public class Q17521
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());

        long[] ary = new long[15];
        for(int i=0; i<n; i++)
            ary[i] = Long.parseLong(br.readLine());

        long coin = 0;
        if(ary[0] < ary[1])
        {
            coin = W / ary[0];
            W %= ary[0];
        }

        for(int i=0; i<n-1; i++)
        {
            if(ary[i] < ary[i+1])
            {
                coin += W / ary[i];
                W %= ary[i];
            }
            else
            {
                W += coin * ary[i];
                coin = 0;
            }
        }

        System.out.println(W + coin*ary[n-1]);
    }
}
