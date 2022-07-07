import java.util.ArrayList;
public class QuickSort
{
	// Stores what the bar array is at each step through the sorting process.
	ArrayList<ArrayList<Bar>> allStepsArray;
	
	public QuickSort()
	{
		allStepsArray = new ArrayList<>();
	}

	// Call this method to sort everything and generate all the snapshots of the steps in between.
	public void sort(ArrayList<Bar> pList)
	{
		if(!allStepsArray.isEmpty())
		{
			allStepsArray.clear();
		}
		quicksort(pList, 0, pList.size() - 1);
	}
	
	private int partition(ArrayList<Bar> pList, int low, int high)
	{
		int pivot = (int) (low + Math.floor(Math.random() * (high - low))); // Get random pivot value
		swap(pList, pivot, high); // place pivot to the end
		pivot = pList.get(high).getHeight();
		int i = (low - 1);
		for(int j = low; j <= high - 1; j++)
		{
			if(pList.get(j).getHeight() < pivot)
			{
				i++;
				swap(pList, i, j);
			}
		}
		swap(pList, i + 1, high);
		return i + 1;
	}
	
	private void quicksort(ArrayList<Bar> pList, int low, int high)
	{
		if(low < high)
		{
			int splitPoint = partition(pList, low, high);
			quicksort(pList, low, splitPoint - 1);
			quicksort(pList, splitPoint + 1, high);
		}
	}

	private void swap(ArrayList<Bar> pList, int val1, int val2)
	{
		Bar placeholder = pList.get(val1);
		pList.set(val1, pList.get(val2));
		pList.set(val2, placeholder);
		allStepsArray.add(new ArrayList<>(pList));
	}

	// Call this method to return all the steps of the sort process.
	public ArrayList<ArrayList<Bar>> getAllStepsArray()
	{
		return allStepsArray;
	}

	@Override
	public String toString()
	{
		return "QuickSort";
	}
}
