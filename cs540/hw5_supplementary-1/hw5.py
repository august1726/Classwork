import sys
import matplotlib.pyplot as plt
import numpy as np
import csv



if __name__=="__main__":
    filename = sys.argv[1] # the first argument as string
    z = []
    with open (filename,encoding='utf-8-sig') as f:
        r = csv.DictReader(f)
        for line in r:
            z.append(line)
    x = []
    y = []
    for row in z :
        x.append(row.get('year'))
        y.append(row.get('days'))
    fig, ax = plt.subplots()
    x = np.array(x, dtype='int64')
    y = np.array(y, dtype='int64')
    ax.plot(x, y)
    ax.set_xlabel('Year')
    ax.set_ylabel('Number of Frozen Days')
    plt.savefig("plot.jpg")
    X = np.array([[1, x[i]] for i in range(len(x))], dtype='int64')
    print('Q3a:')
    print(X)
    Y = np.array([y[i] for i in range(len(y))], dtype='int64')
    print('Q3b:')
    print(Y)
    Z = np.dot(np.transpose(X), X)
    print('Q3c:')
    print(Z)
    I = np.linalg.inv(Z)
    print('Q3d:')
    print(I)
    PI = np.dot(I, np.transpose(X))
    print('Q3e:')
    print(PI)
    Beta_hat = np.dot(PI, Y)
    print('Q3f:')
    print(Beta_hat)
    y_test = Beta_hat[0] + Beta_hat[1] * 2022
    print('Q4: ', y_test)
    Q5 = '='
    if (Beta_hat[1] < 0) :
        Q5 = '<'
    if (Beta_hat[1] > 0):
        Q5 = '>'
    print('Q5a: ', Q5)
    print('Q5b: if the sign is <, the number of days of ice is predicted to shrink every following winter until the lake does not freeze at all. If the sign is >, the amount of ice is predicted to grow every following winter. If the sign is =, the amount of ice each winter is predicted to stay exactly the same every year (it will be equal to Beta hat 0)')
    x_star = -1 * Beta_hat[0] / Beta_hat[1]
    print('Q6a: ', x_star)
    print('Q6b: this prediction is not interesting because the amount of ice each year does not follow a significant pattern. There are many factors affecting the number of days Lake Mendota is frozen that can not be accounted for by simply making mathematical predictions. It should also be noted that the guess made on what the number of days for 2022 would be was very incorrect. 2022-2023 winter ended up having more days of ice than any of the previous 9 years. Nature can be random which makes it hard for mathematical and ML models to predict')