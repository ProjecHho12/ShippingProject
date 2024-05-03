package employee;

import parcel.Parcel;
import parcel.ParcelRepository;

import java.util.stream.Collectors;

public class EmployeeControllerImpl {
    private final EmployeeRepository er;
    public EmployeeControllerImpl(EmployeeRepository employeeRepository) {
        er = employeeRepository;
    }

    //
//
    public int register(String name, String email, String password, String gender, String address, int age, int employeePhone, Job job) {
        Employee newEmployee = new Employee(name, email, password, gender, address, age, employeePhone, job);
        if (!this.er.isContains(newEmployee)){
            this.er.resister(newEmployee);
            return 0;
        }
        return 1;
    }

    public Employee login(String email, String password){
        Employee matechedEmployee;
        try {
            matechedEmployee = er.employeeList
                    .stream()
                    .filter(e -> e.getEmployeeEmail()
                            .equals(email))
                    .collect(Collectors.toList()).get(0);
        } catch (IndexOutOfBoundsException e){
            e.getStackTrace();
            matechedEmployee = null;
        }


            if (matechedEmployee != null) {
                return er.login(matechedEmployee , password);
            } else {
                return null;
            }




    }

    public void modifyPw(Employee employee, String oldPassword, String newPassword) {
        if (er.identificationByPw(employee, oldPassword)) {
            employee.setEmployeePW(newPassword);
        }
    }

    /**
     * 택배 출고시키는 함수
     * @param trackingNumber - 타겟 운송장 번호
     * @return - 일치하는 운송장 번호가 없으면 -1 반환
     */
    public int setOutcoming(String trackingNumber){
        ParcelRepository parcelRepository = new ParcelRepository();
        Parcel[] parcels = parcelRepository.getParcelArray();
        Parcel targetParcel = null;
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i].getTrackingNumber().equals(trackingNumber) ){
                targetParcel = parcels[i];
            }
        }
        if (targetParcel != null && targetParcel.getStatus().equals("입고") ){
            er.setParcelStatus(targetParcel);
            return 1;
        }
        return  -1;
    }
}
