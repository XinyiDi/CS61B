package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c){
        super();
        this.comparator = c;

    }


    public T max(){
        if (size() == 0) {
            return null;
        } else {
            int maxDex = 0;
            for (int i = 0; i < size(); i += 1){
                int cmp = comparator.compare(get(i), get(maxDex));
                if (cmp > 0){
                    maxDex = i;
                }
            }
            return get(maxDex);
        }
    }

    public T max(Comparator<T> nc){
        if (size() == 0) {
            return null;
        } else {
            int maxDex = 0;
            for (int i = 0; i < size(); i += 1){
                int cmp = nc.compare(get(i), get(maxDex));
                if (cmp > 0){
                    maxDex = i;
                }
            }
            return get(maxDex);
        }
    }


}
