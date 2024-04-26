package parcel;

import java.time.LocalDate;

/**
 * packageName    : parcel fileName       : Parcel author         : hoho date           : 4/25/24
 * description    :
 */
public class Parcel {
    // 택배 1개에 들어가야 하는 정보
    private int TrackingNumber; // 운송장번호
    private Sender Sender; // 보내는 분 (이름, 연락처, 주소)
    private Recipient Recipient; // 받는 분 (이름, 연락처, 주소)
    private ProductInfo ProductInfo; // 상품 정보 (상품명, 상품가격, 크기)
    private String Status; // 배송상태 (접수완료, 배송중, 배송완료)
    private LocalDate regDate; // 접수일자
    private int ShippingFee; // 배송비

    public Parcel(int trackingNumber, parcel.Sender sender, parcel.Recipient recipient, parcel.ProductInfo productInfo, String status, int shippingFee) {
        TrackingNumber = trackingNumber;
        Sender = sender;
        Recipient = recipient;
        ProductInfo = productInfo;
        Status = status;
        this.regDate = LocalDate.now();
        ShippingFee = shippingFee;
    }

    public parcel.Sender getSender() {
        return Sender;
    }

    public parcel.Recipient getRecipient() {
        return Recipient;
    }

    public parcel.ProductInfo getProductInfo() {
        return ProductInfo;
    }

    public String getStatus() {return Status; }

    public int getTrackingNumber() {
        return TrackingNumber;
    }

    public int getShippingFee() {
        return ShippingFee;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "Sender=" + Sender +
                ", Recipient=" + Recipient +
                ", ProductInfo=" + ProductInfo +
                ", Status=" + Status +
                ", TrackingNumber='" + TrackingNumber + '\'' +
                ", ShippingFee=" + ShippingFee +
                '}';
    }
}
