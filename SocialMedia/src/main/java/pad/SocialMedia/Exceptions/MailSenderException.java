package pad.SocialMedia.Exceptions;



public class MailSenderException extends RuntimeException {
    public MailSenderException(String exceprion_occurred_when_sending_email, Exception e) {
        super(exceprion_occurred_when_sending_email,e);
    }
    public MailSenderException(Exception e) {
        super(e);
    }
}
