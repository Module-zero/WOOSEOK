import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-07-15
 * Time: 오후 4:44
 */

public class Q2290
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        char[][] chs = {{'-', ' ', '-', '-', ' ', '-', '-', '-', '-', '-'},
                        {'|', ' ', ' ', ' ', '|', '|', '|', ' ', '|', '|'},
                        {'|', '|', '|', '|', '|', ' ', ' ', '|', '|', '|'},
                        {' ', ' ', '-', '-', '-', '-', '-', ' ', '-', '-'},
                        {'|', ' ', '|', ' ', ' ', ' ', '|', ' ', '|', ' '},
                        {'|', '|', ' ', '|', '|', '|', '|', '|', '|', '|'},
                        {'-', ' ', '-', '-', ' ', '-', '-', ' ', '-', '-'}};

        int len = n.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<7; i++)
        {
            // 가로
            if(i == 0 || i == 3 || i == 6)
            {
                for(int j=0; j<len; j++)
                {
                    int it = n.charAt(j) - '0';

                    sb.append(' ');
                    for(int k=0; k<s; k++)
                        sb.append(chs[i][it]);
                    sb.append("  ");
                }

                sb.append('\n');
            }
            // 세로
            else if(i == 1)
            {
                for(int kk=0; kk<s; kk++)
                {
                    for(int j=0; j<len; j++)
                    {
                        int it = n.charAt(j) - '0';
                        sb.append(chs[1][it]);
                        for(int k=0; k<s; k++)
                            sb.append(' ');
                        sb.append(chs[2][it]);
                        sb.append(' ');
                    }
                    sb.append(" \n");
                }

                i++;
            }
            else
            {
                for(int kk=0; kk<s; kk++)
                {
                    for(int j=0; j<len; j++)
                    {
                        int it = n.charAt(j) - '0';
                        sb.append(chs[4][it]);
                        for (int k = 0; k < s; k++)
                            sb.append(' ');
                        sb.append(chs[5][it]);
                        sb.append(' ');
                    }

                    sb.append(" \n");
                }

                i++;
            }
        }

        System.out.print(sb.toString());
    }
}
