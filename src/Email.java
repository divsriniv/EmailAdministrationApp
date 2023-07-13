import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "xyzcompany.com";

    //Email constrcutor to recieve employee's first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
       

        //Call setDepartment method
        this.department = setDepartment();

        //Call rnadomPassword method to set 
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Department method that asks for department and returns it 
    private String setDepartment() {
        System.out.print("Hey employee: " + firstName + " . Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1){
            return "Sales";
        }

        else if (departmentChoice == 2){
            return "dev";
        }

        else if (departmentChoice == 3){
            return "acct";
        }

        else {
            return "";
        }

    }

    //Password method that sets a random passowrd
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);



    }

    //Method that sets mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
        
    }

    //Method that sets alternate email
    public void setAlternateEmail(String alt){
        this.alternateEmail = alt;
    }

    //Method that sets alternate password
    public void changePassword(String passowrd){
        this.password = password;
    }

    //getter method for mailbox capacity
    public int getMailbocCapacity(){
        return mailboxCapacity;
    }

    //getter method for alternate email
    public String getAlternateEmail(){
        return alternateEmail;
    }

    //getter method for password
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
               "\nCOMPANY EMAIL: " + email + 
               "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}