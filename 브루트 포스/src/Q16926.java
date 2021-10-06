import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-15
 * Time: 오후 4:33
 */

public class Q16926
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] A = new int[300][300];
        int[][] B = new int[300][300];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
            {
                A[i][j] = Integer.parseInt(st.nextToken());
                B[i][j] = A[i][j];
            }
        }

        while(R-- > 0)
        {
            int lim = Math.min(N, M)/2;

            for(int n=0; n<lim; n++)
            {
                int tmp = A[n][n];

                for(int i=n; i<M-n-1; i++)
                    A[n][i] = A[n][i+1];

                for(int i=n; i<N-n-1; i++)
                    A[i][M-n-1] = A[i+1][M-n-1];

                for(int i=M-n-1; i>n; i--)
                    A[N-n-1][i] = A[N-n-1][i-1];

                for(int i=N-n-1; i>n; i--)
                    A[i][n] = A[i-1][n];

                A[n+1][n] = tmp;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                sb.append(A[i][j]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
