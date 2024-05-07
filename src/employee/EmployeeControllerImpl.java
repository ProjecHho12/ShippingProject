package employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import parcel.parcelElement.Parcel;

import parcel.ParcelRepository;

import java.util.stream.Collectors;

public class EmployeeControllerImpl {

	private final EmployeeRepository er;
	private final ArrayList<Parcel> parcelArr;

	public EmployeeControllerImpl(EmployeeRepository employeeRepository) {
		er = employeeRepository;
        parcelArr = ParcelRepository.getInstance().getParcelArrayList();
	}

	//
//
	public int register(String name, String email, String password, String gender, String address,
		int age, int employeePhone, Job job) {
		Employee newEmployee = new Employee(name, email, password, gender, address, age,
			employeePhone, job);
		if (!this.er.isContains(newEmployee)) {
			this.er.resister(newEmployee);
			return 0;
		}
		return 1;
	}

	public Employee login(String email, String password) {
		Employee matechedEmployee;
		try {
			matechedEmployee = er.employeeList
				.stream()
				.filter(e -> e.getEmployeeEmail()
					.equals(email))
				.collect(Collectors.toList()).get(0);
		} catch (IndexOutOfBoundsException e) {
			e.getStackTrace();
			matechedEmployee = null;
		}

		if (matechedEmployee != null) {
			return er.login(matechedEmployee, password);
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
	 *
	 * @param trackingNumber - 타겟 운송장 번호
	 * @return - 일치하는 운송장 번호가 없으면 -1 반환
	 */
	public int setOutcoming(String trackingNumber) {
        Parcel targetParcel;

        try {
            targetParcel = parcelArr.stream().filter(p->p.getTrackingNumber()==trackingNumber).collect(Collectors.toList()).get(0);

			er.setParcelStatus(targetParcel);

			ParcelRepository repo = ParcelRepository.getInstance();
			repo.saveDataToFile();
            return 1;
        } catch (IndexOutOfBoundsException e){
            e.getStackTrace();
            return -1;

        }

	}

	public ArrayList<Parcel> selectAllParcel() {
		return parcelArr;
	}

	public List<Parcel> selectIncomingParcel() {
//		return Arrays.stream(parcelRepository.getParcelArray())
//			.filter(p -> p.getStatus().equals("입고")).collect(Collectors.toList());

        return parcelArr.stream().filter(p -> p.getStatus().equals("입고")).collect(Collectors.toList());
	}
}
