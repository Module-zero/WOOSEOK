import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-03
 * Time: 오후 4:17
 */

public class Q16987
{
    static int N;
    static int[] S = new int[9];
    static int[] W = new int[9];
    static int max = 0;

    public static void foo(int index, int cnt)
    {
        if(index == N)
        {
            max = Integer.max(max, cnt);
            return;
        }

        if(S[index] <= 0 || cnt >= N-1)
        {
            foo(index+1, cnt);
            return;
        }

        for(int i=0; i<N; i++)
        {
            if(i == index)
                continue;

            if(S[i] <= 0)
                continue;

            int tcnt = cnt;
            S[index] -= W[i];
            if(S[index] <= 0)
                tcnt++;
            S[i] -= W[index];
            if(S[i] <= 0)
                tcnt++;

            foo(index+1, tcnt);

            S[index] += W[i];
            S[i] += W[index];
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        foo(0, 0);
        System.out.println(max);
    }
}
