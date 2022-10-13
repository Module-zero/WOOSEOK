import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오후 11:07
 */

public class Q11265
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[501][501];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int k=1; k<=N; k++)
        {
            for(int i=1; i<=N; i++)
            {
                for(int j=1; j<=N; j++)
                    ary[i][j] = Integer.min(ary[i][j], ary[i][k] + ary[k][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(ary[A][B] <= C)
                sb.append("Enjoy other party\n");
            else
                sb.append("Stay here\n");
        }

        System.out.print(sb.toString());
    }
}
