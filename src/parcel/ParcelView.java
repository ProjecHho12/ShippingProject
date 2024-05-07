package parcel;

import customer.Customer;
import parcel.parcelElement.*;

import java.io.Serializable;

import static parcel.parcelElement.InformationCheck.si;

public class ParcelView implements Serializable {
    private static final long serialVersionUID = 1L;
    private Status status;
    private ParcelRepository repository;
    private StringInput si;
    private Parcel parcel;


    public ParcelView() {
        this.si = new StringInput();
        this.parcel = new Parcel(si);
        this.repository = ParcelRepository.getInstance();
    }

    // 택배 접수하기 (택배 리스트 & 외부저장소에 택배 1개 저장)
    public void receiptParcel(Sender sender, Recipient recipient, Parcel parcel, ProductInfo productInfo, Customer tar) {
        // 입력된 정보 바탕으로 택배 1개 초기화
//        this.parcel.setSender(sender);
//        this.parcel.setRecipient(recipient);
        this.parcel.setProductInfo(productInfo);


        // 택배리스트 에 택배 저장하기
        //ArrayList<Parcel> parcels = new ArrayList<>();

        repository.getParcelArrayList().add(this.parcel);

        //parcels.add(this.parcel);

        // 오류System.out.println(parcel.toString());

        // 택배리스트 택배저장소(텍스트파일)에 저장
        repository.saveParcelListInFile();

        // 접수된 내용 보여주기
        System.out.println("고객님의 택배 가 접수되었습니다.");
        // 여기 다른분 꺼 내용지운거 추가해야됨 ㄴㅇ모ㅗㅓㅑㅐㅅ거ㅙㅈㅅㄱ너ㅐ조거ㅐ
        // 여기도 다른분꺼 내용지운거 추가하기 리ㅑ허마ㅐ가ㅔㅗㄴ기ㅓㅛㅔㅓㅏㅐ둇아ㅓ; 기존 startInputParcel메소드
        //System.out.println(Arrays.toString(repository.getParcelArrayList().toArray())); // 이거오류
        tar.addTrackingNumbers(parcel.getTrackingNumber());
    }

    // 실행메소드 구현하기
    public void start(Customer tar) {

        // 보내는 사람
        Sender sender = new Sender(si);
        sender.checkInfo();
        String sendNum = sender.getAddress().getState().getCode();

        //String sendNum = "002";

        // 받는사람
        Recipient recipient = new Recipient();
        recipient.checkInfo();
        String reciNum = recipient.getAddress().getState().getCode();

        //String reciNum = "063";

        //운송장번호
        this.parcel.createTrackingNumber(si, sendNum, reciNum);

        // 상품정보
        ProductInfo productInfo = new ProductInfo(si);
        productInfo.checkInfo(); // 입력 메서드 실행 및 객체 생성

        //System.out.println("죄회죄화" + productInfo);
        receiptParcel(sender, recipient, this.parcel, productInfo, tar);


        // 접수내용 조회

        if (repository.getParcelArrayList() == null || repository.getParcelArrayList().isEmpty()) {
            System.out.println("택배 저장소가 비어있습니다.");
        } else {
            System.out.println("파일에서 읽어온 택배 리스트:");
            for (Parcel parcel : repository.getParcelArrayList()) {
                System.out.println("접수일자   : " + this.parcel.getRegDate());
                System.out.println("운송장번호 : " + this.parcel.getTrackingNumber());
                System.out.println(this.parcel.getSender());
                System.out.println(this.parcel.getRecipient());
                System.out.println("상품 정보  : " + this.parcel.getProductInfo());
                System.out.println("택배 상태  : " + parcel.getStatus().getDescription());
            }
        }
    }


//    // 택배리스트 전체조회
//    public void showAllParcelList() {
//        System.out.printf("현재 접수된 택배\uD83D\uDCE6 목록입니다. \n 총 %d개가 접수완료 상태입니다.\n\n", repository.getParcelArrayList().size());
//        // 단축키 iter
//
//        System.out.println("파일에서 읽어온 택배 리스트:");
//        for (Parcel parcel : repository.getParcelArrayList()) {
//            System.out.println("접수일자   : " + parcel.getRegDate());
//            System.out.println("운송장번호 : " + parcel.getTrackingNumber());
//            System.out.println("parcel.getSender()");
//            System.out.println("parcel.getRecipient()");
//            System.out.println("상품 정보  : " + parcel.getProductInfo());
//            System.out.println("택배 상태  : " + parcel.getStatus());
//        }
//        for (Parcel parcel : repository.getParcelArrayList()) {
//            System.out.println(parcel);
//        }
//        if (repository.getParcelArrayList() == null || repository.getParcelArrayList().isEmpty()) {
//            System.out.println("저장된 택배가 1개도 없습니다.");
//        } else {
//            System.out.printf("현재 접수된 택배 목록입니다. (총%d개)\n", repository.getParcelArrayList().size());
//            // 단축키 iter
//            for (Parcel parcel : repository.getParcelArrayList()) {
//                System.out.println(parcel);
//            }
//        }

//    // 4. 프로그램 종료 메서드
//    public Boolean exitProgram() {
//        while (true) {
//            String selectExit = si.inputString("프로그램을 종료하시겠습니까? True / False");
//
//            if (selectExit.toUpperCase().contains("T")) {
//                repository.closeProgram();
//                return true;
//            } else if (selectExit.toUpperCase().contains("F")) {
//                return false;
//            } else {
//                System.out.println("True 또는 False 를 입력해 주세요 ❗");
//            }
//        }
//    }
}
//    // 0. 메뉴조회 및 사용할 메뉴 선택
//    public String showMenu() {
//        System.out.println("\n* ------- 택배 등록\uD83D\uDCE6 ------- *");
//        System.out.println("1. 택배 등록");
//        System.out.println("2. 택배 조회");
//        //System.out.println("3. 택배 운송");
//        System.out.println("4. 프로그램 종료\uD83D\uDE25");
//        System.out.println("* -------------------------- *");
//
//        return si.inputString("이용하실 메뉴번호\uD83D\uDD22를 입력해주세요 ❗");
//    }


