package loop;

import parcel.ParcelRepository;

public class ParcelControllerImpl {
    private final ParcelRepository parcelRepository;
    public ParcelControllerImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }
}
