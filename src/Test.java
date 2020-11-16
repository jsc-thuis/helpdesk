public class Test {
    public static void main(String[] args) {
        try {
            SupportSystem s = new SupportSystem("DodgeSoft");
            s.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
