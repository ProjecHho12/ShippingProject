package loop;

public interface Controller {
    int register(String name, String email, String password, String gender, String address, String age);
    int login(String email, String password);
}
