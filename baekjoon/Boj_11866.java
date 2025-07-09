package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj_11866 {

	public static void main(String[] args) throws IOException {
		
		int N;	// 사람 수
		int K;	// K 번째
		String input;	// N과 K를 받기 위한 변수 
		int parse = 0;	// N과 K로 이루어진 문자열에서 공백(" ")의 인덱스
		int index = 0;	// 제거할 숫자를 가르키는 인덱스
		
		// 표준 입력(System.in)을 바탕으로 InputStreamReader를 생성하고, 이를 BufferedReader로 감싸 입력을 효율적으로 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();	// 입력된 문자열의 한줄을 읽어, String 타입 input 에 저장
		parse = input.indexOf(" ");	// 공백 위치의 인덱스
		
		N = Integer.parseInt(input.substring(0, parse));	// 문자옆의 앞 숫자
		K = Integer.parseInt(input.substring(parse + 1));	// 문자열의 뒤 숫자
		
		List<Integer> arrayList = new ArrayList<>();	// 1 부터 N 까지의 수를 순차적으로 저장할 ArrayList
		Queue<Integer> queue = new LinkedList<>();		// K 번째 마다의 수를 저장할 Queue
		
		for(int i = 0; i < N; i++)
		{
			arrayList.add(i+1);
		}
		
		
		
		while(arrayList.size() > 0)	// arrayList에 숫자가 하나도 없을 때까지 반복
		{
			
			for(int j = 0; j < K - 1; j++)	// K번째 수를 찾기 위한 인덱스 이동(현재 가르키고 있는 인덱스부터 첫번째 이므로 k-1번 이동)
			{
				if(index < arrayList.size())	// 가르키는 인덱스가 arrayList의 크기보다 작을 경우
				{
					index++;	// 한 칸 이동
				}
				if(index == arrayList.size())	// 가르키는 인덱스가 arrayList의 크기와 같을 경우
				{
					index = 0;	// 맨 앞으로 이동
				}
				
			}
			
			queue.offer(arrayList.get(index));	// queue 에 해당하는 숫자 삽입 
			arrayList.remove(index);	// arrayList 에서는 해당 숫자 제거
			
			if(index >= arrayList.size())	// 그리고 나서 제거한 숫자가 arrayList의 마지막 숫자인 경우
			{
				index = 0;	// 맨 앞으로 이동
			}
			
		}
		
		System.out.print("<");
		
		while(!queue.isEmpty())	// 큐가 비어있지 않을 때 까지 반복
		{
			if(queue.size() == 1)
			{
				System.out.println(queue.poll() + ">");	// queue 의 맨 앞 숫자 삭제 및 반환
				continue;	// 반복문 다음 단계로 이동
			}
			
			System.out.print(queue.poll() + ", ");	// queue 의 맨 앞 숫자 삭제 및 반환
		}

	}

}
