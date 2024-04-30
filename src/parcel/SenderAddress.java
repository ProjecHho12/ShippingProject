package parcel;

import parcel.Tr.TrackingNumber;

public class SenderAddress {
    private TrackingNumber SenderAddressStateProvinceRegion; // 광역시,도
    private String SenderAddressCity; // 시/,군,구
    private String SenderAddressStreetAddress; // 세부주소
    private String SenderAddressZipPostalCode; // 우편번호

    public SenderAddress(TrackingNumber senderAddressStateProvinceRegion, String senderAddressCity, String senderAddressStreetAddress, String senderAddressZipPostalCode) {
        SenderAddressStateProvinceRegion = senderAddressStateProvinceRegion;
        SenderAddressCity = senderAddressCity;
        SenderAddressStreetAddress = senderAddressStreetAddress;
        SenderAddressZipPostalCode = senderAddressZipPostalCode;
    }

    public String getSenderAddressZipPostalCode() {
        return SenderAddressZipPostalCode;
    }

    public String getSenderAddressStreetAddress() {
        return SenderAddressStreetAddress;
    }

    public String getSenderAddressCity() {
        return SenderAddressCity;
    }

    public TrackingNumber getSenderAddressStateProvinceRegion() {
        return SenderAddressStateProvinceRegion;
    }

    @Override
    public String toString() {
        return "SenderAddress{" +
                "SenderAddressStateProvinceRegion=" + SenderAddressStateProvinceRegion +
                ", SenderAddressCity='" + SenderAddressCity + '\'' +
                ", SenderAddressStreetAddress='" + SenderAddressStreetAddress + '\'' +
                ", SenderAddressZipPostalCode='" + SenderAddressZipPostalCode + '\'' +
                '}';
    }

//    public String newtoString() {
//        return String.format("광역시/도: %s, 시/군/구: %s, 세부주소: %s, 우편번호: %s",
//                this.SenderAddressStateProvinceRegion, this.SenderAddressCity, this.SenderAddressStreetAddress, this.SenderAddressZipPostalCode);
//    }
}
