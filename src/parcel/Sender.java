package parcel;

// Parcel 필드 1. Sender(보내는 분)에 들어가는 내용
public class Sender {
    private String senderName; // 보내는 분 이름
    private String senderAddress; // 보내는 분 주소
    private String senderNumber; // 보내는 분 번호

    public Sender(String senderName, String senderAddress, String senderNumber) {
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderNumber = senderNumber;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "senderName='" + senderName + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", senderNumber='" + senderNumber + '\'' +
                '}';
    }
}
