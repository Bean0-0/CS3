public class Main {
    public static void main(String[] args) {
        int[] arr1 = {34, 64, 87, 56, 31, 98, 54, 12, 52, 67};
        int[] arr2 = {54, 77, 68, 21, 35, 24, 10, 39, 75, 82};

        Sorts sorts = new Sorts();
        sorts.bubbleSort(arr1);
        sorts.insertionSort(arr2);
    }
}