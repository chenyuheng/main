package logic.command;

import model.Model;
import model.Task;
import model.TasksManager;
import common.DukeException;

public class UndoneCommand extends Command {
    int[] indexes;

    public UndoneCommand(int[] indexes) {
        this.indexes = indexes;
    }

    //@@author chenyuheng
    @Override
    /**
     * Undone task(s). The inversion of command Done.
     * @param model model
     * @return The executed output.
     * @throws DukeException If the arguments of this command is invalid.
     */
    public CommandOutput execute(Model model) throws DukeException {
        TasksManager tasksManager = model.getTasksManager();
        checkAvailability(model);
        String output = "";
        for (int i = 0; i < indexes.length; i++) {
            Task task = tasksManager.getTaskById(indexes[i]);
            if (!task.isDone()) {
                output += "Task " + task.getName() + " is undone originally.\n";
            } else {
                task.markAsUndone();
                output += "Noted, marked task " + task.getName() + " as undone.\n";
            }
        }
        model.save();
        return new CommandOutput(output);
    }

    //@@author chenyuheng
    /**
     * Checks if task is in task list, and if it is a valid index
     * @param model model object
     * @throws DukeException If index if not availability
     */
    public void checkAvailability(Model model) throws DukeException {
        int taskListLength = model.getTaskList().size();
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] < 0 || indexes[i] >= taskListLength) {
                throw new DukeException("Index " + (indexes[i] + 1) + " out of range.\n Please try again.");
            }
        }
    }

}
