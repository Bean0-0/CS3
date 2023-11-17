import java.util.LinkedList;

public class JavaLinkedList {
	private LinkedList<Integer> list;

	public JavaLinkedList() {
		list = new LinkedList<>();
	}

	public JavaLinkedList(int[] nums) {
		list = new LinkedList<>();
		for (int num : nums) {
			list.add(num);
		}
	}

	public double getSum() {
		double total = 0;
		for (int num : list) {
			total += num;
		}
		return total;
	}

	public double getAvg() {
		double sum = getSum();
		return sum / list.size();
	}

	public int getLargest() {
		int largest = Integer.MIN_VALUE;
		for (int num : list) {
			largest = Math.max(largest, num);
		}
		return largest;
	}

	public int getSmallest() {
		int smallest = Integer.MAX_VALUE;
		for (int num : list) {
			smallest = Math.min(smallest, num);
		}
		return smallest;
	}

	public String toString() {
		StringBuilder output = new StringBuilder();
		for (int num : list) {
			output.append(num).append(" ");
		}
		return output.toString();
	}
}
