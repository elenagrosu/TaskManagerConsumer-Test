package com.company;

/**
 * This is a model class to hold student object information
 *
 */

public class Student {
    private String name;
    public String faculty;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, String faculty, int age) {
        this.name = name;
        this.faculty = faculty;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Name: "+name+" Faculty: "+faculty+" Age: "+age;
    }

    @Override
    public int hashCode() {
        return (int) age * name.hashCode() * faculty.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        final Student other = (Student) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }

       if (this.age != other.age) {
            return false;
        }

        if (this.faculty != other.faculty) {
            return false;
        }

        return true;    }
}