package levelUpBank;

import java.time.LocalDate;

public interface AccountRepository {
    void createNewAccount(long account_number, long amount);
    void printAllAccounts();
    void printAllAccountsForClient();
    void printAccountWithMaxAmount();
    void printTotalAmount();
}
