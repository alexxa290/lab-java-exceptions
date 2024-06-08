
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PersonsList {
    private List<Person> personList;

    public void addPerson(Person person) {
        personList.add(person);
    }
    public PersonsList() {
        this.personList = personList;
    }
    public Person findByName (String name) throws IllegalArgumentException {
        if ((name.split(" ").length) != 2) {
            throw new IllegalArgumentException("The name should be formatted as \"firstName lastName\"");
        } else {
            for (Person person : personList) {
                if (Objects.equals(person.getName(), name)) {
                    return person;
                }
            }
        }
        throw new NullPointerException("There is not any person in the list with the specified name");
    }
    public Person clonePerson (Person person) {
        Random random = new Random();
        int randomId = random.nextInt(1000000);
        return new Person(randomId, person.getName(), person.getAge(),person.getOccupation());
    }
    public void writePersonInfo (Person person) throws IOException {
        try {
            File file = new File("Info about " + person.getName() + ".txt");
            String message = " Id: "+person.getId() + "\n Name: " +person.getName() + "\n Age: " + person.getAge() + "\n Occupation: " + person.getOccupation();

            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Creating new file about " + person.getName());
                message = "**Original info at " + new Date() + "** \n" + message;
            } else {
                System.out.println("Updating current existing file about " + person.getName());
                message = "\r\n\n**Updated info at " + new Date() + "** \n" + message;
            }

            FileWriter writer = new FileWriter("Info about " + person.getName() + ".txt",true);
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            System.out.println("There was an error when creating the file: " + e.getMessage());
        }
    }
}
