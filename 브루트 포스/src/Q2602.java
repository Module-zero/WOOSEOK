import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-06
 * Time: 오후 5:18
 */

public class Q2602
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] ary = str.toCharArray();
        int ilen = str.length();

        String[] sstr = new String[2];
        char[][] cary = new char[2][];
        sstr[0] = br.readLine();
        cary[0] = sstr[0].toCharArray();
        sstr[1] = br.readLine();
        cary[1] = sstr[1].toCharArray();

        int len = sstr[0].length();

        int[][][] dp = new int[21][2][101];
        for(int i=0; i<ilen; i++)
        {
            boolean isOk = false;

            for(int j=0; j<2; j++)
            {
                for(int k=0; k<len; k++)
                {
                    if(cary[j][k] != ary[i])
                        continue;

                    if(i == 0)
                    {
                        dp[i][j][k]++;
                        isOk = true;
                        continue;
                    }

                    for(int l=0; l<k; l++)
                    {
                        dp[i][j][k] += dp[i - 1][1 - j][l];
                        if(dp[i][j][k] > 0)
                            isOk = true;
                    }
                }
            }

            if(!isOk)
            {
                System.out.println(0);
                return;
            }
        }

        int ans = 0;
        for(int i=0; i<2; i++)
        {
            for(int j=0; j<len; j++)
                ans += dp[ilen-1][i][j];
        }

        System.out.println(ans);
    }
}
