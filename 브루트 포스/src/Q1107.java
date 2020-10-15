/*
리모컨

문제
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

수빈이가 지금 보고 있는 채널은 100번이다.

입력
첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.  둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

출력
첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-14
 * Time: 오후 11:53
 */

public class Q1107
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[10];

        if(M > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++)
            {
                int num = Integer.parseInt(st.nextToken());
                button[num] = true;
            }
        }

        // +, -버튼으로만 이동할 경우로 초기화
        int min = N - 100;
        if(min < 0)
            min = -min;

        for(int i=0; i<1000000; i++)
        {
            int ch = i;
            int digit = 0;

            if(ch == 0)
            {
                // 0번이 고장났을 경우 다음 번호로
                if(button[ch])
                    continue;
                else // 고장나지 않았을 경우
                    digit = 1;
            }

            boolean broken = false;

            while(ch > 0)
            {
                int num = ch % 10;

                // 고장난 버튼이면
                if(button[num])
                {
                    broken = true;
                    break;
                }

                ch /= 10;
                digit++;
            }

            // 고장난 버튼이 포함되어 있으면 다음 번호로 이동
            if(broken)
                continue;

            // 고장난 버튼이 포함되지 않았을 경우
            int cnt = i - N;
            // 음수일 경우 부호 전환
            if(cnt < 0)
                cnt = -cnt;

            // 버튼 누른 횟수 더하기
            cnt += digit;

            if(cnt < min)
                min = cnt;
        }

        System.out.println(min);
    }
}
