package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeQueue {
    private Queue<Trainee> traineeQueue;

    public TraineeQueue() {
        traineeQueue = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        traineeQueue.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        if (traineeQueue.peek() == null) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return traineeQueue.poll();
    }

    public boolean isEmpty() {
        return traineeQueue.isEmpty();
    }
}
