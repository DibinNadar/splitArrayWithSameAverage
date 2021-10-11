package spiltter;


import java.util.ArrayList;


public class Main {

    public boolean canSplitArraySameAverage(ArrayList<Integer> a, ArrayList<Integer> b) {

        double aSum = 0, bSum = 0; // Reset Value for each recursive call

        for (int it : a)  aSum = aSum + it;
        for (int it : b)  bSum = bSum + it;  // Update value for each recursive call


        if ((!a.isEmpty() && !b.isEmpty()) && (bSum / b.size() == aSum / a.size())) {
            System.out.println("Possible with " + a+ " and " + b +'\n');
            return true;
        }

        if (b.size() == 1)   return false; // Not possible for this combination



        for (int i = 0; i < b.size(); i++) {

            ArrayList<Integer> newA = (ArrayList<Integer>) a.clone();
            ArrayList<Integer> newB = (ArrayList<Integer>) b.clone();  // Creating deep copies

            newA.add(newB.remove(i)); // Updating both the arrays

            if (canSplitArraySameAverage(newA, newB))  // passing updated values to the next call
                return true; // Early true return

        }

        return false;
    }


    public static void main(String[] args) {

        Main main = new Main();

        
        int[] test1 = {1,2,3,4,5,6,7};
        int[] test2 = {10,11};
        int[] test3 = {0};
        int[] test4 = {};
        int[] test5 = {445, 1, 1, 22, 33, 98, 65, 135};

        
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for (int it : test1)  b.add(it);
        if (!main.canSplitArraySameAverage(a,b))  System.out.println("Not Possible\n");

        b = new ArrayList<>();
        for (int it : test2)  b.add(it);
        if (!main.canSplitArraySameAverage(a,b))  System.out.println("Not Possible\n");

        b = new ArrayList<>();
        for (int it : test3)  b.add(it);
        if (!main.canSplitArraySameAverage(a,b))  System.out.println("Not Possible\n");

        b = new ArrayList<>();
        for (int it : test4)  b.add(it);
        if (!main.canSplitArraySameAverage(a,b))  System.out.println("Not Possible\n");

        b = new ArrayList<>();
        for (int it : test5)  b.add(it);
        if (!main.canSplitArraySameAverage(a,b))  System.out.println("Not Possible\n");


    }
}
