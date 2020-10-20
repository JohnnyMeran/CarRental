package ro.jademy.carrental.model.users;

public class Client extends User {
    private int clientId;
    private String phoneNumber;
    private int cnp;

    public Client(int userId, int clientId, String firstName, String lastName, String userName, String passWord, String phoneNumber, int cnp){
        this.userId = userId;
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.cnp = cnp;
    }

    public Client(String firstName, String lastName, String userName, String passWord) {

    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }
}
