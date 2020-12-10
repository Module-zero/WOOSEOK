/*
인싸들의 가위바위보

https://www.acmicpc.net/problem/16986
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-08
 * Time: 오후 5:12
 */

public class Q16986
{
    static int N;
    static int K;
    static int[][] A = new int[10][10];
    static int[] jiwoo = new int[21];
    static int[] kyoung = new int[21];
    static int[] min = new int[21];
    static int win0;
    static int win1;
    static int win2;
    static int cnt0;
    static int cnt1;
    static int cnt2;

    public static boolean nextPermutation()
    {
        int i = N;
        while(i>1 && jiwoo[i-1] >= jiwoo[i]) --i;

        if(i == 1)
            return false;

        int j = N;
        while(jiwoo[i-1] >= jiwoo[j]) --j;

        int tmp = jiwoo[i-1];
        jiwoo[i-1] = jiwoo[j];
        jiwoo[j] = tmp;

        int k = N;
        while(i<k)
        {
            tmp = jiwoo[i];
            jiwoo[i] = jiwoo[k];
            jiwoo[k] = tmp;
            ++i;
            --k;
        }

        return true;
    }

    public static boolean foo(int id, int winner, int next)
    {
        // 지우가 K번을 이겼으면 true
        if(win0 == K)
            return true;

        // 경희나 민호가 K번을 이겼으면 false
        if(win1 == K || win2 == K)
            return false;

        // 지우, 경희, 민호의 손동작 저장
        int[] hand = {jiwoo[cnt0], kyoung[cnt1], min[cnt2]};
        // 지우가 경기에 참여하지 않을 경우
        if(winner != 0 && next != 0)
        {
            // 앞의 인덱스의 승
            if(A[hand[winner]][hand[next]] == 2)
                winner = winner;
                // 비겼을 경우 순서가 늦은 사람이 승
            else if(A[hand[winner]][hand[next]] == 1)
                winner = (next > winner ? next : winner);
                // 뒤의 인덱스의 승
            else
                winner = next;

            if(winner == 1)
                win1++;
            else
                win2++;

            cnt1++;
            cnt2++;
            return foo(id+1, winner, 0);
        }

        // 지우의 상대
        int target = (winner == 0) ? next : winner;

        // 라운드 진행
        cnt0++;
        if(target == 1)
            cnt1++;
        else
            cnt2++;

        // 지우 손동작의 경우의 수
        // 지우의 승
        if(A[hand[0]][hand[target]] == 2)
        {
            win0++;
            if(foo(id+1, 0, 3-target))
                return true;
            win0--;
        }
        // 지우의 순서가 제일 앞이므로 비겨도 패
        else
        {
            // 경희가 이겼을 경우
            if(target == 1)
            {
                win1++;
                if(foo(id+1, target, 3-target))
                    return true;
                win1--;
            }
            // 민호가 이겼을 경우
            else
            {
                win2++;
                if(foo(id+1, target, 3-target))
                    return true;
                win2--;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=20; i++)
            kyoung[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=20; i++)
            min[i] = Integer.parseInt(st.nextToken());

        // 지우 초기화
        for(int i=1; i<=N; i++)
            jiwoo[i] = i;

        while(true)
        {
            // 승리 횟수 초기화
            win0 = win1 = win2 = 0;
            // 판 진행 횟수 초기화
            cnt0 = cnt1 = cnt2 = 1;

            if (foo(1, 0, 1))
            {
                System.out.println(1);
                return;
            }

            if(!nextPermutation())
                break;
        }

        System.out.println(0);
    }
}
