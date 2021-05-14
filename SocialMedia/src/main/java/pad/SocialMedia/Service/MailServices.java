package pad.SocialMedia.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pad.SocialMedia.Exceptions.MailSenderException;
import pad.SocialMedia.Model.NotificationEmail;

@Service
@AllArgsConstructor
@Slf4j
public class MailServices {

    private final MailContentBuilder mailContentBuilder;
    private final JavaMailSender mailSender;

    @Async
    public void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("mesiatehnologicagenesis@gmail.com");// sa faceti pls un mail =)))
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
        };
        try {
            mailSender.send(messagePreparator);
            log.info("Activation email send!");
            System.out.println("Activation email send");
        } catch
        ( MailException e ) {
            throw new MailSenderException("Exception occurred when sending email to " + notificationEmail.getRecipient(), e);
        }
    }
}
