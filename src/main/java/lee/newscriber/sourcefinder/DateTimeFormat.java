package lee.newscriber.sourcefinder;

public enum DateTimeFormat {
    ZONE_OFFSET_FOUR_DIGITS("E',' dd MMM yyyy HH':'mm':'ss Z"),
    ZONE_NAME("E',' dd MMM yyyy HH':'mm':'ss z");

    private final String format;

    DateTimeFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
