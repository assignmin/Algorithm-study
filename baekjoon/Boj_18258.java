package study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_18258 {

	public static void main(String[] args) throws IOException {
		
		int N;	// 명령 수
		int latest = 0;	// 가장 최근에 push한 숫자
		String instruction = null;	// 명령 한 줄
		String[] parse = null;	// 명령과 숫자를 구분하여 받을 문자열 배열
		
		Queue<Integer> queue = new LinkedList<> ();	// 큐
		
		// 입출력 최적화
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 명령 수
		N = Integer.parseInt(bf.readLine());
		
		// 문자열을 효율적으로 조합하기 위한 StringBuilder 객체
		StringBuilder sb = new StringBuilder();
		
		// 명령 입력
		for(int i = 0; i < N; i++)
		{
			instruction = bf.readLine();
			
			// 명령 분리
			parse = instruction.split(" ");
			
			// 명령이 push 인 경우
			if(parse[0].equals("push"))
			{
				// 큐에 넣을 숫자 변환 후, 큐에 삽입
				latest = Integer.parseInt(parse[1]);
				queue.offer(latest);
			
			}
			// 명령이 pop 인 경우
			else if(parse[0].equals("pop"))
			{
				// 큐가 비어있는지 확인
				if(queue.isEmpty())
				{
					// sb에 문자열 추가
					sb.append("-1\n");
				}
				else
				{
					// sb에 문자열 추가
					sb.append(queue.poll()).append("\n");
				}
			}
			// 명령이 size 인 경우
			else if(parse[0].equals("size"))
			{
				// sb에 문자열 추가
				sb.append(queue.size()).append("\n");
			}
			// 명령이 empty 인 경우
			else if(parse[0].equals("empty"))
			{
				// 큐가 비어있는지 확인
				if(queue.isEmpty())
				{
					// sb에 문자열 추가
					sb.append("1\n");
				}
				else
				{
					// sb에 문자열 추가
					sb.append("0\n");
				}
			}
			// 명령이 front 인 경우
			else if(parse[0].equals("front"))
			{
				// 큐가 비어있는지 확인
				if(queue.isEmpty())
				{
					// sb에 문자열 추가
					sb.append("-1\n");
				}
				else
				{
					// sb에 문자열 추가
					sb.append(queue.peek()).append("\n");
				}
			}
			// 명령이 back 인 경우
			else if(parse[0].equals("back"))
			{
				// 큐가 비어있는지 확인
				if(queue.isEmpty())
				{
					// sb에 문자열 추가
					sb.append("-1\n");
				}
				else
				{
					// sb에 문자열 추가
					sb.append(latest).append("\n");
				}
			}
		}
		
		// sb의 내용을 write(write() 메서드는 Object 클래스를 받지 않으므로 toString()메서드 호출)
		br.write(sb.toString());
		
		// 버퍼 출력 후, 닫기
		br.flush();
		br.close();
		bf.close();

	}

}
