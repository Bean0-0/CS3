public class ListFunHouse {

	// Method to print the entire list on the screen
	public static void print(ListNode list) {
		ListNode currentNode = list;
		while (currentNode != null) {
			System.out.print(currentNode.getValue() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

	// Method to return the number of nodes present in the list
	public static int nodeCount(ListNode list) {
		int count = 0;
		ListNode currentNode = list;
		while (currentNode != null) {
			count++;
			currentNode = currentNode.getNext();
		}
		return count;
	}

	// Method to double the first node
	public static void doubleFirst(ListNode list) {
		ListNode first = new ListNode(list.getValue(), list.getNext());
		list.setNext(first);
	}

	// Method to double the last node
	public static void doubleLast(ListNode list) {
		ListNode lastNode = null;
		ListNode currentNode = list;
		while (currentNode != null) {
			lastNode = currentNode;
			currentNode = currentNode.getNext();
		}

		Comparable lastNodeValue = lastNode.getValue();
		ListNode newNode = new ListNode(lastNodeValue, null);
		lastNode.setNext(newNode);
	}

	// Method to remove every other node
	public static void skipEveryOther(ListNode list) {
		ListNode currentNode = list;
		ListNode previousNode = null;
		while (currentNode != null) {
			if (previousNode != null) {
				previousNode.setNext(currentNode.getNext());
			}

			previousNode = currentNode;
			currentNode = currentNode.getNext();
			if (currentNode != null) {
				currentNode = currentNode.getNext();
			}
		}
	}

	// This method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value) {
		int count = 1;
		while (list != null) {
			if (count % x == 0) {
				list.setValue(value);
			}
			count++;
			list = list.getNext();
		}
	}

	// This method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x) {
		int count = 1;
		ListNode prev = null;
		ListNode curr = list;
		while (curr != null) {
			if (count % x == 0) {
				prev.setNext(curr.getNext());
			} else {
				prev = curr;
			}
			count++;
			curr = curr.getNext();
		}
	}
}
