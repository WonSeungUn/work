package kosa.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferExam {

	public static void main(String[] args) {
		// Scanner => 키보드로부터 데이터 입력받음
		// System.in => InputStream(바이트스트림) 과 연결되어 있음.
		// 문자스트림으로 바꾸고 싶다면 InputStreamReader 사용
		// => BufferedReader => 키보드로부터 입력받은 데이터를 연결받음 => 필터스트림 => 기존의 스트림과 연결하여 사용해야함.

//		InputStream in = System.in;
//		InputStreamReader isr = new InputStreamReader(in);
//		BufferedReader br = new BufferedReader(isr);

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new FileWriter("output.txt"));

			System.out.print("입력: ");
			String str = "";
			while ((str = br.readLine()) != null) {
				str += "\n";
				bw.write(str);
			}
			System.out.println("쓰기 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
