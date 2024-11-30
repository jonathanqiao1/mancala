package us.jonathans.use_case.notify_user;

/**
 * Input data for the user's phone number
 */

public class NotifyUserInputData {
    private String phoneNumber;
    private String username;


    public NotifyUserInputData(String phoneNumber, String username) {
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

}
