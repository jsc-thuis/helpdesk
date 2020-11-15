public class TestServices {
    public static void main(String[] args) {
        ServiceReader r = new ServiceReader();
        for (Service s : r.getServices()) {
            System.out.println(s.toString());
        }
    }
}