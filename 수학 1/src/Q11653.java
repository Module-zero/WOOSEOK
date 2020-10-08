/*
소인수분해

문제
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.

출력
N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-08
 * Time: 오후 5:45
 */

public class Q11653
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 1이면 1 출력, 아니면 소인수분해
        if(N != 1)
        {
            for(int i=2; i*i<=N; i++)
            {
                while(N % i == 0)
                {
                    sb.append(i + "\n");
                    N /= i;
                }
            }

            if(N > 1)
                sb.append(N + "\n");
        }

        System.out.print(sb.toString());
    }
}
