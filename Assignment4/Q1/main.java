import java.util.*;

class Course {
    String courseCode;
    String courseName;
    int capacity;
    HashSet<String> enrolledStudents;
    ArrayList<String> prerequisites;
    LinkedList<String> waitlist;
    Course(String code, String name, int capacity) {
        this.courseCode = code;
        this.courseName = name;
        this.capacity = capacity;
        enrolledStudents = new HashSet<>();
        prerequisites = new ArrayList<>();
        waitlist = new LinkedList<>();
    }
    void addPrerequisite(String code) {
        if (!prerequisites.contains(code)) {
            prerequisites.add(code);
        }
    }
}

class CourseRegistrationPortal {
    private HashMap<String, Course> courses;
    private HashMap<String, HashSet<String>> completedCourses;
    private HashMap<String, HashSet<String>> studentCourses;

    CourseRegistrationPortal() {
        courses = new HashMap<>();
        completedCourses = new HashMap<>();
        studentCourses = new HashMap<>();
    }

    public void addCourse(String code, String name, int capacity) {
        if (courses.containsKey(code)) {
            System.out.println("Course already exists!");
            return;
        }
        if (capacity <= 0) {
            System.out.println("Capacity must be positive!");
            return;
        }
        courses.put(code, new Course(code, name, capacity));
        System.out.println("Course added: " + code);
    }

    public void addPrerequisite(String courseCode, String prerequisiteCode) {
        Course course = courses.get(courseCode);
        if (course == null ||
            !courses.containsKey(prerequisiteCode)) {
            System.out.println("Invalid course code!");
            return;
        }
        if (courseCode.equals(prerequisiteCode)) {
            System.out.println("A course cannot require itself!");
            return;
        }
        course.addPrerequisite(prerequisiteCode);
        System.out.println("Prerequisite added.");
    }

    public void completeCourse(String studentId, String courseCode) {
        if (!courses.containsKey(courseCode)) {
            System.out.println("Course does not exist!");
            return;
        }
        completedCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(courseCode);
        System.out.println(studentId + " completed " + courseCode);
    }

    private boolean checkPrerequisites(String studentId, Course course) {
        HashSet<String> completed = completedCourses.getOrDefault(studentId, new HashSet<>());
        for (String prerequisite : course.prerequisites) {
            if (!completed.contains(prerequisite)) {
                System.out.println("Missing prerequisite: " + prerequisite);
                return false;
            }
        }
        return true;
    }

    public void registerStudent(String studentId, String courseCode) {
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        if (course.enrolledStudents.contains(studentId)) {
            System.out.println("Already enrolled!");
            return;
        }
        if (course.waitlist.contains(studentId)) {
            System.out.println("Already on waitlist!");
            return;
        }
        if (!checkPrerequisites(studentId, course)) {
            System.out.println("Registration denied!");
            return;
        }
        if (course.enrolledStudents.size() < course.capacity) {
            course.enrolledStudents.add(studentId);
            studentCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(courseCode);
            System.out.println(studentId + " successfully enrolled in " +courseCode);
        }
        else {
            course.waitlist.addLast(studentId);
            System.out.println(studentId + " added to waitlist for " +courseCode);
        }
    }

    public void dropCourse(String studentId, String courseCode) {
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        if (!course.enrolledStudents.remove(studentId)) {
            System.out.println("Student is not enrolled!");
            return;
        }
        HashSet<String> studentEnrollment = studentCourses.get(studentId);
        if (studentEnrollment != null) {
            studentEnrollment.remove(courseCode);
        }
        System.out.println(studentId + " dropped " + courseCode);
        promoteWaitlistedStudent(course);
    }

    private void promoteWaitlistedStudent(Course course) {
        Iterator<String> iterator = course.waitlist.iterator();
        while (iterator.hasNext()) {
            String studentId = iterator.next();
            if (checkPrerequisites(studentId, course)) {
                iterator.remove();
                course.enrolledStudents.add(studentId);
                studentCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(course.courseCode);System.out.println(studentId + " promoted from waitlist to " +course.courseCode);
                return;
            }
        }
        System.out.println("No eligible waitlisted student.");
    }

    public void displayCourse(String courseCode) {
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        System.out.println("\n--- Course Details ---");
        System.out.println("Code: " + course.courseCode);
        System.out.println("Name: " + course.courseName);
        System.out.println("Capacity: " + course.capacity);
        System.out.println("Enrolled Students: " + course.enrolledStudents);
        System.out.println("Prerequisites: " + course.prerequisites);

        System.out.println("Waitlist: " + course.waitlist);

        System.out.println("Available Seats: " + (course.capacity - course.enrolledStudents.size()));
    }

    public void displayStudentCourses(String studentId) {
        System.out.println("Courses for " + studentId + ": " +studentCourses.getOrDefault(studentId, new HashSet<>()));
    }
}

public class Main {
    public static void main(String[] args) {
        CourseRegistrationPortal portal = new CourseRegistrationPortal();

        portal.addCourse("CS101", "Programming Basics", 2);
        portal.addCourse("CS201", "Data Structures", 2);
        portal.addCourse("CS301", "Algorithms", 1);

        portal.addPrerequisite("CS201", "CS101");
        portal.addPrerequisite("CS301", "CS201");

        portal.completeCourse("S101", "CS101");
        portal.completeCourse("S102", "CS101");
        portal.completeCourse("S103", "CS101");
        portal.completeCourse("S104", "CS101");

        portal.registerStudent("S101", "CS201");
        portal.registerStudent("S102", "CS201");
        portal.registerStudent("S103", "CS201");

        portal.dropCourse("S101", "CS201");

        portal.displayCourse("CS201");

        portal.displayStudentCourses("S103");
    }
}
