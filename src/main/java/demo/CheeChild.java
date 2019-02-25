package demo;

/**
 * @createTime 2019/2/25 16:02
 */
public class CheeChild extends Chee {
    public static void main(String[] args) {
        CheeChild chil = new CheeChild();
        System.out.println(chil.getZzz());//子类继承父类后属性值也继承
    }
}
