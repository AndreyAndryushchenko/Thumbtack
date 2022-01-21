package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Trainee wrong first name"),
    TRAINEE_WRONG_LASTNAME("Trainee wrong last name"),
    TRAINEE_WRONG_RATING("Trainee wrong rating"),
    GROUP_WRONG_NAME("Group wrong name"),
    GROUP_WRONG_ROOM("Group wrong room"),
    TRAINEE_NOT_FOUND("Trainee not found"),
    SCHOOL_WRONG_NAME("School wrong name"),
    DUPLICATE_GROUP_NAME("Duplicate group name"),
    GROUP_NOT_FOUND("Group not found"),
    DUPLICATE_TRAINEE("Duplicate trainee"),
    EMPTY_TRAINEE_QUEUE("Empty trainee queue");

    private String message;

    TrainingErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
