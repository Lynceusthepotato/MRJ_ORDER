import Account
import Bank
import Customer

BK = Bank.Bank
AC = Account.Account(5000)
CS = Customer.Costumer


def menu():
    steps = "1. Add Costumer \n""2. Deposit\n""3. Withdraw\n""4. How many costumer\n""5. Exit\n"
    choice = input(steps)
    return int(choice)


while True:
    try:
        choice = menu()
        if choice == 1:
            BK("BNI").addCostumer(FName=input("Enter first name: "), LName=input("Enter last name: "))
        elif choice == 2:
            AC.deposit(int(input("How much money do you want to put into the bank account: ")))
            print("Your balance now are", AC.getBalance())
        elif choice == 3:
            AC.withdraw(int(input("How much money do you want to take?")))
            print("Your balance now are", AC.getBalance())
        elif choice == 4:
            print(BK("BNI").getNumOfCustomer(0))
        elif choice == 5:
            break
    except ValueError:
        continue
