import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 3:37
 */

public class Q2740
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] A = new int[100][100];
        int[][] B = new int[100][100];
        int[][] C = new int[100][100];
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<K; j++)
                B[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<K; j++)
            {
                for(int k=0; k<M; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<K; j++)
                sb.append(C[i][j]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
