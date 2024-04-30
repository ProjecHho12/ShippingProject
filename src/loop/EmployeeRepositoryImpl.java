package loop;

public class EmployeeRepositoryImpl implements Repository{

    @Override
    public boolean checkId(String email) {
        return false;
    }

    @Override
    public boolean checkPassword(String email, String password) {
        return false;
    }
}
