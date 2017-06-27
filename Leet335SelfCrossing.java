package B06_27;

public class Leet335SelfCrossing {
	/**               i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3
                 
                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐ 
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

*/
	public boolean isSelfCrossing(int[] x) {
		for (int i = 3; i < x.length; i++) {
			// Case 1: current line crosses the line 3 steps ahead of it
			if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3])
				return true;
			// Case 2: current line crosses the line 4 steps ahead of it
			else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
				return true;
			// Case 3: current line crosses the line 6 steps ahead of it
			else if (i >= 5 &&  x[i] + x[i - 4] >= x[i - 2] && x[i - 1] <= x[i - 3]
			            && x[i - 1] + x[i - 5] >= x[i - 3] && x[i - 2] >= x[i - 4])
				return true;
		}
		return false;
	}

}