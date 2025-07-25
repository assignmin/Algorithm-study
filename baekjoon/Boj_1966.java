package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Boj_1966 {

	// 큐를 구성할 인덱스와 중요도를 담은 문서, static 인 main 문에서 사용하기 위해 static 으로 선언
	static class Docs {
		
		int index;
		int imp;
		
		Docs(int index, int imp) {
			
			this.index = index;
			this.imp = imp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		int cNum;	// 케이스 수
		int N;	// 문서 수
		int target;	//찾고자 하는 문서 현재 위치
		int space;	// 공백 위치
		int index;	// 큐에 저장하기 위한 인덱스
		int out;	// 나간 문서의 수
		String caseNum = null;	// 케이스 수(문자열)
		String docs = null;	// 문서 수와 찾고자 하는 문서 현재 위치(문자열)
		String importance = null;	// 중요도(문자열)
		
		// 입력 최적화
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 한 줄 읽어오기
		caseNum = bf.readLine();
		
		// 케이스 수
		cNum = Integer.parseInt(caseNum);
		
		// 결과 담을 배열
		int[] result = new int[cNum];
		
		for(int i = 0; i < cNum; i++)
		{
			// 새 케이스마다 초기화
			index = 0;
			out = 1;
			
			// 한 줄 읽어오기
			docs = bf.readLine();
			
			// 공백 위치
			space = docs.indexOf(" ");
			
			// 공백을 기준으로 앞을 문서 수, 뒤를 찾고자 하는 문서 현재 위치로 분리
			N = Integer.parseInt(docs.substring(0,space));
			target = Integer.parseInt(docs.substring(space + 1));
			
			// 인덱스와 중요도를 담을 큐와 중요도를 역순(내림차순)으로 담을 우선순위 큐
			Queue<Docs> inImp = new LinkedList<> ();
			PriorityQueue<Integer> onlyImp = new PriorityQueue<> (Collections.reverseOrder());
			
			// 한 줄 읽어오기
			importance = bf.readLine();
			
			// 공백을 기준으로 분리
			String[] tokens = importance.split(" ");
			
			// tokens의 개수만큼 반복
			for(String token : tokens)
			{
				// 큐에 Docs 객체 넣고, 우선순위 큐에 중요도 삽입
				inImp.offer(new Docs(index++, Integer.parseInt(token)));
				onlyImp.offer(Integer.parseInt(token));
			}
			
			// 큐가 빌 때까지 반복
			while(!inImp.isEmpty())
			{
				// 큐에서 맨 앞의 요소 반환하면서 제거
				Docs document = inImp.poll();
				
				// 중요도가 서로 같은 경우
				if(document.imp == onlyImp.peek())
				{
					// 우선순위 큐에서 제거
					onlyImp.poll();
					
					// 인덱스가 같은 경우
					if(document.index == target)
					{
						result[i] = out;
						break;
					}
					
					// 나간 문서 수 증가
					out++;
				}
				else
				{
					// 다시 큐의 뒤에 삽입
					inImp.offer(document);
				}
				
			}
		}
		
		for(int j = 0; j < cNum; j++)
		{
			System.out.println(result[j]);
		}

	}

}
