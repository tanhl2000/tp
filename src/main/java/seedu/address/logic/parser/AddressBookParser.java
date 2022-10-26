package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddEventCommand;
import seedu.address.logic.commands.AddPersonCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteEventCommand;
import seedu.address.logic.commands.DeletePersonCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindPersonsCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListEventsCommand;
import seedu.address.logic.commands.MakeStatsCommand;
import seedu.address.logic.commands.TagEventCommand;
import seedu.address.logic.commands.UntagEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddPersonCommand.COMMAND_WORD:
            return new AddPersonCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeletePersonCommand.COMMAND_WORD:
            return new DeletePersonCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindPersonsCommand.COMMAND_WORD:
            return new FindPersonsCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommandParser().parse(arguments);
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case MakeStatsCommand.COMMAND_WORD:
            return new MakeStatsCommand();

        case ListEventsCommand.COMMAND_WORD:
            return new ListEventsCommand();

        case AddEventCommand.COMMAND_WORD:
            return new AddEventCommandParser().parse(arguments);

        case DeleteEventCommand.COMMAND_WORD:
            return new DeleteEventCommandParser().parse(arguments);
        // add TagEventCommand in AddressBook parser
        case TagEventCommand.COMMAND_WORD:
            return new TagEventCommandParser().parse(arguments);
        //add UntagEventCommand in AddressBook parser
        case UntagEventCommand.COMMAND_WORD:
            return new UntagEventCommandParser().parse(arguments);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
