import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-19
 * Time: 오후 12:17
 */

public class Q20168
{
    static int N;
    static int M;
    static int A;
    static int B;
    static int C;
    static int[][] ary = new int[11][11];
    static int ans = 10000;
    static boolean check[] = new boolean[11];

    public static void foo(int index, int rem, int max)
    {
        if(rem < 0)
            return;

        if(index == B)
        {
            ans = Integer.min(ans, max);
            return;
        }

        for(int i=1; i<=N; i++)
        {
            if(check[i])
                continue;

            if(ary[index][i] == 0)
                continue;

            check[i] = true;
            foo(i, rem - ary[index][i], Integer.max(max, ary[index][i]));
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ary[a][b] = c;
            ary[b][a] = c;
        }

        check[A] = true;
        foo(A, C, 0);

        if(ans == 10000)
            ans = -1;

        System.out.println(ans);
    }
}
