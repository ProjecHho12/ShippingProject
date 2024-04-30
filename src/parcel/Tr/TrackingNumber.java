package parcel.Tr;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TrackingNumber {
    // 운송장 번호 열거형
    SEOUL("002", Arrays.asList("SEOUL", "서울시", "서울")),
    INCHON("032", Arrays.asList("INCHON", "인천시", "인천")),
    DAEJEON("042", Arrays.asList("DAEJEON", "대전시", "대전")),
    BUSAN("051", Arrays.asList("BUSAN", "부산시", "부산")),
    ULSAN("052", Arrays.asList("ULSAN", "울산시", "부산")),
    DAEGU("053", Arrays.asList("DAEGU", "대구시", "대구")),
    GWANGJU("062", Arrays.asList("GWANGJU", "광주시", "광주")),
    JEJU("064", Arrays.asList("JEJU", "제주도", "제주")),
    GYEONGGI("031", Arrays.asList("GYEONGGI", "경기도", "경기")),
    GANGWON("033", Arrays.asList("GANGWON", "강원도", "강원")),
    CHUNGNAM("041", Arrays.asList("CHUNGNAM", "충청남도","충남")),
    CHUNGBUK("043", Arrays.asList("CHUNGBUK", "충청북도","충북")),
    GYEONGBUK("054", Arrays.asList("GYEONGBUK", "경상북도", "경북")),
    GYEONGNAM("055", Arrays.asList("GYEONGNAM", "경상남도", "경남")),
    JEONNAM("061", Arrays.asList("JEONNAM", "전라남도", "전남")),
    JEONBUK("063", Arrays.asList("JEONBUK", "전라북도", "전북"));

    private String code;
    private final List<String> names;

    TrackingNumber(String code, List<String> names) {
        this.code = code;
        this.names = names;
    }

    public String getCode() {
        return code;
    }

    public List<String> getNames() {
        return names;
    }

}
