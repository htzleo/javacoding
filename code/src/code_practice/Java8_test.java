package code_practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8_test {
    class TempStudent {
        public String name;
        public int age;
        public Address address;
        public List<MobileNumber> mobileNumbers;

        public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.mobileNumbers = mobileNumbers;
        }
    }

    class Student{
        private String name;
        private int age;
        private Address address;
        private List<MobileNumber> mobileNumbers;

        public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.mobileNumbers = mobileNumbers;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Address getAddress() {
            return address;
        }

        public List<MobileNumber> getMobileNumbers() {
            return mobileNumbers;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
            this.mobileNumbers = mobileNumbers;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address=" + address +
                    ", mobileNumbers=" + mobileNumbers +
                    '}';
        }
    }

    class Address{
        private String zipcode;

        public Address(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
    }

    class MobileNumber{
        private String number;

        public MobileNumber(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
    @Test
    public void test(){
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

        List<Student> students = Arrays.asList(student1, student2, student3);

        /*****************************************************
         Get student with exact match name "jayesh"
         *****************************************************/
        Optional<Student> stud = students.stream()
                .filter(student -> student.getName().equals("Jayesh")).findFirst();
        System.out.println(stud.isPresent()?stud.get().getName():"Not fing");
        System.out.println("--------------------");

        /*****************************************************
         Get student with matching address "1235"
         *****************************************************/
        Optional<Student> stud1 = students.stream()
                .filter(student -> student.getAddress().getZipcode().equals("1235"))
                .findAny();
        System.out.println(stud1.isPresent() ? stud1.get().getName() : "No student found");
        System.out.println("--------------------");

        /*****************************************************
         Get all student having mobile numbers 3333.
         *****************************************************/
        List<Student> stud2 = students.stream()
                .filter(student -> student.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(), "3333")))
                .collect(Collectors.toList());
        String result1 = stud2.stream().map(std -> std.getName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result1);
        System.out.println("--------------------");

        /*****************************************************
         Get all student having mobile number 1233 and 1234
         *****************************************************/
    }
}
