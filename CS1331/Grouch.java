/**
 * Created by Marc Marone on 6/5/2016.
 * Driver/Runner to simulate Oscar (get it?)
 *
 * @author Marc Marone
 * @version 2.0
 */
public class Grouch {
    /**
     * Runner method to test Course and Student objects
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //Initialize Course objects
        Course cs1331 = new Course("CS 1331", "Howey L1", 3);
        Course math3215 = new Course("Math 3215", "Skiles 268", 3);
        Course math3012 = new Course("Math 3012", "Skiles 268", 3);
        Course cs3510 = new Course("CS 3510", "Klaus 1447", 3);
        Course phys2211 = new Course("PHYS 2211", "Howey L4", 4);

        //Test the three argument constructor
        Student carl = new Student("Carl", "CS", 3.64);

        //Test the six argument constructor
        Student carla = new Student("Carla", "ME", 3.82, phys2211, cs1331,
                math3215);

        //toString test for both cases:
        testToString(carl);
        testToString(carla);

        //tests if a Student still works with some null and some nonnull Courses
        System.out.println("Testing incomplete schedule");
        carl.setCourse2(math3012);
        System.out.println(carl);

        //tests  gpa bounds checking
        System.out.println("Testing constructor GPA bounds/default value");
        testGPA(new Student("Marc", "CS", 9.0));
        testGPA(new Student("Marc", "CS", -4.0));

        System.out.println("Testing GPA setter out of bounds");
        System.out.println("Carl's original GPA: " + carl.getGpa());

        carl.setGpa(9.9);
        testGPA(carl);

        carl.setGpa(-4.0);
        testGPA(carl);

        System.out.println();
        testGTID();

    }

    private static void testStudentGetters(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("GTID: " + student.getGtID());
        System.out.println("Major: " + student.getMajor());
        System.out.println("GPA: " + student.getGpa());
        System.out.println(student.getCourse1());
        System.out.println(student.getCourse2());
        System.out.println(student.getCourse3());
    }

    private static void testCourseGetters(Course course) {
        System.out.println("Course name: " + course.getName());
        System.out.println("Location: " + course.getLocation());
        System.out.println("Credit Hours: " + course.getHours());
    }

    private static void testToString(Student student) {
        System.out.println("Testing toString()...");
        System.out.println(student); //calls toString implicitly
        System.out.println("Should match...");
        System.out.println(student.toString()); //calls toString explicitly
    }

    private static void testGPA(Student student) {
        System.out.println(student.getName() + "'s gpa: " + student.getGpa());
    }

    private static void testGTID() {
        Student student;
        System.out.print("The following students should have unique ");
        System.out.println("consecutive GTIDs and properly capped GPAs");
        for (int i = 0; i < 5; i++) {
            student = new Student("Student " + i, "EE", (37.50 + i) / 10.0);
            System.out.println(student.getName() + " has ID "
                    + student.getGtID() + " and GPA " + student.getGpa());
        }
    }
}
