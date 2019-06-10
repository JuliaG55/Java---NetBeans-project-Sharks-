package task.pkg3;

public class Shark3 implements Comparable <Shark3> {

    private final String common_name;
    private final String latin_name;

    Shark3(String c_name, String l_name) {

        common_name = c_name;
        latin_name = l_name;
    }

    public String getCommon_name() {
        return common_name;
    }

    public String getLatin_name() {
        return latin_name;
    }
    
    @Override
    public int compareTo(Shark3 shark) {
        return this.common_name.compareTo(shark.common_name);
    }
    
    @Override
    public String toString() {
        return "Shark: " + this.common_name + ", Latin Name: " + this.latin_name + "\n";
    }

}
