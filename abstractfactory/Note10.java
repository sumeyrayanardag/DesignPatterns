
package abstractfactory;

public class Note10 implements Telephone{
    String model;
    String battery;
    int width;
    int height;

    public Note10(String model, String battery, int width, int height) {
        this.model = model;
        this.battery = battery;
        this.width = width;
        this.height = height;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Note10{" + "model=" + model + ", battery=" + battery + ", width=" + width + ", height=" + height + '}';
    }
    
    
    
}
