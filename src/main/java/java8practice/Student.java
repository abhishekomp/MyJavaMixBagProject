package java8practice;

public class Student {
    private String name;
    private String surname;
    private String city;
    private double avgGrade;
    private int age;

    public Student(String name, String surname, String city, double avgGrade, int age) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.avgGrade = avgGrade;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", avgGrade=" + avgGrade +
                ", age=" + age +
                '}';
    }
}
