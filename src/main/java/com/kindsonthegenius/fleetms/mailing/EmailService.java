package com.kindsonthegenius.fleetms.mailing;

import javax.mail.MessagingException;

public interface EmailService {

    void sendMail(AbstractEmailContext email) throws MessagingException;
}
