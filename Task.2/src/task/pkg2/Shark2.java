package task.pkg2;

public class Shark2 {

    private final String common_name;
    private final String[] oceanic_regions;

    Shark2(String c_name, String[] o_regions) {

        common_name = c_name;
        oceanic_regions = o_regions;

    }

    public String getCommon_name() {
        return common_name;
    }

    public String[] getOceanic_regions() {
        return oceanic_regions;
    }

    @Override
    public String toString() {
        return "Shark: " + this.common_name + ", Region: " + this.oceanic_regions + "\n";
    }

}
