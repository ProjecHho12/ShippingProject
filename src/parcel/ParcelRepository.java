package parcel;

import parcel.Tr.TrackingNumber;

public class ParcelRepository {
    // 회원정보를 입력받아서 회원 배열에 저장
    private Parcel[] parcelArray;

    public ParcelRepository() {
        // 필드 parcelArray 초기화 (객체 1개짜리 배열로 시작!)
        parcelArray = new Parcel[1];

        // 기본적으로 넣어 줄 객체 1개
        // 보내는 분
        SenderAddress onesenderaddress = new SenderAddress(TrackingNumber.CHUNGBUK, "청주시", "흥덕동", "24856");
        Sender onesender = new Sender("풀순이", onesenderaddress, "01048596812");
        // 받는 분
        RecipientAddress onerecipientaddress = new RecipientAddress(TrackingNumber.CHUNGBUK, "청주시", "흥덕동", "24856");
        Recipient onerecipient = new Recipient("풀돌이", onerecipientaddress, "01048596812");
        // 상품 정보
        ProductInfo oneproductinfo = new ProductInfo("풀죽", 1000, "소형");

        //종합
        parcelArray[0] = new Parcel("0020430001", onesender, onerecipient, oneproductinfo, "접수완료", 10000);
    }

    public Parcel[] getParcelArray() {
        return parcelArray;
    }

    //메소드
    // 택배 정보 생성
    void addParcelInformation (Parcel newParcel){
        // 배열에 데이터를 추가
        // 임시배열은 원래 배열보다 하나 크고
        Parcel[] temp = new Parcel[parcelArray.length + 1];
        // 원래 배열크기만큼 for loop 돌려서
        for (int i = 0; i < parcelArray.length; i++) {
            // 임시배열에 원래배열 인덱스 맞춰서 넣어주고
            temp[i] = parcelArray[i];
        }
        // 추가된 내용만 임시배열의 맨 끝에 넣어준다.
        temp[temp.length -1] = newParcel;
        // 원래배열에 임시배열 대입
        parcelArray = temp;
    }
}


