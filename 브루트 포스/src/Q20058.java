import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-02
 * Time: 오전 1:53
 */

public class Q20058
{
    static int[][] ary = new int[65][65];
    static int[][] tmp = new int[65][65];
    static int l;

    public static void rotate(int size, int rs, int re, int cs, int ce)
    {
        if(size == l)
        {
            for(int r=rs; r<re; r++)
            {
                for(int c=cs; c<ce; c++)
                {
                    //tmp[r][c] = ary[re - ce + c][rs + ce - 1 - r];
                    tmp[r][c] = ary[cs + re - 1 - c][ce - re + r];
                }
            }
            for(int r=rs; r<re; r++)
            {
                for(int c=cs; c<ce; c++)
                    ary[r][c] = tmp[r][c];
            }

            return;
        }

        size /= 2;
        rotate(size, rs, rs+size, cs, cs+size);
        rotate(size, rs+size, re, cs, cs+size);
        rotate(size, rs, rs+size, cs+size, ce);
        rotate(size, rs+size, re, cs+size, ce);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int lim = (int)Math.pow(2, N);
        for(int i=0; i<lim; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<lim; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] L = new int[1001];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++)
            L[i] = Integer.parseInt(st.nextToken());

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int[][] map = new int[65][65];
        for(int i=0; i<Q; i++)
        {
            l = (int)Math.pow(2, L[i]);
            rotate(lim, 0, lim, 0, lim);

            for(int r=0; r<lim; r++)
            {
                for(int c=0; c<lim; c++)
                {
                    if(ary[r][c] == 0)
                        continue;

                    int cnt = 0;
                    for(int k=0; k<4; k++)
                    {
                        int newR = r + dr[k];
                        if(newR < 0 || newR >= lim)
                            continue;
                        int newC = c + dc[k];
                        if(newC < 0 || newC >= lim)
                            continue;

                        if(ary[newR][newC] > 0)
                            cnt++;
                    }

                    map[r][c] = cnt;
                }
            }

            for(int r=0; r<lim; r++)
            {
                for(int c=0; c<lim; c++)
                {
                    if(ary[r][c] == 0)
                        continue;

                    if(map[r][c] < 3)
                        ary[r][c]--;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[65][65];
        int ans = 0;
        for(int r=0; r<lim; r++)
        {
            for(int c=0; c<lim; c++)
            {
                if(ary[r][c] == 0)
                    continue;

                sum += ary[r][c];
                if(check[r][c])
                    continue;

                check[r][c] = true;
                int cnt = 1;
                queue.add(new int[]{r, c});
                while(!queue.isEmpty())
                {
                    int[] q = queue.poll();
                    for(int k=0; k<4; k++)
                    {
                        int newR = q[0] + dr[k];
                        if(newR < 0 || newR >= lim)
                            continue;

                        int newC = q[1] + dc[k];
                        if(newC < 0 || newC >= lim)
                            continue;

                        if(check[newR][newC])
                            continue;
                        if(ary[newR][newC] == 0)
                            continue;

                        check[newR][newC] = true;
                        cnt++;
                        queue.add(new int[]{newR, newC});
                    }
                }

                ans = Integer.max(ans, cnt);
            }
        }

        System.out.println(sum);
        System.out.println(ans);
    }
}
