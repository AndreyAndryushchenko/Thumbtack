package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;
import net.thumbtack.school.iface.v3.HasArea;

public class PairBox<T extends Figure, V extends Figure> implements HasArea {
    private static final double EPS = 1E-6;

    private T objT;
    private V objV;

    public PairBox(T objT, V objV) {
        super();
        this.objT = objT;
        this.objV = objV;
    }

    public T getContentFirst() {
        return objT;
    }

    public V getContentSecond() {
        return objV;
    }

    public void setContentFirst(T objT) {
        this.objT = objT;
    }

    public void setContentSecond(V objV) {
        this.objV = objV;
    }

    @Override
    public double getArea() {
        return objT.getArea() + objV.getArea();
    }

    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> obj) {
        return Math.abs(getArea() - obj.getArea()) < EPS;
    }

    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> obj1,
                                      PairBox<? extends Figure, ? extends Figure> obj2) {
        return Math.abs(obj1.getArea() - obj2.getArea()) < EPS;
    }
}
