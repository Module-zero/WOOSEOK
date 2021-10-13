import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-13
 * Time: 오후 4:29
 */

public class Q19949
{
    static int[] ary = new int[11];
    static int[] ans = new int[11];
    static int cnt;

    public static void foo(int index, int prev, int pprev, int sum)
    {
        if(index == 10)
        {
            if(sum >= 5)
                cnt++;
            return;
        }

        for(int i=1; i<=5; i++)
        {
            if(i == prev && i == pprev)
                continue;

            ary[index] = i;
            if(ary[index] == ans[index])
                foo(index+1, i, prev, sum+1);
            else
                foo(index+1, i, prev, sum);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<10; i++)
            ans[i] = Integer.parseInt(st.nextToken());

        foo(0, 0, 0, 0);

        System.out.println(cnt);
    }
}
