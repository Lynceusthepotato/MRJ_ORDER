class Account:
    __balance = 0

    def __init__(self, balance2):
        self.__balance = balance2

    def getBalance(self):
        return self.__balance

    def deposit(self, amt):
        if amt > 0:
            self.__balance = self.__balance + amt
            return True
        else:
            return False

    def withdraw(self, amt):
        if amt > 0:
            self.__balance = self.__balance - amt
            return True
        else:
            return False
