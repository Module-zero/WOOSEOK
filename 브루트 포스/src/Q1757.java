import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1757
{
    public static void foo(int N, int M, int[] ary)
    {
        int[][] dp = new int[10001][501];
        for(int i=1; i<=N; i++)
        {
            dp[i][0] = dp[i-1][0];
            for(int j=1; j<=i && j<=M; j++)
            {
                dp[i][0] = Integer.max(dp[i][0], dp[i-j][j]);
                dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j - 1] + ary[i]);
            }
        }

        int ans = 0;
        for(int i=0; i<=M && i<=N; i++)
            ans = Integer.max(ans, dp[N-i][i]);

        for(int i=0; i<=M; i++)
        {
            for(int j=1; j<=N; j++)
                System.out.print(dp[j][i] + " ");
            System.out.println();
        }
        System.out.println("foo : " + ans);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ary = new int[10001];
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][501];
        for(int i=1; i<=N; i++)
        {
            dp[i][0] = dp[i-1][0];

            for(int j=1; j<=M && j<=i; j++)
            {
                dp[i][0] = Integer.max(dp[i][0], dp[i-j][j]);
                dp[i][j] = dp[i-1][j-1] + ary[i];
            }
        }

        foo(N, M, ary);

        System.out.println();
        for(int i=0; i<=M; i++)
        {
            for(int j=1; j<=N; j++)
                System.out.print(dp[j][i] + " ");
            System.out.println();
        }
        System.out.println(dp[N][0]);
    }
}
