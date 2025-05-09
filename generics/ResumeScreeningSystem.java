import java.util.*;

// Abstract class representing a generic Job Role
abstract class JobRole {
    String candidateName;
    int experience; // in years

    JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }

    abstract boolean isEligible();
    abstract String getRoleName();
}

// Concrete Job Roles

class SoftwareEngineer extends JobRole {
    String[] programmingLanguages;

    SoftwareEngineer(String candidateName, int experience, String[] languages) {
        super(candidateName, experience);
        this.programmingLanguages = languages;
    }

    @Override
    boolean isEligible() {
        return experience >= 2 && programmingLanguages.length >= 2;
    }

    @Override
    String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    int projectsCompleted;

    DataScientist(String candidateName, int experience, int projectsCompleted) {
        super(candidateName, experience);
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    boolean isEligible() {
        return experience >= 3 && projectsCompleted >= 5;
    }

    @Override
    String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    boolean hasMBA;

    ProductManager(String candidateName, int experience, boolean hasMBA) {
        super(candidateName, experience);
        this.hasMBA = hasMBA;
    }

    @Override
    boolean isEligible() {
        return experience >= 4 && hasMBA;
    }

    @Override
    String getRoleName() {
        return "Product Manager";
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private T jobRole;

    Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("Processing resume for: " + jobRole.candidateName);
        if (jobRole.isEligible()) {
            System.out.println("✅ Eligible for " + jobRole.getRoleName());
        } else {
            System.out.println("❌ Not eligible for " + jobRole.getRoleName());
        }
    }
}

// Utility class with wildcard method
class ResumeProcessor {
    public static void bulkScreening(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            Resume<? extends JobRole> resume = new Resume<>(role);
            resume.processResume();
            System.out.println();
        }
    }
}

// Main class
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> applicants = new ArrayList<>();

        applicants.add(new SoftwareEngineer("Alice", 3, new String[]{"Java", "Python"}));
        applicants.add(new DataScientist("Bob", 2, 4));
        applicants.add(new ProductManager("Carol", 5, true));
        applicants.add(new SoftwareEngineer("Dave", 1, new String[]{"C++"}));

        ResumeProcessor.bulkScreening(applicants);
    }
}
