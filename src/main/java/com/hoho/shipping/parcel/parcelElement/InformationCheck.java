package com.hoho.shipping.parcel.parcelElement;

import com.hoho.shipping.parcel.StringInput;

public interface InformationCheck<T> {

    StringInput si = new StringInput();

    // 정보 체크 대상을 넣어줄 기능
    // 보내는 사람 & 받는 사람 & 상품 정보
    T CheckTarget ();

    // 택배의 정보들을 체크할 수 있는 기능
    default T checkInfo() {
        // 정보 확인
        T object = CheckTarget();
        System.out.println(" 입력하신 정보가 맞는지 확인해주세요.");
        System.out.printf("* ---------------------------------- *\n%s\n", object);
        while (true) {
            String inputCheck = si.inputString("- 입력하신 정보가 맞으면 True 를 입력해주세요.\n- 다시 입력하시려면 False 를 입력해주세요.");
            if (inputCheck.toUpperCase().contains("T")) {
                System.out.println("입력하신 내용이 저장되었습니다.");
                break;
            } else if (inputCheck.toUpperCase().contains("F")) {
                CheckTarget();
            } else {
                System.out.println("True 또는 False 를 입력해 주세요!");
            }
        }
        return object;
    }


}
