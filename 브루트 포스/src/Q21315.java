import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-31
 * Time: 오후 3:58
 */

public class Q21315
{
    public static void foo(int i, int k)
    {

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[1001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

    }
}
