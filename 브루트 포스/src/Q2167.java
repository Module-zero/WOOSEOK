import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-08
 * Time: 오후 4:00
 */

public class Q2167
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[301][301];
        int[][] sum = new int[301][301];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=M; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = ary[i][j] + sum[i][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        while(K-- > 0)
        {
            int ans = 0;

            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int k=i; k<=x; k++)
                ans += sum[k][y] - sum[k][j - 1];

            System.out.println(ans);
        }
    }
}
