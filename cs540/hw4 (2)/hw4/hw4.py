import csv
import numpy as np
import math
from scipy.cluster.hierarchy import dendrogram
import matplotlib.pyplot as plt

def load_data(filepath):
    x = []
    with open (filepath,encoding='utf-8') as f:
        r = csv.DictReader(f)
        
        for line in r:
            x.append(line)
    return x

def calc_features(row):
    z = []
    z.append(np.float64(row.get('Population')))
    z.append(np.float64(row.get('Net migration')))
    z.append(np.float64(row.get('GDP ($ per capita)')))
    z.append(np.float64(row.get('Literacy (%)')))
    z.append(np.float64(row.get('Phones (per 1000)')))
    z.append(np.float64(row.get('Infant mortality (per 1000 births)')))
    a = np.array(z, dtype='float64')
    return a
    
def distance_matrix(features):
    # output: symmetric matrix of shape n, n
    matrix = [[0 for i in range(len(features))] for j in range(len(features))]
    # NEsted Loops
    #go from first to last
        # go from current_i to the end
            #output[i][j] = # get value
            #output[j][i] = same value
    for i in range(len(features)):
        for j in range(i, len(features)):
            matrix[i][j] = np.linalg.norm(features[i] - features[j])
            matrix[j][i] = matrix[i][j]
    return matrix

def complete_linkage(clusters, j, k, dist_matrix):
    max = 0
    max_j = 0
    max_k = 0
    count = len(clusters[j].get('data')) + len(clusters[k].get('data'))
    ind1 = 0
    ind2 = 0
    for l in range(len(clusters[j].get('data'))):
        for m in range(len(clusters[k].get('data'))):
            if dist_matrix[clusters[j].get('data')[l]][clusters[k].get('data')[m]] > max:
                max = dist_matrix[clusters[j].get('data')[l]][clusters[k].get('data')[m]]
                max_j = clusters[j].get('data')[l]
                max_k = clusters[k].get('data')[m]
                ind1 = clusters[j].get('index')
                ind2 = clusters[k].get('index')
    return max, max_j, max_k, count, ind1, ind2

def hac(features):
    # conevrt features to a numpy array
    features_np = np.array(features)
    dist_matrix = distance_matrix(features_np)
    Z = np.array([[0 for i in range(4)] for j in range(len(features) - 1)], dtype='float')
    clusters = [] 
    clust_index = 0
    for i in range(len(features)):
        clusters.append(dict(index=clust_index, data=[i]))
        clust_index += 1
    # for i in range(len(features) - 1):
    
    for i in range(len(Z)):
        min_j = -1
        min_k = -1
        min = math.inf
        min_count = 0
        ind1 = 0
        ind2 = 0
        for j in range(len(clusters)):
            for k in range(j + 1, len(clusters)):
                link, temp_j, temp_k, count, temp1, temp2 = complete_linkage(clusters, j, k, dist_matrix)
                if link > 0 and link < min:
                    min = link
                    min_j = temp_j
                    min_k = temp_k
                    min_count = count
                    ind1 = j
                    ind2 = k
                elif link > 0 and link == min:
                    if temp_j < min_j:
                        min = link
                        min_j = temp_j
                        min_k = temp_k
                        min_count = count
                        ind1 = j
                        ind2 = k
        Z[i][0] = clusters[ind1].get('index')
        Z[i][1] = clusters[ind2].get('index')
        Z[i][2] = dist_matrix[min_j][min_k]
        Z[i][3] = min_count
        clusters.append(dict(index=clust_index, data = clusters[ind1].get('data') + clusters[ind2].get('data')))
        clust_index += 1
        del clusters[ind2]
        del clusters[ind1]
    return Z

def fig_hac(Z, names):
    fig = plt.figure()
    dendrogram(Z, labels=names, leaf_rotation=90)
    plt.tight_layout()         
    
    return fig

def normalize_features(features):
    features_np = np.array(features)
    features_norm = [[0 for i in range(len(features[0]))] for j in range(len(features))]
    mean = np.mean(features_np, axis=0)
    std = np.std(features_np, axis=0)
    for i in range(len(features_np)):
        for j in range(len(features_np[i])):
            features_norm[i][j] = (features_np[i][j] - mean[j]) / std[j]

    return features_norm

#data = load_data("countries.csv")
#country_names = [row["Country"] for row in data]
#features = [calc_features(row) for row in data]
#features_normalized = normalize_features(features)
#n = 20
#Z_raw = hac(features[:n])
#Z_normalized = hac(features_normalized[:n])
#fig = fig_hac(Z_normalized, country_names[:n])
#plt.show()