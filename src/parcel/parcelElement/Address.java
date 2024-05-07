package parcel.parcelElement;

import parcel.StringInput;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    private TrackingNumber state;
    private String city;
    private String streetAddress;
    private String zipPostalCode;

    private StringInput si;

    private Address(TrackingNumber state, String city, String streetAddress, String zipPostalCode) {
        this.state = state;
        this.city = city;
        this.streetAddress = streetAddress;
        this.zipPostalCode = zipPostalCode;
    }

    public Address(StringInput si) {
        this.si = new StringInput();
    }

    public TrackingNumber getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public void setState(TrackingNumber state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    @Override
    public String toString() {
        return String.format("| 광역시/도 : %s | 시/군/구 : %s \n| 세부주소  : %s \n| 우편번호  : %s\n",
                this.state, this.city, this.streetAddress, this.zipPostalCode);
    }

    // Address 는 사람의 주소(보내는 사람 주소, 받는 사람 주소)에 대한 정보를 처리
    public static Address createAddress (StringInput si) {
        return new Address(si);
    }

    // 광역시.도 & 도시 & 기타주소 & 우편번호
    private void inputState() {
        // 광역시.도 (운송장번호(Tracking Number) 연동)
        this.state = null;
        boolean check = false;
        while (true) {
            String inputLocal = si.inputString("| 광역시&도 를 입력해주세요. ex) 서울, 강원도, BUSAN 등");
            for (TrackingNumber t : TrackingNumber.values()) {
                if (t.getNames().contains(inputLocal.toUpperCase()) || t.getNames().contains(inputLocal)) {
                    this.state = t;
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            } else {
                System.out.println("광역시&도 가 아닙니다. 다시입력해주세요.");
            }
        }
    }

    private void inputCity() {
        // 시.군.구
        this.city = null;
        while (true) {
            city = si.inputString("| 시&군&구를 입력해주세요.");
            if (!city.matches(".*시|.*군|.*구")) {
                System.out.println("oo시 & oo군 & oo구 로 입력해야 합니다.");
            } else {
                break;
            }
        }
    }

    private void inputstreetAddress() {
        // 기타주소
        this.streetAddress = si.inputString("|나머지 주소 를 입력해주세요.");
    }

    private void inputzipPostalCode() {
        // 우편번호
        this.zipPostalCode = null;
        while (true) {
            zipPostalCode = si.inputString("|우편번호를 입력해주세요. (5자리 숫자)");
            if (zipPostalCode.length() == 5) {
                break;
            } else {
                System.out.println("우편번호는 5자리 숫자로 입력해야 합니다!");
            }
        }
    }

    public Address executeInputMethodsAndGetAddress(StringInput si) {
        inputState();
        inputCity();
        inputstreetAddress();
        inputzipPostalCode();

        // 입력된 주소 정보로 주소 객체의 필드 값을 설정
        setState(getState());
        setCity(getCity());
        setStreetAddress(this.streetAddress);
        setZipPostalCode(this.zipPostalCode);


        return this;
    }
}
