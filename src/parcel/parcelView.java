package parcel;

import java.util.Arrays;
import java.util.Scanner;

public class parcelView {

    static Scanner sc = new Scanner(System.in);

    private ParcelRepository repository;

    public parcelView(){ this.repository = new ParcelRepository();}

    // 1. 택배 등록하기

//    void showParcels() {
//        System.out.println("========= 현재 회원 목록 (총 %d명) ==========\n");
//        for (Parcel p : repository.getParcelList()) {
//            System.out.println(p);
//        }
//    }
    // 1. 택배 등록하기

    static boolean inputUser() {

        System.out.println("보내는 분 - 보내시는 고객님의 정보를 정확히 입력해 주세요.");
        System.out.println("이름을 입력해주세요.");
        String senderName = sc.next();
        System.out.println("주소를 입력해주세요");
        String senderAddress = sc.next();
        System.out.println("연락처를 입력해주세요.");
        String senderNumber = sc.next();

        System.out.println("받는 분 - 받으시는 고객님의 정보를 정확히 입력해 주세요.");
        System.out.println("이름을 입력해주세요.");
        String recipientName = sc.next();
        System.out.println("주소를 입력해주세요");
        String recipientAddress = sc.next();
        System.out.println("연락처를 입력해주세요.");
        String recipientNumber = sc.next();

        System.out.println("상품 정보 - 상품 정보를 정확히 입력해 주세요.");
        System.out.println("상품명 입력해주세요.");
        String productName = sc.next();
        System.out.println("상품가격을 입력해주세요");
        int productValue = Integer.parseInt(sc.next());
        System.out.println("상품 크기를 입력해주세요.");
        String productSize = sc.next();

        System.out.println("입력하신 정보가 맞는지 확인해주세요.");
        System.out.println("보내는 분 -");
        System.out.printf("%s | %s | %s\n", senderName, senderAddress, senderNumber);
        System.out.println("받는 분 -");
        System.out.printf("%s | %s | %s\n", recipientName, recipientAddress, recipientNumber);
        System.out.println("상품 정보 -");
        System.out.printf("%s | %s | %s\n", productName, productValue, productSize);

        System.out.println("입력하신 정보대로 택배를 접수하시겠습니까? True / False");

        String selectExit = sc.next();

        Parcel newParcel;
        if (selectExit.toUpperCase().contains("T")) {
            System.out.println("택배가 접수되었습니다.");
            Sender newSender = new Sender(senderName, senderAddress, senderNumber);
            Recipient newRecipient = new Recipient(recipientName, recipientAddress, recipientNumber);
            ProductInfo newProductInfo = new ProductInfo(productName, productValue, productSize);
            newParcel = new Parcel(0001, newSender, newRecipient, newProductInfo, "접수완료", 100);

            ParcelRepository.getParcelList().push(newParcel);

            return true;
        } else if (selectExit.toUpperCase().contains("F")) {
            return false;
        } else {
            return false;
        }



        // 유저객체에 입력받은 회원정보 넣기
        //User newUser = new User(email, userName, password);

        //ur.addUser(newUser);

    }

    // 3. 프로그램 종료 메서드
    static Boolean exitProgram(){
        System.out.println("프로그램을 종료하시겠습니까? True / False");
        String selectExit = sc.next();

        if (selectExit.toUpperCase().contains("T")){
            return true;
        } else if (selectExit.toUpperCase().contains("F")) {
            return false;
        } else {
            return false;
        }
    }

    // 0. 메뉴조회 및 사용할 메뉴 선택
    static String showMenu(){
        System.out.println(" ===== 택배 등록 =====");
        System.out.println("1. 택배 등록");
        System.out.println("3. 프로그램 종료");

        System.out.println("이용하실 메뉴번호를 입력해주세요!");
        return sc.nextLine();
    }

    // 0-1. 메뉴 선택에 따른 메서드 연결
    static void run(){
        while (true) {
            String selectNumber = showMenu();

            switch (selectNumber){
                case "1": // 택배등록
                    inputUser();
                    break;
                case "2": // 택배조회
                    //showParcels();
                    break;
                case "3": // 프로그램 종료
                    boolean exit = exitProgram();
                    if (exit) return;
            }
        }
    }





    static void input2(){
        //System.out.printf("# %s님이 %s일 선불택배를 접수하셨습니다.",
               // PC.Sender.senderName,
                //PC.regDate);
        System.out.println("운송장 번호 : ");
        System.out.println("보내는 분 : ");
        System.out.println("받는 분 : ");
        System.out.println("상품정보 : ");
        System.out.println("배송비 : ");

        System.out.println("운송장번호 1번 택배 센터입고하시겠습니까? (y/n)");
        System.out.println("직원콩떡이가 운송장번호 1번 택배의 입고를 수락했습니다.");
        System.out.println("직원콩떡이가 운송장번호 1번 택배의 입고를 거절했습니다.");

        System.out.println("만득이가 센터에 입고된 운송장번호 1번 택배를 출고시켰습니다.");
        System.out.println("택배기사가 운송장번호 1번 택배를 인수했습니다.");
        System.out.println("택배기사가 운송장번호 1번 택배를 배달중입니다.");

        System.out.println("고객 팥돌이가 운송장번호 1번 택배를 수령했습니다.");
        System.out.println("배달이 완료되었습니다.");
    }






}
