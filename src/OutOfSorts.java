public class OutOfSorts {

	static void insertionSort (int a[], int n) {
		for (int i = 1; i < n; i++) {
			int j, temp = a[i];
			for (j = i - 1; j >= 0; j--) {
				if (a[j] > temp)
					a[j + 1] = a[j];
				else
					break;
			}
			a[j] = temp;
		}
	}
}
