package parcel;

import parcel.Tr.TrackingNumber;

import java.util.*;

import static java.util.Comparator.comparing;

public class ParcelView {

    static Scanner sc = new Scanner(System.in);

    // 객체의 협력
    static ParcelRepository repository;

    //TrackingNumber trackingNumber;

    public ParcelView() {
        // 객체의 협력을 하기 위해선 객체를 생성해줘야 한다.
        this.repository = new ParcelRepository();
    }



    static boolean inputParcelInformation() {

        // 보내는 분 정보 입력
        System.out.println("보내는 분 - 보내시는 고객님의 정보를 정확히 입력해 주세요.");
        String SenderName;
        while (true) {
            System.out.println("이름을 입력해주세요. (10자 이하)");
            SenderName = sc.next();
            if (SenderName.length() <= 10) {
                break;
            } else {
                System.out.println("이름은 10자 이하로 적어주세요");
            }
        }

        System.out.println("주소 - 보내시는 고객님의 주소를 정확히 입력해 주세요.");
        TrackingNumber locals = null;
        TrackingNumber SenderAddressStateProvinceRegion;
        while (true) {
            System.out.println("광역시/도 를 입력해주세요 ex) 서울, Seoul");
            String local = sc.next();

            try {
                for (TrackingNumber m : TrackingNumber.values()) {
                    if (m.getNames().contains(local.toUpperCase())) {
                        locals = m;
                    }
                }
                TrackingNumber v1 = TrackingNumber.valueOf(String.valueOf(locals));

                if (v1 == locals) {
                    // System.out.println("1번 " + locals); // SEOUL
                    //System.out.println("2번 " + locals.getCode()); // 002
                    SenderAddressStateProvinceRegion = locals;
                    String SenderLocalNumber = locals.getCode();
                    break;
                } else {
                    System.out.println("정확한 지역명을 입력해주세요!");
                }
            } catch (Exception e) {
                System.out.println("정확한 지역명을 입력해주세요");
            }
        }
        System.out.println("시/군/구 를 입력해주세요.");
        String SenderAddressCity = sc.next();
        System.out.println("나머지 주소를 입력해주세요.");
        String SenderAddressStreetAddress = sc.next();
        System.out.println("우편번호를 입력해주세요.");
        String SenderAddressZipPostalCode = sc.next();

        System.out.println("연락처를 입력해주세요.");
        String SenderNumber = sc.next();


        // 받는 분 정보 입력
        System.out.println("받는 분 - 받으시는 고객님의 정보를 정확히 입력해 주세요.");
        String RecipientName;
        while (true) {
            System.out.println("이름을 입력해주세요. (10자 이하)");
            RecipientName = sc.next();
            if (RecipientName.length() <= 10) {
                break;
            } else {
                System.out.println("이름은 10자 이하로 적어주세요");
            }
        }

        System.out.println("주소 - 보내시는 고객님의 주소를 정확히 입력해 주세요.");
        TrackingNumber locals1 = null;
        TrackingNumber RecipientAddressStateProvinceRegion;
        while (true) {
            System.out.println("광역시/도 를 입력해주세요 ex) 서울, Seoul");
            String local1 = sc.next();

            try {
                for (TrackingNumber m : TrackingNumber.values()) {
                    if (m.getNames().contains(local1.toUpperCase())) {
                        locals1 = m;
                    }
                }
                TrackingNumber v2 = TrackingNumber.valueOf(String.valueOf(locals1));

                if (v2 == locals1) {
                    // System.out.println("1번 " + locals); // SEOUL
                    //System.out.println("2번 " + locals.getCode()); // 002
                    RecipientAddressStateProvinceRegion = locals1;
                    String RecipientLocalNumber = locals1.getCode();
                    break;
                } else {
                    System.out.println("정확한 지역명을 입력해주세요!");
                }
            } catch (Exception e) {
                System.out.println("정확한 지역명을 입력해주세요");
            }
        }
        System.out.println("시/군/구 를 입력해주세요.");
        String RecipientAddressCity = sc.next();
        System.out.println("나머지 주소를 입력해주세요.");
        String RecipientAddressStreetAddress = sc.next();
        System.out.println("우편번호를 입력해주세요.");
        String RecipientAddressZipPostalCode = sc.next();

        System.out.println("연락처를 입력해주세요.");
        String RecipientNumber = sc.next();


        // 보내는 상품 정보 입력
        System.out.println("상품 정보 - 상품 정보를 정확히 입력해 주세요.");
        System.out.println("상품명 입력해주세요.");
        String productName = sc.next();
        System.out.println("상품가격을 입력해주세요");
        int productValue = Integer.parseInt(sc.next());
        System.out.println("상품 크기를 입력해주세요.");
        String productSize = sc.next();

        System.out.println("입력하신 정보가 맞는지 확인해주세요.");
        System.out.println("보내는 분 -");
        System.out.printf("%s\n%s %s %s %s\n%s\n",
                SenderName,
                SenderAddressStateProvinceRegion, SenderAddressCity, SenderAddressStreetAddress, SenderAddressZipPostalCode,
                SenderNumber);

        System.out.println("받는 분 -");
        System.out.printf("%s\n%s %s %s %s\n%s\n",
                RecipientName,
                RecipientAddressStateProvinceRegion, RecipientAddressCity, RecipientAddressStreetAddress, RecipientAddressZipPostalCode,
                RecipientNumber);

        System.out.println("상품 정보 -");
        System.out.printf("%s | %s | %s\n", productName, productValue, productSize);

        System.out.println("입력하신 정보대로 택배를 접수하시겠습니까? True / False");

        String selectExit = sc.next();


        if (selectExit.toUpperCase().contains("T")) {
            System.out.println("택배가 접수되었습니다.");
            // 보내는 분
            SenderAddress newsenderaddress = new SenderAddress(SenderAddressStateProvinceRegion, SenderAddressCity, SenderAddressStreetAddress, SenderAddressZipPostalCode);
            Sender newsender = new Sender(SenderName, newsenderaddress, SenderNumber);

            // 받는 분
            RecipientAddress newrecipientAddress = new RecipientAddress(RecipientAddressStateProvinceRegion, RecipientAddressCity, RecipientAddressStreetAddress, RecipientAddressZipPostalCode);
            Recipient newrecipient = new Recipient(RecipientName, newrecipientAddress, RecipientNumber);

            // 상품 정보
            ProductInfo newproductinfo = new ProductInfo(productName, productValue, productSize);

            // 운송장번호
            // 보내는 분 지역번호 3자리
            String SenderLocalNumber = locals.getCode();
            // 받는 분 지역번호 3자리
            String RecipientLocalNumber = locals1.getCode();
            // 남은 뒷자리 4자리는 배열에 남은 택배길이
            String lastNumber = String.format("%04d", repository.getParcelArray().length + 1);

            // 최종 운송장 번호
            String Number = SenderLocalNumber.concat(RecipientLocalNumber).concat(lastNumber);


            // 입력된 데이터 기반으로 하나의 객체 생성
            Parcel newParcel = new Parcel(Number, newsender, newrecipient, newproductinfo, "접수완료", 1000);
            // 생성된 개체를 배열에 저장
            repository.addParcelInformation(newParcel);

            return true;
        } else if (selectExit.toUpperCase().contains("F")) {
            return false;
        } else {
            return false;
        }

    }

