package us.jonathans.interface_adapter.notifyuser;

import us.jonathans.use_case.notify_user.NotifyUserInputBoundary;
import us.jonathans.use_case.notify_user.NotifyUserInputData;

public class NotifyUserController {

    private final NotifyUserInputBoundary notifyUserUseCaseInteractor;

    public NotifyUserController(NotifyUserInputBoundary notifyUserUseCaseInteractor) {
        this.notifyUserUseCaseInteractor = notifyUserUseCaseInteractor;
    }

    public void notifyUser(String phoneNumber, String username) {
        NotifyUserInputData notifyUserInputData = new NotifyUserInputData(phoneNumber, username);
        notifyUserUseCaseInteractor.execute(notifyUserInputData);
    }
}
