import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-19
 * Time: 오전 11:40
 */

public class Q2469
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int[] bu = new int[27];
        for(int i=0; i<k; i++)
        {
            int num = str.charAt(i) - 'A';
            bu[i] = num;
        }

        int qm = 0;
        char[][] ary = new char[1001][27];
        for(int i=0; i<n; i++)
        {
            String line = br.readLine();
            for(int j=0; j<k-1; j++)
            {
                ary[i][j] = line.charAt(j);
                if(ary[i][j] == '?')
                    qm = i;
            }
        }

        int[] td = new int[27];
        for(int i=0; i<k; i++)
            td[i] = i;

        for(int i=0; i<qm; i++)
        {
            for(int j=0; j<k-1; j++)
            {
                if(ary[i][j] == '-')
                {
                    int tmp = td[j+1];
                    td[j+1] = td[j];
                    td[j] = tmp;
                }
            }
        }

        for(int i=n-1; i>qm; i--)
        {
            for(int j=0; j<k-1; j++)
            {
                if(ary[i][j] == '-')
                {
                    int tmp = bu[j+1];
                    bu[j+1] = bu[j];
                    bu[j] = tmp;
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        boolean[] check = new boolean[27];
        for(int i=0; i<k-1; i++)
        {
            if(check[i] || td[i] == bu[i])
                sb.append('*');
            else
            {
                if(td[i] == bu[i+1] && td[i+1] == bu[i])
                {
                    sb.append('-');
                    check[i+1] = true;
                }
                else
                {
                    sb = new StringBuffer();
                    for(int j=0; j<k-1; j++)
                        sb.append('x');

                    System.out.println(sb.toString());
                    return;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
