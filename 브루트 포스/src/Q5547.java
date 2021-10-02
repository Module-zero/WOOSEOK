import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 11:05
 */

public class Q5547
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] dr = {-1, -1, 0, 0, 1, 1};
        int[] dc = null;
        // 짝수
        int[] dce = {-1, 0, -1, 1, -1, 0};
        // 홀수
        int[] dco = {0, 1, -1, 1, 0, 1};

        int[][] ary = new int[101][101];
        for(int i=1; i<=H; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=W; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] check = new boolean[101][101];
        Queue<int[]> queue = new LinkedList<>();
        int gCnt = 0;
        int[][] group = new int[101][101];
        for(int i=1; i<=H; i++)
        {
            for(int j=1; j<=W; j++)
            {
                if(check[i][j])
                    continue;

                check[i][j] = true;
                queue.add(new int[]{i, j});
                group[i][j] = ++gCnt;

                while(!queue.isEmpty())
                {
                    int[] tmp = queue.poll();
                    if(tmp[0] % 2 == 0)
                        dc = dce;
                    else
                        dc = dco;

                    for(int k=0; k<6; k++)
                    {
                        int newR = tmp[0] + dr[k];
                        if(newR <= 0 || newR > H)
                            continue;

                        int newC = tmp[1] + dc[k];
                        if(newC <= 0 || newC > W)
                            continue;

                        if(check[newR][newC])
                            continue;
                        if(ary[newR][newC] != ary[i][j])
                            continue;

                        check[newR][newC] = true;
                        group[newR][newC] = gCnt;
                        queue.add(new int[]{newR, newC});
                    }
                }
            }
        }

        int[][] map = new int[101][101];
        int[] maxCnt = new int[10001];
        int ans = 0;
        for(int i=1; i<=H; i++)
        {
            for(int j=1; j<=W; j++)
            {
                if(ary[i][j] == 1)
                    continue;

                if(i % 2 == 0)
                    dc = dce;
                else
                    dc = dco;

                boolean[] c = new boolean[10001];
                int cnt = 0;
                for(int k=0; k<6; k++)
                {
                    int newR = i + dr[k];
                    if(newR <= 0 || newR > H)
                    {
                        if(!c[0])
                        {
                            c[0] = true;
                            cnt++;
                        }
                        continue;
                    }

                    int newC = j + dc[k];
                    if(newC <= 0 || newC > W)
                    {
                        if(!c[0])
                        {
                            c[0] = true;
                            cnt++;
                        }
                        continue;
                    }

                    if(c[group[newR][newC]])
                        continue;
                    if(group[i][j] == group[newR][newC])
                        continue;

                    c[group[newR][newC]] = true;
                    cnt++;
                }

                map[i][j] = cnt;
                maxCnt[group[i][j]] = Math.max(maxCnt[group[i][j]], map[i][j]);
            }
        }

        for(int i=1; i<=H; i++)
        {
            for(int j=1; j<=W; j++)
            {
                if(ary[i][j] == 0)
                    continue;

                if(i % 2 == 0)
                    dc = dce;
                else
                    dc = dco;

                int cnt = 0;
                for(int k=0; k<6; k++)
                {
                    int newR = i + dr[k];
                    if(newR <= 0 || newR > H)
                    {
                        cnt++;
                        continue;
                    }

                    int newC = j + dc[k];
                    if(newC <= 0 || newC > W)
                    {
                        cnt++;
                        continue;
                    }

                    if(group[i][j] != group[newR][newC])
                    {
                        if(ary[newR][newC] == 0 && maxCnt[group[newR][newC]] == 1)
                            continue;

                        cnt++;
                    }
                }

                ans += cnt;
            }
        }

        System.out.println(ans);
    }
}
