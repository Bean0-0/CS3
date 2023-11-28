
public class HistoList {

	private HistoNode front;


	public HistoList() {
		front = null;
	}


	public void addLetter(char let) {
		HistoNode temp = front;
		while (temp != null) {
			if (temp.getLetter() == let) {
				temp.setLetterCount(temp.getLetterCount() + 1);
				return;
			}
			temp = temp.getNext();
		}
		front = new HistoNode(let, 1, front);
	}


	public void removeLetter(char let) {
		if (front != null && front.getLetter() == let) {
			front = front.getNext();
			return;
		}
		HistoNode temp = front;
		while (temp.getNext() != null) {
			if (temp.getNext().getLetter() == let) {
				temp.setNext(temp.getNext().getNext());
				return;
			}
			temp = temp.getNext();
		}
	}


	public int indexOf(char let) {
		int index = 0;
		HistoNode temp = front;

		while (temp != null) {
			if (temp.getLetter() == let) {
				return index;
			}
			index++;
			temp = temp.getNext();
		}

		return -1;
	}


	private HistoNode nodeAt(int spot) {
		HistoNode current = null;
		int count = 0;

		if (spot < 0) {
			return null;
		}

		current = front;
		while (count < spot && current != null) {
			current = current.getNext();
			count++;
		}

		return current;
	}


	public String toString() {
		String output = "";
		HistoNode temp = front;

		while (temp != null) {
			output += temp.getLetter() + " - " + temp.getLetterCount() + "    ";
			temp = temp.getNext();
		}

		return output;
	}
}
