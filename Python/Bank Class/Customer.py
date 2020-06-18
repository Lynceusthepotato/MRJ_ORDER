import Account


class Costumer:
    __FName = ""
    __LName = ""
    __account = Account.Account(5000)

    def __init__(self, FName, LName):
        self.__FName = FName
        self.__LName = LName

    def getFName(self):
        return self.__FName

    def getLName(self):
        return self.__LName

    def getAccount(self):
        return self.__account

    def setAccount(self, acct):
        self.__account = acct
