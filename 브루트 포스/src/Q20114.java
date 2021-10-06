import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 4:52
 */

public class Q20114
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[] ary = new char[100];
        while(H-- > 0)
        {
            String str = br.readLine();

            for(int i=0; i<W*N; i+=W)
            {
                for(int j=i; j<i+W; j++)
                {
                    char ch = str.charAt(j);
                    if(ch == '?')
                        continue;
                    else
                        ary[j/W] = ch;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            if(ary[i] == '\0')
                ary[i] = '?';

            sb.append(ary[i]);
        }

        System.out.println(sb.toString());
    }
}
