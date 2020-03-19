package MainPackage;

public class MainApp {
    int i;

    MainApp() {
        System.out.println("MainApp");
    }

    MainApp(int i) {
        System.out.println("MainApp overloaded MainApp(int i)");
        this.i = i;
    }


    public static void main(String[] args) {
        new MainApp();
    }
}
