package functional.service;

import functional.model.Order;

import java.time.LocalDateTime;

public class UtilityService {
    public void sendEmail(String customerId, String contents) {
        System.out.println(contents + " for : " + customerId);
    }

    public void log(String event, String id, LocalDateTime now) {
        System.out.println("Event : " + event + ", " + id + ", "+ now.toString());
    }


}
