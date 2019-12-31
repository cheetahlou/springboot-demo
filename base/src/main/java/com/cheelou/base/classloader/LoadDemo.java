public class LoadDemo {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "This is a classloader Demo class£¬LoadDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
