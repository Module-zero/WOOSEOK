/*
이분 그래프

https://www.acmicpc.net/problem/1707
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-21
 * Time: 오전 10:47
 */

public class Q1707
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        while(K-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 인접 리스트
            ArrayList<ArrayList<Integer>> ary = new ArrayList<>();
            for(int i=0; i<=V; i++)
                ary.add(new ArrayList<>());

            // 아직 방문하지 않았으면 0, A그룹이면 1, B그룹이면 2
            int[] check = new int[V+1];

            // 이분 그래프이면 true
            boolean isBG = true;

            for(int i=0; i<E; i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                ary.get(a-1).add(b-1);
                ary.get(b-1).add(a-1);
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int j=0; j<V; j++)
            {
                // 이분 그래프가 아니면 탐색 종료
                if(isBG == false)
                    break;

                // 방문하지 않은 정점이면 탐색
                if(check[j] == 0)
                {
                    queue.add(j);
                    check[j] = 1;
                }

                while(!queue.isEmpty())
                {
                    int num = queue.poll();

                    for(int i=0; i<ary.get(num).size(); i++)
                    {
                        // 연결되어 있음
                        int target = ary.get(num).get(i);

                        // 연결되어 있고 아직 방문하지 않았으면 반대 그룹으로 지정하고 방문한다.
                        if(check[target] == 0)
                        {
                            queue.add(target);
                            check[target] = (check[num] == 1) ? 2 : 1;
                        }
                        // 연결되어 있는데 그룹이 같으면 이분 그래프가 아니다.
                        else if(check[target] == check[num])
                        {
                            isBG = false;
                            break;
                        }
                    }

                    // 이분 그래프가 아니면 탐색 종료
                    if(isBG == false)
                        break;
                }
            }

            if(isBG == true)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }
}
