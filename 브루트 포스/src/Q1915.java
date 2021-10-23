import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-23
 * Time: 오후 1:52
 */

public class Q1915
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] ary = new int[1001][1001];
        for(int i=1; i<=n; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=m; j++)
                ary[i][j] = str.charAt(j-1) - '0';
        }

        int ans = 0;

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(ary[i][j] == 1)
                {
                    ary[i][j] = Integer.min(Integer.min(ary[i - 1][j], ary[i][j - 1]), ary[i - 1][j - 1]) + 1;
                    ans = Integer.max(ary[i][j], ans);
                }
            }
        }

        System.out.println(ans*ans);
    }
}
