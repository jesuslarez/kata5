
package kata5;


class People {
    private String name;
    private String surname;
    private String department;
    private int id;

    public People(String name, String surname, String department) {
        this.name = name;
        this.surname = surname;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }
  
}
