class Solution1:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if (coordinates[1][0] ^ coordinates[0][0]) == 0:
            return len(set([x[0] for x in coordinates])) ^ 1 == 0
        else:
            k = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0])
            for i in range(1, len(coordinates) - 1):
                if (coordinates[i + 1][0] - coordinates[i][0]) ^ 0 == 0:
                    return False
                k1 = (coordinates[i + 1][1] - coordinates[i][1]) / (coordinates[i + 1][0] - coordinates[i][0])
                # print(coordinates[i],k,k1)
                if (k != k1):
                    return False
            return True


class Solution2:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        ((first_x, first_y), (second_x, second_y)) = coordinates[:2]

        delta_2x = second_x - first_x
        delta_2y = second_y - first_y

        if delta_2x == 0:
            for coordinate in coordinates[2:]:
                if coordinate[0] != first_x:
                    return False
        else:
            slope = delta_2y / delta_2x
            for coordinate in coordinates[2:]:
                if coordinate[0] == first_x:
                    return False
                else:
                    new_slope = (coordinate[1] - first_y) / (coordinate[0] - first_x)
                    if new_slope != slope:
                        return False
                    else:
                        return True


class Solution3:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        ((first_x, first_y), (second_x, second_y)) = coordinates[:2]

        for coordinate in coordinates[2:]:
            return (second_y - first_y) * (coordinate[0] - first_x) == \
                   (coordinate[1] - first_y) * (second_x - first_x)
