package parcel;

import customer.Customer;
import parcel.parcelElement.*;

import java.io.*;
import java.util.*;

import static java.util.Comparator.comparing;

public class ParcelView {

    static Scanner sc = new Scanner(System.in);

    // 객체의 협력
    static ParcelRepository repository;

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
            System.out.println("이름을 입력해주세요. (10자 이하)");
            SenderName = sc.next();
            if (SenderName.length() <= 10) {
                break;
            } else {
                System.out.println("이름은 10자 이하로 적어주세요");
            }
        }

        System.out.println("주소 - 보내시는 고객님의 주소를 정확히 입력해 주세요.");
        TrackingNumber senderLocal = null;
        TrackingNumber SenderAddressStateProvinceRegion;

        while (true) {
            System.out.println("광역시/도 를 입력해주세요 ex) 서울, Seoul");
            String local = sc.next();

            try {
                for (TrackingNumber t : TrackingNumber.values()) {
                    if (t.getNames().contains(local.toUpperCase())) {
                        senderLocal = t;
                    }
                }
                TrackingNumber placeName = TrackingNumber.valueOf(String.valueOf(senderLocal));

                if (placeName == senderLocal) {
                    // System.out.println("1번 " + senderLocal); // SEOUL
                    //System.out.println("2번 " + senderLocal.getCode()); // 002
                    SenderAddressStateProvinceRegion = senderLocal;
                    String SenderLocalNumber = senderLocal.getCode();
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


        // 반환 값 : 보내는 분 (이름, 주소, 전화번호)
        SenderAddress newsenderaddress = new SenderAddress(SenderAddressStateProvinceRegion, SenderAddressCity, SenderAddressStreetAddress, SenderAddressZipPostalCode);

        Sender newsender = new Sender(SenderName, newsenderaddress, SenderNumber); // 최종

        return newsender;
    }


    // 1-2. 받는 분 정보 입력
    static Recipient inputRecipientInfo() {

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

        System.out.println("주소 - 받으시는 고객님의 주소를 정확히 입력해 주세요.");
        TrackingNumber RecipientLocal = null;
        TrackingNumber RecipientAddressStateProvinceRegion;

        while (true) {
            System.out.println("광역시/도 를 입력해주세요 ex) 서울, Seoul");
            String local = sc.next();

            try {
                for (TrackingNumber t : TrackingNumber.values()) {
                    if (t.getNames().contains(local.toUpperCase())) {
                        RecipientLocal = t;
                    }
                }
                TrackingNumber placeName = TrackingNumber.valueOf(String.valueOf(RecipientLocal));

                if (placeName == RecipientLocal) {
                    // System.out.println("1번 " + RecipientLocal); // SEOUL
                    //System.out.println("2번 " + RecipientLocal.getCode()); // 002
                    RecipientAddressStateProvinceRegion = RecipientLocal;
                    String RecipientLocalNumber = RecipientLocal.getCode();
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


        // 반환 값 : 받는 분 (이름, 주소, 전화번호)
        RecipientAddress newrecipientAddress = new RecipientAddress(RecipientAddressStateProvinceRegion, RecipientAddressCity, RecipientAddressStreetAddress, RecipientAddressZipPostalCode);

        Recipient newrecipient = new Recipient(RecipientName, newrecipientAddress, RecipientNumber); // 최종

        return newrecipient;
    }


    // 1-3. 보내는 분, 받는 분 정보 기반으로 운송장 번호 만들기
    private static String makeTrackingNumber(Sender newsender, Recipient newrecipient){

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


    // 1-4. 보내는 상품 정보 입력
    static ProductInfo inputProductInfo() {

        System.out.println("상품 정보 - 상품 정보를 정확히 입력해 주세요.");
        System.out.println("상품 명 입력해주세요.");
        String productName = sc.next();
        System.out.println("상품 가격을 입력해주세요");
        int productValue = Integer.parseInt(sc.next());
        System.out.println("상품 크기를 입력해주세요.");
        String productSize = sc.next();

        // 반환 값 : 보내는 상품 정보 (상품 명, 상품 가격, 상품 크기)
        ProductInfo newproductinfo = new ProductInfo(productName, productValue, productSize); // 최종

        return newproductinfo;
    }


    // 1-5. 보내는 분 정보 확인
    static boolean checkSenderInfo(Sender newsender) {

        System.out.println();
        System.out.println("입력하신 보내는 분 정보 확인해주세요.");
        System.out.println("보내는 분 -");
        System.out.printf("%s\n%s %s %s %s\n%s\n",
                newsender.getSenderName(), // 이름
                newsender.getSenderAddress().getSenderAddressStateProvinceRegion(), // 광역시/도
                newsender.getSenderAddress().getSenderAddressCity(), // 시/군/구
                newsender.getSenderAddress().getSenderAddressStreetAddress(), // 나머지주소
                newsender.getSenderAddress().getSenderAddressZipPostalCode(), // 우편번호
                newsender.getSenderNumber()); // 전화번호

        System.out.println("입력하신 정보가 맞습니까? True / False");

        return Boolean.parseBoolean(sc.nextLine());
    }


    // 1-6. 받는 분 정보 확인
    static boolean checkRecipientInfo(Recipient newrecipient) {

        System.out.println("입력하신 받는 분 정보 확인해주세요.");
        System.out.println("받는 분 -");
        System.out.printf("%s\n%s %s %s %s\n%s\n",
                newrecipient.getRecipientName(), // 이름
                newrecipient.getRecipientAddress().getRecipientAddressStateProvinceRegion(), // 광역시/도
                newrecipient.getRecipientAddress().getRecipientAddressCity(), // 시/군/구
                newrecipient.getRecipientAddress().getRecipientAddressStreetAddress(), // 나머지주소
                newrecipient.getRecipientAddress().getRecipientAddressZipPostalCode(), // 우편번호
                newrecipient.getRecipientNumber()); // 전화번호

        System.out.println("입력하신 정보가 맞습니까? True / False");

        return Boolean.parseBoolean(sc.nextLine());
    }


    // 1-7. 보내는 상품 정보 확인
    static boolean checkProductInfo(ProductInfo newproductinfo) {

        System.out.println("입력하신 보내는 상품 정보 확인해주세요.");
        System.out.println("상품 정보 -");
        System.out.printf("%s | %s | %s\n", newproductinfo.getProductName(), // 상품 명
                newproductinfo.getProductValue(), // 상품 가격
                newproductinfo.getProductSize()); // 상품 크기

        System.out.println("입력하신 정보가 맞습니까? True / False");

        return Boolean.parseBoolean(sc.nextLine());
    }


    // 1-8. 입력된 정보를 바탕으로 객체 생성
    static Parcel saveParcel (String newTrackingNumber, Sender newsender, Recipient newrecipient, ProductInfo newproductinfo){

        Parcel newParcel = new Parcel(newTrackingNumber, newsender, newrecipient, newproductinfo, "접수완료", 1000);

        return newParcel;
    }


    // 1-9. 택배 접수하기
    static void receiptParcel(boolean checkSender, boolean checkRecipient, boolean checkProduct, Parcel saveParcel, Customer tar) {


        if (true) {

            // 생성된 개체를 배열에 저장
            repository.addParcelInformation(saveParcel);

            // 택배 배열을 생성한 메모장 파일에 집어넣기
            repository.saveParcelArrayFile(saveParcel);

            System.out.println("택배가 접수되었습니다.");

            tar.addTrackingNumbers(saveParcel.getTrackingNumber());

        }

    }


    // 1-10. 택배 등록 최종 메소드
    public static void startInputParcel(Customer tar){

        Sender finalSender = inputSenderInfo();
        Recipient finalRecipient = inputRecipientInfo();
        String finalTrackingNumber = makeTrackingNumber(finalSender,finalRecipient);
        ProductInfo finalProductInfo = inputProductInfo();
        boolean checkSender = checkSenderInfo(finalSender);
        boolean checkRecipient = checkRecipientInfo(finalRecipient);
        boolean checkProductInfo = checkProductInfo(finalProductInfo);
        Parcel finalParcel = saveParcel(finalTrackingNumber, finalSender, finalRecipient, finalProductInfo);

        receiptParcel(checkSender, checkRecipient, checkProductInfo, finalParcel, tar);
        // 타겟에게 운송장 정보 전송
    }


    // 2. 접수된 모든 택배 조회
    public static void showParcelArray() {

        System.out.printf("현재 접수된 택배 목록입니다. (총%d개)\n", repository.getParcelArray().length);
        // 단축키 iter
        for (Parcel parcel : repository.getParcelArray()) {
            System.out.println(parcel);
        }

    }

    // 2-1. 메모장에 저장한 배열 불러오기
    static void openFile() {
        // 파일을 저장할 기본 경로 (실존하는 경로로 작성하기)
        String ROOT_PATH = "D://ShippingProject";

        // 저장된 파일 로딩하기
        try (FileInputStream fis = new FileInputStream(ROOT_PATH + "/parcel.txt")) {
            //객체를 로딩할 보조 스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ois.close();
            fis.close();
            repository.addParcelInformation((Parcel) obj);

        } catch (FileNotFoundException e) {
            System.out.println("저장된 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일을 읽어오다가 오류가 발견되었습니다.");
        } catch (ClassNotFoundException e) {
            System.out.println("해당 객체를 찾을 수 없습니다.");
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

    // 0-1. 메뉴 선택에 따른 메서드 연결
//    public static void pacelrun() {
//        // 파일을 저장할 기본 경로 (실존하는 경로로 작성하기)
//        String ROOT_PATH = "D://ShippingProject";
//
//        // 택배 배열 넣을 폴더 & 파일 생성
//        repository.makeSaveFile();
//        repository.ParcelArrayFile();
//
//        while (true) {
//            String selectNumber = showMenu();
//
//            switch (selectNumber) {
//                case "1": // 택배 등록
//                    startInputParcel();
//                    break;
//                case "2": // 택배 조회
//                    showParcelArray();
//                    break;
//                case "3": // 택배운송
//                    break;
//                case "4": // 프로그램 종료
//                    boolean exit = exitProgram();
//                    if (exit) return;
//                default:
//                    System.out.println("메뉴번호를 정확히 입력해 주세요.");
//
//            }
//        }
//    }


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