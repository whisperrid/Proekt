import java.util.Scanner;

public class Main {
    private static String getCodingIncodMessage(String message, int key, char firstCharAlfabet, char lastCharAlfabet) {
        StringBuilder strBox = new StringBuilder(message.length());
        char tmp;
        int countCharsAlfabet = (lastCharAlfabet - firstCharAlfabet) + 1;
        for (int i = 0; i < message.length(); i++) {
            tmp = message.charAt(i);
            if (Character.isLetter(message.charAt(i))) {
                tmp += key % countCharsAlfabet;
                if (tmp > lastCharAlfabet)
                    tmp = (char) (tmp % lastCharAlfabet + firstCharAlfabet - 1);
                else if (tmp < firstCharAlfabet)
                    tmp = (char) (tmp + countCharsAlfabet);
            }
            strBox.append(tmp);
        }
        return strBox.toString();
    }
/*
    У меня не получалось все это красиво объеденить в один код, поэтому вывод написал через метод
    С помощью конструкции if-else сделал шифровку на разных языках (Eng, Rus)
    Сдвиг букв сделал на 14 позиций
    Используемая литература
    https://www.youtube.com/watch?v=dJuo7igM1v4
    https://javascopes.com/java-caesar-cipher-bbdeee8b/
    Немного информации с stackoverflow.com
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите шифруемое слово");
        String message = scanner.nextLine();
        System.out.println("Какой язык вы используете: ");
        System.out.println("1 - Eng   2 - Rus");
        int yazik = scanner.nextInt();

        if (yazik == 1) {
            String codeMessage = getCodingIncodMessage(message, 14, 'a', 'z');
            System.out.println(message + " -> " + codeMessage);
        }
        else if (yazik == 2){
            String codeMessage = getCodingIncodMessage(message, 14, 'а', 'я');
            System.out.println(message + " -> " + codeMessage);
        }
    }
}