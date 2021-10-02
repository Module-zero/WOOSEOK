import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 2:38
 */

public class Q21314
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuffer max = new StringBuffer();
        StringBuffer min = new StringBuffer();
        int len = str.length();
        int mcnt = 0;
        StringBuffer maxn = new StringBuffer();
        StringBuffer minn = new StringBuffer();
        for(int i=0; i<len; i++)
        {
            if(str.charAt(i) == 'M')
                mcnt++;
            else
            {
                maxn.append(5);
                for(int j=0; j<mcnt; j++)
                {
                    maxn.append(0);
                    if(j == 0)
                        minn.append(1);
                    else
                        minn.append(0);
                }

                minn.append(5);
                max.append(maxn);
                min.append(minn);
                mcnt = 0;
                maxn = new StringBuffer();
                minn = new StringBuffer();
            }
        }

        if(mcnt > 0)
        {
            for(int i=0; i<mcnt; i++)
            {
                max.append(1);
                if(i == 0)
                    min.append(1);
                else
                    min.append(0);
            }
        }

        System.out.println(max.toString());
        System.out.println(min.toString());
    }
}
