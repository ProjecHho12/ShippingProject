package parcel;

public class ParcelRepository {
    private static ParcelList parcelList; // 택배 여러개


    // static 초기값 설정
    static {
        parcelList = new ParcelList();

        Sender newsender = new Sender("콩순이","서울","01012340000");
        Recipient newrecipient = new Recipient("콩돌이","부산","01056780000");
        ProductInfo newproductinfo =  new ProductInfo("찐빵", 100, "소형");
        parcelList.push(new Parcel(1234, newsender, newrecipient,newproductinfo,"접수완료",100));
    }

    public static ParcelList getParcelList() {
        return parcelList;
    }

    void addnewPacel (){}


//    static Parcel[] parcels;
//    Sender[] senders;
//    Recipient[] recipients;
//    ProductInfo[] productInfos;
//
//    ParcelList parcelList;
//
//    ParcelRepository(){
//        this.parcels = new Parcel[3];
//        this.senders = new Sender[1];
//        this.recipients = new Recipient[1];
//        this.productInfos = new ProductInfo[1];
//
//        senders[0] = new Sender("콩순이","서울","123");
//        recipients[0] = new Recipient("콩돌이","부산","456");
//        productInfos[0] = new ProductInfo("찐빵", 100, "소형");
//
//        parcels[0] = new Parcel(senders[0], recipients[0], productInfos[0]);
//
//    }
//
//    public void push(Parcel newParcel) {
//        // 맨 끝에 추가
//            Parcel[] temp = new Parcel[parcels.length + 1];
//            for (int i = 0; i < this.parcels.length; i++) {
//                temp[i] = this.parcels[i];
//            }
//            temp[temp.length - 1] = newParcel;
//            this.parcels = temp;
//    }
//
//    public Parcel[] getParcels() {
//        return parcels;
//    }

}
