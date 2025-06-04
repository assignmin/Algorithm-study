package study.baekjoon;

import java.util.Queue;
//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Boj_2164 {

	public static void main(String[] args) throws IOException {
		
		Queue<Integer> queue = new LinkedList<>();
		
		//Scanner scanner = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// BufferedReader가 Scanner 보다 수행속도가 더 빠름 
        
        int num = Integer.parseInt(br.readLine());	// 한 줄을 읽어와서 정수로 변환 후 대입
		
		int queueSize;	// 큐 크기를 받을 변수
		
		//int num = Integer.parseInt(scanner.nextLine());
		
		for(int i = 1; i <= num; i++)
		{
			queue.offer(i);	// 큐에 요소 채우기
		}
		
		queueSize = queue.size();	// 큐 크기
		
		for(int j = 0; j < queueSize - 1; j++)
		{
			queue.poll();	// 맨 앞 요소 꺼내기
			queue.offer(queue.poll());	// 맨 앞의 요소를 맨 뒤로 보냄
		}
		
		System.out.println(queue.poll());	// 마지막 남은 하나의 요소 꺼내기

	}

}
