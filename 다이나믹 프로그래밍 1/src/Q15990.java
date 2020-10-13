/*
1, 2, 3 더하기 5

문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.

1+2+1
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-13
 * Time: 오후 5:04
 */

public class Q15990
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[100001][4];

        for(int i=1; i<=100000; i++)
        {
            for(int j=1; j<=3; j++)
            {
                if(i > j)
                {
                    switch (j)
                    {
                        case 1:
                            dp[i][j] = (dp[i-j][2] + dp[i-j][3]) % 1000000009;
                            break;
                        case 2:
                            dp[i][j] = (dp[i-j][1] + dp[i-j][3]) % 1000000009;
                            break;
                        case 3:
                            dp[i][j] = (dp[i-j][1] + dp[i-j][2]) % 1000000009;
                            break;
                    }
                }
                else if(i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = 0;
            }
        }

        while(T-- > 0)
        {
            int n = Integer.parseInt(br.readLine());

            long sum = (dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009;

            sb.append(sum + "\n");
        }

        System.out.print(sb.toString());
    }
}
