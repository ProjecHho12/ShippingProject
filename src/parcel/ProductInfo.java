package parcel;

// Parcel 필드 3. ProductInfo(상품 정보)에 들어가는 내용
public class ProductInfo {
    private String productName; // 상품명
    private int productValue; // 상품가격
    private String productSize; // 상품크기

    public ProductInfo(String productName, int productValue, String productSize) {
        this.productName = productName;
        this.productValue = productValue;
        this.productSize = productSize;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductValue() {
        return productValue;
    }

    public String getProductSize() {
        return productSize;
    }

    @Override
    public String toString() {
        return String.format("상품명: %s | 상품가격: %s원 | 상품크기: %s",
                this.productName, this.productValue, this.productSize);
    }
}
