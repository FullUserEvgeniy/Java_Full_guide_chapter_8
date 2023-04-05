// В этой программе используется наследование для расширения класса Вох
public class Box {
    private double width;
    private double height;
    private double depth;

    Box(Box obj){
        this.width = obj.width;
        this.height = obj.height;
        this.depth = obj.depth;
    }

    Box(double width, double height, double depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    Box(){
        width = height = depth = -1;
    }

    Box(double len){
        width = height = depth = len;
    }

    double volium(){
        return width * height * depth;
    }
}
class BoxWeight extends Box{
    double weight;

    BoxWeight(double width, double height, double depth, double weight){
        super(width, height, depth); // вызов конструктора суперкласса ( Box(double width, double height, double depth) )
        this.weight = weight; // инициализация собственной переменной
    }

    BoxWeight(BoxWeight obj){
        super(obj); // вызов конструктора суперкласса
        this.weight = obj.weight;
    }

    BoxWeight(){
        super(); // вызов конструктора суперкласса
        this.weight = -1;
    }

    BoxWeight(double len, double weight){
        super(len); // вызов конструктора суперкласса
        this.weight = weight;
    }
}
class DemoBoxWeight{
    public static void main(String[] args) {
        BoxWeight boxWeight1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight boxWeight2 = new BoxWeight(2, 3, 4, 0.076);
        BoxWeight boxWeight3 = new BoxWeight();
        BoxWeight boxWeight4 = new BoxWeight(3, 2);
        BoxWeight boxWeight5 = new BoxWeight(boxWeight1);

        double vol = boxWeight1.volium();
        System.out.println("Объем boxWeight1 = " + vol);
        System.out.println("Вес boxWeight1 = " + boxWeight1.weight);

        vol = boxWeight2.volium();
        System.out.println("Объем boxWeight2 = " + vol);
        System.out.println("Вес boxWeight2 = " + boxWeight2.weight);

        vol = boxWeight3.volium();
        System.out.println("Объем boxWeight3 = " + vol);
        System.out.println("Вес boxWeight3 = " + boxWeight3.weight);

        vol = boxWeight4.volium();
        System.out.println("Объем boxWeight4 = " + vol);
        System.out.println("Вес boxWeight4 = " + boxWeight4.weight);

        vol = boxWeight5.volium();
        System.out.println("Объем boxWeight5 = " + vol);
        System.out.println("Вес boxWeight5 = " + boxWeight5.weight);
    }
}
/*
Объем boxWeight1 = 3000.0
Вес boxWeight1 = 34.3
Объем boxWeight2 = 24.0
Вес boxWeight2 = 0.076
Объем boxWeight3 = -1.0
Вес boxWeight3 = -1.0
Объем boxWeight4 = 27.0
Вес boxWeight4 = 2.0
Объем boxWeight5 = 3000.0
Вес boxWeight5 = 34.3
 */
class ColorBox extends Box{
    int color;

    ColorBox(double width, double height, double depth, int color){
        super(width, height, depth); // вызов конструктора суперкласса ( Box(double width, double height, double depth) )
        this.color = color; // инициализация собственной переменной
    }
}

class DemoBoxColor{
    public static void main(String[] args) {
        ColorBox colorBox = new ColorBox(2, 3, 4, 5);

        System.out.println("Цвет коробки colorBox = " + colorBox.color);
        System.out.println("Объем коробки colorBox = " + colorBox.volium());
    }
}
/*
Цвет коробки colorBox = 5
Объем коробки colorBox = 24.0
 */

/*
Ссылочной переменной типа суперкласса можно присваивать ссылку на
объект любого подкласса, производного от данного суперкласса
 */
class RefDemo{
    public static void main(String[] args) {
        BoxWeight boxWeight = new BoxWeight(3, 5, 7, 8.37);
        Box box = new Box();
        double vol;

        vol = boxWeight.volium();
        System.out.println("Объем boxWeight = " + vol);

        box = boxWeight;
        System.out.println("Объем box = " + box.volium());

        /* Следующий оператор ошибочен, потому что член weight в box
        не определен */
        // System.out.println ("Bec box равен " + box.weight);
    }
}
/*
Объем boxWeight = 105.0
Объем box = 105.0
 */

class Shipment extends BoxWeight{
    double cost;

    Shipment(double width, double height, double depth, double weight, double cost){
        super(width, height, depth, weight); // вызов конструктора суперкласса
        // (BoxWeight(double width, double height, double depth, double weight))
        this.cost = cost; // инициализация собственной переменной
    }

    Shipment(Shipment obj){
        super(obj); // вызов конструктора суперкласса
        this.cost = obj.cost;// инициализация собственной переменной
    }

    Shipment(){
        super(); // вызов конструктора суперкласса
        this.cost = -1;// инициализация собственной переменной
    }

    Shipment(double len, double weight, double cost){
        super(len, weight); // вызов конструктора суперкласса
        this.cost = cost;// инициализация собственной переменной
    }
}
class DemoShipment{
    public static void main(String[] args) {
        Shipment shipment1 = new Shipment(10, 20, 15, 10, 3.41);
        Shipment shipment2 = new Shipment(2, 3, 4, 0.76, 1.28);

        System.out.println("Объем shipment1 = " + shipment1.volium());
        System.out.println("Вес shipment1 = " + shipment1.weight);
        System.out.println("Стоимость доставки shipment1 = " + shipment1.cost);
        System.out.println("---------------------------------------------");
        System.out.println("Объем shipment2 = " + shipment2.volium());
        System.out.println("Вес shipment2 = " + shipment2.weight);
        System.out.println("Стоимость доставки shipment2 = " + shipment2.cost);
    }
}
/*
Объем shipment1 = 3000.0
Вес shipment1 = 10.0
Стоимость доставки shipment1 = 3.41
---------------------------------------------
Объем shipment2 = 24.0
Вес shipment2 = 0.76
Стоимость доставки shipment2 = 1.28
 */