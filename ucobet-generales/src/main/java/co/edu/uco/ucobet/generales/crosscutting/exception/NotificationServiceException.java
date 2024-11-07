package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class NotificationServiceException extends UcobetException {

    private static final long serialVersionUID = 1L;

    public NotificationServiceException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.NOTIFICATION);
    }

    public static final NotificationServiceException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new NotificationServiceException(userMessage, technicalMessage, rootException);
    }

    public static final NotificationServiceException create(final String userMessage) {
        return new NotificationServiceException(userMessage, userMessage, new Exception());
    }

    public static final NotificationServiceException create(final String userMessage, final String technicalMessage) {
        return new NotificationServiceException(userMessage, technicalMessage, new Exception());
    }
}