    // 2. 접수된 모든 택배 조회
    static void showParcelArray() {
        System.out.printf("현재 접수된 택배 목록입니다. (총%d개)\n", repository.getParcelArray().length);
        // 단축키 iter
        for (Parcel parcel : repository.getParcelArray()) {
            System.out.println(parcel);
        }
        System.out.println("안녕");
    }

    // 4. 프로그램 종료 메서드
    static Boolean exitProgram() {
        System.out.println("프로그램을 종료하시겠습니까? True / False");
        String selectExit = sc.next();

        if (selectExit.toUpperCase().contains("T")) {
            return true;
        } else if (selectExit.toUpperCase().contains("F")) {
            return false;
        } else {
            return false;
        }
    }

    // 0. 메뉴조회 및 사용할 메뉴 선택
    static String showMenu() {
        System.out.println(" ===== 택배 등록 =====");
        System.out.println("1. 택배 등록");
        System.out.println("2. 택배 조회");
        System.out.println("3. 프로그램 종료");

        System.out.println("이용하실 메뉴번호를 입력해주세요!");
        return sc.nextLine();
    }

    // 0-1. 메뉴 선택에 따른 메서드 연결
    static void pacelrun() {
        while (true) {
            String selectNumber = showMenu();

            switch (selectNumber) {
                case "1": // 택배 등록
                    inputParcelInformation();
                    break;
                case "2": // 택배 조회
                    showParcelArray();
                    break;
                case "3": // 택배운송
                    break;
                case "4": // 프로그램 종료
                    boolean exit = exitProgram();
                    if (exit) return;
                default:
                    System.out.println("메뉴번호를 정확히 입력해 주세요.");

            }
        }
    }


//    static void input2() {
//        //System.out.printf("# %s님이 %s일 선불택배를 접수하셨습니다.",
//        // PC.Sender.senderName,
//        //PC.regDate);
//        System.out.println("운송장 번호 : ");
//        System.out.println("보내는 분 : ");
//        System.out.println("받는 분 : ");
//        System.out.println("상품정보 : ");
//        System.out.println("배송비 : ");
//
//        System.out.println("운송장번호 1번 택배 센터입고하시겠습니까? (y/n)");
//        System.out.println("직원콩떡이가 운송장번호 1번 택배의 입고를 수락했습니다.");
//        System.out.println("직원콩떡이가 운송장번호 1번 택배의 입고를 거절했습니다.");
//
//        System.out.println("만득이가 센터에 입고된 운송장번호 1번 택배를 출고시켰습니다.");
//        System.out.println("택배기사가 운송장번호 1번 택배를 인수했습니다.");
//        System.out.println("택배기사가 운송장번호 1번 택배를 배달중입니다.");
//
//        System.out.println("고객 팥돌이가 운송장번호 1번 택배를 수령했습니다.");
//        System.out.println("배달이 완료되었습니다.");
//    }


}
