package parcel;

// Parcel 필드 2. Recipient(받는 분)에 들어가는 내용
public class Recipient {
    private String recipientName; // 받는 분 이름
    private String recipientAddress; // 받는 분 주소
    private String recipientNumber; // 받는 분 번호

    public Recipient(String recipientName, String recipientAddress, String recipientNumber) {
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.recipientNumber = recipientNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public String getRecipientNumber() {
        return recipientNumber;
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "recipientName='" + recipientName + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", recipientNumber='" + recipientNumber + '\'' +
                '}';
    }
}
