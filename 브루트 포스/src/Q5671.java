import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 2:29
 */

public class Q5671
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ary = new int[5001];
        for(int i=1; i<=5000; i++)
        {
            int tmp = i;
            boolean[] b = new boolean[10];
            boolean isOk = true;
            while(tmp > 0)
            {
                int r = tmp % 10;
                if(b[r])
                {
                    isOk = false;
                    break;
                }

                b[r] = true;
                tmp /= 10;
            }

            if(isOk)
                ary[i]++;

            ary[i] += ary[i-1];
        }

        StringBuffer sb = new StringBuffer();
        while(true)
        {
            String str = br.readLine();
            if(str == null)
                break;

            StringTokenizer st = new StringTokenizer(str);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(ary[M] - ary[N-1]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
