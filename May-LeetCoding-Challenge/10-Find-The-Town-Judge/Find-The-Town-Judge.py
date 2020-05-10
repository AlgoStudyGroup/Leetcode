# Solution 1 Using HashTable
class Solution1:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trusting = set([x[0] for x in trust])
        candidat = set([x for x in range(1, N + 1)]) - trusting  # Those who don't trust anyone
        if not candidat:  # If everyone trust at least one person, return -1
            return -1
        croire = dict()  # counting persons that each trusts
        for x in trust:
            if x[0] not in croire:
                croire[x[0]] = {x[1]}
            else:
                croire[x[0]].add(x[1])
        for x in trusting:  # find those who are trusted by everyone
            candidat &= croire[x]
        if not candidat or len(candidat) > 1:
            return -1
        else:  # if and only if one person
            return candidat.pop()


# Solution 2 Two Arrays
class Solution2:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trusting = [0] * N
        trusted = [0] * N
        for x in trust:
            trusting[x[0] - 1] += 1
            trusted[x[1] - 1] += 1
        res = -1
        for i in range(N):
            if trusting[i] ^ 0 == 0 and trusted[i] ^ (N - 1) == 0:
                return i + 1

        return res


class Solution3:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        not_judge = set([lst[0] for lst in trust])
        candidates_dict = {i: 0 for i in range(1, N + 1)}

        for lst in trust:
            candidates_dict[lst[1]] += 1

        candidate_exist = 0
        for candidate, times in candidates_dict.items():
            if times == N - 1 and not candidate in not_judge:
                candidate_exist += 1
                return candidate

        if candidate_exist == 0:
            return -1


# Solution 4: 1 list
class Solution4:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        # create empty list, one element for each person
        people = [0 for _ in range(N)]

        # iterate through trust table, increase/decrease count for each person
        # being trusted
        for trusting, trusted in trust:
            people[trusting - 1] -= 1
            people[trusted - 1] += 1

        # find judge: N-1 people trust him and he trusts nobody, hence his count
        # should be N-1. We could have only 1 juge since everyone trusts only 1
        # person
        try:
            i_judge = people.index(N - 1) + 1
        except ValueError:
            return -1
        return i_judge
