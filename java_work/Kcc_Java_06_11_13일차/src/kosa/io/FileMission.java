package kosa.io;

import java.io.File;

public class FileMission {
	public static void main(String[] args) {
		// 1. 바이트스트림을 이용하여 이미지 파일을 복사해보자.
//		String source = "C:\\Users\\KOSA\\OneDrive\\바탕 화면\\자소서사진.jpg";
//		String dest = "C:\\Users\\KOSA\\OneDrive\\바탕 화면\\UML\\www.jpg";
//		File origin  = new File(source);
//		File copy = new File(dest);
//		CopyUtil.copyFile(origin, copy);
		
		// 2. 디렉토리 복사를 구현
		String source = "C:\\Users\\KOSA\\OneDrive\\바탕 화면\\공부용 사진";
		String dest = "C:\\Users\\KOSA\\OneDrive\\바탕 화면\\UML\\공부용 사진";
		File origin  = new File(source);
		File copy = new File(dest);
		CopyUtil.copyDirectory(origin, copy);
	}
}
