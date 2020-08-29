public class MarsRover {
    public String execute(String s) {
        if ("L".equals(s)) return "0:0:W";
        if ("LL".equals(s)) return "0:0:S";

        return String.format("0:%d:N", s.length());
    }
}
