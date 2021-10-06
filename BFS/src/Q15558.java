import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-07-15
 * Time: 오후 3:18
 */

public class Q15558
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] strs = new String[2];
        strs[0] = br.readLine();
        strs[1] = br.readLine();
        boolean[][] check = new boolean[2][100001];

        Queue<int[]> queue = new LinkedList<>();
        // [0] : 칸, [1] : 왼쪽(0), 오른쪽(1), [2] : 없어질 칸(시간)
        queue.add(new int[]{0, 0, 0});
        check[0][0] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            if(tmp[0] >= N - 1)
            {
                System.out.println(1);
                return;
            }

            // 1칸 앞
            if(strs[tmp[1]].charAt(tmp[0] + 1) != '0' && !check[tmp[1]][tmp[0] + 1])
            {
                queue.add(new int[]{tmp[0] + 1, tmp[1], tmp[2] + 1});
                check[tmp[1]][tmp[0] + 1] = true;
            }

            // 1칸 뒤
            if(tmp[0] - 1 > tmp[2] && strs[tmp[1]].charAt(tmp[0] - 1) != '0' && !check[tmp[1]][tmp[0] - 1])
            {
                queue.add(new int[]{tmp[0] - 1, tmp[1], tmp[2] + 1});
                check[tmp[1]][tmp[0] - 1] = true;
            }

            // 옆 줄 k칸 앞
            if(tmp[0] + k >= N)
            {
                System.out.println(1);
                return;
            }

            if(strs[1 - tmp[1]].charAt(tmp[0] + k) != '0' && !check[1 - tmp[1]][tmp[0] + k])
            {
                queue.add(new int[]{tmp[0] + k, 1 - tmp[1], tmp[2] + 1});
                check[1 - tmp[1]][tmp[0] + k] = true;
            }
        }

        System.out.println(0);
    }
}
