package kcc.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Manager {
	ArrayList<PhoneInfo> arr;
	int count;

	public Manager() {
//		arr = new PhoneInfo[10];
		arr = new ArrayList<PhoneInfo>();
	}

	public void addPhoneInfo() {
		System.out.println("1. 일반 2. 회사 3. 동창");
		String menu = DataInput.sc.nextLine();
		switch (menu) {
		case "1":
			System.out.print("이름 :");
			String name = DataInput.sc.nextLine();
			System.out.print("전화번호 :");
			String phoneNo = DataInput.sc.nextLine();
			System.out.print("생년월일 :");
			String birth = DataInput.sc.nextLine();

			// 생성자를 배열안으로 대입할 수 있다!
			arr.add(new PhoneInfo(name, phoneNo, birth));
			break;
		case "2":
			System.out.print("부서명 :");
			String dept = DataInput.sc.nextLine();
			System.out.print("직책명 :");
			String position = DataInput.sc.nextLine();
			System.out.print("이름 :");
			name = DataInput.sc.nextLine();
			System.out.print("전화번호 :");
			phoneNo = DataInput.sc.nextLine();
			System.out.print("생년월일 :");
			birth = DataInput.sc.nextLine();
			arr.add(new Company(name, phoneNo, birth, dept, position));
			System.out.println(arr);
			break;
		case "3":
			System.out.print("전공명 :");
			String major = DataInput.sc.nextLine();
			System.out.print("학번 :");
			String year = DataInput.sc.nextLine();
			System.out.print("이름 :");
			name = DataInput.sc.nextLine();
			System.out.print("전화번호 :");
			phoneNo = DataInput.sc.nextLine();
			System.out.print("생년월일 :");
			birth = DataInput.sc.nextLine();
			arr.add(new Universe(name, phoneNo, birth, major, year));
			System.out.println(arr);
			break;
		}

	}

	public void listPhoneInfo() {
		System.out.println("1. 일반 2. 회사 3. 동창");
		String menu = DataInput.sc.nextLine();
		switch (menu) {
		case "1":
			Iterator<PhoneInfo> iter = arr.iterator();
			while (iter.hasNext()) {
				iter.next().show();
			}
			
			break;
		case "2":
			Iterator<PhoneInfo> iter2 = arr.iterator();
			while (iter2.hasNext()) {
				PhoneInfo c = iter2.next();
				if (c instanceof Company) {
					c.show();
				}
			}
			break;
		case "3":
			Iterator<PhoneInfo> iter3 = arr.iterator();
			while (iter3.hasNext()) {
				PhoneInfo u = iter3.next();
				if (u instanceof Universe) {
					u.show();
				}
			}
			break;
		}
	}

	public void searchPhoneInfo() {
		// 검색하고자하는 이름으로 1개의 PhoneInfo 객체의 내용을 출력한다.
		System.out.println("이름을 입력해주세요");
		String name = DataInput.sc.nextLine();
		int index = -1;
		for (int i = 0; i < arr.size(); i++) {
			if (name.equals(arr.get(i).getName())) {
				arr.get(i).show();
				System.out.println(arr.get(i));
				index = i;
				System.out.println(index);
			}
		}

		if (index == -1) {
			System.out.println("검색하신 이름은 존재하지 않습니다.");
		}
	}

	public void updatePhoneInfo() {
		// 이름을 입력 => 해당 phoneInfo 추출 => 수정 전화번호 입력 => 전화번호 수정이 완료
		System.out.println("이름을 입력해주세요");
		String name = DataInput.sc.nextLine();
		int index = -1;
		for (int i = 0; i < arr.size(); i++) {
			if (name.equals(arr.get(i).getPhoneNo())) {
				System.out.println("바꾸실 전화번호를 입력해주세요");
				String change = DataInput.sc.nextLine();
				arr.get(i).setPhoneNo(change);
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("해당 이름은 존재하지 않습니다.");
		}

	}

	public void deletePhoneInfo() {
		// 이름 입력 => 대상 객체 검색 => 인덱스 찾기 => 해당 객체 삭제
		System.out.print("삭제할 이름: ");
		String temp = DataInput.sc.nextLine();
		int num = -1;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).name.equals(temp)) {
				num = i;
			}
		}

		if (num == -1) {
			System.out.println("해당 이름은 존재하지 않습니다.");
		} else {
//			for (int i = num; i < count; i++) {
//				if (i == arr.length - 1) {
//					arr[i] = null;
//				} else {
//					arr[i] = arr[i + 1];
//				}
//			}
//			count--;
			arr.remove(num);
		}

	}

	// 정렬
	public void phoneSort() {
		System.out.println("1. 일반 2. 회사 3. 동창");
		String input = DataInput.sc.nextLine();
		switch (input) {
		case "1":
			System.out.println("1. 이름별로 오름차순하기 2. 이름별로 내림차순하기 3. 나이 적은 순서대로 4. 나이 많은 순서대로");
			String key = DataInput.sc.nextLine();
			switch (key) {
			case "1":
				Collections.sort(arr, new Comparator<PhoneInfo>() {
					// 이름순으로 오름차순 (가 -> 하)
					@Override
					public int compare(PhoneInfo o1, PhoneInfo o2) {
						if (o1.getName().compareTo(o2.getName()) < 0) {
							return -1;
						} else if (o1.getName().compareTo(o2.getName()) > 0) {
							return 1;
						}
						return 0;
					}
				});
				break;
			case "2":
				Collections.sort(arr, new Comparator<PhoneInfo>() {
					// 이름순으로 내림차순(하 -> 가)
					@Override
					public int compare(PhoneInfo o1, PhoneInfo o2) {
						if (o1.getName().compareTo(o2.getName()) > 0) {
							return -1;
						} else if (o1.getName().compareTo(o2.getName()) < 0) {
							return 1;
						}
						return 0;
					}
				});
				break;
			case "3":
				Collections.sort(arr, new Comparator<PhoneInfo>() {
					// 나이 적은 순서대로
					@Override
					public int compare(PhoneInfo o1, PhoneInfo o2) {
						if (o1.getBirth().compareTo(o2.getBirth()) > 0) {
							return -1;
						} else if (o1.getBirth().compareTo(o2.getBirth()) < 0) {
							return 1;
						}
						return 0;
					}
				});
				break;
			case "4":
				Collections.sort(arr, new Comparator<PhoneInfo>() {
					// 나이 많은 순서대로
					@Override
					public int compare(PhoneInfo o1, PhoneInfo o2) {
						if (o1.getBirth().compareTo(o2.getBirth()) > 0) {
							return 1;
						} else if (o1.getBirth().compareTo(o2.getBirth()) < 0) {
							return -1;
						}
						return 0;
					}
				});
				break;
			}
			break;
		
		}
	}

	public void phoneDataSave() {
		// phoneInfo 객체 불러오기. -> 객체를 file로 저장시키기..! (분류..? 할까?)
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("phone.txt"));
			oos.writeObject(arr);
			System.out.println("데이터 저장 완료");
		} catch (Exception e) {
			System.out.println("데이터 저장 실패");
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void phoneDataLoad() {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("phone.txt"));
			arr = (ArrayList<PhoneInfo>) ois.readObject();
			System.out.println("불러오기 완료");
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
