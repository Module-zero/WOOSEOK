import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-16
 * Time: 오후 2:21
 */

public class Q18429
{
    static int N;
    static int K;
    static int[] A = new int[9];
    static boolean[] check = new boolean[9];
    static int ans = 0;

    public static void foo(int index, int weight)
    {
        if(index == N)
        {
            ans++;
            return;
        }

        for(int i=0; i<N; i++)
        {
            if(check[i])
                continue;

            int sum = weight + A[i] - K;
            if(sum < 500)
                continue;

            check[i] = true;
            foo(index+1, sum);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        foo(0, 500);

        System.out.println(ans);
    }
}
