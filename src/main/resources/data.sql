INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD, LANGPREF) VALUES ('Abhijeet', 'Padhy', 'abhijeet.padhy@gmail.com', '$2a$11$csuBDJbyZxcNbF3s8vkVvus4ez9aa5/jt3dMfg1SAAch8mj4yltkK', 'java');
INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD, LANGPREF) VALUES ('Abhisekh', 'Padhy', 'abhisekh.padhy@gmail.com', '$2a$11$1gTGi3Tmkx6hOb40HKlzKuBsgHNinZ.JyV/b5Lk0ZAkBNsAFiq0EG', 'java');


INSERT INTO CODE (USER_ID, LANG, CODEBODY, CODELINK, CODETITLE, CODETOPIC, CODEDESC) VALUES (
    1,
    'java',
    'char charArray[] = str.toCharArray();',
    'https://spring.io/guides/gs/spring-boot/',
    'How many Crows!',
    'Arrays',
    'This is the problem statement!'
);

INSERT INTO CODE (USER_ID, LANG, CODEBODY, CODELINK, CODETITLE, CODETOPIC, CODEDESC) VALUES (
    2,
    'java',
    'char charArray[] = str.toCharArray();',
    'https://spring.io/guides/gs/spring-boot/',
    'How many Crows!',
    'Arrays',
    'This is the problem statement!'
);

INSERT INTO CODE(USER_ID, LANG, CODEBODY, CODELINK, CODETITLE, CODETOPIC, CODEDESC) VALUES(1, '2', U&'class Solution {\000d\000a    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {\000d\000a        ArrayList<Integer> result = new ArrayList<>();\000d\000a        for(int i=0;i<n;i++){\000d\000a            if(arr[i] == i+1)\000d\000a                result.add(i+1);\000d\000a        }\000d\000a        return result;\000d\000a    }\000d\000a}', 'https://practice.geeksforgeeks.org/problems/value-equal-to-index-value1330/1#', 'Value equal to index value ', 'Binary Search', U&'Given an array Arr of N positive integers. Your task is to find the elements whose value is equal to that of its index value ( Consider 1-based indexing ).\000d\000a\000d\000aExample 1:\000d\000a\000d\000aInput: \000d\000aN = 5\000d\000aArr[] = {15, 2, 45, 12, 7}\000d\000aOutput: 2\000d\000aExplanation: Only Arr[2] = 2 exists here.\000d\000aExample 2:\000d\000a\000d\000aInput: \000d\000aN = 1\000d\000aArr[] = {1}\000d\000aOutput: 1\000d\000aExplanation: Here Arr[1] = 1 exists.\000d\000aYour Task:  \000d\000aYou don''t need to read input or print anything. Your task is to complete the function valueEqualToIndex() which takes the array of integers arr[] and n as parameters and returns an array of indices where the given conditions are satified. When there is not such element exists then return an empty array of length 0.\000d\000a\000d\000aExpected Time Complexity: O(N)\000d\000aExpected Auxiliary Space: O(1)\000d\000aNote: There can be more than one element in the array which have same value as their index. You need to include every such element''s index. Follows 1-based indexing of the array.');

INSERT INTO AUTH_USER_GROUP (USERNAME, AUTH_GROUP) VALUES('abhijeet.padhy@gmail.com', 'USER');
INSERT INTO AUTH_USER_GROUP (USERNAME, AUTH_GROUP) VALUES('abhijeet.padhy@gmail.com', 'ADMIN');
INSERT INTO AUTH_USER_GROUP (USERNAME, AUTH_GROUP) VALUES('abhisekh.padhy@gmail.com', 'USER');