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
    __id = ""

    def __init__(self):
        with open("read file data.txt", "r") as f:
            self.__filename = f.read().splitlines()

    def delData(self, id):
        self.__filename.remove(f'{id}')
        with open("read file data.txt", "w") as fp:
            for i in self.__filename:
                fp.write(i + "\n")


filename = open("read file data.txt").readlines()
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
            while True:
                id = input("Enter id[SXXXX]: ").capitalize()
                if len(id) != 5:
                    print("invalid input")
                    break
                elif id[0] != "S":
                    print("You need to use S in the start")
                    break
                #elif id == filename: :c
                    #print("You can't input the same id")
                    #break
                else:
                    pass
                name = input("Enter Name: ").capitalize()
                if len(name) > 20:
                    print("Too long")
                    break
                else:
                    pass
                position = input("Enter position[Staff|Officer|Manager]: ").capitalize()
                if position == "Staff":
                    salary = int(input("Enter Salary[3500000 ~ 7000000]: "))
                    if salary > 7000000:
                        print("You can't cheat the system dude")
                        break
                    pass
                elif position == "Officer":
                    salary = int(input("Enter Salary[7000001 ~ 10000000]: "))
                    if salary > 10000000:
                        print("You can't cheat the system dude")
                        pass
                elif position == "Manager":
                    salary = int(input("Enter Salary[10000000 ~]: "))
                    pass
                else:
                    print("There is only 3 position")
                    break
                A().newData(id=id, name=name, position=position,
                            salary=salary)
                break
        elif choice == 2:
            B().delData(id=input(""))
        elif choice == 3:
            pass
        elif choice == 4:
            break
    except ValueError:
        continue
