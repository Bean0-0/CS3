public class HashTable {
	private ListNode[] table;

	public HashTable() {
		table = new ListNode[10];
	}

	public void add(Object obj) {
		int hash = getHash(obj.toString());
		ListNode newNode = new ListNode(obj);

		if (table[hash] == null) {
			table[hash] = newNode;
		} else {
			ListNode current = table[hash];
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}

	private int getHash(String word) {
		int vowelCount = 0;
		int letterCount = 0;
		for (char c : word.toCharArray()) {
			if (isVowel(c)) {
				vowelCount++;
			}
			letterCount++;
		}
		return (vowelCount * letterCount) % 10;
	}

	private boolean isVowel(char c) {
		return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
	}

	public String toString() {
		String output = "HASHTABLE\n";

		for (int i = 0; i < table.length; i++) {
			output += "bucket " + i + ": ";
			if (table[i] != null) {
				ListNode current = table[i];
				while (current != null) {
					output += current.getData() + " ";
					current = current.getNext();
				}
			}
			output += "\n";
		}

		return output;
	}
}

class ListNode {
	private Object data;
	private ListNode next;

	public ListNode(Object data) {
		this.data = data;
		this.next = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}
