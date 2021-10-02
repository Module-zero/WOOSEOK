import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-30
 * Time: 오후 4:55
 */

public class Q20056
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]>[][] queue = new LinkedList[50][50];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                queue[i][j] = new LinkedList<>();
        }

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            queue[r-1][c-1].add(new int[]{m, s, d, 0});
        }

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        for(int k=0; k<K; k++)
        {
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    while(!queue[i][j].isEmpty())
                    {
                        if(queue[i][j].peek()[3] != k)
                            break;

                        int[] tmp = queue[i][j].poll();

                        int s = tmp[1] % N;
                        int newR = i + s*dr[tmp[2]];
                        if(newR < 0)
                            newR = N + newR;
                        else
                            newR = newR % N;

                        int newC = j + s*dc[tmp[2]];
                        if(newC < 0)
                            newC = N + newC;
                        else
                            newC = newC % N;

                        queue[newR][newC].add(new int[]{tmp[0], tmp[1], tmp[2], tmp[3]+1});
                    }
                }
            }

            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    int size = queue[i][j].size();
                    if(size < 2)
                        continue;

                    int msum = 0;
                    int ssum = 0;
                    int d = queue[i][j].peek()[2] % 2;
                    boolean all = true;

                    while(!queue[i][j].isEmpty())
                    {
                        int[] tmp = queue[i][j].poll();
                        msum += tmp[0];
                        ssum += tmp[1];
                        if(tmp[2] % 2 != d)
                            all = false;
                    }

                    msum /= 5;
                    if(msum == 0)
                        continue;

                    ssum /= size;
                    if(all)
                        d = 0;
                    else
                        d = 1;

                    for(int l=0; l<4; l++)
                        queue[i][j].add(new int[]{msum, ssum, d + 2 * l, k + 1});
                }
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                while(!queue[i][j].isEmpty())
                {
                    int[] tmp = queue[i][j].poll();
                    ans += tmp[0];
                }
            }
        }

        System.out.println(ans);
    }
}
