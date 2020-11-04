/*
이모티콘

https://www.acmicpc.net/problem/14226
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오후 9:14
 */

public class Q14226
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        // [0] : 화면, [1] : 클립보드
        boolean[][] check = new boolean[1001][1001];

        Queue<int[]> queue = new LinkedList<>();

        // [0] : 화면의 이모티콘 개수, [1] : 시간, [2] : 클립보드의 이모티콘 개수
        queue.add(new int[]{1, 0, 0});
        check[0][0] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            //화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if(!check[tmp[0]][tmp[0]])
            {
                check[tmp[0]][tmp[0]] = true;
                queue.add(new int[]{tmp[0], tmp[1] + 1, tmp[0]});
            }

            //클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if(tmp[0] + tmp[2] <= S && !check[tmp[0] + tmp[2]][tmp[2]])
            {
                // 정답이면
                if(tmp[0] + tmp[2] == S)
                {
                    System.out.println(tmp[1] + 1);
                    return;
                }

                check[tmp[0] + tmp[2]][tmp[2]] = true;
                queue.add(new int[]{tmp[0] + tmp[2], tmp[1] + 1, tmp[2]});
            }

            //화면에 있는 이모티콘 중 하나를 삭제한다.
            if(tmp[0] - 1 >= 0 && !check[tmp[0] - 1][tmp[2]])
            {
                // 정답이면
                if(tmp[0] - 1 == S)
                {
                    System.out.println(tmp[1] + 1);
                    return;
                }

                check[tmp[0] - 1][tmp[2]] = true;
                queue.add(new int[]{tmp[0] - 1, tmp[1] + 1, tmp[2]});
            }
        }
    }
}
