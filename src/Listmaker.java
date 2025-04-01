import java.util.ArrayList;
import java.util.Scanner;

public class Listmaker
{

    private static ArrayList<String> userList = new ArrayList<>();

    public static void main(String[] args)
    {


        Scanner input = new Scanner(System.in);
        String menuSelection;
        boolean isDone = false;

        do
        {
            SafeInput.prettyHeader(60, "A-Add D-Delete I-Insert P-Print Q-Quit");
            menuSelection = SafeInput.getRegExString(input, "Please pick a menu option: ", "[AaDdIiPpQq]");
            menuSelection = menuSelection.toUpperCase();
            System.out.print("\n");

            if(!userList.isEmpty())
                switch (menuSelection)
                {
                    case "A":
                        addToList(input);
                        break;
                    case "D":
                        deleteFromList(input);
                        break;
                    case "I":
                        insertIntoList(input);
                        break;
                    case "P":
                        printList(input);
                        break;
                    case "Q":
                        isDone = true;
                        break;
                }
            else
            {
                switch (menuSelection)
                {
                    case "A":
                        addToList(input);
                        break;
                    case "D":
                    case "I":
                    case "P":
                        System.out.println("The list is empty, please select Add to start list.");
                        break;
                    case "Q":
                        isDone = true;
                        break;
                }
            }
        }
        while(!isDone);


    }

    private static void addToList(Scanner input)
    {
        String userAdd;

        if(!userList.isEmpty())
        {
            for (int x = 0; x < userList.size(); x++)
            {
                System.out.println((x + 1) + ": " + userList.get(x));
            }
        }
        else
        {
            System.out.println("List is empty.");
        }

        userAdd = SafeInput.getNonZeroLenString(input,"Please enter the data you would like to add: ");
        userList.add(userAdd);
        return;
    }

    private static void deleteFromList(Scanner input)
    {
        int userDelete;

        for(int x = 0; x < userList.size(); x++)
        {
            System.out.println((x + 1) + ": " + userList.get(x));
        }

        userDelete = SafeInput.getRangedInt(input,"Please enter the index number of the item you want to delete: ",1,userList.size());
        userList.remove(userDelete - 1);

        return;
    }

    private static void insertIntoList(Scanner input)
    {
        String userInsert;
        int userInsertIndex;

        for(int x = 0; x < userList.size(); x++)
            {
            System.out.println((x + 1) + ": " + userList.get(x));
            }

        userInsert = SafeInput.getNonZeroLenString(input,"Please enter the data you would like to insert: ");
        userInsertIndex = SafeInput.getRangedInt(input,"Please enter the index you would like to add at: ", 1,userList.size());

        for(int x = userList.size(); x >= userInsertIndex - 1; x--)
        {
            userList.add(userList.get(x));
        }
        userList.set(userInsertIndex - 1, userInsert);

        return;
    }

    private static void printList(Scanner input)
    {
        for(int x = 0; x < userList.size(); x++)
        {
            System.out.println((x + 1) + ": " + userList.get(x));
        }

        return;
    }

}