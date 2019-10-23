filename = ("read file data.txt", "r")


class newStaff:
    __id = 0
    __name = ""
    __position = ""
    __salary = 0
    __filename = []

    def __init__(self):
        with open("read file data.txt", "r") as f:
            self.__filename = f.read().splitlines()

    def newData(self, id, name, position, salary):
        self.__filename.append(f'{id} {name} {position} {salary}')
        with open("read file data.txt", "w") as fp:
            for i in self.__filename:
                fp.write(i + "\n")


class deleteStaff:
    __id = 0

    def __init__(self):
        with open("read file data.txt", "r") as f:
            self.__filename = f.read().splitlines()

    def delData(self,id):
        self.__filename.remove(f'{id}')
        with open("read file data.txt", "w") as fp:
            for i in self.__filename:
                fp.write(i + "\n")




A = newStaff
B = deleteStaff


def menu():
    steps = "1. New Staff \n""2. Delete Staff\n""3. View Summary Data\n""4. Save & Exit\n""Input Choice: "
    choice = input(steps)
    return int(choice)


while True:
    try:
        choice = menu()
        if choice == 1:
            A().newData(id=input("Enter id[SXXXX]: "), name=input("Enter Name: "), position=input("Enter position: "),
                        salary=int(input("Enter Salary: ")))
        elif choice == 2:
            B().delData(id=input(""))
        elif choice == 3:
            pass
        elif choice == 4:
            break
    except ValueError:
        continue
