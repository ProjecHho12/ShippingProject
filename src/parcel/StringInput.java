package parcel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class StringInput implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient BufferedReader reader;

    public StringInput() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    // 문자열을 입력 받고, 공백은 입력받지 않음
    public String inputString(String message) {
        String inputString = null;

        while (true) {
            System.out.println(message);

            try {
                inputString = reader.readLine();
            } catch (IOException e) {
                System.out.println("입력할 수 없습니다.");
            }

            if (inputString == null || inputString.trim().isEmpty()) {
                System.out.println("공백은 입력할 수 없습니다 !");
            } else {
                System.out.println(" \n");
                break;
            }
        }

        return inputString;
    }
}

//    // 정수만 입력받고, 공백은 입력받지 않음, 저장은 문자열타입으로 받음
//    public String inputInt(String message) {
//
//        String inputInt = null;
//        System.out.println(message);
//        while (sc.hasNext()) {
//            inputInt = sc.nextLine();
//            if (inputInt == null || inputInt.trim().isEmpty()){
//                System.out.println("공백은 입력할 수 없습니다 !");
//            } else if (sc.hasNextInt()) {
//                break;
//            } else {
//                System.out.println("숫자만 입력해주세요 !");
//            }
//        }
//        return inputInt;
//    }

