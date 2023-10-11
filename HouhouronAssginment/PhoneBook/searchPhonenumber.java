package PhoneBook;

import java.util.Scanner;

class InputPhoneNumber {
    private String name;
    private String number;

    public InputPhoneNumber(String name, String number) {  //이름과 전화번호를 모아서 저장 해놓은 constructor
        this.name = name;
        this.number = number;
    }

    public String getName() {  //입력받은 이름을 저장
        return name;
    }

    public String getNumber() {  //입력받은 번호를 저장
        return number;
    }
}

class PhoneBook {
    private InputPhoneNumber[] numbers;  // Object Array
    private int maxSize;	// ┌ Array의 최대길이
    private int size;		// └ Array 번호

    public PhoneBook(int maxSize) {
        this.maxSize = maxSize;
        this.numbers = new InputPhoneNumber[maxSize]; //이름과 번호가 저장되는 Array
        this.size = 0;
    }

    public void addNumber(InputPhoneNumber number) {
        if (size < maxSize) {
            numbers[size] = number;  //이름과 번호가 저장되는 Array
            size++;
        } else {
            System.out.println("저장을 완료했습니다.");
        }
    }

    public InputPhoneNumber findNumber(String name) {
        for (int i = 0; i < size; i++) {
            if (numbers[i].getName().equals(name)) {  // Array에 저장된 이름과 찾는 이름이 일치하는 지 확인
                return numbers[i];					  // 같을 경우 numbers Array를 리턴
            }
        }
        return null; //입력된 값 이외에는 null 반환
    }
}

public class searchPhonenumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("저장할 연락처 수 >> ");
        int maxSize = scan.nextInt(); // 입력받을 연락처 수
        PhoneBook pB = new PhoneBook(maxSize);  // 연락처가 저장되는 Array
        scan.nextLine(); // 개행문자 처리

        for (int i = 0; i < maxSize; i++) {
            System.out.print("이름과 전화번호를 입력하세요 (ex. 홍길동 <Enter[space bar금지]> 010-1234-1234): ");
            String name = scan.nextLine(); // 이름입력
            String number = scan.nextLine(); //번호입력
            InputPhoneNumber iNumber = new InputPhoneNumber(name, number); //inputNumber - 연락처 입력
            pB.addNumber(iNumber); // 연락처 추가
        }

        while (true) {
            System.out.print("번호를 검색할 이름 >> ");
            String search = scan.nextLine(); // 번호를 찾을 이름입력
            if (search.equals("종료")) { // '종료'가 입력되면 프로그램 종료
                break;
            }
            InputPhoneNumber fNumber = pB.findNumber(search); // foundNumber - 번호찾기 완료
            if (fNumber != null) { // 저장된 연락처 검색 시 fNumber가 null값을 가지지 않음
                System.out.println(fNumber.getName() + "의 번호는 " + fNumber.getNumber());
            } else{
                System.out.println("없는 연락처입니다.");
            }
        }
    }
}
