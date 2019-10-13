package bean;

public class Teacher
{
  private String name;
  private String workSchool;
  private int age;

  public Teacher(String name, String workSchool, int age)
  {
    this.name = name;
    this.workSchool = workSchool;
    this.age = age;
  }

  public String toString()
  {
    return name+"-"+workSchool+"-"+age;
  }

  public int hashCode()
  {
    return toString().hashCode();
  }

  public boolean equals(Object x)
  {
    return (x instanceof  Teacher)&&(toString().equalsIgnoreCase(x.toString()));
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWorkSchool() {
    return workSchool;
  }

  public void setWorkSchool(String workSchool) {
    this.workSchool = workSchool;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
