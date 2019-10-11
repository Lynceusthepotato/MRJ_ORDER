import matplotlib.pyplot as plt
from datetime import datetime
from pylab import show
import pandas as pd
import pygal
import numpy as np
import csv

# I DON'T UNDERSTAND
dates, steps = [], []
filename = "activity.csv"
pd.plotting.register_matplotlib_converters()
dp = pd.read_csv(filename, error_bad_lines=False,
                           warn_bad_lines=False) #Tried with data frame but i dont understand
dp['date'] = pd.to_datetime(dp['date'])  # i tried to combine the date but i think its missing something and i dont know how to do it
with open(filename) as f:
    reader = csv.reader(f)
    headrow = next(reader)
    for row in reader:
        step = row[0]
        steps.append(step)
        dp = datetime.strptime(row[1], "%Y-%m-%d")
        dates.append(dp)
    value = np.array(steps)
    value = value[~pd.isnull(value)]#I dont know why this doesnt work
    '''np.mean(value,dtype=np.float64)''' #so this doesnt work as well 
    datepo = np.array(dates)
    bars = plt.bar(datepo, value, 1)
    for bar in bars:
        bar.set_edgecolor("black")
    plt.ylabel("steps")
    plt.xlabel("date")
    plt.title("histogram")
    plt.yticks([0, 100, 300, 500, 700, 800, 1000])
    plt.show()
