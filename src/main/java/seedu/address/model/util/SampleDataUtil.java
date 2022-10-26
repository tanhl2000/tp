package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventTitle;
import seedu.address.model.event.Purpose;
import seedu.address.model.event.StartDate;
import seedu.address.model.event.StartTime;
import seedu.address.model.person.Address;
import seedu.address.model.person.DateOfBirth;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Uid;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), new Gender("male"), new DateOfBirth("13/2/1988"),
                    getTagSet("friends"), new Uid()),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new Gender("female"),
                    new DateOfBirth("11/5/1968"), getTagSet("colleagues", "friends"), new Uid()),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new Gender("female"), new DateOfBirth("4/12/2002"),
                    getTagSet("neighbours"), new Uid()),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new Gender("male"),
                    new DateOfBirth("29/7/1996"), getTagSet("family"), new Uid()),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), new Gender("male"), new DateOfBirth("2/6/1984"),
                    getTagSet("classmates"), new Uid()),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), new Gender("male"), new DateOfBirth("2/11/1954"),
                    getTagSet("colleagues"), new Uid())
        };
    }

    public static Event[] getSampleEvents() {
        return new Event[] {
            new Event(new EventTitle("22 Sale"), new StartDate("2/2/2022"), new StartTime("02:00"),
                    new Purpose("For football fans")),
            new Event(new EventTitle("44 Sale"), new StartDate("4/4/2022"), new StartTime("16:00"),
                    new Purpose("For computer scientists")),
            new Event(new EventTitle("66 Sale") , new StartDate("6/6/2022"), new StartTime("06:00"),
                    new Purpose("For car enthusiasts")),
            new Event(new EventTitle("88 Sale") , new StartDate("8/8/2022"), new StartTime("20:00"),
                    new Purpose("For bread lovers")),
            new Event(new EventTitle("1010 Sale") , new StartDate("10/10/2022"), new StartTime("10:00"),
                    new Purpose("For watch hobbyists")),
            new Event(new EventTitle("1212 Sale") , new StartDate("12/12/2022"), new StartTime("12:00"),
                    new Purpose("For stationery buyers"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        for (Event sampleEvent : getSampleEvents()) {
            sampleAb.addEvent(sampleEvent);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
