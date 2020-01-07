package prob1g;

import java.util.Objects;
import java.util.function.Function;

public class MyClass {

    public static void main(String[] args) {
        MyClass ob1 = new MyClass("First", 1);
        MyClass ob2 = new MyClass("Second", 2);

        //compare ob1 to itself, should return true
       System.out.println(ob1.myMethod(ob1));

        //compare ob1 to ob2, should return false
       System.out.println (ob1.myMethod(ob2));
    }

    private String x;
    private int y;

    public MyClass(String x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyClass)) return false;
        MyClass myClass = (MyClass) o;
        return x == myClass.x &&
                y == myClass.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean myMethod(MyClass myClass){
        Function<MyClass,Boolean> equality = this::equals;
        return equality.apply(myClass);
    }


}