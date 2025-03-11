package Tasks;

import java.util.ArrayList;

public class Task3 {
    public static class Employee {
        public static ArrayList<Employee> getExampleList() {
            var exampleList = new ArrayList<Employee>();
            exampleList.add(new Employee("John", 32, "Building", 35000.0));
            exampleList.add(new Employee("Alisa", 32, "Logistics", 21700.1));
            exampleList.add(new Employee("Ben", 32, "Developing", 55320.0));
            exampleList.add(new Employee("Kelvin", 32, "Design", 43090.5));
            exampleList.add(new Employee("Elizabeth", 32, "Analytics", 38505.9));
            exampleList.add(new Employee("Sam", 32, "Developing", 49210.0));

            return exampleList;
        }

        public Employee() {
            this.fullName = "";
            this.age = 0;
            this.department = "";
            this.salary = 0.0;
        }

        public Employee(String fullName, Integer age, String department, Double salary) {
            this.fullName = fullName;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getFullName() {
            return this.fullName;
        }

        public void setAge(Integer age) {
            if(age < 0) {
                this.age = 0;
                System.out.println("Age should not be negative!");
                return;
            }
            this.age = age;
        }

        public Integer getAge() {
            return this.age;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }

        public void setSalary(Double salary) {
            if(salary < 0) {
                this.salary = 0.0;
                System.out.println("Salary should not be negative");
                return;
            }
            this.salary = salary;
        }

        public Double getSalary() {
            return  this.salary;
        }

        private String fullName;
        private Integer age;
        private String department;
        private Double salary;
    }
}
