/*
공유기 설치

https://www.acmicpc.net/problem/2805
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오후 4:59
 */

public class Q2110
{
    static int N;
    static int C;
    static ArrayList<Integer> ary = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
            ary.add(Integer.parseInt(br.readLine()));

        Collections.sort(ary);

        
    }
}
