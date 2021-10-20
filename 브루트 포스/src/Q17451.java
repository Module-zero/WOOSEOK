import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-20
 * Time: 오후 12:57
 */

public class Q17451
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] v = new long[300001];
        for(int i=0; i<n; i++)
            v[i] = Integer.parseInt(st.nextToken());

        long ans = v[n-1];
        for(int i=n-2; i>=0; i--)
            ans = v[i] * (long)Math.ceil((double)ans/v[i]);

        System.out.println(ans);
    }
}
