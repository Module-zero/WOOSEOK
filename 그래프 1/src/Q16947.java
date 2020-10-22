/*
서울 지하철 2호선

https://www.acmicpc.net/problem/16947
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오후 1:38
 */

public class Q16947
{
    public static int N;
    public static ArrayList<ArrayList<Integer>> ary;
    public static int[] dist = new int[3001];
    public static boolean[] isCycle = new boolean[3001];
    public static int cycleStartIndex = 0;

    public static void dfs(int num, int cnt)
    {
        if(isCycle[num])
        {
            // 사이클이 시작되는 정점인지 찾는다.
            if(cnt - dist[num] >= 3)
                cycleStartIndex = num;

            return;
        }

        isCycle[num] = true;
        dist[num] = cnt;

        ArrayList<Integer> tAry = ary.get(num);
        for(int j=0; j<tAry.size(); j++)
        {
            // 연결된 정점 하나를 꺼낸다.
            int target = tAry.get(j);

            // isCycle 배열을 방문한 노드를 체크하는 데에 사용
            dfs(target, cnt+1);

            // 순환선을 찾았으면 탐색 종료(isCycle 배열은 해당 정점이 순환선에 포함되는지 검사하는 데에 사용)
            if(cycleStartIndex > 0)
                break;
        }

        // 순환선 시작점이 자기 자신이면
        if(cycleStartIndex == num)
            cycleStartIndex = -1;
        // 순환선이 끝났거나 못찾았으면 자기 자신은 순환선이 아님
        else if(cycleStartIndex <= 0)
            isCycle[num] = false;

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ary = new ArrayList<>();
        for(int i=0; i<=N; i++)
            ary.add(new ArrayList<>());

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int id1 = Integer.parseInt(st.nextToken());
            int id2 = Integer.parseInt(st.nextToken());

            ary.get(id1).add(id2);
            ary.get(id2).add(id1);
        }

        for(int i=1; i<=N; i++)
        {
            isCycle[i] = true;

            ArrayList<Integer> tAry = ary.get(i);
            for(int j=0; j<tAry.size(); j++)
            {
                // 연결된 정점 하나를 꺼낸다.
                int num = tAry.get(j);

                // isCycle 배열을 방문한 노드를 체크하는 데에 사용
                dfs(num, 1);

                // 순환선을 찾았으면 탐색 종료(isCycle 배열은 해당 정점이 순환선에 포함되는지 검사하는 데에 사용)
                if(cycleStartIndex > 0)
                {
                    // 순환선 시작점이 자기 자신이면
                    if(cycleStartIndex == i)
                        cycleStartIndex = -1;
                    break;
                }
                // 순환선이 끝났거나 못찾았으면 자기 자신은 순환선이 아님
                else if(cycleStartIndex < 0)
                {
                    isCycle[i] = false;
                    break;
                }

                isCycle[num] = false;
            }

            if(cycleStartIndex > 0)
                break;

            isCycle[i] = false;
        }

        for(int i=1; i<=N; i++)
            System.out.print(isCycle[i] + " ");
        System.out.println();

        StringBuilder sb = new StringBuilder();

        // 순환선과의 거리 계산
        for(int i=1; i<=N; i++)
        {
            int cnt = 0;

            int num = i;
            while(!isCycle[num])
            {
                num = ary.get(num).get(0);
                cnt++;
            }

            sb.append(cnt + " ");
        }

        System.out.println(sb.toString());
    }
}
