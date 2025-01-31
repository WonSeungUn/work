package kosa.mission;

import java.util.Scanner;
import java.util.Stack;

public class StackMission {
	public static void main(String[] args) {
		// 키보드로부터 수학 수식을 입력
		// ((2+3)+10) => 괄호가 일치하는지 불일치하는지 판단
		Stack<String> stack = new Stack<String>();

		Scanner sc = new Scanner(System.in);

		// 키보드로부터 입력을 받는다.
		String input = sc.nextLine();

		// try catch 문을 쓰는 이유는 '(' 일 경우 stack에 push되고 ')' 일 경우 stack에 존재하는 '('가 pop이 되어 빠지는데
		// 만약 ')' 가 '(' 보다 더 많을 경우 이미 stack에는 존재하는 '('가 없는데 '('를 빼야되는 상황이 발생할 수 있으므로 
		// EmptyStackException 예외가 발생한다. 그러므로 예외 발생할 때 catch 절에 "괄호가 불일치 합니다"라는 문구를 주기 위해서 try catch 문 작성!
		try {
			// 키보드로부터 입력받은 문자를 하나씩 char에 넣는다.
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				// 키보드로부터 입력받은 문자 중에서 '(' 만 stack에 넣는다.
				if (c == '(') {
					// stack의 push의 경우 String만 들어갈 수 있기 때문에 char는 '' 이고 String은 "" 이기 때문에 char 뒤에 "" 붙여주기
					stack.push(c + "");
					// 키보드로부터 입력받은 문자 중에서 ')'이 나올 경우 stack에 존재하는 '('를 pop 해준다!
				} else if (c == ')') {
					stack.pop();
				}
			}
			// stack 안에 '('가 없다면 '('과 ')'의 수가 일치하기 때문에 올바른 괄호가 된다!
			if (stack.isEmpty()) {
				System.out.println("괄호가 일치하다.");
				// stack 안에 '('가 존재한다면 '('과 ')'의 수가 불일치하기 때문에 올바른 괄호가 아니다!
			} else {
				System.out.println("괄호가 불일치 하다");
			}
			// stack안에 '('가 존재하지 않는데 ')'가 나와 '('를 pop해야 하는 상황이 발생하면 예외가 발생하므로 예외처리해준다!
		} catch (Exception e) {
			System.out.println("괄호가 불일치 하다");
		}
	}
}
