package TaskOne;

import java.util.*;

//Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать
//из этого набора только те данные, id которых попадает в числовой диапазон
//1/2/5/8/9/13. Среди отобранных значений отобрать только те, которые имеют нечетное
//количество букв в имени. После чего вернуть список List имен, записанных буквами
//задом наперед.
public class Main {
    public static void main(String[] args) {
        final int SIZE_USER;
        System.out.print("Введите сколько вы хотите ввести User: ");
        Scanner scanner = new Scanner(System.in);
        SIZE_USER = scanner.nextInt();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < SIZE_USER; i++) {
            User user = new User(scanner.nextInt(), scanner.nextLine().trim());
            userList.add(user);
        }

        Map<Integer, String> myUserAboutList = new HashMap<>();
        for (User user : userList) {
            myUserAboutList.put(user.getId(), user.getName());
        }
        System.out.println("Ваши пользователи: " + myUserAboutList);

        int[] idRange = {1, 2, 5, 8, 9, 13};
        Map<Integer, String> filterMyUser = new HashMap<>();
        for (int id : idRange) {
            if (myUserAboutList.containsKey(id)) {
                filterMyUser.put(id, myUserAboutList.get(id));
            }
        }
        System.out.println("Пользователи с id по условию: " + filterMyUser);

        List<String> userNameLenghtNechet = new ArrayList<>();
        for (String name : filterMyUser.values()) {
            if (name.length() % 2 != 0) {
                userNameLenghtNechet.add(name);
            }
        }
        System.out.println("Пользователи у которых нечетная длинна " + userNameLenghtNechet);

        List<String> userNameNaOborot = new ArrayList<>();
        for (String name : userNameLenghtNechet) {
            String textNaoborot = new StringBuilder(name).reverse().toString();
            userNameNaOborot.add(textNaoborot);
        }
        System.out.println("Именя пользователей наоборот: " + userNameNaOborot);
    }
}
