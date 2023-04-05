// Простой пример наследования
public class A {
    int i = 10;
    int j = 20;

    void showij(){
        System.out.println("i= " + i + " and j= " + j);
    }
}
class B extends A{
    int x = 30;

    void showx(){
        System.out.println("x= " + x);
    }

    void sum(){
        System.out.println("i+j+x = " + (i + j + x));
    }
}
class SimleInheritance{
    public static void main(String[] args) {
        A superObj = new A();

        superObj.showij();
        superObj.i = 9;
        superObj.j = 19;
        superObj.showij();

        B obj = new B();
        obj.showij();
        obj.i = 8;
        obj.j = 18;
        obj.showij();
        obj.showx();
        obj.sum();
    }
}
/*
i= 10 and j= 20
i= 9 and j= 19
i= 10 and j= 20
i= 8 and j= 18
x= 30
i+j+x = 56
 */
class C extends A{
    int i = 100; // переменная скрывает переменную суперкласса i
    int j = 200; // переменная скрывает переменную суперкласса j

    void showij(){
        super.showij(); // доступ к методу showij() суперкласса, скрытого собственным методом showij()
        System.out.println("super.i = " + super.i); // доступ к переменной i суперкласса. скрытой собственной переменной i
        System.out.println("super j = " + super.j); // доступ к переменной j суперкласса. скрытой собственной переменной j
    }
    public static void main(String[] args) {
        C c = new C();
        System.out.println("i = " + c.i);
        System.out.println("j = " + c.j);
        c.showij();
    }
}
/*
i = 100
j = 200
super.i = 10
super j = 20
 */
