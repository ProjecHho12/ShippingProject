package parcel;

import parcel.Tr.TrackingNumber;

import java.io.*;
import java.util.Arrays;

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
    // 택배 정보 객체 배열에 담기
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

    // 택배 배열 저장할 폴더 & 파일 생성하기

    // 파일을 저장할 기본 경로 (실존하는 경로로 작성하기)
    String ROOT_PATH = "D://ShippingProject";

    // 택배 배열 넣을 폴더 & 파일 생성
    void makeDirectory() {

        // 폴더 생성 명령
        // 파일 정보 객체 생성 (ParcelRepository 라는 폴더 생성)
        File directory = new File(ROOT_PATH + "/ParcelRepository");
        // 만약 폴더 directory 가 존재하지 않는다면 폴더를 만들기
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                System.out.println("폴더 생성에 실패했습니다.");
                return;
            }

            // 파일 생성 (ParcelRepository 폴더 안에 parcelrepository.txt 생성)
            File newfile = new File(ROOT_PATH + "/ParcelRepository/parcelrepository.txt");
            // 만약 파일 newfile 이 존재하지 않는다면 폴더를 만들기
            if (!newfile.exists()) {
                try { // alt + enter
                    if (newfile.createNewFile())
                        System.out.println("파일 생성에 실패했습니다.");// 예외사항 처리해주기
                } catch (IOException e) {
                    System.out.println("파일생성에 실패했습니다.");
                }
            }
        }
    }

    void saveParcelArrayFile(Parcel newParcel) {
        try (FileWriter  fw = new FileWriter(ROOT_PATH + "/ParcelRepository/parcelrepository.txt", true)) {

            String newParcelArrayInfo = String.format("%s,%s,%s,%s,%s,%s", newParcel.getTrackingNumber(),newParcel.getSender(),newParcel.getRecipient(),newParcel.getProductInfo(),newParcel.getStatus(),newParcel.getShippingFee());
            fw.write(newParcelArrayInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ParcelArrayFile (){
        String targetPath = ROOT_PATH + "/ParcelRepository/parcelrepository.txt";

        try(FileReader fr = new FileReader(targetPath)) {

            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String s = br.readLine();
                if (s == null) break;
                String[] split = s.split(",");

                Parcel parcel = new Parcel(
                        split[0],
                        split[1],
                        split[2],
                        split[3],
                        split[4],
                        split[5]
                );
                addParcelInformation(parcel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


