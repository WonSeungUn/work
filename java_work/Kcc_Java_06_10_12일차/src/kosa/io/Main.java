package kosa.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	Member m;
	
	// ��ü ����ȭ
	public void insert() {
		m = new Member("ȫ�浿", 20, new Video(1, "�����Ǻ�", "���켺"));
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
			oos.writeObject(m);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception e2) {

			}
		}
	}
	
	
	// ��ü ������ȭ
	public void show() {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("object.txt"));
			m = (Member)ois.readObject();
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.insert();
		
		
		main.m = null;
		main.show();
		
		System.out.println(main.m);
	}
}
