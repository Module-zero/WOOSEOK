/*
배열 합치기

https://www.acmicpc.net/problem/11728
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-05
 * Time: 오전 11:48
 */

public class Q11728
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[1000001];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] B = new int[1000001];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        // 배열 A의 인덱스
        int i=0;
        // 배열 B의 인덱스
        int j=0;
        // 정답 배열 ans의 인덱스
        int k=0;
        int[] ans = new int[2000001];

        while(i < N && j < M)
        {
            if(A[i] <= B[j])
                ans[k++] = A[i++];
            else
                ans[k++] = B[j++];
        }

        while(i < N)
            ans[k++] = A[i++];

        while(j < M)
            ans[k++] = B[j++];

        StringBuilder sb = new StringBuilder();
        for(int l=0; l<k; l++)
            sb.append(ans[l]).append(" ");

        System.out.println(sb.toString());
    }
}
