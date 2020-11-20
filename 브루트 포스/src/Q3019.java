import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오후 3:56
 */

public class Q3019
{
    // [7][19][3][2]
    static int[][][][] block =
            {
                    // 작대기
                    {{{1, 0}, {2, 0}, {3, 0}},
                    {{0, 1}, {0, 2}, {0, 3}}},
                    // ㅁ
                    {{{0, 1}, {1, 0}, {1, 1}}},
                    // z 반대
                    {{{0, 1}, {1, 1}, {1, 2}},
                    {{1, 0}, {1, -1}, {2, -1}}},
                    // z
                    {{{0, -1}, {1, -1}, {1, -2}},
                    {{1, 0}, {1, 1}, {2, 1}}},
                    // ㅗ
                    {{{0, 1}, {1, 1}, {0, 2}},
                    {{1, 0}, {1, 1}, {2, 0}},
                    {{0, 1}, {0, 2}, {-1, 1}},
                    {{1, -1}, {1, 0}, {2, 0}}},
                    // ㄴ 반대
                    {{{0, 1}, {0, 2}, {1, 2}},
                    {{0, -1}, {1, -1}, {2, -1}},
                    {{1, 0}, {1, 1}, {1, 2}},
                    {{1, 0}, {2, 0}, {2, -1}}},
                    // ㄴ
                    {{{0, 1}, {0, 2}, {1, 0}},
                    {{1, 0}, {2, 0}, {2, 1}},
                    {{1, 0}, {1, -1}, {1, -2}},
                    {{0, 1}, {1, 1}, {2, 1}}}
            };

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken()) - 1;
        int[] height = new int[101];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            height[i] = Integer.parseInt(st.nextToken());


    }
}
