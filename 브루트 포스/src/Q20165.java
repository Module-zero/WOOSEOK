import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-18
 * Time: 오후 3:47
 */

public class Q20165
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] ary = new int[101][101];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        boolean[][] map = new boolean[101][101];
        int ans = 0;
        while(R-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            char D = st.nextToken().charAt(0);

            int dir = 0;
            switch(D)
            {
                case 'E':
                    dir = 0;
                    break;
                case 'W':
                    dir = 1;
                    break;
                case 'S':
                    dir = 2;
                    break;
                case 'N':
                    dir = 3;
                    break;
            }

            // 안 넘어진 도미노였을 경우
            if(!map[X][Y])
            {
                ans++;
                map[X][Y] = true;
                int rem = ary[X][Y] - 1; // 남은 힘
                while(rem > 0)
                {
                    int newX = X + dr[dir];
                    if(newX <= 0 || newX > N)
                        break;

                    int newY = Y + dc[dir];
                    if(newY <= 0 || newY > M)
                        break;

                    X = newX;
                    Y = newY;
                    // 이미 넘어진 도미노였을 경우
                    if(map[X][Y])
                    {
                        rem--;
                        continue;
                    }

                    ans++;
                    map[X][Y] = true;
                    rem = Integer.max(rem, ary[X][Y]);
                    rem--;
                }
            }

            // 수비수
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            map[X][Y] = false;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(ans).append('\n');
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(map[i][j])
                    sb.append("F ");
                else
                    sb.append("S ");
            }

            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
