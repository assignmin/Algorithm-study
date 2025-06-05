package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_10845 {

	public static void main(String[] args) throws IOException {

		// 표준 입력(System.in)을 바탕으로 InputStreamReader를 생성하고, 이를 BufferedReader로 감싸 입력을 효율적으로 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력된 문자열을 읽어서 정수로 변환
		int num = Integer.parseInt(br.readLine());
		
		String input = null;	// 명령을 받을 변수
		int remember = 0;	// 최근에 들어간 수(큐의 가장 뒤에 위치한 수)를 저장할 변수
		
		Queue<Integer> queue = new LinkedList<>();	// LinkedList로 Queue 구현
		
		for(int i = 0; i < num; i++)
		{
			input = br.readLine();	// 명령 입력받기
			
			if(input.contains("push"))	// input 문자열 안에 push 라는 문자열이 포함되어있는지 확인(true/false 반환)
			{
				// input 문자열에서 '인덱스 5번 위치부터 문자열 끝까지'(숫자)를 또 다른 문자열로 받은 후, 정수 변환 후, 큐에 삽입
				queue.offer(Integer.parseInt(input.substring(5)));
				// 큐에 삽입한 수 저장
				remember = Integer.parseInt(input.substring(5));
			}
			else if(input.equals("pop"))	// 명령이 pop인 경우
			{
				if(queue.isEmpty())	// 큐가 비어있는 경우
				{
					System.out.println(-1);
				}
				else
				{
					System.out.println(queue.poll());	// 큐의 맨 앞 숫자를 큐에서 제거해서 반환
				}
			}
			else if(input.equals("size"))	// 명령이 size인 경우
			{
				System.out.println(queue.size());	// 큐의 크기
			}
			else if(input.equals("empty"))	// 명령이 empty인 경우
			{
				if(queue.isEmpty())	// 큐가 비어있는 경우
				{
					System.out.println(1);
				}
				else if(!queue.isEmpty())	// 큐가 비어있지 않은 경우
				{
					System.out.println(0);
				}
			}
			else if(input.equals("front"))	// 명령이 front인 경우
			{
				if(queue.isEmpty())	// 큐가 비어있는 경우
				{
					System.out.println(-1);
				}
				else
				{
					System.out.println(queue.peek());	// 큐의 맨 앞 숫자를 큐에서 제거하지 않고 반환
				}
			}
			else if(input.equals("back"))	// 명령이 back인 경우
			{
				if(queue.isEmpty())	// 큐가 비어있는 경우
				{
					System.out.println(-1);
				}
				else
				{
					System.out.println(remember);
				}
			}
		}

	}

}
