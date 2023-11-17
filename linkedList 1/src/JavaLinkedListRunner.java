import static java.lang.System.*;

public class JavaLinkedListRunner
{
	public static void main ( String[] args )
	{
	  JavaLinkedList test = new JavaLinkedList(new int[]{4,5,6,7,8,9,10,11,12,13});
		out.println(test);

		test = new JavaLinkedList(new int[]{24,75,86,37,82,94,111,82,43});
		out.println(test);

		test = new JavaLinkedList(new int[]{0,4,5,2,1,4,6});
		out.println(test);

		// Sample data for first list
		int[] nums1 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		JavaLinkedList list1 = new JavaLinkedList(nums1);


		System.out.println("SUM:: " + list1.getSum());
		System.out.println("AVERAGE:: " + list1.getAvg());
		System.out.println("SMALLEST:: " + list1.getSmallest());
		System.out.println("LARGEST:: " + list1.getLargest());


		int[] nums2 = {24, 75, 86, 37, 82, 94, 111, 82, 43};
		JavaLinkedList list2 = new JavaLinkedList(nums2);


		System.out.println("\nSUM:: " + list2.getSum());
		System.out.println("AVERAGE:: " + list2.getAvg());
		System.out.println("SMALLEST:: " + list2.getSmallest());
		System.out.println("LARGEST:: " + list2.getLargest());


		int[] nums3 = {0, 4, 5, 2, 1, 4, 6};
		JavaLinkedList list3 = new JavaLinkedList(nums3);


		System.out.println("\nSUM:: " + list3.getSum());
		System.out.println("AVERAGE:: " + list3.getAvg());
		System.out.println("SMALLEST:: " + list3.getSmallest());
		System.out.println("LARGEST:: " + list3.getLargest());

	}
}