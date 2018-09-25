package pkg1;

/**
 * Ordered List class will represent a linked list of generic nodes, handling
 * insertion of new nodes by placing them in the correct position considering
 * the list is organized in ascending or descending order. The class will
 * contain methods that will reverse the order and print a string of the list
 * containing all nodes, also a delete method that will search through the
 * ordered list in search of a user specified node and remove it from the list.
 *
 * @author Joshua Suarez
 *
 */
public class OrderedList<E extends Comparable<E>>
{
	private Node head;

	public OrderedList()
	{
		head = null;
	}

	/**
	 * inserts a new node containing its parameter in its proper place in the
	 * list
	 *
	 * @param x info of node to be inserted into the ordered list.
	 */
	public void insert(E x)
	{
		Node newNode = new Node(x);

		//If list is empty insert first node
		if (head == null)
		{
			head = newNode;
		}
		//if list has one node and the node already in the list less than 
		//the node to be inserted, insert before.
		else if (head.next == null && head.info.compareTo(newNode.info) < 0)
		{
			head.next = newNode;
		}
		//if list has one node and the node already in the list greater than 
		//the node to be inserted, insert after.
		else if (head.next == null && head.info.compareTo(newNode.info) > 0)
		{
			newNode.next = head.next;
			head = newNode;
		}
		//if more than one node, traverse the list and place new node in 
		//correct position
		else
		{
			Node temp = head;
			Node temp2 = head.next;

			//while not end of list
			while (temp.next != null)
			{
				//Traverse the list and insert node in proper place if the 
				//list is ascending
				if (temp.info.compareTo(newNode.info) > 0
					   && this.isAscending())
				{
					newNode.next = temp2;
					temp.next = newNode;
					break;
				}
				else if (temp2.info.compareTo(newNode.info) < 0
					   && this.isAscending())
				{
					//Advance nodes one position forward
					temp = temp.next;
					temp2 = temp2.next;
				}
				else if (temp2.info.compareTo(newNode.info) > 0
					   && this.isAscending())
				{
					newNode.next = temp2;
					temp.next = newNode;
					break;
				}

				//Traverse the list and insert node in proper place if the 
				//list is descending
				else if (temp.info.compareTo(newNode.info) < 0
					   && this.isDescending())
				{
					newNode.next = temp;
					head = newNode;
					break;
				}
				else if (temp2.info.compareTo(newNode.info) > 0
					   && this.isDescending())
				{
					//Advance nodes one position forward
					temp = temp.next;
					temp2 = temp2.next;
				}
				else if (temp2.info.compareTo(newNode.info) < 0
					   && this.isDescending())
				{
					newNode.next = temp2;
					temp.next = newNode;
					break;
				}
			}
			//if node to be inserted is greater than all nodes on the 
			//list, place at last position
			if (temp.next == null)
			{
				temp.next = newNode;
			}
		}
	}

	/**
	 * Reverse the original order of the list of nodes.
	 *
	 */
	public void reverse()
	{
		//if list is empty
		if (head == null)
		{
			System.out.println("The list is empty\n");
		}
		//Create a pointer to head and declare a next and previous node 
		//initialized to null. 
		Node temp = head;
		Node prev = null;
		Node next = null;

		//While not end of list
		while (temp != null)
		{
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		//Point head to previous
		head = prev;
	}

	/**
	 * Computes and return true if the ordered list is in ascending order or
	 * false if not.
	 *
	 * @return true or false if list is in ascending order
	 */
	private boolean isAscending()
	{

		return head.info.compareTo(head.next.info) < 0;
	}

	/**
	 * Computes and return true if the ordered list is in descending order and
	 * false if not.
	 *
	 * @return true or false if list is in ascending order
	 */
	private boolean isDescending()
	{
		return head.info.compareTo(head.next.info) > 0;
	}

	/**
	 * Computes and returns a boolean value indicating if list is empty.
	 *
	 * @return true or false indicating if list is empty
	 */
	public boolean isEmpty()
	{
		return head == null;
	}

	/**
	 * Clear the ordered list. Remove all nodes from the list.
	 *
	 */
	public void clear()
	{
		head = null;
	}

	/**
	 * Deletes a specified node from the list returning true if found. If not
	 * found, no action is taken and the method will return false.
	 *
	 * @param x info of node to be deleted from the list
	 * @return true if node is found and deletes it.
	 */
	public boolean delete(E x)
	{
		if (head == null)
		{
			//list is empty
			return false;
		}
		//if head is the node to be deleted
		if (head.info.equals(x))
		{
			//set head to point to next node
			head = head.next;
			return true;
		}

		//else start at the head of the list
		Node temp = head;
		//while not last node
		while (temp.next != null)
		{
			//if x is found
			if (temp.next.info.equals(x))
			{
				temp.next = temp.next.next;
				return true;
			}
			// else, move to next node
			temp = temp.next;
		}
		//return false if node containing 
		//the specified data is not found
		return false;
	}

	/**
	 * Print a string containing all values inside the list.
	 *
	 * @return the ordered list
	 */
	public String toString()
	{
		Node temp = head;
		String out = "";

		if (temp == null)
		{
			return "The list is empty!";
		}
		else
		{
			while (temp != null)
			{
				out += temp.info + " ";
				temp = temp.next;
			}
		}

		return out;
	}

	/**
	 * Generic node class represent a generic data structure unit accepting
	 * generic info and containing a pointer to be used to point to the address
	 * of another node.
	 *
	 */
	class Node
	{

		//instance vars
		E info;		//Node info
		Node next;	//pointer to next node

		//constructor
		Node(E info)
		{
			this.info = info;
			next = null;
		}
	}//end of Node inner class declaration 

}//End of OrderedList class ==================================================
