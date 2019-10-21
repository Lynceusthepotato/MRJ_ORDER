import Customer


class Bank:
    __customer = Customer
    __numberOfCustomer = 0
    __bankName = ""
    __filename = []

    def __init__(self, bankName):
        self.__bankName = bankName
        with open("Customer.txt", "r") as f:
            self.__filename = f.read().splitlines()

    def addCostumer(self, FName, LName):
        self.__filename.append(f'{FName} {LName}')
        with open("Customer.txt", "w") as fp:
            for i in self.__filename:
                fp.write(i+"\n")

    def getNumOfCustomer(self, numcus):
        self.__numberOfCustomer = numcus
        with open("Customer.txt") as pop:
            for numcus,l in enumerate(pop):
                pass
            return numcus + 1
