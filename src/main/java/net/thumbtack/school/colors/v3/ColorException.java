package net.thumbtack.school.colors.v3;

public class ColorException extends Exception {
    private ColorErrorCode errorCode;

    public ColorException(ColorErrorCode errorCode) {
        super(errorCode.getErrorString());
        this.errorCode = errorCode;
    }

    public ColorErrorCode getErrorCode() {
        return errorCode;
    }
}
