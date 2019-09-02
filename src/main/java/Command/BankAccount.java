package Command;

import java.util.List;

interface Command{
    void call();
}



public class BankAccount {

    private Integer balance;
    private Integer overDraftLimit=500;

    public void deposit(Integer amount){

        balance =+amount;
        System.out.println("Deposited "+amount+", balance is now "+balance);
    }

    public void withdraw(Integer amount){

        if(balance - amount >=overDraftLimit){
            balance -=amount;
            System.out.println("Withdraw "+amount+",balance now is "+balance);
        }

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", overDraftLimit=" + overDraftLimit +
                '}';
    }
}

class BankAccountCommand implements Command{

    private BankAccount account;

    public enum Action{
        DEPOSIT,
        WITHDRAWL
    }

    private  Action action;
    private Integer amount;

    public BankAccountCommand(BankAccount account, Action action, Integer amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call() {

        switch (action){

            case DEPOSIT:
                account.deposit(amount);
                break;
            case WITHDRAWL:
                account.withdraw(amount);
                break;

        }



    }
}

class Demo{

    public static void main(String[] args) {

        BankAccount ba = new BankAccount();
        System.out.println(ba);

       List<BankAccountCommand> commands= List.of(
                new BankAccountCommand(ba,BankAccountCommand.Action.DEPOSIT,100),
                new BankAccountCommand(ba,BankAccountCommand.Action.WITHDRAWL,1000)
        );

        for(BankAccountCommand c:commands){

            c.call();
            System.out.println(ba);

        }
    }
}

