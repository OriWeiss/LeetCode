class Increasing:
    def almostIncreasingSequence(self, sequence) -> bool:
        haveRemoved = False
        if(len(sequence) <= 2 ): #if sequence has no or 1 element auto return true
            return True

        if(sequence[0] > sequence[1]): #check first
            haveRemoved = True

        for i in range(1,len(sequence)-1):
            if(sequence[i] >= sequence[i+1]):
                if(haveRemoved or sequence[i-1] >= sequence[i+1]):
                    return False
                haveRemoved = True

        return True
def main():
    a = [0,1,1,2]
    b = [10,1,2,3,4,5]
    c = [1,2,3,4,5,3,5,6]
    d = [40,50,60,10,20,30]
    e = [20,10,11,9]
    print(Increasing().almostIncreasingSequence(a))
    print(Increasing().almostIncreasingSequence(b))
    print(Increasing().almostIncreasingSequence(c))
    print(Increasing().almostIncreasingSequence(d))
    print(Increasing().almostIncreasingSequence(e))
main()