import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-05
 * Time: 오후 5:08
 */

public class Q17085
{
    static char[][] ary = new char[15][15];
    static int N;
    static int M;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }

        int ans = 0;
        for(int r1=0; r1<N; r1++)
        {
            for(int c1=0; c1<M; c1++)
            {
                int s1 = 0;
                while(true)
                {
                    if(r1-s1 < 0 || r1+s1 >= N)
                        break;
                    if(c1-s1 < 0 || c1+s1 >= M)
                        break;

                    if(ary[r1-s1][c1] != '#' || ary[r1+s1][c1] != '#' || ary[r1][c1-s1] != '#' || ary[r1][c1+s1] != '#')
                        break;

                    ary[r1-s1][c1] = '*';
                    ary[r1+s1][c1] = '*';
                    ary[r1][c1+s1] = '*';
                    ary[r1][c1-s1] = '*';

                    for(int r2=r1; r2<N; r2++)
                    {
                        for(int c2=0; c2<M; c2++)
                        {
                            int s2 = 0;
                            while(true)
                            {
                                if(r2-s2 < 0 || r2+s2 >= N)
                                    break;
                                if(c2-s2 < 0 || c2+s2 >= M)
                                    break;

                                if(ary[r2-s2][c2] != '#' || ary[r2+s2][c2] != '#' || ary[r2][c2-s2] != '#' || ary[r2][c2+s2] != '#')
                                    break;

                                ans = Integer.max(ans, (4*s1 + 1) * (4*s2 + 1));
                                s2++;
                            }
                        }
                    }


                    s1++;
                }

                for(int r=r1-s1+1; r<r1+s1; r++)
                    ary[r][c1] = '#';
                for(int c=c1-s1+1; c<c1+s1; c++)
                    ary[r1][c] = '#';
            }
        }

        System.out.println(ans);
    }
}
