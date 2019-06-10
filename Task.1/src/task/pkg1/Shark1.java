package task.pkg1;

public class Shark1 {

    private final String common_name;
    private final String latin_name;
    private final double max_length;

    Shark1(String c_name, String l_name, double max_l) {
        common_name = c_name;
        latin_name = l_name;
        max_length = max_l;
    }

    public String getCommon_name() {
        return common_name;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public double getMax_length() {
        return max_length;
    }

    @Override
    public String toString() {
        return "Shark: " + this.common_name + ", Length: " + this.max_length + "\n";
    }

}
