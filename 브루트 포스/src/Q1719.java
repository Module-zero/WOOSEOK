import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-26
 * Time: 오후 8:37
 */

public class Q1719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] tmp = new int[201][201];
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
                tmp[i][j] = 200000;
        }

        int[][] ary = new int[201][201];
        for(int i=0; i<m; i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            tmp[a][b] = num;
            tmp[b][a] = num;
            ary[a][b] = b;
            ary[b][a] = a;
        }

        for(int k=1; k<=n; k++)
        {
            for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=n; j++)
                {
                    int num = tmp[i][k] + tmp[k][j];
                    if(num < tmp[i][j])
                    {
                        int t = k;
                        while(t != ary[i][t])
                            t = ary[i][t];

                        ary[i][j] = t;
                        tmp[i][j] = num;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(i == j)
                    sb.append('-');
                else
                    sb.append(ary[i][j]);
                sb.append(' ');
            }

            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
