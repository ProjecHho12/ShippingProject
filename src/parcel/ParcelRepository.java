package parcel;

import parcel.parcelElement.*;

import java.io.*;

public class ParcelRepository {
    // 회원정보를 입력받아서 회원 배열에 저장
    private Parcel[] parcelArray;

    // 택배 배열 저장할 텍스트 파일 저장 경로
    private static final String ROOT_PATH = "parcel.txt"; // 파일의 경로


    // 필드 parcelArray 초기화 (객체 1개짜리 배열로 시작!)
    public ParcelRepository() {
        parcelArray = new Parcel[1];

        // 기본적으로 넣어 줄 객체 1개
        // 보내는 분
        SenderAddress onesenderaddress = new SenderAddress(TrackingNumber.CHUNGBUK, "청주시", "흥덕동", "24856");
        Sender onesender = new Sender("풀순이", onesenderaddress, "01048596812");
        // 받는 분
        RecipientAddress onerecipientaddress = new RecipientAddress(TrackingNumber.CHUNGBUK, "청주시", "흥덕동", "24856");
        Recipient onerecipient = new Recipient("풀돌이", onerecipientaddress, "01048596812");
        // 상품 정보
        ProductInfo oneproductinfo = new ProductInfo("풀죽", "1000", ProductSize.SMALL);

        //종합
        parcelArray[0] = new Parcel("0020430001", onesender, onerecipient, oneproductinfo, Status.INCOMING, 10000);
    }


    //getter
    public Parcel[] getParcelArray() {
        return parcelArray;
    }


    //메소드
    // 입력받은 택배 정보가 담긴 객체 배열에 담기
    void addParcelInformation(Parcel newParcel) {
        // 배열에 데이터를 추가
        // 임시배열은 원래 배열보다 하나 크고
        Parcel[] temp = new Parcel[parcelArray.length + 1];
        // 원래 배열크기만큼 for loop 돌려서
        for (int i = 0; i < parcelArray.length; i++) {
            // 임시배열에 원래배열 인덱스 맞춰서 넣어주고
            temp[i] = parcelArray[i];
        }
        // 추가된 내용만 임시배열의 맨 끝에 넣어준다.
        temp[temp.length - 1] = newParcel;
        // 원래배열에 임시배열 대입
        parcelArray = temp;
    }


    // 택배 배열 넣을 텍스트 파일 생성
    void makeSaveFile() {

        // 파일 생성 (ParcelRepository 폴더 안에 parcelrepository.txt 생성)
        File newfile = new File(ROOT_PATH);
        // 만약 파일 newfile 이 존재하지 않는다면 폴더를 만들기
        if (!newfile.exists()) {
            try {
                if (newfile.createNewFile())
                    System.out.println("파일이 생성되었습니다.");
            } catch (IOException e) {
                System.out.println("파일 생성 중 오류가 발생했습니다.");
            }
        }
    }


    // 텍스트 파일에 택배 배열 넣기
    public void saveParcelArrayFile(Parcel saveParcel) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ROOT_PATH))) {
            // Parcel 배열을 파일에 쓰기
            oos.writeObject(parcelArray);
            System.out.println("Parcel 배열이 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }


    // 택배 조회할 때 텍스트 파일에서 객체 읽어오기
    public void readParcelArrayFile() {

        Parcel[] loadedParcelArray = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ROOT_PATH))) {
            // 파일에서 Parcel 배열 읽기

            loadedParcelArray = (Parcel[]) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            loadedParcelArray = parcelArray;
            //System.err.println("파일 로드 중 오류가 발생했습니다: " + e.getMessage());
        }

        Parcel[] tempArray = parcelArray;
        parcelArray = loadedParcelArray;
    }
}



