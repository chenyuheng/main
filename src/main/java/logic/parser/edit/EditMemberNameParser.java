package logic.parser.edit;

import common.DukeException;
import logic.command.Command;
import logic.command.edit.EditMemberNameCommand;

//@@author JasonChanWQ

public class EditMemberNameParser {

    public static final String EDIT_MEMBER_NAME_USAGE =
            "usage: edit member name [Old Name] /to [New Name]";
    public static final String EMPTY_OLD_NAME_MESSAGE = "[Old Name] cannot be empty!";
    public static final String EMPTY_NEW_NAME_MESSAGE = "[NEW Name] cannot be empty!";
    public static final String TO_NOT_FOUND_MESSAGE = "Please input a /to";

    //@@author JasonChanWQ
    /**
     * Parses the user input and returns EditMemberNameCommand
     * @param argument [Old Name] /to [New Name]
     * @return EditMemberNameCommand
     * @throws DukeException exception
     */

    public static Command parseEditMemberName(String argument) throws DukeException {
        if (argument.equals("")) {
            throw new DukeException(EDIT_MEMBER_NAME_USAGE);
        } else {
            String keyword = argument.trim();
            boolean isFound = keyword.indexOf("/to") != -1 ? true : false;

            if (isFound == true) {
                String[]arrOfStr = keyword.split("/to",2);
                String oldName = arrOfStr[0].trim();
                String newName = arrOfStr[1].trim();
                if (oldName.equals("")) {
                    throw new DukeException(EMPTY_OLD_NAME_MESSAGE);
                } else if (newName.equals("")) {
                    throw new DukeException(EMPTY_NEW_NAME_MESSAGE);
                } else {
                    return new EditMemberNameCommand(oldName, newName);
                }
            } else {
                throw new DukeException(TO_NOT_FOUND_MESSAGE);
            }
        }
    }
}
