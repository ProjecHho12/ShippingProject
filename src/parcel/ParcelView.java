package parcel;

import customer.Customer;
import parcel.parcelElement.*;

import java.util.*;

import static java.util.Comparator.comparing;

public class ParcelView {

    static Scanner sc = new Scanner(System.in);

    // 객체의 협력
    static ParcelRepository repository;
    Status status;

    public ParcelView() {
        // 객체의 협력을 하기 위해선 객체를 생성해줘야 한다.
        repository = new ParcelRepository();
    }

    public static ParcelRepository getRepository() {
        return repository;
    }

    // 1-1. 보내는 분 정보 입력
    static Sender inputSenderInfo() {

        System.out.println("보내는 분 - 보내시는 고객님의 정보를 정확히 입력해 주세요.");
        String SenderName;
        while (true) {
            System.out.println("이름을 입력해주세요. (5자 이하)");
            SenderName = sc.nextLine();
            if (SenderName.trim().isEmpty() || SenderName.length() >= 5) {
                System.out.println("이름은 공백을 제외한 다섯 글자 이하로 적어주세요!");
            } else {
                break;
            }
        }

        System.out.println("주소 - 보내시는 고객님의 주소를 정확히 입력해 주세요.");
        TrackingNumber senderLocal = null;
        TrackingNumber SenderAddressStateProvinceRegion;
        while (true) {
            System.out.println("광역시/도 를 입력해주세요. ex) 서울, 충청북도, BUSAN 등");
            String local = sc.nextLine();
            try {
                for (TrackingNumber t : TrackingNumber.values()) {
                    if (t.getNames().contains(local.toUpperCase()) || t.getNames().contains(local)) {
                        senderLocal = t;
                    }
                }
                TrackingNumber placeName = TrackingNumber.valueOf(String.valueOf(senderLocal));
                if (placeName == senderLocal) {
                    // System.out.println("1번 " + senderLocal); // SEOUL
                    //System.out.println("2번 " + senderLocal.getCode()); // 002
                    SenderAddressStateProvinceRegion = senderLocal;
                    break;
                } else {
                    System.out.println("광역시/도 에 해당하지 않습니다!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("광역시/도 에 해당하지 않습니다!");
            }
        }

        String SenderAddressCity;
        while (true) {
            System.out.println("시/군/구 를 입력해주세요.");
            SenderAddressCity = sc.nextLine();
            if (SenderAddressCity.trim().isEmpty()) {
                System.out.println("공백을 제외한 시/군/구를 입력해주세요!");
            } else if (!SenderAddressCity.matches(".*시|.*군|.*구")) {
                System.out.println("oo시 or oo군 or oo구 로 입력하셔야 합니다!");
            } else {
                break;
            }
        }

        String SenderAddressStreetAddress;
        while (true) {
            System.out.println("나머지 주소를 입력해주세요.");
            SenderAddressStreetAddress = sc.nextLine();
            if (SenderAddressStreetAddress.trim().isEmpty()) {
                System.out.println("공백을 제외하고 입력해주세요!");
            } else {
                break;
            }
        }

        String SenderAddressZipPostalCode;
        while (true) {
            System.out.println("우편번호를 입력해주세요. (5자리 숫자)");
            SenderAddressZipPostalCode = sc.nextLine();
            if (SenderAddressZipPostalCode.length() != 5) {
                System.out.println("우편번호는 다섯 자리로 입력하셔야 합니다!");
            } else {
                break;
            }
        }

        String SenderNumber;
        while (true) {
            System.out.println("연락처를 입력해주세요. ex)010-0000-0000");
            SenderNumber = sc.nextLine();
            if (SenderNumber.length() != 11) {
                System.out.println("연락처는 핸드폰 번호 11자리를 입력해야 합니다!");
            } else {
                break;
            }
        }

        // 반환 값 : 보내는 분 (이름, 주소, 전화번호)
        SenderAddress newsenderaddress = new SenderAddress(SenderAddressStateProvinceRegion, SenderAddressCity, SenderAddressStreetAddress, SenderAddressZipPostalCode);
        Sender newsender = new Sender(SenderName, newsenderaddress, SenderNumber); // 최종

        return newsender;
    }


    // 1-2. 보내는 분 정보 확인
    static void checkSenderInfo(Sender newsender) {

        System.out.println("입력하신 정보가 맞는지 확인해주세요.");
        System.out.println("보내는 분 -");
        System.out.printf("%s\n", newsender);

        while (true){
            System.out.println("이대로 저장하시겠습니까? True / False");
            String checkSender = sc.nextLine();

            if (checkSender.toUpperCase().contains("T")) {
                System.out.println("입력하신 내용이 저장되었습니다.");
                break;
            } else if (checkSender.toUpperCase().contains("F")) {
                inputSenderInfo();
            } else {
                System.out.println("True 또는 False 를 입력해 주세요!");
            }
        }
    }


    // 1-3. 받는 분 정보 입력
    static Recipient inputRecipientInfo() {

        System.out.println("받는 분 - 보내시는 고객님의 정보를 정확히 입력해 주세요.");
        String RecipientName;
        while (true) {
            System.out.println("이름을 입력해주세요. (5자 이하)");
            RecipientName = sc.nextLine();
            if (RecipientName.trim().isEmpty() || RecipientName.length() >= 5) {
                System.out.println("이름은 공백을 제외한 다섯 글자 이하로 적어주세요!");
            } else {
                break;
            }
        }

        System.out.println("주소 - 받으시는 고객님의 주소를 정확히 입력해 주세요.");
        TrackingNumber RecipientLocal = null;
        TrackingNumber RecipientAddressStateProvinceRegion;
        while (true) {
            System.out.println("광역시/도 를 입력해주세요 ex) 서울, 충청북도, BUSAN 등");
            String local = sc.nextLine();
            try {
                for (TrackingNumber t : TrackingNumber.values()) {
                    if (t.getNames().contains(local.toUpperCase()) || t.getNames().contains(local)) {
                        RecipientLocal = t;
                    }
                }
                TrackingNumber placeName = TrackingNumber.valueOf(String.valueOf(RecipientLocal));
                if (placeName == RecipientLocal) {
                    // System.out.println("1번 " + senderLocal); // SEOUL
                    //System.out.println("2번 " + senderLocal.getCode()); // 002
                    RecipientAddressStateProvinceRegion = RecipientLocal;
                    break;
                } else {
                    System.out.println("광역시/도 에 해당하지 않습니다!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("광역시/도 에 해당하지 않습니다!");
            }
        }

        String RecipientAddressCity;
        while (true) {
            System.out.println("시/군/구 를 입력해주세요.");
            RecipientAddressCity = sc.nextLine();
            if (RecipientAddressCity.trim().isEmpty()) {
                System.out.println("공백을 제외한 시/군/구를 입력해주세요!");
            } else if (!RecipientAddressCity.matches(".*시|.*군|.*구")) {
                System.out.println("oo시 or oo군 or oo구 로 입력하셔야 합니다!");
            } else {
                break;
            }
        }

        String RecipientAddressStreetAddress;
        while (true) {
            System.out.println("나머지 주소를 입력해주세요.");
            RecipientAddressStreetAddress = sc.nextLine();
            if (RecipientAddressStreetAddress.trim().isEmpty()) {
                System.out.println("공백을 제외하고 입력해주세요!");
            } else {
                break;
            }
        }

        String RecipientAddressZipPostalCode;
        while (true) {
            System.out.println("우편번호를 입력해주세요. (5자리 숫자)");
            RecipientAddressZipPostalCode = sc.nextLine();
            if (RecipientAddressZipPostalCode.length() != 5) {
                System.out.println("우편번호는 다섯 자리로 입력하셔야 합니다!");
            } else {
                break;
            }
        }

        String RecipientNumber;
        while (true) {
            System.out.println("연락처를 입력해주세요. ex)010-0000-0000");
            RecipientNumber = sc.nextLine();
            if (RecipientNumber.length() != 11) {
                System.out.println("연락처는 핸드폰 번호 11자리를 입력해야 합니다!");
            } else {
                break;
            }
        }

        // 반환 값 : 받는 분 (이름, 주소, 전화번호)
        RecipientAddress newrecipientAddress = new RecipientAddress(RecipientAddressStateProvinceRegion, RecipientAddressCity, RecipientAddressStreetAddress, RecipientAddressZipPostalCode);
        Recipient newrecipient = new Recipient(RecipientName, newrecipientAddress, RecipientNumber); // 최종

        return newrecipient;
    }


    // 1-4. 받는 분 정보 확인
    static void checkRecipientInfo(Recipient newrecipient) {

        System.out.println("입력하신 보내는 분 정보가 맞는지 확인해주세요.");
        System.out.println("받는 분 -");
        System.out.printf("%s", newrecipient);

        while (true) {
            System.out.println("이대로 진행하시겠습니까? True / False");
            String checkRecipient = sc.nextLine();

            if (checkRecipient.toUpperCase().contains("T")) {
                System.out.println("입력하신 내용이 저장되었습니다.");
                break;
            } else if (checkRecipient.toUpperCase().contains("F")) {
                inputRecipientInfo();
            } else {
                System.out.println("True 또는 False 를 입력해 주세요!");
            }
        }
    }


    // 1-5. 보내는 분, 받는 분 정보 기반으로 운송장 번호 만들기
    private static String makeTrackingNumber(Sender newsender, Recipient newrecipient) {

        // (10자리, 보내는 분 지역번호 3자리 / 받는 분 지역번호 3자리 / 택배배열 길이+1 4자리)
        // 보내는 분 지역번호 3자리
        String senderLocalNumber = newsender.getSenderAddress().getSenderAddressStateProvinceRegion().getCode();
        // 받는 분 지역번호 3자리
        String recipientLocalNumber = newrecipient.getRecipientAddress().getRecipientAddressStateProvinceRegion().getCode();
        // 남은 뒷자리 4자리는 배열에 남은 택배길이
        String lastNumber = String.format("%04d", repository.getParcelArray().length + 1);
        // 최종 운송장 번호
        String newTrackingNumber = senderLocalNumber.concat(recipientLocalNumber).concat(lastNumber);

        return newTrackingNumber;
    }


    // 1-6. 보내는 상품 정보 입력
    static ProductInfo inputProductInfo() {

        System.out.println("상품 정보 - 보내는 물건의 정보를 정확히 입력해 주세요.");
        String productName;
        while (true) {
            System.out.println("상품명을 입력해주세요.");
            productName = sc.nextLine();
            if (productName.trim().isEmpty()) {
                System.out.println("공백을 제외하고 입력해주세요.");
            } else {
                break;
            }
        }

        String productValue;
        while (true) {
            System.out.println("상품 가액을 입력해주세요");
            productValue = sc.nextLine();
            if (productValue.trim().isEmpty()) {
                System.out.println("공백을 제외하고 입력해주세요.");
            } else {
                break;
            }
        }

        ProductSize productSize = null;
        while (true) {
            System.out.println("상품 크기를 입력해주세요. (소, 중, 대, 특대형)");
            String size = sc.nextLine();
            for (ProductSize value : ProductSize.values()) {
                if (value.getKorName().equals(size)) {
                    productSize = ProductSize.valueOf(value.getKorName());
                    break;
                } else {
                    System.out.println("소형, 중형, 대형, 특대형 중 한가지를 써주세요!");
                }
            }
            break;
        }

        // 반환 값 : 보내는 상품 정보 (상품 명, 상품 가격, 상품 크기)
        ProductInfo newProductInfo = new ProductInfo(productName, productValue, productSize); // 최종
        return newProductInfo;
    }


    // 1-7. 보내는 상품 정보 확인
    static void checkProductInfo(ProductInfo newproductinfo) {

        System.out.println("입력하신 보내는 상품 정보가 맞는지 확인해주세요.");
        System.out.println("상품 정보 -");
        System.out.printf("%s", newproductinfo);

        while (true) {
            System.out.println("이대로 저장하시겠습니까? True / False");
            String checkProduct = sc.nextLine();
            if (checkProduct.toUpperCase().contains("T")) {
                System.out.println("입력하신 내용이 저장되었습니다.");
                break;
            } else if (checkProduct.toUpperCase().contains("F")) {
                inputProductInfo();
            } else {
                System.out.println("True 또는 False 를 입력해 주세요!");
            }
        }
    }


    // 1-8. 입력된 정보를 바탕으로 객체 생성
    static Parcel saveParcel(String newTrackingNumber, Sender newsender, Recipient newrecipient, ProductInfo
            newproductinfo) {

        Parcel newParcel = new Parcel(newTrackingNumber, newsender, newrecipient, newproductinfo, Status.INCOMING, 1000);

        return newParcel;
    }


    // 1-9. 택배 접수하기
    static void receiptParcel(Parcel saveParcel) {
        // 생성된 개체를 배열에 저장
        repository.addParcelInformation(saveParcel);

        // 택배 배열을 생성한 메모장 파일에 집어넣기
        repository.saveParcelArrayFile(saveParcel);

        System.out.println("택배가 접수되었습니다.");

        // 접수 된 내역 보여주기
        System.out.println(Arrays.toString(repository.getParcelArray()));
    }


    // 1-10. 택배 등록 최종 메소드
    public static void startInputParcel(Customer tar) {

        // 보내는 분 정보입력 & 확인 메소드 호출
        Sender finalSender = inputSenderInfo();
        checkSenderInfo(finalSender);
        // 받는 분 정보입력 & 확인 메소드 호출
        Recipient finalRecipient = inputRecipientInfo();
        checkRecipientInfo(finalRecipient);
        // 운송장 번호 생성 메소드 호출
        String finalTrackingNumber = makeTrackingNumber(finalSender, finalRecipient);
        // 상품 정보입력 & 확인 메소드 호출
        ProductInfo finalProductInfo = inputProductInfo();
        // 입력된 정보를 바탕으로 객체 생성 메소드 호출
        Parcel finalParcel = saveParcel(finalTrackingNumber, finalSender, finalRecipient, finalProductInfo);
        // 접수완료 및 외부저장소 저장 메소드 호출
        receiptParcel(finalParcel);
    }


    // 2. 접수된 모든 택배 조회
    public static void showParcelArray() {

        System.out.printf("현재 접수된 택배 목록입니다. (총%d개)\n", repository.getParcelArray().length);
        // 단축키 iter
        for (Parcel parcel : repository.getParcelArray()) {
            System.out.println(parcel);
        }

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
        System.out.println("3. 택배 운송");
        System.out.println("4. 프로그램 종료");

        System.out.println("이용하실 메뉴번호를 입력해주세요!");
        return sc.nextLine();
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