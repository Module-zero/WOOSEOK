import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-19
 * Time: 오전 11:17
 */

public class Q2729
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        int[] ans = new int[82];
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            String s2 = st.nextToken();

            int id = 0;
            int i = s1.length() - 1;
            int j = s2.length() - 1;
            boolean up = false;

            while(i >= 0 && j >= 0)
            {
                int c1 = s1.charAt(i) - '0';
                int c2 = s2.charAt(j) - '0';

                c1 += c2;
                if(up)
                    c1++;

                if(c1 >= 2)
                {
                    up = true;
                    c1 -= 2;
                }
                else
                    up = false;

                ans[id++] = c1;

                i--;
                j--;
            }

            while(i >= 0)
            {
                int c = s1.charAt(i) - '0';
                if(up)
                {
                    c++;
                    if(c == 2)
                    {
                        c -= 2;
                        up = true;
                    }
                    else
                        up = false;
                }

                ans[id++] = c;
                i--;
            }

            while(j >= 0)
            {
                int c = s2.charAt(j) - '0';
                if(up)
                {
                    c++;
                    if(c == 2)
                    {
                        c -= 2;
                        up = true;
                    }
                    else
                        up = false;
                }

                ans[id++] = c;
                j--;
            }

            if(up)
                ans[id++] = 1;

            StringBuffer tmp = new StringBuffer();
            boolean ok = false;
            for(int k=id-1; k>=0; k--)
            {
                if(ans[k] == 1)
                    ok = true;

                if(ok)
                    tmp.append(ans[k]);
            }
            if(!ok)
                tmp.append(0);

            tmp.append('\n');
            sb.append(tmp);
        }

        System.out.print(sb.toString());
    }
}
