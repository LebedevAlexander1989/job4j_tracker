package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 */
public class BankService {

    /**
     * Карта пользователей и их аккаунтов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя, иначе обновляет данные пользователя по ключу User
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя по паспортным данным
     * @param passport паспортные данные пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет аккаунт пользователю, если он найден в карте пользователей
     * @param passport паспортные данные пользователя
     * @param account аккаунт пользователя
     */
    public void addAccount(String passport, Account account) {
        User userByPassport = findByPassport(passport);
        if (userByPassport != null) {
            List<Account> accounts = users.get(userByPassport);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспортным данным
     * @param passport паспортные данные пользователя
     * @return пользователь, если он найден, иначе null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет аккаунт пользоателя по паспортным данным и реквизитам счета
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты счета
     * @return аккаунт пользователя, если он найден, иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User userByPassport = findByPassport(passport);
        if (userByPassport != null) {
            List<Account> accounts = users.get(userByPassport);
            for (Account a : accounts) {
                if (a.getRequisite().equals(requisite)) {
                    return a;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счета на другой
     * @param sourcePassport паспортные данные пользователя, откуда переводятся деньги
     * @param sourceRequisite реквизиты счета, откуда переводятся деньги
     * @param destinationPassport паспортные данные пользователя, куда переводятся деньги
     * @param destinationRequisite реквизиты счета, куда переводятся деньги
     * @param amount сумма, которую нужно перевести
     * @return true, если деньги были успешно переведены, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;

        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (sourceAccount != null && destinationAccount != null) {
            if (sourceAccount.getBalance() >= amount) {
                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                destinationAccount.setBalance(destinationAccount.getBalance() + amount);

                result = true;
            }
        }
        return result;
    }

    /**
     * Метод используется для получения списка аккаунтов по пользователю. Нужно для тестов!
     * @param user пользователь
     * @return список аккаунтов, если такой пользователь есть в карте пользователей, иначе null
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
