class Solution:

    def check(self,s: str, p: str, sPoint: int, pPoint: int) -> bool:
        if (len(s) == sPoint):
            if(p[len(p)-1] == '*' ):
                if (pPoint == len(p) -2):
                    return True
                else:
                    i = pPoint +1
                    while(i < len(p)):
                        if(p[i] == '*'):
                            i += 2
                        else:
                            break
                    if(i > len(p)):
                        return True
            elif(pPoint == len(p)):
                return True
            elif(len(s) == 0):
                if (pPoint + 1 < len(p) and p[pPoint + 1] == '*'):
                    if (self.check(s, p, sPoint, pPoint+2) == True):
                        return True
                    if(self.check(s, p, sPoint, pPoint + 1) == True):
                        return True
            return False
        if (len(s) <= sPoint or len(p) <= pPoint):
            return False
        if (pPoint+1 < len(p) and p[pPoint + 1] == '*'):
            if (p[pPoint] == s[sPoint]):
                if (self.check(s, p, sPoint + 1, pPoint) == True):
                    return True
            elif(p[pPoint] == '.'):
                if (self.check(s, p, sPoint + 1, pPoint) == True):
                    return True
            pPoint += 2
        if(pPoint < len(p) and (p[pPoint] == s[sPoint] or p[pPoint] == '.')):
            if(pPoint+1 < len(p) and p[pPoint + 1] == '*'):
                if(self.check(s, p, sPoint + 1, pPoint) == True):
                    return True
                elif(self.check(s, p, sPoint + 1, pPoint+2) == True):
                    return True
                elif(self.check(s, p, sPoint, pPoint+2) == True):
                    return True
            elif(self.check(s, p, sPoint + 1, pPoint + 1) == True):
                return True
        if(pPoint+1 < len(p) and p[pPoint + 1] == '*'):
            if (self.check(s, p, sPoint, pPoint+2) == True):
                return True
        return False

    def isMatch(self, s: str, p: str) -> bool:
        if (len(s)!= 0 and len(p) != 0 and (p[len(p) - 1] != '*') and s[len(s) - 1] != p[len(p) - 1] and p[len(p) - 1] != '.'):
            return False
        if(len(s)== 0 and len(p)== 0):
            return True
        return self.check(s, p, 0, 0)





def main():
    import sys
    import io
    def readlines():
        for line in io.TextIOWrapper(sys.stdin.buffer, encoding='utf-8'):
            yield line.strip('\n')

    lines = readlines()
    while True:
        try:
            s = next(lines)
            p = next(lines)

            ret = Solution().isMatch(s, p)

            out = (ret);
            print(out)
        except StopIteration:
            break
main()