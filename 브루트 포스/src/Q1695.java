import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-29
 * Time: 오후 10:50
 */

public class Q1695
{
    static int[] ary = new int[5001];
    static int[][] dp = new int[5001][5001];

    public static int foo(int start, int end)
    {
        if(start >= end)
            return dp[start][end] = 0;

        if(dp[start][end] != -1)
            return dp[start][end];

        if(ary[start] == ary[end])
            return dp[start][end] = foo(start + 1, end - 1);
        else
            return dp[start][end] = Integer.min(foo(start+1, end), foo(start, end-1)) + 1;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                dp[i][j] = -1;
        }

        System.out.println(foo(0, N-1));
    }
}
