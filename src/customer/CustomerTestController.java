package customer;

import parcel.parcelView;

public class CustomerTestController {

    CustomerTestView cv = new CustomerTestView();
    parcelView pv = new parcelView();

    void run() {

        while (true) {
            String menuNum = cv.showProgramMenu();

            switch (menuNum) {
                case "1":
                    cv.logIn();
                    break;
                case "2":
                    cv.makeNewCustomer();
                    break;
                case "3":
//                    cv.showCustomers();
                    break;
                case "9":
                    System.out.println("프로그램을 종료 합니다.");
                    return;
            } // end switch

        }// end while
    }

    void customerRun() {

        String CustomerMenuNum = cv.showCustomerMenu();

        switch (CustomerMenuNum) {
            case "1":
                pv.inputUser();
                break;
            case "2":
                cv.makeNewCustomer();
                break;
            case "3":
//                    cv.showMembers();
                break;
            case "9":
                System.out.println("프로그램을 종료 합니다.");
                return;
        } // end switch
    }
}
