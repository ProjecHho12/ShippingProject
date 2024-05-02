package parcel;

import parcel.parcelElement.ProductInfo;
import parcel.parcelElement.Recipient;
import parcel.parcelElement.Sender;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * packageName    : parcel fileName       : Parcel author         : hoho date           : 4/25/24
 * description    :
 */
public class Parcel implements Serializable {
    // 택배 1개에 들어가야 하는 정보
    private String TrackingNumber; // 운송장번호
    private Sender Sender; // 보내는 분 (이름, 연락처, 주소)
    private Recipient Recipient; // 받는 분 (이름, 연락처, 주소)
    private ProductInfo ProductInfo; // 상품 정보 (상품명, 상품가격, 크기)
    private String Status; // 배송상태 (접수완료, 배송중, 배송완료)
    private LocalDate regDate; // 접수일자
    private int ShippingFee; // 배송비

    public Parcel(String trackingNumber, parcel.parcelElement.Sender sender, parcel.parcelElement.Recipient recipient, parcel.parcelElement.ProductInfo productInfo, String status, int shippingFee) {
        TrackingNumber = trackingNumber;
        Sender = sender;
        Recipient = recipient;
        ProductInfo = productInfo;
        Status = status;
        this.regDate = LocalDate.now();
        ShippingFee = shippingFee;
    }

    public Parcel(String trackingNumber, String s, String s1, String s2, String status, String s3) {
    }

    public String getTrackingNumber() {
        return TrackingNumber;
    }

    public parcel.parcelElement.Sender getSender() {
        return Sender;
    }

    public parcel.parcelElement.Recipient getRecipient() {
        return Recipient;
    }

    public parcel.parcelElement.ProductInfo getProductInfo() {
        return ProductInfo;
    }

    public String getStatus() {
        return Status;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public int getShippingFee() {
        return ShippingFee;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "TrackingNumber='" + TrackingNumber + '\'' +
                ", Sender=" + Sender +
                ", Recipient=" + Recipient +
                ", ProductInfo=" + ProductInfo +
                ", Status='" + Status + '\'' +
                ", regDate=" + regDate +
                ", ShippingFee=" + ShippingFee +
                '}';
    }

//    public String newtoString() {
//        return String.format("운송장번호: %s\n보내는 분\n%s\n받는 분\n%s\n상품정보\n%s\n택배상태: %s | 접수일: %s | 택배가격: %d원",
//                this.TrackingNumber, this.Sender, this.Recipient, this.ProductInfo, this.Status, this.regDate, this.ShippingFee);
//    }
}


