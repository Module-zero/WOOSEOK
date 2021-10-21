import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-21
 * Time: 오후 3:53
 */

public class Q1956
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] d = new int[401][401];
        int num = 99999999;
        for(int i=1; i<=V; i++)
        {
            for(int j=1; j<=V; j++)
                d[i][j] = num;
        }

        int[][] ary = new int[401][401];
        for(int i=0; i<E; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = c;
        }

        for(int i=1; i<=V; i++)
        {
            for(int j=1; j<=V; j++)
            {
                for(int k=1; k<=V; k++)
                {
                    if(d[j][i] != num && d[i][k] != num)
                        d[j][k] = Integer.min(d[j][k], d[j][i] + d[i][k]);
                }
            }
        }

        int ans = num;
        for(int i=1; i<=V; i++)
            ans = Integer.min(ans, d[i][i]);

        if(ans == num)
            ans = -1;

        System.out.println(ans);
    }
}
