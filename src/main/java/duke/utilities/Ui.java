package duke.utilities;

import duke.commands.ByeCommand;
import duke.commands.DeadlineCommand;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.EventCommand;
import duke.commands.FindCommand;
import duke.commands.HelpCommand;
import duke.commands.ListCommand;
import duke.commands.ToDoCommand;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    /**
     * Logo of the bot
     */
    private static final String LOGO = " _ __ _   _  __ _ _ __\n"
            + "| '__| | | |/ _` | '_ \\\n"
            + "| |  | |_| | (_| | | | |\n"
            + "|_|   \\__, |\\__,_|_| |_|\n"
            + "       __/ |\n"
            + "      |___/";

    /**
     * A decorative spacer between user inputs and outputs by the bot
     */
    private static final String DIVIDER = "____________________________________________________________";


    private static final String MESSAGE_WELCOME = "Hello from\n"
            + LOGO
            + "\nHow can I assist you? Type something below! :D";
    private static final String MESSAGE_GOODBYE = "Bye. Hope to see you again soon!";
    private static final String MESSAGE_NO_INPUT = "No input found! Please type <mode> + item";


    private static final String TASK_PLURAL = "tasks";
    private static final String TASK_SINGLE = "task";
    private static final String PRINT_TASK_MESSAGE_FRONT = "Now you have ";
    private static final String PRINT_TASK_MESSAGE_BACK = " in the list.";
    private static final String PRINT_FOUND_MESSAGE_FRONT = "We have found ";
    private static final String PRINT_FOUND_MESSAGE_BACK = " that match!";

    private static final String SPACING = " ";
    private final Scanner in = new Scanner(System.in);

    public Ui() {
    }

    public String scanUserInput() {
        return in.nextLine();
    }

    public static void print(String... input) {
        for (String m : input) {
            System.out.println(m);
        }
    }

    /**
     * Prints the goodbye message
     */
    public static void printByeMessage() {
        System.out.println(MESSAGE_GOODBYE);
    }

    /**
     * Prints the welcome message
     */
    public static void printWelcomeMessage() {
        System.out.println(MESSAGE_WELCOME);
    }

    /**
     * Prints a divider
     */
    public static void printDivider() {
        System.out.println(DIVIDER);
    }

    /**
     * Prints the list of tasks stored
     *
     * @param tasks ArrayList to be printed
     */
    public static void printList(ArrayList<Task> tasks) {
        int counter = 1;
        for (Task t : tasks) {
            System.out.print(counter + ". ");
            System.out.println(t);
            counter++;
        }
        printTaskNumber(tasks);
    }

    /**
     * Prints the number of tasks
     */
    public static void printTaskNumber(ArrayList<Task> tasks) {
        System.out.println(PRINT_TASK_MESSAGE_FRONT + tasks.size()
                + SPACING + getPluralTask(tasks) + PRINT_TASK_MESSAGE_BACK);
    }

    /**
     * Prints the list of commands that can be used
     */
    public static void printHelp() {
        System.out.println("Commands available: ");
        print(
                ToDoCommand.COMMAND_WORD_HELP,
                EventCommand.COMMAND_WORD_HELP,
                DeadlineCommand.COMMAND_WORD_HELP,
                ListCommand.COMMAND_WORD,
                DoneCommand.COMMAND_WORD_HELP,
                DeleteCommand.COMMAND_WORD_HELP,
                FindCommand.COMMAND_WORD_HELP,
                ByeCommand.COMMAND_WORD,
                HelpCommand.COMMAND_WORD);
    }

    /**
     * Prints the list with matches in findTasks
     *
     * @param matches ArrayList to be printed
     */
    public static void printMatchingList(ArrayList<Task> matches) {
        for (int i = 0; i < matches.size(); i++) {
            System.out.println(i+1 + ". " + matches.get(i));
        }
        System.out.println(PRINT_FOUND_MESSAGE_FRONT + matches.size()
                + SPACING +  getPluralTask(matches) + PRINT_FOUND_MESSAGE_BACK);

    }

    private static String getPluralTask(ArrayList<Task> tasks) {
        return tasks.size() == 1 ? TASK_SINGLE : TASK_PLURAL;
    }
}
