import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-08
 * Time: 오후 4:44
 */

public class Q10798
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] ary = new char[5][15];
        for(int i=0; i<5; i++)
        {
            String str = br.readLine();
            int len = str.length();
            for(int j=0; j<len; j++)
                ary[i][j] = str.charAt(j);
            for(int j=len; j<15; j++)
                ary[i][j] = ' ';
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<5; j++)
            {
                if(ary[j][i] == ' ')
                    continue;
                else
                    sb.append(ary[j][i]);
            }
        }

        System.out.println(sb.toString());
    }
}
