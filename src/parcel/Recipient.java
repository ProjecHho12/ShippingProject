package parcel;

// Parcel 필드 2. Recipient(받는 분)에 들어가는 내용
public class Recipient {
    private String RecipientName; // 받는 분 이름
    private RecipientAddress RecipientAddress; // 받는 분 주소
    private String RecipientNumber; // 받는 분 번호

    public Recipient(String recipientName, parcel.RecipientAddress recipientAddress, String recipientNumber) {
        RecipientName = recipientName;
        RecipientAddress = recipientAddress;
        RecipientNumber = recipientNumber;
    }

    public String getRecipientName() {
        return RecipientName;
    }

    public parcel.RecipientAddress getRecipientAddress() {
        return RecipientAddress;
    }

    public String getRecipientNumber() {
        return RecipientNumber;
    }

    @Override
    public String toString() {
        return String.format("이름: %s\n주소 - %s | 전화번호: %s",
                this.RecipientName, this.RecipientAddress, this.RecipientNumber);
    }
}
