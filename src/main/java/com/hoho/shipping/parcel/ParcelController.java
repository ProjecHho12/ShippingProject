//package main.parcel;
//
//public class ParcelController {
//    ParcelView view;
//    ParcelRepository repository;
//
//    public ParcelController() {
//        this.view = new ParcelView();
//        this.repository = ParcelRepository.getInstance();
//    }
//
//    // 0. 메뉴 선택에 따른 메서드 연결
//    public void parcelrun() {
//        // 파일을 저장할 기본 경로 (실존하는 경로로 작성하기)
//        // String ROOT_PATH = "main.parcel.txt";
//
//        // 택배 배열 넣을 폴더 & 파일 생성
//        repository.readParcelArrayInFile();
//
//        while (true) {
//            String selectNumber = view.showMenu();
//
//            switch (selectNumber) {
//                case "1": // 택배 등록
//                    view.start ();
//                    break;
//                case "2": // 택배 조회
//                    view.showAllParcelList();
//                    break;
//                case "3": // 택배운송
//                    break;
//                case "4": // 프로그램 종료
//                    boolean exit = view.exitProgram();
//                    if (exit)
//                        repository.closeProgram();
//                    return;
//                default:
//                    System.out.println("메뉴번호를 정확히 입력해 주세요.");
//
//            }
//        }
//    }
//}
//
