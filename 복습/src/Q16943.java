import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-28
 * Time: 오후 1:03
 */

public class Q16943
{
    static char[] A;
    static int B;
    static boolean[] check = new boolean[9];
    static int len;
    static int ans = -1;

    public static void foo(int id, int n)
    {
        if(id == len)
        {
            if(n >= B)
                return;

            ans = Integer.max(ans, n);
            return;
        }

        for(int i=0; i<len; i++)
        {
            if(check[i])
                continue;

            if(n == 0 && A[i] == '0')
                continue;

            check[i] = true;
            foo(id + 1, n*10 + A[i] - '0');
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());
        len = A.length;

        foo(0, 0);
        System.out.println(ans);
    }
}
