import java.util.ArrayList;
import java.util.List;

// Abstract CourseType
abstract class CourseType {
    public abstract String getEvaluationMethod();
}

// Exam-based course
class ExamCourse extends CourseType {
    public String getEvaluationMethod() {
        return "Evaluation by Final Exam";
    }
}

// Assignment-based course
class AssignmentCourse extends CourseType {
    public String getEvaluationMethod() {
        return "Evaluation by Assignments";
    }
}

// Research-based course
class ResearchCourse extends CourseType {
    public String getEvaluationMethod() {
        return "Evaluation by Research Papers";
    }
}
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T type;

    public Course(String courseName, String department, T type) {
        this.courseName = courseName;
        this.department = department;
        this.type = type;
    }

    public void displayDetails() {
        System.out.println("Course: " + courseName + ", Department: " + department);
        System.out.println("Evaluation: " + type.getEvaluationMethod());
    }

    public T getType() {
        return type;
    }
}

class CourseManager {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course Type: " + course.getEvaluationMethod());
        }
    }
}

public class university {
    public static void main(String[] args) {
        // Create individual course instances
        Course<ExamCourse> calculus = new Course<>("Calculus", "Mathematics", new ExamCourse());
        Course<AssignmentCourse> softwareEng = new Course<>("Software Engineering", "CS", new AssignmentCourse());
        Course<ResearchCourse> aiResearch = new Course<>("AI Research", "AI Lab", new ResearchCourse());

        // Display course details
        calculus.displayDetails();
        softwareEng.displayDetails();
        aiResearch.displayDetails();

        // Demonstrate wildcard usage
        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        System.out.println("\nDisplaying course types using wildcard:");
        CourseManager.displayAllCourses(courseTypes);
    }
}
