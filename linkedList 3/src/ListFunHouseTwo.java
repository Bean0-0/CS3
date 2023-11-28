public class ListFunHouseTwo {

	private ListNode theList;

	public ListFunHouseTwo() {

	}

	public void add(Comparable data) {
		ListNode newNode = new ListNode(data, theList);
		theList = newNode;
	}

	// this method will return the number of nodes present in list
	public int nodeCount() {
		int count = 0;
		ListNode currentNode = theList;
		while (currentNode != null) {
			count++;
			currentNode = currentNode.getNext();
		}
		return count;
	}

	// this method will create a new node with the same value as the first node and add this
	// new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst() {
		if (theList != null) {
			ListNode newNode = new ListNode(theList.getValue(), theList);
			theList = newNode;
		}
	}

	// this method will create a new node with the same value as the last node and add this
	// new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast() {
		if (theList != null) {
			ListNode currentNode = theList;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			ListNode newNode = new ListNode(currentNode.getValue(), null);
			currentNode.setNext(newNode);
		}
	}

	// method skipEveryOther will remove every other node
	public void skipEveryOther() {
		if (theList != null) {
			ListNode currentNode = theList;
			ListNode previousNode = null;
			while (currentNode != null) {
				if (previousNode != null) {
					previousNode.setNext(currentNode.getNext());
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
	}

	// this method will set the value of every xth node in the list
	public void setXthNode(int x, Comparable value) {
		if (theList != null) {
			int count = 1;
			ListNode currentNode = theList;
			while (currentNode != null) {
				if (count % x == 0) {
					currentNode.setValue(value);
				}
				count++;
				currentNode = currentNode.getNext();
			}
		}
	}

	// this method will remove every xth node in the list
	public void removeXthNode(int x) {
		if (theList != null) {
			int count = 1;
			ListNode currentNode = theList;
			ListNode previousNode = null;
			while (currentNode != null) {
				if (count % x == 0) {
					if (previousNode != null) {
						previousNode.setNext(currentNode.getNext());
					} else {
						theList = currentNode.getNext();
					}
				} else {
					previousNode = currentNode;
				}
				count++;
				currentNode = currentNode.getNext();
			}
		}
	}

	// this method will return a String containing the entire list
	public String toString() {
		String output = "";
		ListNode currentNode = theList;
		while (currentNode != null) {
			output += currentNode.getValue() + " ";
			currentNode = currentNode.getNext();
		}
		return output;
	}
}
