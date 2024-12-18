package ru.olejka.sorting.algorithms;

public class LinSort {
	public static void lsdRadixSort(int[] array) {
		lsdRadixSort(array, 0, array.length - 1);
	}

	public static void lsdRadixSort(int[] array, int start, int end) {
		int max = findMax(array, start, end);
		int exp = 1;
		int[] temp = new int[end - start + 1];

		while (max / exp > 0) {
			int[] count = new int[10];
			for (int i = start; i <= end; i++) {
				int digit = (array[i] / exp) % 10;
				count[digit]++;
			}
			for (int i = 1; i < 10; i++) {
				count[i] += count[i - 1];
			}
			for (int i = end; i >= start; i--) {
				int digit = (array[i] / exp) % 10;
				temp[--count[digit]] = array[i];
			}
			System.arraycopy(temp, 0, array, start, temp.length);
			exp *= 10;
		}
	}

	public static void msdRadixSort(int[] array) {
		msdRadixSort(array, 0, array.length - 1, findMaxDigit(array));
	}

	public static void msdRadixSort(int[] array, int start, int end, int digit) {
		if (start >= end || digit < 0) {
			return;
		}

		int[] count = new int[10];
		int[] temp = new int[end - start + 1];
		int divisor = (int) Math.pow(10, digit);

		for (int i = start; i <= end; i++) {
			int currentDigit = (array[i] / divisor) % 10;
			count[currentDigit]++;
		}
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		for (int i = end; i >= start; i--) {
			int currentDigit = (array[i] / divisor) % 10;
			temp[--count[currentDigit]] = array[i];
		}
		System.arraycopy(temp, 0, array, start, temp.length);

		for (int i = 0; i < 10; i++) {
			int subStart = (i == 0) ? start : start + count[i - 1];
			int subEnd = start + count[i] - 1;
			msdRadixSort(array, subStart, subEnd, digit - 1);
		}
	}

	private static int findMaxDigit(int[] array) {
		int max = findMax(array, 0, array.length - 1);
		int digitCount = 0;
		while (max > 0) {
			digitCount++;
			max /= 10;
		}
		return digitCount - 1;
	}

	public static void countingSort(int[] array) {
		countingSort(array, 0, array.length - 1);
	}

	public static void countingSort(int[] array, int start, int end) {
		int min = findMin(array, start, end);
		int max = findMax(array, start, end);
		int range = max - min + 1;

		int[] count = new int[range];
		int[] output = new int[end - start + 1];

		for (int i = start; i <= end; i++) {
			count[array[i] - min]++;
		}
		for (int i = 1; i < range; i++) {
			count[i] += count[i - 1];
		}
		for (int i = end; i >= start; i--) {
			output[--count[array[i] - min]] = array[i];
		}
		System.arraycopy(output, 0, array, start, output.length);
	}

	private static int findMax(int[] array, int start, int end) {
		int max = array[start];
		for (int i = start + 1; i <= end; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	private static int findMin(int[] array, int start, int end) {
		int min = array[start];
		for (int i = start + 1; i <= end; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
}
