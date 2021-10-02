import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-15
 * Time: 오후 7:54
 */

public class Q14620
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[10][10];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-2, -1, -1, -1, 0, 0, 0, 0, 1, 1, 1, 2};
        int[] dc = {0, -1, 0, 1, -2, -1, 1, 2, -1, 0, 1, 0};
        int[] ddr = {-1, 0, 0, 0, 1};
        int[] ddc = {0, -1, 0, 1, 0};

        int min = Integer.MAX_VALUE;
        for(int r1=1; r1<N-1; r1++)
        {
            for(int c1=1; c1<N-1; c1++)
            {
                for(int r2=1; r2<N-1; r2++)
                {
                    for(int c2=1; c2<N-1; c2++)
                    {
                        if(r1 == r2 && c1 == c2)
                            continue;

                        boolean flag = false;
                        for(int i=0; i<12; i++)
                        {
                            int newR2 = r2 + dr[i];
                            if(newR2 < 0 || newR2 >= N)
                                continue;
                            int newC2 = c2 + dc[i];
                            if(newC2 < 0 || newC2 >= N)
                                continue;

                            if(newR2 == r1 && newC2 == c1)
                            {
                                flag = true;
                                break;
                            }
                        }

                        if(flag)
                            continue;

                        for(int r3=1; r3<N-1; r3++)
                        {
                            for(int c3=1; c3<N-1; c3++)
                            {
                                if(r1 == r3 && c1 == c3)
                                    continue;
                                if(r2 == r3 && c2 == c3)
                                    continue;

                                boolean flag2 = false;
                                for(int i=0; i<12; i++)
                                {
                                    int newR3 = r3 + dr[i];
                                    if(newR3 < 0 || newR3 >= N)
                                        continue;
                                    int newC3 = c3 + dc[i];
                                    if(newC3 < 0 || newC3 >= N)
                                        continue;

                                    if(newR3 == r1 && newC3 == c1)
                                    {
                                        flag2 = true;
                                        break;
                                    }
                                    if(newR3 == r2 && newC3 == c2)
                                    {
                                        flag2 = true;
                                        break;
                                    }
                                }

                                if(flag2)
                                    continue;

                                int ans = 0;
                                for(int i=0; i<5; i++)
                                {
                                    int newR1 = r1 + ddr[i];
                                    int newC1 = c1 + ddc[i];

                                    ans += ary[newR1][newC1];
                                }
                                for(int i=0; i<5; i++)
                                {
                                    int newR2 = r2 + ddr[i];
                                    int newC2 = c2 + ddc[i];

                                    ans += ary[newR2][newC2];
                                }
                                for(int i=0; i<5; i++)
                                {
                                    int newR3 = r3 + ddr[i];
                                    int newC3 = c3 + ddc[i];

                                    ans += ary[newR3][newC3];
                                }
                                if(ans < min)
                                    min = ans;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(min);
    }
}
