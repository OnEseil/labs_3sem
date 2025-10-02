package lab1.task1;

public class Primes {
    public static void main() {
        for (int i = 2; i < 101; i++) {
            if (isPrime(i)) {
                System.out.printf(i + " ");
            }
        }
    }

    public static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
