import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {
    @Test
    public void testSetAgeThrowsError() {
        Person person = new Person(1, "Anne Smith", 29, "Teacher");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-5);
        });
    }

    @Test
    public void testFindByNameProperlyFormattedName() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Anne Smith", 29, "Teacher");
        Person person2 = new Person(2, "Mark Spencer", 44, "Doctor");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        assertEquals(person1, personsList.findByName("Mark Spencer"));
    }
    @Test
    public void testFindByNameThrowsException() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(2, "Mark Spencer", 44, "Doctor");
        personsList.addPerson(person);

        assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("Mark");
        });
    }

    @Test
    public void testCloneCreateCloneObject() {
        Person originalPerson = new Person(1, "Anne Smith", 29, "Teacher");
        PersonsList personsList = new PersonsList();
        Person clonedPerson = personsList.clonePerson(originalPerson);

        assertNotEquals(originalPerson.getId(), clonedPerson.getId());

        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());
    }
}
