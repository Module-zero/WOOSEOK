import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-30
 * Time: 오후 6:44
 */

public class Q1577
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        boolean[][][] work = new boolean[101][101][4];
        int[] dr = {0, 1};
        int[] dc = {1, 0};
        while(K-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(c < a || d < b)
            {
                int t1 = c, t2 = d;
                c = a;
                d = b;
                a = t1;
                b = t2;
            }

            for(int i=0; i<2; i++)
            {
                int newR = b + dr[i];
                if(newR < 0 || newR > M)
                    continue;

                int newC = a + dc[i];
                if(newC < 0 || newC > N)
                    continue;

                if(newR != d || newC != c)
                    continue;

                work[b][a][i] = true;
                break;
            }
        }

        long[][] dp = new long[101][101];
        dp[0][0] = 1;
        for(int i=0; i<=M; i++)
        {
            for(int j=0; j<=N; j++)
            {
                if(i == 0 && j == 0)
                    continue;

                if(i-1 >= 0 && !work[i-1][j][1])
                    dp[i][j] += dp[i-1][j];
                if(j-1 >= 0 && !work[i][j-1][0])
                    dp[i][j] += dp[i][j-1];
            }
        }

        System.out.println(dp[M][N]);
    }
}
