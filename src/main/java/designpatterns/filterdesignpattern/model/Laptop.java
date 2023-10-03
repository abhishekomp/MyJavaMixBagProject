package designpatterns.filterdesignpattern.model;

public class Laptop {

    private Integer id;
    private String hardDisk;
    private String processor;
    private String ram;
    private String operatingSystem;
    private String screenSize;

    public Laptop(Integer id, String hardDisk, String processor, String ram, String operatingSystem, String screenSize) {
        this.id = id;
        this.hardDisk = hardDisk;
        this.processor = processor;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
        this.screenSize = screenSize;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRam() {
        return ram;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", hardDisk='" + hardDisk + '\'' +
                ", processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                ", OS='" + operatingSystem + '\'' +
                ", screenSize='" + screenSize + '\'' +
                '}';
    }
}
