package br.com.techlab.matchers;


import com.google.inject.matcher.Matcher;
import com.google.common.collect.Ordering;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.Comparator;

public class SortMatchers<T> extends TypeSafeDiagnosingMatcher<Iterable<T>> {

    public static final String ASCENDING = "ascending";
    public static final String DESCENDING = "descending";
    public static final String CUSTOM = "custom";

    public static <T extends Comparable<T>> SortMatchers<T> inAscendingOrder() {
        Ordering<T> ordering = Ordering.natural();
        return with(ordering, ASCENDING);
    }

    public static <T extends Comparable<T>> SortMatchers<T> inAscendingOrderWithNullsLast() {
        Ordering<T> ordering = Ordering.natural().nullsLast();
        return with(ordering, ASCENDING);
    }

    public static <T extends Comparable<T>> SortMatchers<T> inDescendingOrder() {
        Ordering<T> ordering = Ordering.natural().reverse();
        return with(ordering, DESCENDING);
    }

    public static <T extends Comparable<T>> SortMatchers<T> inDescendingOrderWithNullsLast() {
        Ordering<T> ordering = Ordering.natural().nullsLast().reverse();
        return with(ordering, DESCENDING);
    }

    public static <T> SortMatchers<T> with(Comparator<T> comparator) {
        return with(comparator, CUSTOM);
    }

    public static <T> SortMatchers<T> with(Comparator<T> comparator, String orderType) {
        if (comparator instanceof Ordering) {
            return with((Ordering<T>) comparator, orderType);
        }
        return with(Ordering.from(comparator), orderType);
    }

    public static <T> SortMatchers<T> with(Ordering<T> ordering) {
        return with(ordering, CUSTOM);
    }

    public static <T> SortMatchers<T> with(Ordering<T> ordering, String orderType) {
        return new SortMatchers<>(ordering, orderType);
    }

    private final String orderType;
    private final Ordering<T> ordering;

    private SortMatchers(Ordering<T> ordering, String orderType) {
        this.ordering = ordering;
        this.orderType = orderType;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("an iterable in ").appendText(orderType).appendText(" order");
    }

    @Override
    protected boolean matchesSafely(Iterable<T> item, Description mismatchDescription) {
        if (ordering.isOrdered(item)) {
            return true;
        }
        mismatchDescription.appendText("was not in order");
        return false;
    }
}
