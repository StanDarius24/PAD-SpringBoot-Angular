package pad.SocialMedia.Exceptions;

public class TokenException extends RuntimeException {
    public TokenException(String token_invalid) {
        super(token_invalid);
    }
}
