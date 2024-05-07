package parcel.parcelElement;

import parcel.ParcelRepository;
import parcel.StringInput;

import java.io.Serializable;
import java.time.LocalDate;

public class Parcel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trackingNumber;
    private PersonInfo sender;
    private PersonInfo recipient;
    private ProductInfo productInfo;
    private Status status;
    private LocalDate regDate;

    private StringInput si;
    private ParcelRepository repository;

    public Parcel(String trackingNumber, PersonInfo sender, PersonInfo recipient, ProductInfo productInfo, Status status) {
        this.trackingNumber = trackingNumber;
        this.sender = sender;
        this.recipient = recipient;
        this.productInfo = productInfo;
        this.status = status;
        this.regDate = LocalDate.now();
    }

    public Parcel(StringInput si) {
        this.si = new StringInput();
        this.regDate = LocalDate.now();
        this.repository = ParcelRepository.getInstance();
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public PersonInfo getSender() {
        return sender;
    }

    public PersonInfo getRecipient() {
        return recipient;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }
    public Status getStatus() {
        return this.status;
    }

    public void setSender(PersonInfo sender) {
        this.sender = sender;
    }

    public void setRecipient(PersonInfo recipient) {
        this.recipient = recipient;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    // Address 는 사람의 주소(보내는 사람 주소, 받는 사람 주소)에 대한 정보를 처리
    public static Parcel createParcel (StringInput si) {
        return new Parcel(si);
    }


    // Parcel 은 택배 하나에 대한 정보를 처리
    public void createTrackingNumber(StringInput si, String a, String b) {
        //운송장 번호
        // (10자리, 보내는 분 지역번호 3자리 / 받는 분 지역번호 3자리 / 택배배열 길이+1 4자리)
        // 보내는 사람 지역번호 3자리
//        Sender makeSender = new Sender(si);
        String senderNumber = a;
        //System.out.println(senderNumber);
        //System.out.println("1번");
        // 받는 분 지역번호 3자리
//        PersonInfo makeRecipient = new Recipient();
        String recipientNumber = b;
        //System.out.println(recipientNumber);
        //System.out.println("2번");
        // 남은 뒷자리 4자리는 배열에 남은 택배길이
        String lastNumber = String.format("%04d", repository.getParcelArrayList().size() + 1);
        //System.out.println("3번");
        // 최종 운송장 번호
        this.trackingNumber = senderNumber.concat(recipientNumber).concat(lastNumber);
        setTrackingNumber(this.trackingNumber);
        //System.out.println("4번");
    }


//
//    // 입력된 정보 바탕으로 택배 1개 생성
//    public Parcel makeParcel () {
//        // 보내는 사람
//        PersonInfo Sender = sender.checkInfo();
//        // 받는 사람
//        PersonInfo Recipient = recipient.checkInfo();
//        //운송장번호
//        TrackingNumber TrackingNumber = makeTrackingNumber();
//        // 상품 정보
//        ProductInfo productInfo = ProductInfo.checkInfo();
//
//        // 택배 1개 생성
//        Parcel oneParcel = new Parcel(TrackingNumber, Sender, Recipient, productInfo, parcel.parcelElement.Status.INCOMING, "3000원");
//
//        return oneParcel;
//    }




}
