package day11;

class MyObject {
    private String name;
    private int value;

    // 기본 생성자
    public MyObject() {}

    // 매개변수 있는 생성자
    public MyObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // Getter 및 Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
