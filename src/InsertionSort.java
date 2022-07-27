import java.util.ArrayList;

public class InsertionSort extends Sorter
{
    private ArrayList<ArrayList<Bar>> allStepsArray;
    public InsertionSort()
    {
        allStepsArray = new ArrayList<>();
    }
    public ArrayList<ArrayList<Bar>> sort(ArrayList<Bar> barArrayList)
    {
        allStepsArray = new ArrayList<>();
        allStepsArray.add(new ArrayList<>(barArrayList));
        insertionSort(barArrayList);
        return allStepsArray;
    }

    private void insertionSort(ArrayList<Bar> barArrayList)
    {
        int i = 1;
        while(i < barArrayList.size())
        {
            int j = i;
            while(j > 0 && barArrayList.get(j - 1).getHeight() > barArrayList.get(j).getHeight())
            {
                swap(barArrayList, j, j - 1);
                allStepsArray.add(new ArrayList<>(barArrayList));
                j = j - 1;
            }
            i = i + 1;
        }
    }

    private void swap(ArrayList<Bar> arrayList, int index1, int index2)
    {
        Bar temp = new Bar();
        temp = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2, temp);
    }

    @Override
    public String toString()
    {
        return "Insertion Sort";
    }
}
