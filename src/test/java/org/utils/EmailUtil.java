package org.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class EmailUtil {

    public static void sendReport() {

        try {

            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(ExtentManager.reportPath);
            attachment.setName("Automation Report.html");

            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);

            // 🔐 Use App Password (IMPORTANT)
            email.setAuthenticator(new DefaultAuthenticator("murali@a-tkg.co.in", "xzsjjzbffhvqoxvq"));

            email.setStartTLSEnabled(true);
            // email.setSSLOnConnect(true);

            email.setFrom("murali@a-tkg.co.in");
            email.setSubject("Automation Test Report");
            email.setMsg("Please find the attached report.");

            email.addTo("murali@a-tkg.co.in");

            email.attach(attachment);

            email.send();

            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
