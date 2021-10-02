import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-30
 * Time: 오후 8:00
 */

public class Q19236
{
    static class Temp
    {
        int r;
        int c;
        int d;
        boolean died = false;

        public Temp(int r, int c, int d)
        {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        public Temp(Temp temp)
        {
            this.r = temp.r;
            this.c = temp.c;
            this.d = temp.d;
            this.died = temp.died;
        }
    }

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

    public static int foo(Temp[] og, int[][] map, int r, int c, int sum)
    {
        if(r < 0 || r >= 4 || c < 0 || c >= 4)
            return sum;
        if(og[map[r][c]].died)
            return sum;

        int shark = map[r][c];
        sum += map[r][c]+1;

        int[][] ary = new int[4][4];
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++)
                ary[i][j] = map[i][j];
        }

        Temp[] temp = new Temp[16];
        for(int i=0; i<16; i++)
            temp[i] = new Temp(og[i]);

        int ans = 0;
        for (int i = 0; i < 16; i++)
        {
            if (i == shark)
                continue;

            Temp tmp = temp[i];
            if(tmp.died)
                continue;

            for (int j = 0; j < 8; j++)
            {
                int newR = tmp.r + dr[(tmp.d + j) % 8];
                if (newR < 0 || newR >= 4)
                    continue;

                int newC = tmp.c + dc[(tmp.d + j) % 8];
                if (newC < 0 || newC >= 4)
                    continue;

                // 상어면 갈 수 없다.
                if(newR == r && newC == c)
                    continue;

                int t = ary[newR][newC];
                // 자리 교환
                ary[newR][newC] = ary[tmp.r][tmp.c];
                ary[tmp.r][tmp.c] = t;
                tmp.d = (tmp.d + j) % 8;

                Temp op = temp[t];
                op.r = tmp.r;
                op.c = tmp.c;

                tmp.r = newR;
                tmp.c = newC;

                break;
            }
        }

        // 상어 턴
        Temp s = temp[shark];
        s.died = true;
        for(int k=1; k<=3; k++)
        {
            int newR = s.r + k*dr[s.d];
            int newC = s.c + k*dc[s.d];

            ans = Math.max(ans, foo(temp, ary, newR, newC, sum));
        }

        return ans;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] ary = new int[4][4];
        Temp[] temp = new Temp[16];
        int shark = 0;
        for(int i=0; i<4; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<4; j++)
            {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                temp[a-1] = new Temp(i, j, b-1);
                ary[i][j] = a-1;
            }
        }

        System.out.println(foo(temp, ary, 0, 0, 0));
    }
}
