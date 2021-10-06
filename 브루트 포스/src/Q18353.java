import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-03
 * Time: 오전 12:20
 */

public class Q18353
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[2001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=N; i>=1; i--)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[2001];
        int ans = 0;
        for(int i=1; i<=N; i++)
        {
            cnt[i] = 1;

            for(int j=1; j<i; j++)
            {
                if(ary[i] > ary[j])
                    cnt[i] = Integer.max(cnt[i], cnt[j] + 1);
            }

            ans = Integer.max(ans, cnt[i]);
        }

        System.out.println(N-ans);
    }
}
