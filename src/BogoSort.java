import java.util.ArrayList;
import java.util.Collections;

public class BogoSort extends Sorter
{
    private ArrayList<ArrayList<Bar>> allStepsArray;
    private static final int MAX_ARRAY_SIZE = 1000000;

    public BogoSort()
    {
        allStepsArray = new ArrayList<>();
    }
    public ArrayList<ArrayList<Bar>> sort(ArrayList<Bar> barArrayList)
    {
        allStepsArray = new ArrayList<>();
        boolean sorted = false;
        allStepsArray.add(barArrayList);
        for(int i = 1; i < MAX_ARRAY_SIZE; i ++)
        {
            allStepsArray.add(new ArrayList<>(allStepsArray.get(i - 1)));
            Collections.shuffle(allStepsArray.get(i));
            for(int j = 0; j < allStepsArray.get(i).size(); j ++)
            {
                if(j == allStepsArray.get(i).size() - 1)
                {
                    sorted = true;
                }
                else if(allStepsArray.get(i).get(j).getHeight() > allStepsArray.get(i).get(j + 1).getHeight())
                {
                    break;
                }
            }
            if(sorted)
            {
                return allStepsArray;
            }
        }
        return allStepsArray;
    }

    public static int getMAX_ARRAY_SIZE()
    {
        return MAX_ARRAY_SIZE;
    }

    @Override
    public String toString()
    {
        return "BogoSort";
    }
}
