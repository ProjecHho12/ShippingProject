package parcel;

import parcel.parcelElement.Parcel;

public class ParcelList {

    private Parcel[] pArr;

    private static final int NOT_FOUND = -1;

    public ParcelList() {
        this.pArr = new Parcel[0];
    }

}
