import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * Test all methods of the OrderedList class.
 *
 * @author Joshua Suarez
 */
public class main
{

	public static void main(String[] args) throws IOException
	{
		OrderedList<Integer> list = new OrderedList<Integer>();

		Scanner in = new Scanner(new File("ordlist.txt"));

		while (in.hasNext())
		{
			String command = in.next();

			if (command.equalsIgnoreCase("insert"))
			{
				int num = in.nextInt();
				list.insert(num);
				System.out.println(num + " has been inserted into the list");
				System.out.println("The list: \n" + list.toString() + "\n");
			}
			else if (command.equalsIgnoreCase("delete"))
			{
				int num = in.nextInt();
				if (list.delete(num))
				{
					System.out.println(num + " has been deleted from the list");
					System.out.println("The list: \n" + list.toString() + "\n");
				}
				else
				{
					System.out.println(num + " does not exist.\n");
				}
			}
			else if (command.equalsIgnoreCase("REVERSE"))
			{
				list.reverse();
				System.out.println("List in reverse.");
				System.out.println("The list: \n" + list.toString() + "\n");
			}
			else if (command.equalsIgnoreCase("clear"))
			{
				list.clear();
				System.out.println("List has been cleared.");
				System.out.println("The list: \n" + list.toString() + "\n");
			}
		}
	}
}
