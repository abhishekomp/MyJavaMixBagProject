package extractText;

public class ExtractTagValueFromString {

    public String findValue(String log, String startSymbol, String stopSymbol) {
        int start = log.lastIndexOf(startSymbol);
        start = start + startSymbol.length();
        int stop = log.lastIndexOf(stopSymbol);

        if (stop < start) {
            stop = start + 9;
        }
        log.substring(start, stop);
        return log.substring(start, stop);
    }

}
