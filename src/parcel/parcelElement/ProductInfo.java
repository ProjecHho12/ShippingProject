package parcel.parcelElement;

import parcel.StringInput;

import java.io.Serializable;

public class ProductInfo implements InformationCheck<ProductInfo>, Serializable {
    private static final long serialVersionUID = 1L;

    private String productName;
    private String productValue;
    private ProductSize productSize;
    private String fee;

    private StringInput si;

    private ProductInfo(String productName, String productValue, ProductSize productSize, String fee) {
        this.productName = productName;
        this.productValue = productValue;
        this.productSize = productSize;
        this.fee = fee;
    }

    public ProductInfo(StringInput si) {
        this.si = si;
    }

    @Override
    public String toString() {
        return String.format("| 상품명   :  %s \n| 상품가격  :  %s원 \n| 상품크기  :  %s \n| 택배가격  :  %s \n* ------------------------------- *",
                this.productName, this.productValue, this.productSize, this.fee);
    }

    // ProductInfo 는 보내는 상품에 대한 정보를 처리
    public static ProductInfo createProductInfo (StringInput si) {
        return new ProductInfo(si);
    }

    // 상품명 & 상품가격 & 상품크기
    private void inputProductName() {
        // 상품명
        System.out.println("\n상품 정보 - 보내는 물건의 정보를 정확히 입력해 주세요.");
        this.productName = null;
        while (true) {
            this.productName = si.inputString("상품명을 입력해주세요.");
            if (this.productName.trim().isEmpty()) {
                System.out.println("공백을 제외하고 입력해주세요.");
            } else {
                break;
            }
        }
    }

    private void inputProductValue() {
        // 상품가격
        this.productValue = null;
        while (true) {
            this.productValue = si.inputString("\n상품 가액을 입력해주세요");
            if (this.productValue.trim().isEmpty()) {
                System.out.println("공백을 제외하고 입력해주세요.");
            } else {
                break;
            }
        }
    }

    private void inputProductSize() {
        // 상품크기
        this.productSize = null;
        this.fee = null;
        boolean check = false;
        while (true) {
            String size = si.inputString("\n상품 크기를 입력해주세요. (소, 중, 대, 특대형)");
            for (ProductSize value : ProductSize.values()) {
                if (value.getSizeName().contains(size)) {
                    this.productSize = value;
                    this.fee = value.getValue();
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            } else {
                System.out.println("소형, 중형, 대형, 특대형 중 한가지를 써주세요 ❗");
            }
        }
    }

    @Override
    public ProductInfo CheckTarget() {
        return executeInputMethods(si);
    }

    @Override
    public ProductInfo checkInfo() {
        InformationCheck.super.checkInfo();
        return this;

    }

    public ProductInfo executeInputMethods(StringInput si) {
        this.si = si; // StringInput 객체 설정

        // 입력 메서드 실행
        inputProductName();
        inputProductValue();
        inputProductSize();

        // 모든 입력이 완료된 ProductInfo 객체 반환
        return this;
    }

}
