import java.io.*;

public class StudentDataStreamExample {

    public static void main(String[] args) {
        String fileName = "students.dat";

        // Writing student details to binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // You can add multiple students here
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(8.5);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(9.0);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(7.8);

            System.out.println("Student data written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading student details from binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nRetrieved Student Data:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
