package personal.trainings.java17;

/**
 * An example of a record with multiple constructors and static variables and method
 * @param id
 * @param firstName
 * @param lastName
 */
public record Employee(int id, String firstName, String lastName)
{
    static int empToken;

    // Compact Constructor
    public Employee
    {
        if (id < 100) {
            throw new IllegalArgumentException(
                    "Employee Id cannot be below 100.");
        }
        if (firstName.length() < 2) {
            throw new IllegalArgumentException(
                    "First name must be 2 characters or more.");
        }
    }

    // Alternative Constructor
    public Employee(int id, String firstName)
    {
        this(id, firstName, null);
    }

    // Instance methods
    public void getFullName()
    {
        if (lastName == null)
            System.out.println(firstName());

        else
            System.out.println(firstName() + " "
                    + lastName());
    }

    // Static methods
    public static int generateEmployeeToken()
    {
        return ++empToken;
    }
}