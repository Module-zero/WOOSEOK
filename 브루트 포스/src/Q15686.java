/*
치킨 배달

https://www.acmicpc.net/problem/15686
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오후 3:11
 */

public class Q15686
{
    static int N;
    static int M;
    static int[][] ary = new int[51][51];
    static ArrayList<int[]> chick = new ArrayList<>();
    static ArrayList<int[]> house = new ArrayList<>();
    // 집 최대 2N(100)개, 치킨집 최대 13개
    static int[][] dist = new int[100][13];
    boolean[] check = new boolean[13];
    static int min = Integer.MAX_VALUE;

    public static void foo(int index, int cnt, ArrayList<Integer> chicks)
    {
        if(index == chick.size())
        {
            if(cnt != M)
                return;

            int sum = 0;
            // 치킨집을 M개 선정했으면 집마다 치킨 거리를 구한다.
            for(int i=0; i<house.size(); i++)
            {
                int tmp = Integer.MAX_VALUE;

                for (int j=0; j<chicks.size(); j++)
                {
                    // 치킨집 번호
                    int id = chicks.get(j);

                    tmp = Integer.min(tmp, dist[i][id]);
                }

                sum += tmp;
            }

            min = Integer.min(min, sum);

            return;
        }

        // index번 치킨집을 선정하지 않음
        foo(index+1, cnt, chicks);

        // index번 치킨집을 선정
        ArrayList<Integer> list = new ArrayList<>(chicks);
        list.add(index);
        foo(index+1, cnt+1, list);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                ary[i][j] = st.nextToken().charAt(0) - '0';

                if(ary[i][j] == 1)
                    house.add(new int[]{i, j});
                else if(ary[i][j] == 2)
                    chick.add(new int[]{i, j});
            }
        }

        for(int i=0; i<house.size(); i++)
        {
            int[] hou = house.get(i);

            for(int j=0; j<chick.size(); j++)
            {
                int[] chi = chick.get(j);

                // i집에서 j치킨집에 대한 치킨 거리 저장
                dist[i][j] = Math.abs(hou[0] - chi[0]) + Math.abs(hou[1] - chi[1]);
            }
        }

        foo(0, 0, new ArrayList<>());
        System.out.println(min);
    }
}
