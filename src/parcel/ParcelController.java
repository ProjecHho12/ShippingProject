package parcel;

public class ParcelController {
    static ParcelView view;
    static ParcelRepository repository;

    public ParcelController() {
        view = new ParcelView();
        repository = new ParcelRepository();
    }


    // 0. 메뉴 선택에 따른 메서드 연결
    public static void pacelrun() {
        // 파일을 저장할 기본 경로 (실존하는 경로로 작성하기)
        // String ROOT_PATH = "parcel.txt";

        // 택배 배열 넣을 폴더 & 파일 생성
        repository.makeSaveFile();
        repository.readParcelArrayFile();

        while (true) {
            String selectNumber = view.showMenu();

            switch (selectNumber) {
                case "1": // 택배 등록
                    view.startInputParcel();
                    break;
                case "2": // 택배 조회
                    view.showParcelArray();
                    break;
                case "3": // 택배운송
                    break;
                case "4": // 프로그램 종료
                    boolean exit = view.exitProgram();
                    if (exit) return;
                default:
                    System.out.println("메뉴번호를 정확히 입력해 주세요.");

            }
        }
    }
}

