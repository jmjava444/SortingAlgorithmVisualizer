import java.util.ArrayList;

public class HeapSort extends Sorter
{
    private ArrayList<ArrayList<Bar>> allStepsArray;

    public HeapSort()
    {
        allStepsArray = new ArrayList<>();
    }
    @Override
    public ArrayList<ArrayList<Bar>> sort(ArrayList<Bar> barArrayList)
    {
        allStepsArray = new ArrayList<>();
        allStepsArray.add(new ArrayList<>(barArrayList));
        heapSort(barArrayList);
        return allStepsArray;
    }

    private void heapSort(ArrayList<Bar> arr)
    {
        int n = arr.size();
        for(int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(arr, n, i);
        }
        for(int i = n - 1; i > 0; i--)
        {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(ArrayList<Bar> barArrayList, int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if(l < n && barArrayList.get(l).getHeight() > barArrayList.get(largest).getHeight())
        {
            largest = l;
        }
        if(r < n && barArrayList.get(r).getHeight() > barArrayList.get(largest).getHeight())
        {
            largest = r;
        }
        if(largest != i)
        {
            swap(barArrayList, i, largest);
            heapify(barArrayList, n, largest);
        }
    }

    private void swap(ArrayList<Bar> barArrayList, int index1, int index2)
    {
        Bar temp = barArrayList.get(index1);
        barArrayList.set(index1, barArrayList.get(index2));
        barArrayList.set(index2, temp);
        allStepsArray.add(new ArrayList<>(barArrayList));
    }

    @Override
    public String toString()
    {
        return "Heap Sort";
    }
}
