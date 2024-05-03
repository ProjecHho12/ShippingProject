package parcel;

public enum Status {
    // 배송정보접수(고객), 화물접수(입고직원), 배송시작, 배송중, 배송완료
    INCOMING("입고"), OUTCOMING("출고");

    private String description;

    Status(String description) {
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
