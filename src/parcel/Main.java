package parcel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    // 파일을 저장할 기본 경로 (실존하는 경로로 작성하기)
    public static final String ROOT_PATH = "D://ShippingProject";

    public static void main(String[] args) {

        ParcelView parcelView = new ParcelView();
        ParcelRepository parcelRepository = new ParcelRepository();

//        // 폴더 생성 명령
//        // 파일 정보 객체 생성 (ParcelRepository 라는 폴더 생성)
//        File directory = new File(ROOT_PATH + "/ParcelRepository");
//        // 만약 폴더 directory 가 존재하지 않는다면 폴더를 만들기
//        if (!directory.exists()) directory.mkdir();
//
//
//        // 파일 생성 (ParcelRepository 폴더 안에 parcelrepository.txt 생성)
//        File newfile = new File(ROOT_PATH + "/ParcelRepository/parcelrepository.txt");
//        // 만약 파일 newfile 이 존재하지 않는다면 폴더를 만들기
//        if (!newfile.exists()) {
//            try { // alt + enter
//                newfile.createNewFile(); // 예외사항 처리해주기
//            } catch (IOException e) {
//                System.out.println("파일생성에 실패했습니다.");
//            }
//        }
//
//        // 텍스트 기반 스트림 : Writer, Reader
//        try (FileWriter fw = new FileWriter(newfile)){
//            parcelRepository.getParcelArray();
//
//            // 파일생성명령
//            fw.write(Arrays.toString(parcelRepository.getParcelArray()));
//        } catch (Exception e){
//            e.printStackTrace();
//        }






        parcelView.pacelrun();


    }
}
