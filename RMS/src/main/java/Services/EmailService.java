package Services;

import Models.Order;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class EmailService {
    public static void sendMail(Order order) {

        String to = order.getCustomerEmail();

        String from = "ueatsrms.oop@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "toxholdygvxdtvjb");

            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("UEATS Order status update!!!");

            message.setContent("<h1>UEATS Restaurant</h1>"
                            + "<h2>Thank you for ordering food from UEATS.</h2>"
                            + "<h3>Your order is ready to pick up. Please collect your order from the counter.</h3>"
                            + "<h3>Order Summary :</h3>"
                            + String.format("<ul><li>Order ID : %d </li>", order.getId())
                            + String.format("<li>Order Date : %s </li>", order.getOrderDate())
                            + String.format("<li>Total Amount : %.2f </li></ul>", order.getBillAmount())
                            + "<h3>We hope you enjoy our food and service and that you will visit us again soon.</h3>",
                    "text/html");

            Transport.send(message);
            System.out.println("Email sent successfully!!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
