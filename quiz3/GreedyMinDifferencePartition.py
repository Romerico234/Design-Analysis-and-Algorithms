def greedy_partition(A):
    N = len(A)
    half_size = N // 2
    indexed_A = [(A[i], i) for i in range(N)]
    indexed_A.sort(reverse=True, key=lambda x: x[0])
    
    subset_A1 = []
    subset_A2 = []
    sum_A1, sum_A2 = 0, 0

    for value, index in indexed_A:
        if len(subset_A1) < half_size and (sum_A1 <= sum_A2 or len(subset_A2) >= half_size):
            subset_A1.append(value)
            sum_A1 += value
        else:
            subset_A2.append(value)
            sum_A2 += value

    print("Subset A1:", subset_A1, "with sum:", sum_A1)
    print("Subset A2:", subset_A2, "with sum:", sum_A2)
    print("Difference:", abs(sum_A1 - sum_A2))

A = [3, 1, 4, 2, 2, 1]
greedy_partition(A)
