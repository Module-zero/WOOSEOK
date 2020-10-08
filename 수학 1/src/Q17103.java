/*
골드바흐 파티션

문제
골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.

입력
첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.

출력
각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-07
 * Time: 오후 11:24
 */

public class Q17103
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] prime = new int[500000];
        int pCnt = 0;
        boolean[] check = new boolean[1000001];
        check[0] = check[1] = true;

        int max = 1000000;
        for(int i=2; i<=max; i++)
        {
            if(!check[i])
            {
                prime[pCnt++] = i;

                for(int j=i+i; j<=max; j+=i)
                    check[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            for(int i=0; i<pCnt; i++)
            {
                int a = prime[i];
                if(a > N/2)
                    break;
                int b = N - a;

                // b가 소수면 cnt 증가
                if(check[b] == false)
                    cnt++;
            }

            sb.append(cnt + "\n");
        }

        System.out.print(sb.toString());
    }
}
