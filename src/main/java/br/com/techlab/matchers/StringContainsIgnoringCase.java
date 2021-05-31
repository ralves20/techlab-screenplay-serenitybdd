//package br.com.techlab.matchers;
//
//
//public class StringContainsIgnoringCase extends SubstringMatcher {
//    public StringContainsIgnoringCase(String substring) {
//        super(substring);
//    }
//
//    protected boolean evalSubstringOf(String string) {
//        return string.toLowerCase().indexOf(this.substring.toLowerCase()) >= 0;
//    }
//
//    protected String relationship() {
//        return "containing";
//    }
//
//    @Factory
//    public static Matcher<String> containsIgnoringCase(String substring) {
//        return new StringContainsIgnoringCase(substring);
//    }
//}