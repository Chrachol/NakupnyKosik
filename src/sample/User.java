package sample;

public class User {

    private String Username;
    private String Email;
    private String Password;

    public User(){

    }
    public User(String Username, String Email, String Password){
        this.Username=Username;
        this.Email=Email;
        this.Password=Password;

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
