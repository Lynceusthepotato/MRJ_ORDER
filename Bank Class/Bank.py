import Customer


class Bank:
    __customer = Customer
    __numberOfCustomer = 0
    __bankName = ""
    __filename = open("Customer.txt")
    __FName = ""
    __LName = ""

    def __init__(self, bankName):
        self.__bankName = bankName
        with open("Customer.txt","r") as f:
            self.__filename = f.read().splitlines()

    def addCostumer(self, FName, LName):
        self.__filename.append(f'{FName} {LName}')
        with open("Customer.txt", "r+") as fp:
            for i in fp:
                fp.write(i)

    def getNumOfCustomer(self):
        pop = open("Customer.txt")
        for i in pop:
            "".join(i)
            for a in i:
                self.__numberOfCustomer += 1


