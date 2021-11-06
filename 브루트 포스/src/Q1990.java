import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오후 4:10
 */

public class Q1990
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] notprime = new boolean[10001];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=2; i*i<=b; i++)
        {
            if(notprime[i])
                continue;

            list.add(i);
            for(int j=i+i; j*j<=b; j+=i)
                notprime[j] = true;
        }

        if(b >= 10000000)
            b = 10000000;

        for(int i=a; i<=b; i++)
        {
            String str = String.valueOf(i);
            int len = str.length();

            boolean ok = true;
            for(int j=0; j<len/2; j++)
            {
                if(str.charAt(j) != str.charAt(len-j-1))
                {
                    ok = false;
                    break;
                }
            }

            if(!ok)
                continue;

            boolean prime = true;
            for(int n : list)
            {
                if(i <= n)
                    break;

                if(i % n == 0)
                {
                    prime = false;
                    break;
                }
            }

            if(!prime)
                continue;

            sb.append(i).append('\n');
        }

        sb.append("-1\n");
        System.out.print(sb.toString());
    }
}
