from itertools import combinations

def find_min_difference_partition(A):
    N = len(A)
    total_sum = sum(A)
    half_size = N // 2
    min_difference = float('inf')
    best_subset_A1 = []
    best_subset_A2 = []
    
    all_combinations = generate_combinations(A, half_size)

    for subset_A1 in all_combinations:
        subset_A2 = []
        sum_A1 = 0
        for i in range(N):
            if i in subset_A1:
                sum_A1 += A[i]
            else:
                subset_A2.append(A[i])
        sum_A2 = total_sum - sum_A1
        difference = abs(sum_A1 - sum_A2)
        if difference < min_difference:
            min_difference = difference
            best_subset_A1 = [A[i] for i in subset_A1]
            best_subset_A2 = subset_A2

    print("Subset A1:", best_subset_A1, "with sum:", sum(best_subset_A1))
    print("Subset A2:", best_subset_A2, "with sum:", sum(best_subset_A2))
    print("Minimum Difference:", min_difference)

def generate_combinations(A, subset_size):
    return list(combinations(range(len(A)), subset_size))

A = [3, 1, 4, 2, 2, 1]
find_min_difference_partition(A)

