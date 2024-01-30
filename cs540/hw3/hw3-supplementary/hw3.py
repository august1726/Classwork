from scipy.linalg import eigh
import numpy as np
import matplotlib.pyplot as plt

def load_and_center_dataset(filename):
    x = np.load(filename)
    x = x - np.mean(x, axis=0)
    return x

def get_covariance(dataset):
    S = 1/(len(dataset) - 1) * np.dot(np.transpose(dataset), dataset)
    return S

def get_eig(S, m):
    temp, U = eigh(S, subset_by_index=[len(S) - m, len(S) - 1])
    Lambda = [[0 for i in range(m)] for j in range(m)]
    for i in range(m):
        Lambda[i][i] = temp[m - i - 1]
    U = np.fliplr(U)
    return Lambda, U

def get_eig_prop(S, prop):
    temp= eigh(S, eigvals_only=True)
    sum = np.sum(temp)
    temp2, U = eigh(S, subset_by_value=[prop * sum, np.inf])
    Lambda = [[0 for i in range(len(temp2))] for j in range(len(temp2))]
    for i in range(len(Lambda)):
        Lambda[i][i] = temp2[len(Lambda) - i - 1]
    U = np.fliplr(U)
    return Lambda, U

def project_image(image, U):
    alpha = np.dot(np.transpose(U), image)
    xpca = np.dot(U, alpha)
    return xpca

def display_image(orig, proj):
    # Your implementation goes here!
    # Please use the format below to ensure grading consistency
    # fig, (ax1, ax2) = plt.subplots(figsize=(9,3), ncols=2)
    # return fig, ax1, ax2
    orig1 = np.reshape(orig, (32,32))
    orig1 = np.rot90(orig1, 1, (1,0))
    proj1 = np.reshape(proj, (32,32))
    proj1 = np.rot90(proj1, 1, (1,0))
    fig, (ax1, ax2) = plt.subplots(figsize=(9,3), ncols=2)
    ax1.set_title('Original')
    ax2.set_title('Projection')
    im1 = ax1.imshow(orig1, aspect='equal')
    im2 = ax2.imshow(proj1, aspect='equal')
    fig.colorbar(im1, ax=ax1)
    fig.colorbar(im2, ax=ax2)
    return fig, ax1, ax2
    
x = load_and_center_dataset('YaleB_32x32.npy')

S = get_covariance(x)

Lambda, U = get_eig(S, 2)
Lambda, U = get_eig_prop(S, 0.07)
projection = project_image(x[1], U)
fig, ax1, ax2 = display_image(x[1], projection)
plt.show()
