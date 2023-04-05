// Использование полиморфизма во время выполнения
abstract class Figure { // абстрактный класс, так как в реализации есть абстрактный метод
    private double dim1; // поля не могут быть статичными
    private double dim2; // поля не могут быть статичными

    double getDim1(){ // чтение значения закрытого поля
        return dim1;
    }

    double getDim2(){ // чтение значения закрытого поля
        return dim2;
    }

    Figure(double dim1, double dim2){ // конструктор не может быть абстрактным
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract double area(); // абстрактный метод реализованый в классах наследниках
}

class Rectangle extends Figure{
    Rectangle(double a, double b){
        super(a, b); // обращение к конструктору суперкласса
    }

    @Override
    double area() { // реализация метода в классе наследнике
        System.out.println("Внутри area() для Rectangle");
        return getDim1() * getDim2();
    }
}

class Triangle extends Figure{
    Triangle(double a, double b){
        super(a, b); // обращение к конструктору суперкласса
    }

    @Override
    double area() { // реализация метода в классе наследнике
        System.out.println("Внутри area() для Triangle");
        return getDim1() * getDim2() / 2;
    }
}

class FindAreas{
    public static void main(String[] args) {
        Figure figure1 = new Rectangle(10, 10);
        Figure figure2 = new Rectangle(9, 5);
        Figure figure3 = new Triangle(10, 8);
        Figure figref;

        figref = figure1;
        System.out.println("Плoщaдь равна " + figref.area());

        figref = figure2;
        System.out.println("Плoщaдь равна " + figref.area());

        figref = figure3;
        System.out.println("Плoщaдь равна " + figref.area());
    }
}
/*
Внутри area() для Rectangle
Плoщадь равна 100.0
Внутри area() для Rectangle
Плoщaдь равна 45.0
Внутри area() для Triangle
Плoщaдь равна 40.0
 */