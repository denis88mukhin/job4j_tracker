package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Класс описывает работу банковского сервиса
 * @author Denis Mukhin
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всекх пользователей системы с привязанными к ним номерами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * @param user пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод позволяет удалить пользователя из системы.
     * Самым выжным параметром для пользователя является его пасспорт, этот параметр его уникально идентифицирует.
     * @param passport уделние пользователя производится по номеру паспрота
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позволяет добавить новый счет к пользователю.
     * Первоначально производится поиск пользователя по номеру пасспорта с помощью иетода {@code findByPassport}.
     * После этого получаем список всех счетов пользователя, проверяем, что такого счета у него еще нет и добавляем
     * счет к ним.
     * @param passport номер паспорта пользователя, которому добавляется счет
     * @param account номер добавляемого счета
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
               accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру пасспорта
     * @param passport номер пасспорт искомого пользователя
     * @return возвращет пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User key : users.keySet()) {
            if (passport.equals(key.getPassport())) {
                user = key;
                break;
            }
        }
        return user;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Сначаа происходит поиск пользователя по паспорту с помощбю метода {@code findByPassport}.
     * Потом получаем список счетов пользователя и в нем ищем нужный счет.
     * @param passport номер пасспорта пользователя счте, которого ищем
     * @param requisite искомый счет
     * @return возвращет счте пользователя или null если ничего ненайдено
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод позволяет перечислить деньги с одного счета на другой счет.
     * Сначала ищем счет отправителя и счет получателя. После списываем деньги с счет отправителя и зачислем их
     * на счет получателя.
     * @param sourcePassport номер паспорта отправителя
     * @param sourceRequisite номер счет отправителя
     * @param destinationPassport номер паспорта получателя
     * @param destinationRequisite номер счета получателя
     * @param amount сумма перевода
     * @return {@code false} если счет не найден или не хватает денег на счете c которого переводят
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
