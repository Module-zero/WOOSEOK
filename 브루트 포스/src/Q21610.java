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
 * Time: 오후 4:01
 */

public class Q21610
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[51][51];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

        Queue<int[]> cloud = new LinkedList<>();
        cloud.add(new int[]{N-1, 0});
        cloud.add(new int[]{N-1, 1});
        cloud.add(new int[]{N-2, 0});
        cloud.add(new int[]{N-2, 1});

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            boolean[][] check = new boolean[51][51];
            while(!cloud.isEmpty())
            {
                int[] newL = cloud.poll();

                int r = (newL[0] + dr[d-1]*s) % N;
                if(r < 0)
                    r = N + r;

                int c = (newL[1] + dc[d-1]*s) % N;
                if(c < 0)
                    c = N + c;

                check[r][c] = true;

                // 구름 위치에 비가 내림
                ary[r][c]++;
            }

            for(int r=0; r<N; r++)
            {
                for(int c=0; c<N; c++)
                {
                    if(!check[r][c])
                        continue;

                    int cnt = 0;
                    for(int j=1; j<8; j+=2)
                    {
                        int newR = r + dr[j];
                        if(newR < 0 || newR >= N)
                            continue;
                        int newC = c + dc[j];
                        if(newC < 0 || newC >= N)
                            continue;

                        if(ary[newR][newC] > 0)
                            cnt++;
                    }

                    ary[r][c] += cnt;
                }
            }

            for(int r=0; r<N; r++)
            {
                for(int c=0; c<N; c++)
                {
                    if(ary[r][c] < 2)
                        continue;
                    if(check[r][c])
                        continue;

                    cloud.add(new int[]{r, c});
                    ary[r][c] -= 2;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                ans += ary[i][j];
        }

        System.out.println(ans);
    }
}
