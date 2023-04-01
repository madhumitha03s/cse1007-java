package DA1;

// Student class
class Student {
  String name;
  int age;
  String rollNumber;
  String address;

  public Student(String name, int age, String rollNumber, String address) {
    this.name = name;
    this.age = age;
    this.rollNumber = rollNumber;
    this.address = address;
  }

  public void display() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Roll Number: " + rollNumber);
    System.out.println("Address: " + address);
  }
}

// RegularStudent subclass
class RegularStudent extends Student {
  String batch;
  int semester;

  public RegularStudent(String name, int age, String rollNumber, String address, String batch, int semester) {
    super(name, age, rollNumber, address);
    this.batch = batch;
    this.semester = semester;
  }

  @Override
  public void display() {
    super.display();
    System.out.println("Batch: " + batch);
    System.out.println("Semester: " + semester);
  }
}

// DistanceLearningStudent subclass
class DistanceLearningStudent extends Student {
  String program;

  public DistanceLearningStudent(String name, int age, String rollNumber, String address, String program) {
    super(name, age, rollNumber, address);
    this.program = program;
  }

  @Override
  public void display() {
    super.display();
    System.out.println("Program: " + program);
  }
}
