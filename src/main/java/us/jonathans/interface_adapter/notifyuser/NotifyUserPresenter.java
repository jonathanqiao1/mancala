package us.jonathans.interface_adapter.notifyuser;

import us.jonathans.use_case.notify_user.NotifyUserOutputBoundary;

public class NotifyUserPresenter implements NotifyUserOutputBoundary {
    private final NotificationService notificationService;

    public NotifyUserPresenter(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void notifyUser(String phoneNumber, String message) {
        notificationService.sendNotification(phoneNumber, message);
    }
}