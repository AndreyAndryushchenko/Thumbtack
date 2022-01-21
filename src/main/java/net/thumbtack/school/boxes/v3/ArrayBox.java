package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {
    private T[] arrayObj;

    public ArrayBox(T[] arrayObj) {
        super();
        this.arrayObj = arrayObj;
    }

    public T[] getContent() {
        return arrayObj;
    }

    public void setContent(T[] arrayObj) {
        this.arrayObj = arrayObj;
    }

    public T getElement(int index) {
        return arrayObj[index];
    }

    public void setElement(T objItem, int index) {
        arrayObj[index] = objItem;
    }

    public boolean isSameSize(ArrayBox<? extends Figure> obj) {
        return getContent().length == obj.getContent().length;
    }
}
