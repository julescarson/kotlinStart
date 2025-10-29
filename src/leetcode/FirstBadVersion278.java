package leetcode;



public class FirstBadVersion278 {
    public boolean isBadVersion(int n) {
        //setup would be some array, with true until false,
        //n returns if that int is true or false;
        return false;
    }

    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        int mid = (last-first)/2;

        if (isBadVersion(first)) return 1;

        int i = 0;
        while (first < last) {
            i++;



            if (i > 100) break;
            mid = first + (last-first)/2;

            boolean midIsBad = isBadVersion(mid);
            boolean preMidGood = !isBadVersion(mid-1);
            if (preMidGood && midIsBad) return mid;

            if (midIsBad) {
                last = mid;

            } else {
                first = mid +1;
            }
        }
        return n; //last item
    }
}
