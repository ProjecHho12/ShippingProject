package parcel;

import parcel.Tr.TrackingNumber;

public class RecipientAddress {
    private TrackingNumber RecipientAddressStateProvinceRegion; // 광역시,도
    private String RecipientAddressCity; // 시/,군,구
    private String RecipientAddressStreetAddress; // 세부주소
    private String RecipientAddressZipPostalCode; // 우편번호

    public RecipientAddress(TrackingNumber recipientAddressStateProvinceRegion, String recipientAddressCity, String recipientAddressStreetAddress, String recipientAddressZipPostalCode) {
        RecipientAddressStateProvinceRegion = recipientAddressStateProvinceRegion;
        RecipientAddressCity = recipientAddressCity;
        RecipientAddressStreetAddress = recipientAddressStreetAddress;
        RecipientAddressZipPostalCode = recipientAddressZipPostalCode;
    }

    public TrackingNumber getRecipientAddressStateProvinceRegion() {
        return RecipientAddressStateProvinceRegion;
    }

    public String getRecipientAddressCity() {
        return RecipientAddressCity;
    }

    public String getRecipientAddressStreetAddress() {
        return RecipientAddressStreetAddress;
    }

    public String getRecipientAddressZipPostalCode() {
        return RecipientAddressZipPostalCode;
    }

    @Override
    public String toString() {
        return "RecipientAddress{" +
                "RecipientAddressStateProvinceRegion=" + RecipientAddressStateProvinceRegion +
                ", RecipientAddressCity='" + RecipientAddressCity + '\'' +
                ", RecipientAddressStreetAddress='" + RecipientAddressStreetAddress + '\'' +
                ", RecipientAddressZipPostalCode='" + RecipientAddressZipPostalCode + '\'' +
                '}';
    }

//    public String newtoString() {
//        return String.format("광역시/도: %s, 시/군/구: %s, 세부주소: %s, 우편번호: %s",
//                this.RecipientAddressStateProvinceRegion, this.RecipientAddressCity, this.RecipientAddressStreetAddress, this.RecipientAddressZipPostalCode);
//    }
}
