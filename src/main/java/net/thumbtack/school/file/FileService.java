package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.ColoredRectangle;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(array);
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            return fileInputStream.readAllBytes();
        }
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return fileInputStream.readAllBytes();
        }
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] byteArray;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(array.length)) {
            byteArrayOutputStream.write(array);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray)) {
            byte[] result = new byte[array.length % 2 == 0 ? array.length / 2 : array.length / 2 + 1];
            for (int i = 0; i < result.length; i++) {
                result[i] = (byte) byteArrayInputStream.read();
                byteArrayInputStream.skip(1);
            }
            return result;
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName))) {
            bufferedOutputStream.write(array);
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            bufferedOutputStream.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            return bufferedInputStream.readAllBytes();
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            return bufferedInputStream.readAllBytes();
        }
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeInt(rect.getTopLeft().getX());
            dataOutputStream.writeInt(rect.getTopLeft().getY());
            dataOutputStream.writeInt(rect.getBottomRight().getX());
            dataOutputStream.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            return new Rectangle(dataInputStream.readInt(), dataInputStream.readInt(),
                    dataInputStream.readInt(), dataInputStream.readInt());
        }
    }

    public static void writeColoredRectangleToBinaryFile(File file, ColoredRectangle rect) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeInt(rect.getTopLeft().getX());
            dataOutputStream.writeInt(rect.getTopLeft().getY());
            dataOutputStream.writeInt(rect.getBottomRight().getX());
            dataOutputStream.writeInt(rect.getBottomRight().getY());
            dataOutputStream.writeUTF(rect.getColor().toString());
        }
    }

    public static ColoredRectangle readColoredRectangleFromBinaryFile(File file) throws IOException, ColorException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            return new ColoredRectangle(dataInputStream.readInt(), dataInputStream.readInt(),
                    dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readUTF());
        }
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            for (Rectangle rect : rects) {
                dataOutputStream.writeInt(rect.getTopLeft().getX());
                dataOutputStream.writeInt(rect.getTopLeft().getY());
                dataOutputStream.writeInt(rect.getBottomRight().getX());
                dataOutputStream.writeInt(rect.getBottomRight().getY());
            }
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            Rectangle[] array = new Rectangle[(int) (randomAccessFile.length() / 16)];
            for (int i = 0; i < (int) (randomAccessFile.length() / 16); i++) {
                randomAccessFile.seek(((int) (randomAccessFile.length() / 16)) * 16 - 16 * (i + 1));
                array[i] = new Rectangle(randomAccessFile.readInt(), randomAccessFile.readInt(),
                        randomAccessFile.readInt(), randomAccessFile.readInt());
            }
            return array;
        }
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            gson.toJson(rect, fileWriter);
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException {
        try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            return gson.fromJson(fileReader, Rectangle.class);
        }
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            bufferedWriter.write(String.valueOf(rect.getTopLeft().getX()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(rect.getTopLeft().getY()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(rect.getBottomRight().getX()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(rect.getBottomRight().getY()));
            bufferedWriter.newLine();
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            return new Rectangle(Integer.parseInt(bufferedReader.readLine()),
                    Integer.parseInt(bufferedReader.readLine()),
                    Integer.parseInt(bufferedReader.readLine()),
                    Integer.parseInt(bufferedReader.readLine()));
        }
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            gson.toJson(trainee, fileWriter);
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException {
        try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            return gson.fromJson(fileReader, Trainee.class);
        }
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            bufferedWriter.write(trainee.getFirstName());
            bufferedWriter.newLine();
            bufferedWriter.write(trainee.getLastName());
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(trainee.getRating()));
            bufferedWriter.newLine();
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            return new Trainee(bufferedReader.readLine(), bufferedReader.readLine(), Integer.parseInt(bufferedReader.readLine()));
        }
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (Trainee) objectInputStream.readObject();
        }
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            gson.toJson(trainee, fileWriter);
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            return gson.fromJson(fileReader, Trainee.class);
        }
    }
}
