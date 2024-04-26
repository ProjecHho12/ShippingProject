package parcel;

public class ParcelList {
    // 택배 여러개 들어가야 하는 정보

    private Parcel[] pArr;

    private static final int NOT_FOUND = -1;

    public ParcelList() {
        this.pArr = new Parcel[0];
    }

    // 맨 끝에 추가
    public void push(Parcel newParcel) {
        Parcel[] temp = new Parcel[this.pArr.length + 1];
        for (int i = 0; i < this.pArr.length; i++) {
            temp[i] = this.pArr[i];
        }
        temp[temp.length - 1] = newParcel;
        this.pArr = temp;
    }

//    // 맨 끝 제거
//    private Parcel pop() {
//        // 맨 끝 책 백업
//        Book lastBook = bArr[bArr.length - 1];
//        Book[] temp = new Book[bArr.length - 1];
//        for (int i = 0; i < temp.length; i++) {
//            temp[i] = bArr[i];
//        }
//        bArr = temp;
//        return lastBook;
//    }
//
//    // 책 정보 삭제
//    public Book remove(int index) {
//        // 삭제 대상 백업
//        Book removedBook = bArr[index];
//        for (int i = index; i < bArr.length - 1; i++) {
//            bArr[i] = bArr[i + 1];
//        }
//        pop();
//        return removedBook;
//    }
//
//    // 배열에 저장된 요소 수 리턴
//    int size() {
//        return bArr.length;
//    }
//
//
//    public Book[] getbArr() {
//        return bArr;
//    }
//
//    public Book get(int index) {
//        return bArr[index];
//    }
}
