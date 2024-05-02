package parcel.parcelElement;

// Parcel 필드 1. Sender(보내는 분)에 들어가는 내용
public class Sender {
    private String SenderName; // 보내는 분 이름
    private SenderAddress SenderAddress; // 보내는 분 주소
    private String SenderNumber; // 보내는 분 번호

    public Sender(String senderName, parcel.parcelElement.SenderAddress senderAddress, String senderNumber) {
        SenderName = senderName;
        SenderAddress = senderAddress;
        SenderNumber = senderNumber;
    }

    public String getSenderName() {
        return SenderName;
    }

    public parcel.parcelElement.SenderAddress getSenderAddress() {
        return SenderAddress;
    }

    public String getSenderNumber() {
        return SenderNumber;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "SenderName='" + SenderName + '\'' +
                ", SenderAddress=" + SenderAddress +
                ", SenderNumber='" + SenderNumber + '\'' +
                '}';
    }

//    public String newtoString() {
//        return String.format("이름: %s\n주소 - %s | 전화번호: %s",
//                this.SenderName, this.SenderAddress, this.SenderNumber);
//    }
}