package pl.zwolek.listofcarsthymeleaf.models;

import pl.zwolek.listofcarsthymeleaf.enums.Color;

public class Car {
    private long id;
    private String model;
    private String mark;
    private Color color;
    private String description;

    public Car() {
    }

    public Car(long id, String mark, String model,Color color) {
        this.id = id;
        this.model = model;
        this.mark = mark;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", color=" + color +
                ", description='" + description + '\'' +
                '}';
    }
}
