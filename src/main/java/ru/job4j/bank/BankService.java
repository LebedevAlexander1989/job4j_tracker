package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        User user = null;
        for (User u: users.keySet()) {
            if (u.getPassport().equals(passport)) {
                user = u;
            }
        }
        if (user != null) {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        User userByPassport = findByPassport(passport);
        if (userByPassport != null) {
            List<Account> accounts = users.get(userByPassport);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;

        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (sourceAccount != null && destinationAccount != null) {
            double sourceBalance = sourceAccount.getBalance();
            if (sourceBalance >= amount) {
                sourceBalance -= amount;

                double destinationBalance = destinationAccount.getBalance();
                destinationBalance += amount;

                sourceAccount.setBalance(sourceBalance);
                destinationAccount.setBalance(destinationBalance);
                result = true;
            }
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
