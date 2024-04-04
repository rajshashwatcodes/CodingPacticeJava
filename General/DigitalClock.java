import java.time.LocalTime;

public class DigitalClock {
    public static void main(String[] args) {
        while (true) {
            LocalTime currentTime = LocalTime.now();
            System.out.print("\r" + formatTime(currentTime));
            try {
                Thread.sleep(1000); // Update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String formatTime(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
