Test = ("hello", 1, [1, 2, 3])
print(Test)

tempList = list(Test)
tempList[0] = "Good Morning"

Test = tuple(tempList)

print(Test)

"""
Output:

('hello', 1, [1, 2, 3])
('Good Morning', 1, [1, 2, 3])


"""