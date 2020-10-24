/*

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-24
 * Time: 오후 6:00
 */

public class nhn3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int time = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int[] ary = new int[100];

        // 정답을 저장할 변수
        int amount = 0;

        while(time-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 오전 : 벽돌을 쌓는다.
            for(int i=0; i<b; i++)
                ary[i] += Integer.parseInt(st.nextToken());

            // 오후 : 시멘트를 붓는다.

            // 시멘트를 얼마나 부을지 조사한다.
            // 자기 자신의 왼쪽과 오른쪽의 가장 가까운 최댓값을 찾는다.
            int[] lMax = new int[100];
            int[] rMax = new int[100];
            // 양 끝의 벽돌에는 시멘트를 붓지 않는다. (1 ~ b-2까지만)
            for(int i=1; i<b-1; i++)
            {
                // 왼쪽으로 가면서 가장 가까운 자신보다 큰 값을 찾는다.
                lMax[i] = ary[i];
                for(int j=i-1; j>=0; j--)
                {
                    // 지나온 값보다 작은 값이면 탈출
                    if(ary[j] < ary[j+1] && j+1 != i)
                        break;

                    if(ary[j] > lMax[i])
                        lMax[i] = ary[j];
                }

                rMax[i] = ary[i];
                // 오른쪽으로 가면서 가장 가까운 자신보다 큰 값을 찾는다.
                for(int j=i+1; j<b; j++)
                {
                    // 지나온 값보다 작은 값이면 탈출
                    if(ary[j] < ary[j-1] && j-1 != i)
                        break;

                    if(ary[j] > rMax[i])
                        rMax[i] = ary[j];
                }
            }

            // 시멘트를 붓는다.
            for(int i=1; i<b-1; i++)
            {
                // 둘 중 작은 값만큼 시멘트를 채운다.
                if(lMax[i] > rMax[i])
                {
                    amount += rMax[i] - ary[i];
                    ary[i] = rMax[i];
                }
                else
                {
                    amount += lMax[i] - ary[i];
                    ary[i] = lMax[i];
                }
            }
        }

        System.out.println(amount);
    }
}
