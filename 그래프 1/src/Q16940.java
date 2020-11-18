/*
BFS 스페셜 저지

https://www.acmicpc.net/problem/16940
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-25
 * Time: 오후 7:17
 */

public class Q16940
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> ary = new ArrayList<>();
        for(int i=0; i<=N; i++)
            ary.add(new ArrayList<>());

        for(int i=0; i<N-1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary.get(a).add(b);
            ary.get(b).add(a);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ans = new int[100001];
        int[] order = new int[100001];

        for(int i=1; i<=N; i++)
        {
            ans[i] = Integer.parseInt(st.nextToken());
            // 입력받은 순서대로 정렬하기 위해 order 배열 사용
            order[ans[i]] = i;
        }

        // 시작 정점이 1이 아니라면 종료
        if(ans[1] != 1)
        {
            System.out.println(0);
            return;
        }

        // 입력받은 순서대로 정렬
        for(int i=1; i<=N; i++)
        {
            ArrayList<Integer> tmp = ary.get(i);
            Collections.sort(tmp, new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    if(order[o1] > order[o2])
                        return 1;
                    else
                        return -1;
                }
            });
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] check = new boolean[100001];
        check[1] = true;

        // 몇 번째로 나오는지 order배열과 비교하기 위한 cnt 선언
        int cnt = 2;
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int i=0; i<ary.get(tmp).size(); i++)
            {
                int num = ary.get(tmp).get(i);

                if(!check[num])
                {
                    queue.add(num);
                    check[num] = true;

                    // 순서가 맞지 않으면 0 출력 후 종료
                    if(order[num] != cnt)
                    {
                        System.out.println(0);
                        return;
                    }

                    cnt++;
                }
            }
        }

        System.out.println(1);
    }
}
