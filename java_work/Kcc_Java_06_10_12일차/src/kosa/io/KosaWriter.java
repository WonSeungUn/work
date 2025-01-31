package kosa.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KosaWriter {
	public static void main(String[] args) {
		// 키보드로부터 문자열을 입력 받아 파일에 쓰는 예제 구현
		// "q"를 입력하기 전까지 문자열을 파일에 쓰도록 하자
		// FileWriter : write(문자열)
		// 파일명 : poem2.txt : 미리생성
		// 코드 실행 후 refresh => 파일 생성 확인 가능
		// close() 구현
		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		try {
			fw = new FileWriter("poem2.txt");
			while(true) {
				String s = sc.nextLine();
				if(s.equals("q")) {
					break;
				}
				fw.write(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
