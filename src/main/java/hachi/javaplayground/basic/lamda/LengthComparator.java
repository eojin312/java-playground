package hachi.javaplayground.basic.lamda;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return Integer.compare(first.length(), second.length());
    }
}
