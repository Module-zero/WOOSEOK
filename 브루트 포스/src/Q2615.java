import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오후 10:55
 */

public class Q2615
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] ary = new int[19][19];
        for(int i=0; i<19; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<19; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<19; i++)
        {
            for(int j=0; j<19; j++)
            {
                if(ary[i][j] != 0)
                {
                    int stone = ary[i][j];

                    boolean isOk = false;
                    if(i + 4 < 19)
                    {
                        if(ary[i+1][j] == stone && ary[i+2][j] == stone && ary[i+3][j] == stone && ary[i+4][j] == stone)
                            isOk = true;

                        if(i + 5 < 19 && ary[i+5][j] == stone)
                            isOk = false;

                        if(i - 1 >= 0 && ary[i-1][j] == stone)
                            isOk = false;
                    }

                    if(isOk)
                    {
                        sb.append(ary[i][j]).append('\n').append(i+1).append(' ').append(j+1).append('\n');
                        System.out.print(sb.toString());
                        return;
                    }

                    if(j + 4 < 19)
                    {
                        if(ary[i][j+1] == stone && ary[i][j+2] == stone && ary[i][j+3] == stone && ary[i][j+4] == stone)
                            isOk = true;

                        if(j + 5 < 19 && ary[i][j+5] == stone)
                            isOk = false;

                        if(j - 1 >= 0 && ary[i][j-1] == stone)
                            isOk = false;
                    }

                    if(isOk)
                    {
                        sb.append(ary[i][j]).append('\n').append(i+1).append(' ').append(j+1).append('\n');
                        System.out.print(sb.toString());
                        return;
                    }

                    if(i + 4 < 19 && j + 4 < 19)
                    {
                        if(ary[i+1][j+1] == stone && ary[i+2][j+2] == stone && ary[i+3][j+3] == stone && ary[i+4][j+4] == stone)
                            isOk = true;

                        if(i + 5 < 19 && j + 5 < 19 && ary[i+5][j+5] == stone)
                            isOk = false;

                        if(i - 1 >= 0 && j - 1 >= 0 && ary[i-1][j-1] == stone)
                            isOk = false;
                    }

                    if(isOk)
                    {
                        sb.append(ary[i][j]).append('\n').append(i+1).append(' ').append(j+1).append('\n');
                        System.out.print(sb.toString());
                        return;
                    }

                    if(i - 4 >= 0 && j + 4 < 19)
                    {
                        if(ary[i-1][j+1] == stone && ary[i-2][j+2] == stone && ary[i-3][j+3] == stone && ary[i-4][j+4] == stone)
                            isOk = true;

                        if(i - 5 >= 0 && j + 5 < 19 && ary[i-5][j+5] == stone)
                            isOk = false;

                        if(i + 1 < 19 && j - 1 >= 0 && ary[i+1][j-1] == stone)
                            isOk = false;
                    }

                    if(isOk)
                    {
                        sb.append(ary[i][j]).append('\n').append(i+1).append(' ').append(j+1).append('\n');
                        System.out.print(sb.toString());
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}
