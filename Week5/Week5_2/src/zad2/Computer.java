package zad2;

public class Computer {

    private String type; //име на производител
    private double procSpeed; // честота
    private String[] files; //имена на файлове

    public Computer(String type, double procSpeed, String[] files) {
        setFiles(files);
        setProcSpeed(procSpeed);
        setType(type);
    }

    public Computer() {
        this("Apple",3.7, new String[]{"No files"});
    }

    public Computer(Computer c) {
        this(c.type, c.getProcSpeed(), c.files);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null && !type.equals("")) {
            this.type = type;
        } else {
            this.type = "Apple";
        }
    }

    public double getProcSpeed() {
        return procSpeed;
    }

    public void setProcSpeed(double procSpeed) {
        if (procSpeed > 0) {
            this.procSpeed = procSpeed;
        } else {
            this.procSpeed = 3.7; //GHz not MHz
        }
    }

    public String[] getFiles() {
        String[] temp = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            temp[i] = files[i];
        }
        return temp;
    }

    public void setFiles(String[] files) {
        if (files != null) {
            this.files = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                if (files[i] != null && !files[i].equals("")) {
                    this.files[i] = files[i];
                } else {
                    this.files[i] = "No file name";
                }
            }
        } else {
            this.files = new String[]{"No files"};
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < files.length; i++) {
            result += files[i] + ", ";
        }
        return String.format("Manufacturer name: %s\n" +
                "Processor speed: %.1f\n" +
                "File names: %s", type, procSpeed, result); //всяка данна на отделен ред
    }
}
