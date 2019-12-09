package statistics;

import java.util.ArrayList;

import statistics.matcher.*;

public class QueryBuilder {
    ArrayList<Matcher> matchers;

    public QueryBuilder() {
        matchers = new ArrayList<Matcher>();
        matchers.add(new All());
    }

    public Matcher build() {
        Matcher[] matchersInArrayForSpreading = new Matcher[matchers.size()];
        for (int i = 0; i < matchersInArrayForSpreading.length; i++) {
            matchersInArrayForSpreading[i] = matchers.get(i);
        }
        matchers = new ArrayList<Matcher>();
        return new And(matchersInArrayForSpreading);
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        matchers.add(new Or(m1, m2));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder playsIn(String teamName) {
        matchers.add(new PlaysIn(teamName));
        return this;
    }

}