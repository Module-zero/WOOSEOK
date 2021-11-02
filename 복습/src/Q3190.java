import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-02
 * Time: 오후 2:46
 */

public class Q3190
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] ary = new int[101][101];
        for(int i=0; i<K; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ary[r][c] = 2;
        }

        int[] count = new int[10001];
        int L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);

            if(C == 'D')
                count[X] = 1;
            else
                count[X] = -1;
        }

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 1;
        int c = 1;
        ary[r][c] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        int t = 1;
        int d = 0;
        while(true)
        {
            r += dr[d];
            if(r <= 0 || r > N)
                break;

            c += dc[d];
            if(c <= 0 || c > N)
                break;

            if(ary[r][c] == 1)
                break;
            else if(ary[r][c] == 0)
            {
                int[] tail = queue.poll();
                ary[tail[0]][tail[1]] = 0;
            }

            queue.add(new int[]{r, c});
            ary[r][c] = 1;

            d = (d + count[t]) % 4;
            if(d < 0)
                d = 3;
            t++;
        }

        System.out.println(t);
    }
}
