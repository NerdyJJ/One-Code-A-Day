"221123 기사단원의 무기";
"문제 : https://school.programmers.co.kr/learn/courses/30/lessons/136798";

"참고자료 : https://mygumi.tistory.com/122";

// 문제 설명

// 숫자나라 기사단의 각 기사에게는 1번부터 number까지 번호가 지정되어 있습니다. 기사들은 무기점에서 무기를 구매하려고 합니다.

// 각 기사는 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매하려 합니다. 단, 이웃나라와의 협약에 의해 공격력의 제한수치를 정하고, 제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는 협약기관에서 정한 공격력을 가지는 무기를 구매해야 합니다.

// 예를 들어, 15번으로 지정된 기사단원은 15의 약수가 1, 3, 5, 15로 4개 이므로, 공격력이 4인 무기를 구매합니다. 만약, 이웃나라와의 협약으로 정해진 공격력의 제한수치가 3이고 제한수치를 초과한 기사가 사용할 무기의 공격력이 2라면, 15번으로 지정된 기사단원은 무기점에서 공격력이 2인 무기를 구매합니다. 무기를 만들 때, 무기의 공격력 1당 1kg의 철이 필요합니다. 그래서 무기점에서 무기를 모두 만들기 위해 필요한 철의 무게를 미리 계산하려 합니다.

// 기사단원의 수를 나타내는 정수 number와 이웃나라와 협약으로 정해진 공격력의 제한수치를 나타내는 정수 limit와 제한수치를 초과한 기사가 사용할 무기의 공격력을 나타내는 정수 power가 주어졌을 때, 무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게를 return 하는 solution 함수를 완성하시오.

// 제한사항
// 1 ≤ number ≤ 100,000
// 2 ≤ limit ≤ 100
// 1 ≤ power ≤ limit

function solution(number, limit, power) {
  // 기사단원 수 number
  // 공격력 제한수치 limit
  // 제한수치를 초과한 기사가 사용할 무기의 공격력 power

  // 무기를 모두 만들기 위해 필요한 철의 무게
  let answer = 0;

  // 약수의 개수를 저장할 배열
  let count = [];

  // TEST 연산횟수
  let dd = 0;

  // 1부터 number 까지 순회하면서 i * j <= number 인 조합을 찾아 count 증가 (배수 찾기)
  // 1166750 회 연산 --> 200064
  for (let i = 1; i <= number; i++) {
    for (let j = 1; j <= number / i; j++) {
      dd++;
      if (isNaN(count[i * j])) count[i * j] = 0;
      count[i * j] += 1;
    }
  }

  // 1부터 i/2 까지 (n^2)
  // 25억 회 연산 --> 200064
  // count[1] = 1;
  // for (let i = 2; i <= number; i++) {
  //   let c = 1;
  //   for (let j = 1; j <= i / 2; j++) {
  //     dd++;
  //     if (i % j == 0) {
  //       c++;
  //     }
  //   }
  //   if (isNaN(count[i])) count[i] = 0;
  //   count[i] += c;
  // }

  // 다른사람풀이
  // 21615703 회 연산 --> 200064
  // for (let i = 1; i <= number; i++) {
  //   let temp = [];
  //   for (let j = 1; j <= Math.sqrt(i); j++) {
  //     dd++;
  //     if (i % j === 0) temp.push(j);
  //   }
  //   res = temp.length;
  //   for (let k = 0; k < res; k++) {
  //     dd++;
  //     temp.push(i / temp[k]);
  //   }
  //   count.push(new Set(temp).size);
  // }

  // 약수 배열을 순회하면서 limit 을 초과하는 경우 정해진 power로 값 재할당
  // for (let i = 0; i < number; i++) {
  for (let i = 1; i <= number; i++) {
    // console.log("count[%d] : %d", i, count[i]);
    if (count[i] > limit) {
      count[i] = power;
    }

    // console.log("count[%d] : %d", i, count[i]);

    // 무게 합계에 추가
    answer += count[i];
  }

  console.log("total %d 회 연산", dd);

  return answer;
}

console.log(solution(100000, 3, 2));
