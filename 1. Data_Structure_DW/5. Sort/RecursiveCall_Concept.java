
// 재귀용법 : 스택(LIFO), 함수 안에서 동일한 함수를 호출하는 형태
// 시간복잡도
// factorial(n) 은 n - 1 번의 factorial() 함수를 호출해서, 곱셈을 함
// 일종의 n-1번 반복문을 호출한 것과 동일
// factorial() 함수를 호출할 때마다, 지역변수 n 이 생성됨
// 시간 복잡도/공간 복잡도는 O(n-1) 이므로 결국, 둘 다 O(n)
public class RecursiveCall_Concept {

    // 1. factorial function
    // 1! = 1
    // 2! = 2*1! -> 2*1
    // 3! = 3*2! -> 3*2
    // 4! = 4*3! -> 4*6 -> 24
    // n! = n!*(n-1)!
    public static int factorial(int num) {
        if (num > 1) {
            System.out.println("num * (num-1) : " + num + " x " + (num - 1));
            return num * factorial(num - 1);
        } else {
            return 1;
        }

    }

    // 2. 숫자가 들어 있는 리스트가 주어졌을 때, 리스트의 합을 리턴하는 함수를 만드세요 (재귀함수를 써보세요)
    // add(1) -> 1
    // add(2,1) -> 2 + add(1)
    // add(3,2,1) -> 3 + add(2,1)
    // add(4,3,2,1) -> 4 + add(3,2,1)
    public static int add(int[] list) {
        if (list.length > 1) {
            int[] tmp = new int[list.length - 1];
            for (int i = 1; i < list.length; i++) {
                tmp[i - 1] = list[i];
            }
            return list[0] + add(tmp);
        } else {
            return list[0];
        }
    }

    // 3. 회문을 판별할 수 있는 함수를 리스트 슬라이싱을 활용해서 만드세요
    // -> 회문(palindrome)은 순서를 거꾸로 읽어도 제대로 읽은 것과 같은 단어와 문장을 의미함
    public static Boolean palindrome(String list) {
        if (list.length() > 1) {
            if (list.charAt(0) == list.charAt(list.length() - 1)) {
                palindrome(list.substring(1, list.length() - 1));
            } else {
                return false;
            }
        } else {
            return true;
        }
        return true;
    }

    // 4. 정수 n을 입력받아, 아래 알고리즘에 의해 1이 되는 과정을 모두 출력하는 함수를 작성하세요.
    // -> n이 홀수이면 3 X n + 1 을 하고, n이 짝수이면 n 을 2로 나눕니다. -> 1이 될 때까지 반복
    public static void isOne(int num) {
        System.out.println(num);
        if (num == 1) {
        } else {
            // 홀수
            if (num % 2 == 1) {
                isOne((3 * num) + 1);
                // 짝수
            } else {
                isOne(num / 2);
            }
        }
    }
    // 5. 정수 n이 입력으로 주어졌을 때, n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구하시오
    // 1 : {1} : 1개
    // 2 : {1,1}, {2} : 2개
    // 3 : {1,1,1}, {1,2}, {2,1}, {3} : 4개
    // 4 : {1,1,1,1}, {1,3}, {3,1}, {1,1,2}, {1,2,1}, {2,1,1}, {4} : 7개
    // 5 : {1,1,1,1,1}, {2,3}, {3,2}, {1,2,2}, {2,1,2}, {2,2,1}, {1,1,3}, {1,3,1},
    // {3,1,1}, {2,1,1,1}, {1,2,1,1}, {1,1,2,1}, {1,1,1,2} : 13개

    public static int isCount(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;

        } else {
            return isCount(n - 1) + isCount(n - 2) + isCount(n - 3);
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(add(new int[] { 4, 3, 2, 1 }));
        System.out.println(palindrome("nonon"));
        isOne(3);
        System.out.println(isCount(5));

    }

}