import java.util.ArrayList;

public class BubbleSort implements Sorter
{
    private ArrayList<ArrayList<Bar>> allStepsArray;

    public BubbleSort()
    {
        allStepsArray = new ArrayList<>();
    }
    @Override
    public ArrayList<ArrayList<Bar>> sort(ArrayList<Bar> barArrayList)
    {
        allStepsArray = new ArrayList<>();
        allStepsArray.add(new ArrayList<>(barArrayList));
        bubbleSort(barArrayList);
        return allStepsArray;
    }

    private void bubbleSort(ArrayList<Bar> barArrayList)
    {
        int n = barArrayList.size();
        boolean swapped = false;
        while(!swapped)
        {
            for(int i = 1; i < n; i ++)
            {
                if(barArrayList.get(i - 1).getHeight() > barArrayList.get(i).getHeight())
                {
                    swap(barArrayList, i - 1, i);
                    allStepsArray.add(new ArrayList<>(barArrayList));
                }
            }
            if(n == 0)
                swapped = true;
            n = n - 1;
        }
    }

    private void swap(ArrayList<Bar> arrayList, int index1, int index2)
    {
        Bar temp = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2, temp);
    }

    @Override
    public String toString()
    {
        return "Bubble Sort";
    }
}
