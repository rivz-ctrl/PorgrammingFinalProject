package org.reeves;

public class Main {
    public static void main(String[] args) {

        Department department = new Department("Finances");

        Address address1 = new Address(5555, "Av. Songbird", "Yorknew City" ,Address.Province.ON, "W4H4L4");
        Address address2 = new Address(5556, "Av. Vagabond", "Dogtown" ,Address.Province.NS, "W7H7L7");

        Student student1 = new Student("Aubrey Graham", Student.Gender.MALE, address1, department);
        Student student2 = new Student("Miyamoto Musashi", Student.Gender.MALE, address2, department);

        Course course = new Course(department, "FF101", 2.0);

        course.addAssignment("ICE", 40, 100);
        course.addAssignment("Final", 60,100);

        course.registerStudent(new Student(student1.getStudentName(), student1.getGender(), student1.getAddress(), department));
        course.registerStudent(new Student(student2.getStudentName(), student2.getGender(), student2.getAddress(), department));

        course.generateScores();
        course.displayScores();
    }
}
