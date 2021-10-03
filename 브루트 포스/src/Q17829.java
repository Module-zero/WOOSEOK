import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-02
 * Time: 오후 11:32
 */

public class Q17829
{
    static int[][] ary = new int[1025][1025];

    public static void foo(int r, int c)
    {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i=0; i<=1; i++)
        {
            for(int j=0; j<=1; j++)
            {
                if(max <= ary[r+i][c+j])
                {
                    second = max;
                    max = ary[r+i][c+j];
                }
                else
                {
                    if(second <= ary[r+i][c+j])
                        second = ary[r+i][c+j];
                }
            }
        }

        ary[r/2][c/2] = second;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        while(N > 1)
        {
            for(int i=0; i<N; i+=2)
            {
                for(int j=0; j<N; j+=2)
                    foo(i, j);
            }

            N /= 2;
        }

        System.out.println(ary[0][0]);
    }
}
