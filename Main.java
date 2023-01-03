import Kiosk.*;

public class Main {
    public static void main(String[] args) {
        AppConfigurer appConfigurer = new AppConfigurer();
        Kiosk kiosk = new Kiosk(
                appConfigurer.productRepository(),
                appConfigurer.menuFunction(),
                appConfigurer.cartFunction(),
                appConfigurer.orderFunction()
        );
        kiosk.start();
    }
}