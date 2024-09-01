class Solution:
    def construct2DArray(self, original: List[int], m: int, n: int) -> List[List[int]]:
        return [original[n * i:n * (i + 1)] for i in range(m)] if m * n == len(original) else []