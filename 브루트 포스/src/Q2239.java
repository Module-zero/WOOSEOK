import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-13
 * Time: 오후 4:40
 */

public class Q2239
{
    static int[][] ary = new int[9][9];
    static ArrayList<int[]> list = new ArrayList<>();
    static int len;
    static boolean[][][] square = new boolean[3][3][10];
    static boolean[][] hor = new boolean[9][10];
    static boolean[][] ver = new boolean[9][10];

    public static boolean foo(int index)
    {
        if(index == len)
        {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<9; i++)
            {
                for(int j=0; j<9; j++)
                    sb.append(ary[i][j]);

                sb.append('\n');
            }

            System.out.print(sb.toString());
            return true;
        }

        int[] loc = list.get(index);
        for(int i=1; i<=9; i++)
        {
            if(hor[loc[0]][i] || ver[loc[1]][i] || square[loc[0]/3][loc[1]/3][i])
                continue;

            hor[loc[0]][i] = true;
            ver[loc[1]][i] = true;
            square[loc[0]/3][loc[1]/3][i] = true;

            ary[loc[0]][loc[1]] = i;
            if(foo(index+1))
                return true;

            ary[loc[0]][loc[1]] = 0;
            hor[loc[0]][i] = false;
            ver[loc[1]][i] = false;
            square[loc[0]/3][loc[1]/3][i] = false;
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++)
        {
            String str = br.readLine();

            for(int j=0; j<9; j++)
            {
                char ch = str.charAt(j);
                ary[i][j] = ch - '0';
                if(ary[i][j] == 0)
                    list.add(new int[]{i, j});
                else
                {
                    hor[i][ary[i][j]] = true;
                    ver[j][ary[i][j]] = true;
                    square[i/3][j/3][ary[i][j]] = true;
                }
            }
        }

        len = list.size();

        foo(0);
    }
}
