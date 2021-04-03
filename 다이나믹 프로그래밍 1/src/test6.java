import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-12
 * Time: 오후 8:42
 */

public class test6
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[3001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[3001];
        int max = 1;
        for(int i=1; i<=N; i++)
        {
            ans[i] = 1;

            for(int j=1; j<i; j++)
            {
                if(P[i] > P[j])
                    ans[i] = Integer.max(ans[i], ans[j] + 1);
            }

            max = Integer.max(max, ans[i]);
        }

        System.out.println(max);
    }
}
