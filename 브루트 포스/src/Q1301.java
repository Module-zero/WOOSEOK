import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-04
 * Time: 오후 8:53
 */

public class Q1301
{
    static int N;
    static int[] ary = new int[6];
    static long[][][][][][][] dp = new long[11][11][11][11][11][6][6];
    static int sum = 0;

    public static long foo(int prev, int pprev, int cnt)
    {
        if(cnt == sum)
            return 1;

        long ret = dp[ary[0]][ary[1]][ary[2]][ary[3]][ary[4]][prev][pprev];
        if(ret != -1)
            return ret;

        ret = 0;

        for(int i=1; i<=N; i++)
        {
            if(prev == i || pprev == i || ary[i] == 0)
                continue;

            ary[i]--;
            ret += foo(i, prev, cnt+1);
            ary[i]++;
        }

        dp[ary[0]][ary[1]][ary[2]][ary[3]][ary[4]][prev][pprev] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++)
        {
            ary[i] = Integer.parseInt(br.readLine());
            sum += ary[i];
        }

        for(int i=0; i<=ary[0]; i++)
        {
            for(int j=0; j<=ary[1]; j++)
            {
                for(int k=0; k<=ary[2]; k++)
                {
                    for(int l=0; l<=ary[3]; l++)
                    {
                        for(int m=0; m<=ary[4]; m++)
                        {
                            for(int n=0; n<=N; n++)
                            {
                                for(int o=0; o<=N; o++)
                                    dp[i][j][k][l][m][n][o] = -1;
                            }
                        }
                    }
                }

            }
        }

        System.out.println(foo(0, 0, 0));
    }
}
