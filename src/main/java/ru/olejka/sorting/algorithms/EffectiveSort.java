package ru.olejka.sorting.algorithms;

import java.util.Comparator;

public class EffectiveSort {
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}

	public static void heapSort(int[] array) {
		int n = array.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(array, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0);
		}
	}

	private static void heapify(int[] array, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && array[left] > array[largest]) {
			largest = left;
		}

		if (right < n && array[right] > array[largest]) {
			largest = right;
		}

		if (largest != i) {
			int swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;

			heapify(array, n, largest);
		}
	}

	public static void mergeSort(int[] array) {
		if (array.length < 2) {
			return;
		}
		int mid = array.length / 2;
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];

		System.arraycopy(array, 0, left, 0, mid);
		System.arraycopy(array, mid, right, 0, array.length - mid);

		mergeSort(left);
		mergeSort(right);

		merge(array, left, right);
	}

	private static void merge(int[] array, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}

		while (i < left.length) {
			array[k++] = left[i++];
		}

		while (j < right.length) {
			array[k++] = right[j++];
		}
	}

	public static <T extends Comparable<T>> void quickSort(T[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}

	private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
		T pivot = array[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				T temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		T temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}

	public static <T extends Comparable<T>> void mergeSort(T[] array) {
		if (array.length < 2) {
			return;
		}
		int mid = array.length / 2;
		T[] left = (T[]) new Comparable[mid];
		T[] right = (T[]) new Comparable[array.length - mid];

		System.arraycopy(array, 0, left, 0, mid);
		System.arraycopy(array, mid, right, 0, array.length - mid);

		mergeSort(left);
		mergeSort(right);

		merge(array, left, right);
	}

	private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (left[i].compareTo(right[j]) <= 0) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}

		while (i < left.length) {
			array[k++] = left[i++];
		}

		while (j < right.length) {
			array[k++] = right[j++];
		}
	}

	public static <T> void heapSort(T[] array, Comparator<T> comparator) {
		int n = array.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(array, n, i, comparator);
		}

		for (int i = n - 1; i >= 0; i--) {
			T temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0, comparator);
		}
	}

	private static <T> void heapify(T[] array, int n, int i, Comparator<T> comparator) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && comparator.compare(array[left], array[largest]) > 0) {
			largest = left;
		}

		if (right < n && comparator.compare(array[right], array[largest]) > 0) {
			largest = right;
		}

		if (largest != i) {
			T swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;

			heapify(array, n, largest, comparator);
		}
	}
}
