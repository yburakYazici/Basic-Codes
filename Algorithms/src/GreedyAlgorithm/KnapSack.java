package GreedyAlgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class KnapSack {

	//get MAX value function
	private static double getMaxValue(ItemValue[] arr, int capacity) {

		//Sorting item by value/weight ratio
		Arrays.sort(arr, new Comparator<ItemValue>() {

			@Override
			public int compare(ItemValue i1, ItemValue i2) {

				double c1 = new Double((double)i1.value / (double)i1.weight);
				double c2 = new Double((double)i2.value / (double)i2.weight);
				
				if(c1<c2)
					return 1;
				else	
					return -1;
			}
		});
		

        double totalValue = 0d;
 
        for (ItemValue i : arr) {
 
            int curWt = (int)i.weight;
            int curVal = (int)i.value;
 
            if (capacity - curWt >= 0) {
 
                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {
 
                // Item cant be picked whole
                double fraction
                    = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity
                    = (int)(capacity - (curWt * fraction));
                break;
            }
        }
 
        return totalValue;
    }
 
    // Item value class
    static class ItemValue {
 
        int value, weight;
 
        // Item value function
        public ItemValue(int val, int wt)
        {
            this.weight = wt;
            this.value = val;
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
 
        ItemValue[] arr = { new ItemValue(60, 10),
                            new ItemValue(100, 20),
                            new ItemValue(120, 30) };
 
        int capacity = 50;
 
        double maxValue = getMaxValue(arr, capacity);
 
        // Function call
        System.out.println(maxValue);
    }

}
