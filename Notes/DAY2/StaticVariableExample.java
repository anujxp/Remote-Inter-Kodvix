class Student {

    int id;
    String name;

    static String college = "GHSC";

}

public class StaticVariableExample {

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();

        s1.id = 1;
        s1.name = "Anuj";

        s2.id = 2;
        s2.name = "Rahul";

        System.out.println(s1.id + " " + s1.name + " " + Student.college);
        System.out.println(s2.id + " " + s2.name + " " + Student.college);

    }
}
/*
Method Area / Class Area
-------------------------
college = GHSC

Heap
-----------
Student Object 1
id
name

Student Object 2
id
name

 */