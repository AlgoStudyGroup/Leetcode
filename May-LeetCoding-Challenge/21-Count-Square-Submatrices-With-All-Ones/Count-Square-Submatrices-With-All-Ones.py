class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        nrows = len(matrix)
        ncols = len(matrix[0])

        output = 0
        for r in range(nrows):
            for c in range(ncols):
                if matrix[r][c] == 0:
                    pass
                elif r == 0 or c == 0:
                    output += 1
                else:
                    min_neighbour = min(matrix[r][c - 1],
                                        matrix[r - 1][c - 1],
                                        matrix[r - 1][c])
                    matrix[r][c] += min_neighbour
                    output += matrix[r][c]

        return output
