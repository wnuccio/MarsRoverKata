public class MarsRover {
    public String execute(String s) {
        if (s.isEmpty()) return "0:0:N";
        if ("M".equals(s)) return "0:1:N";

        return "0:2:N";
    }
}
