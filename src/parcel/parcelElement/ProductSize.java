package parcel.parcelElement;

public enum ProductSize {
    SMALL ("소형"),
    Medium("중형"),
    Large("대형"),
    ExtraLarge("특대형");

    private String KorName;

    ProductSize(String korName) {
        KorName = korName;
    }

    public String getKorName() {
        return KorName;
    }
}
