import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-21
 * Time: 오후 2:39
 */

public class Q20208
{
    static int N;
    static int M;
    static int H;
    static int[][] ary = new int[11][11];
    static int sr = 0;
    static int sc = 0;
    static boolean[] check = new boolean[11];
    static int ans = 0;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void foo(int r, int c, int hp, int score)
    {
        int tr = sr - r;
        if(tr < 0)
            tr = -tr;
        int tc = sc - c;
        if(tc < 0)
            tc = -tc;

        // 집에 갈 수 있으면 계산
        if(hp - tr - tc >= 0)
            ans = Integer.max(ans, score);

        int size = list.size();
        for(int i=0; i<size; i++)
        {
            if(check[i])
                continue;

            int[] tmp = list.get(i);

            int dr = r - tmp[0];
            if(dr < 0)
                dr = -dr;
            int dc = c - tmp[1];
            if(dc < 0)
                dc = -dc;

            int d = dr + dc;

            // 먹으러 갈 수 없으면 계산하지 않는다.
            if(hp - d < 0)
                continue;

            check[i] = true;
            foo(tmp[0], tmp[1], hp+H-d, score+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(ary[i][j] == 1)
                {
                    sr = i;
                    sc = j;
                }
                else if(ary[i][j] == 2)
                    list.add(new int[]{i, j});
            }
        }

        foo(sr, sc, M, 0);

        System.out.println(ans);
    }
}
