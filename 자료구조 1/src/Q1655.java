/*
가운데를 말해요

https://www.acmicpc.net/problem/1655
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-23
 * Time: 오후 4:48
 */

public class Q1655
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(br.readLine());

            // 첫 번째 입력한 수는 maxHeap에 저장
            // 최대 힙을 간단히 구현하기 위해 -를 붙인다.
            if(maxHeap.isEmpty())
                maxHeap.add(-num);
            else
            {
                // 최소 힙이 비었으면 두 번째로 입력한 수이므로 비교해서 알맞은 큐에 넣는다.
                if(minHeap.isEmpty())
                {
                    if(num < -maxHeap.peek())
                    {
                        maxHeap.add(-num);
                        minHeap.add(-maxHeap.poll());
                    }
                    else
                        minHeap.add(num);
                }
                // 세 번째 입력한 수부터 이곳
                else
                {
                    int maxTop = -maxHeap.peek();
                    int minTop = minHeap.peek();

                    // 둘의 사이즈가 같으면
                    // num이 minTop보다 같거나 작을 경우 바로 최대 힙으로
                    // num이 minTop보다 클 경우
                    //      num이 maxTop보다 클 경우 최소 힙의 최솟값을 최대 힙으로 보낸 후 최소 힙으로
                    //      num이 maxTop보다 작거나 같을 경우 바로 최대 힙으로
                    if(maxHeap.size() == minHeap.size())
                    {
                        if(num <= minTop)
                            maxHeap.add(-num);
                        else
                        {
                            if(num > maxTop)
                            {
                                maxHeap.add(-minHeap.poll());
                                minHeap.add(num);
                            }
                            else
                                maxHeap.add(-num);
                        }
                    }
                    // 최대 힙의 크기가 최소 힙의 크기보다 1 크면
                    // num이 minTop보다 크거나 같을 경우 바로 최소 힙으로
                    // num이 minTop보다 작을 경우
                    //      num이 maxTop보다 같거나 클 경우 바로 최소 힙으로
                    //      num이 maxTop보다 작을 경우 최대 힙의 최댓값을 최소 힙으로 보낸 후 최대 힙으로
                    else
                    {
                        if(num >= minTop)
                            minHeap.add(num);
                        else
                        {
                            if(num >= maxTop)
                                minHeap.add(num);
                            else
                            {
                                minHeap.add(-maxHeap.poll());
                                maxHeap.add(-num);
                            }
                        }
                    }
                }
            }

            sb.append(-maxHeap.peek()).append('\n');
        }

        System.out.print(sb.toString());
    }
}
