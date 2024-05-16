## SHIPPING PROJECT (1조 배송해조)


### 1. 프로젝트 소개
고객과 직원으로 나누어 회원가입과 로그인을 하고 택배를 접수하는 프로그램입니다.

### 2. 팀원소개    

| 팀원소개 | 담당 | Github                                      |
|------|----|---------------------------------------------|
| 문지은 | 직원 | [@munmimi](https://github.com/munmimi)      |
| 배윤정 | 택배 | [@yunjeongg](https://github.com/yunjeongg)  |
| 주우빈 | 고객 | [@binwoojoo](https://github.com/binwoojoo)  |
| 송호성 | 통합 | [@hoseong511](https://githubcom/hoseong511) |


### 3. 기술 스택 및 협업도구
 - Java
 - Figma
 - Discord
 - Github
 - Intelli J
 
### 4. 주요기능 및 로직 소개
- 로그인 : 고객과 직원으로 나뉘어 이메일 & 비밀번호를 입력하고 인증을 통해 로그인
- 회원가입 : 고객과 직원으로 나뉘어 이름, 이메일, 비밀번호, 성별, 주소, 나이를 입력하고 검증을 통해 회원 및 직원으로 등록
- 택배접수 : 보내는 분, 받는 분, 상품정보의 입력과 검증을 통해 택배를 접수

### 5. 프로젝트 구조
 ```bash
    ├── src
    │   ├── main.customer
    │   │   ├── Customer.java
    │   │   ├── CustomerController.java
    │   │   ├── CustomerControllerImpl.java
    │   │   ├── CustomerRepository.java
    │   │   ├── CustomerRepositoryInter.java
    │   │   ├── Gender.java
    │   │   └── LoginStatus.java
    │   ├── main.employee
    │   │   ├── Employee.java
    │   │   ├── EmployeeControllerImpl.java
    │   │   ├── EmployeeRepository.java
    │   │   ├── Job.java
    │   │   └── Journal.java
    │   ├── main.loop
    │   │   ├── AppConfig.java
    │   │   ├── CustomerViewImpl.java
    │   │   ├── EmployeeViewImpl.java
    │   │   └── MainViewImpl.java
    │   ├── main.parcel
    │   │   ├── parcelElement.java
    │   │   ├── ParcelRepository.java
    │   │   ├── ParcelView.java
    │   │   └── StringInput.java
    │   ├── main.util
    │   │   └── SimpleInput.java
    │   └── main.java
    ├── .gitignore
    └── README.md
``` 

### 6. 개발 일정
- 04.25 ~ 04.26 : 주제 선정, 방향성 회의 
- 04.26 ~ 04.30 : Java 기능설계 및 구현 
- 05.01 : 통합 
- 05.02 ~ 05.03 :  기능 오류 수정 
- 05.03 ~ 05.07 : PPT제작 및 발표준비 

### 7. 구현화면
<img width="1436" alt="image" src="https://github.com/ProjecHho12/ShippingProject/assets/62678380/de999114-46a2-4ff6-8a8f-6c023d662764">

### 8. 업데이트 예정
- 직원의 입고/출고에 따라서 담당 업무 구분하기
- 유지보수와 확장에 유연하도록 객체지향 설계 기본 원칙 적용하기
- 기존 회원이 새로 택배를 보내는 경우, 주소록을 따로 저장해 주소 입력을 간편화하기
- 고객의 택배 받기 기능을 추가하여 고객과의 상호작용 강화하기
