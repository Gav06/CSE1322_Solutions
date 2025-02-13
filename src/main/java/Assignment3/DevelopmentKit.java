package Assignment3;

import java.util.ArrayList;

public class DevelopmentKit extends Software {
    private ArrayList<String> targetPlatforms;

    public DevelopmentKit(String name, double price, String publisher, ArrayList<String> targetPlatforms) {
        super(name, price, publisher);
        setTargetPlatforms(targetPlatforms);
    }

    public ArrayList<String> getTargetPlatforms() {
        return targetPlatforms;
    }

    public void setTargetPlatforms(ArrayList<String> targetPlatforms) {
        if (targetPlatforms.isEmpty()) {
            targetPlatforms.add("None");
        }
        this.targetPlatforms = targetPlatforms;
    }

    @Override
    public String toString() {
        StringBuilder platforms = new StringBuilder();
        for (String platform : targetPlatforms) {
            platforms.append("\n\t\t").append(platform);
        }
        return super.toString() + "\n\tTarget platforms:" + platforms;
    }
}