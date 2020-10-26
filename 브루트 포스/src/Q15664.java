/*
N과 M (10)

https://www.acmicpc.net/problem/15664
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-17
 * Time: 오전 12:55
 */

public class Q15664
{
    static int N;
    static int M;
    static int[] ary;
    static int[] tmp;
    static ArrayList<int[]> list;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index, int prevIndex)
    {
        if(index == M)
        {
            // 이미 나왔던 배열인지 검사
            for(int i=0; i<list.size(); i++)
            {
                boolean isSame = true;

                // 리스트에서 저장했던 배열을 하나씩 꺼낸다.
                int[] target = list.get(i);

                for(int j=0; j<M; j++)
                {
                    // 하나라도 다르면 같은 배열이 아님
                    if(target[j] != tmp[j])
                        isSame = false;
                }

                if(isSame)
                    return;
            }

            for(int i=0; i<M; i++)
                sb.append(tmp[i] + " ");

            sb.append("\n");

            int[] prev = new int[M];
            for(int i=0; i<M; i++)
                prev[i] = tmp[i];

            // 리스트에 추가
            list.add(prev);

            return;
        }

        for(int i=prevIndex+1; i<N; i++)
        {
            tmp[index] = ary[i];
            foo(index + 1, i);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new int[N];
        tmp = new int[M];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary);

        foo(0, -1);

        System.out.print(sb.toString());
    }
}
