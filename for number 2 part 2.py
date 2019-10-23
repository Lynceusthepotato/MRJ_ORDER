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
        id = id
        remove_line = 0
        fp = open("read file data.txt", "r+")
        lines = fp.readlines()
        fp.seek(0)
        for line in lines:
            if not line.startswith(str(id)):
                fp.write(line)
            else:
                print("Data has been successfully deleted")
                remove_line += 1
        fp.truncate()
        fp.close()


class viewData:
    def __init__(self):
        with open("read file data.txt", "r") as f:
            self.__filename = f.read().splitlines()

    def view(self):
        with open("read file data.txt") as fp:
            next(fp)
            for line in fp:
                # position = line[2] it doesnt work
                # salary = line[3]
                # print(position,salary)
                print(line)


filename = open("read file data.txt").readlines()
A = newStaff
B = deleteStaff
C = viewData


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
                # elif id == filename: :c
                # print("You can't input the same id")
                # break
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
            while True:
                id = input("Enter id[SXXXX]: ").capitalize()
                if len(id) != 5:
                    print("Invalid input")
                    break
                elif id[0] != "S":
                    print("You need to use S in the start")
                    break
                else:
                    pass
                B().delData(id=id)
                break
        elif choice == 3:
            C().view()
        elif choice == 4:
            break
    except ValueError:
        continue
