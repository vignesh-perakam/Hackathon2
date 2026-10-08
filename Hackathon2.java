import java.util.Scanner;

public class Hackathon2 
{

    static class Student 
    {
        String studentName;
        int rollNumber;
        double marks;
        String courseName;
        int courseCredits;

        public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) 
        {
            this.studentName = studentName;
            this.rollNumber = rollNumber;
            this.marks = marks;
            this.courseName = courseName;
            this.courseCredits = courseCredits;
        }

        public double calculateFee() 
        {
            return this.courseCredits * 1500.0;
        }

        public boolean checkEligibility() 
        {
            return this.marks >= 50.0;
        }

        public double calculateScholarship(double totalFee) 
        {
            if (this.marks >= 85.0) 
            {
                return totalFee * 0.20;
            } else if (this.marks >= 70.0 && this.marks <= 84.99) 
            {
                return totalFee * 0.10;
            } else 
            {
                return 0.0;
            }
        }

        public double calculateFinalFee(double totalFee, double scholarship) 
        {
            return totalFee - scholarship;
        }

        public void displayDetails() 
        {
            boolean eligible = checkEligibility();
            
            System.out.println("\n--- Student Details ---");
            System.out.println("Student Name : " + this.studentName);
            System.out.println("Roll Number  : " + this.rollNumber);
            System.out.println("Marks        : " + this.marks);
            System.out.println("Course Name  : " + this.courseName);
            System.out.println("Course Credits: " + this.courseCredits);
            System.out.println("Eligibility  : " + (eligible ? "Eligible" : "Not Eligible"));

            if (eligible) 
            {
                double totalFee = calculateFee();
                double scholarship = calculateScholarship(totalFee);
                double finalFee = calculateFinalFee(totalFee, scholarship);

                System.out.println("\n--- Fee Breakdown ---");
                System.out.println("Total Fee    : Rs. " + totalFee);
                System.out.println("Scholarship  : Rs. " + scholarship);
                System.out.println("Final Fee    : Rs. " + finalFee);
            } else 
            {
                System.out.println("\nStatus: Registration denied. Student marks are below 50.");
            }
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        Student student = new Student(name, roll, marks, courseName, credits);

        if (student.checkEligibility()) 
        {
            student.displayDetails();
        } else 
        {
            student.displayDetails();
        }

        sc.close();
    }
}
