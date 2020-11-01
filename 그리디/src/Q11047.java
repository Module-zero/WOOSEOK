import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-01
 * Time: 오후 2:06
 */

public class Q11047
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ary = new int[10];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        for(int i=N-1; i>=0; i--)
        {
            if(K == 0)
                break;
            ans += K/ary[i];
            K %= ary[i];
        }

        System.out.println(ans);
    }
}
