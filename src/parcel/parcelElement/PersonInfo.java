package parcel.parcelElement;

import parcel.StringInput;

import java.io.Serializable;

public class PersonInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String number;
    private Address address;

    private StringInput si;

    public PersonInfo(String name, String number, Address address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public PersonInfo() {
        this.si = new StringInput();
    }

    public PersonInfo(Address address) {
        this.address = Address.createAddress(si);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("|이름    : %s \n|전화번호 : %s\n|주소\n%s\n",
                this.name, this.number, this.address);
    }

    // PersonInfo 는 사람(보내는 사람, 받는 사람)에 대한 정보를 처리
    // 이름 & 핸드폰번호 & 주소
    private void inputName() {
        //이름
        this.name = null;
        while (true) {
            name = si.inputString("| 이름을 입력해주세요. (5글자 이하)");
            if (name.length() >= 5) {
                System.out.println("이름은 5글자 이하로 적어주세요 !");
            } else {
                break;
            }
        }
    }

    private void inputNumber() {
        // 핸드폰번호
        this.number = null;
        while (true) {
            number = si.inputString("| 핸드폰번호를 입력해주세요. ex) 010-1234-5678");
            String pureNum = number.replaceAll("-", "");
            if (pureNum.matches("\\d{11}")) {
                number = pureNum;
                break;
            } else {
                System.out.println("핸드폰번호 11자리 숫자를 입력해야 합니다!");
            }
        }
    }

    // 외부에서 실행 및 현재 객체 반환하는 메소드
    public PersonInfo executeInputMethods(StringInput si) {
        inputName();
        inputNumber();
        // Address.createAddress()로 새로운 주소 객체 생성
        Address newAddress = Address.createAddress(si);
        // 생성된 주소 객체를 PersonInfo의 address 필드에 할당
        setAddress(newAddress);
        // setAddress() 메소드를 사용하여도 됩니다.
        Address a = getAddress().executeInputMethodsAndGetAddress(si);
        // this.address = Address.createAddress(si);

        return this;
    }
}
