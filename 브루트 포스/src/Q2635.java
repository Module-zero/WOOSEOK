import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-15
 * Time: 오후 7:06
 */

public class Q2635
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[30001];
        ary[0] = n;
        int max = 0;
        StringBuffer ans = new StringBuffer();
        for(int i=(n+1)/2; i<=n; i++)
        {
            ary[1] = i;
            int id = 2;
            while(true)
            {
                int tmp = ary[id-2] - ary[id-1];

                // 음수가 되면 종료
                if(tmp < 0)
                    break;

                ary[id] = tmp;
                id++;
            }

            if(id > max)
            {
                max = id;
                StringBuffer sb = new StringBuffer();
                for(int j=0; j<max; j++)
                    sb.append(ary[j]).append(' ');
                ans = sb;
            }
        }
        System.out.println(max);
        System.out.println(ans.toString());
    }
}
