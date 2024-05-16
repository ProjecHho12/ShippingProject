package com.hoho.shipping.parcel;


import com.hoho.shipping.parcel.parcelElement.Parcel;
import com.hoho.shipping.parcel.parcelElement.TrackingNumber;
import java.io.*;
import java.util.ArrayList;

public class ParcelRepository implements Serializable {
    private static final long serialVersionUID = 1L;

    private static ParcelRepository instance;
    private ArrayList<Parcel> parcelArrayList;

    private ParcelRepository() {
        parcelArrayList = new ArrayList<>();
        readParcelArrayInFile();
    }

    public ParcelRepository(TrackingNumber[] trackingNumbers) {
    }

    public static ParcelRepository getInstance() {
        if (instance == null) {
            instance = new ParcelRepository ();
        }
        return instance;
    }

    public ArrayList<Parcel> getParcelArrayList() {
        return parcelArrayList;
    }

    public void add (Parcel parcel) {
        parcelArrayList.add(parcel);
    }

    // 텍스트 파일에 택배리스트 추가 (객체추가)
    public void saveParcelListInFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./main.parcel.txt"))) {
            oos.writeObject(parcelArrayList);
            System.out.println("택배리스트에 택배가 등록되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

//    public void readParcelArrayInFile() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./main.parcel.txt"))) {
//            Object obj = ois.readObject();
//            if (obj instanceof ArrayList) {
//                this.parcelArrayList = (ArrayList<Parcel>) obj;
//                System.out.println("택배 리스트를 파일에서 읽어왔습니다.");
//            } else {
//                System.out.println("파일에서 읽어온 데이터의 타입이 ArrayList가 아닙니다.");
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("파일이 존재하지 않습니다.");
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("파일에서 오류가 발견되었습니다.");
//        }
//    }

    // 텍스트 파일에 저장된 택배리스트 불러오기
    public void readParcelArrayInFile() {
        // 프로그램을 처음 실행할 때 parcelArrayList를 빈 리스트로 초기화
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./main.parcel.txt"))) {
            this.parcelArrayList = (ArrayList<Parcel>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("\n택배 저장소가 불에 타버렸습니다. \n새로 건설하는 중입니다.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("파일 생성중 오류가 발생했습니다.");
        }
        try {
            File newFile = new File("./main.parcel.txt");
            if (newFile.createNewFile()) {
                System.out.println("택배저장소가 완공되었습니다.\n접수를 시작합니다.");
            }
        } catch (IOException e) {
            System.out.println("파일 생성중 오류가 발생했습니다.");
        }
    }

    // 데이터를 파일에 저장하는 메서드
    public void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./main.parcel.txt"))) {
            oos.writeObject(this.parcelArrayList);
            System.out.println("데이터를 파일에 저장했습니다.");
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 프로그램 종료 시 호출되는 메서드
    public void closeProgram() {
        saveDataToFile();
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
