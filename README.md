## 오픈소스 SW 프로젝트
### MiniGame_Heaven

#### 소개
MiniGame_Heaven 프로젝트는 Java 언어를 사용하여 각 팀원이 개발한 스도쿠 게임, 짝 맞추기 게임, 테트리스 게임,
슬라이딩 퍼즐 게임, 구슬 게임과 같은 다양한 미니 게임을 통합하는 오픈소스 프로젝트입니다. 각 게임은 독립적인 모듈로 개발되며, 
MiniGame_Heaven은 이러한 모듈들을 효과적으로 통합하여 하나의 풍부한 게임으로 만드는 것을 목표로 하고 있습니다.

##### 팀원: 서현우, 김민규, 김현준, 최윤형, 김지수

### 1주차
각 팀원의 게임 선택 및 기본 코드 작성

- **서현우**
  - 스도쿠 게임
  - 스도쿠는 숫자 퍼즐 게임으로, 9x9 격자로 구성되며, 이 격자는 3x3 크기의 9개의 하위 격자로 나뉩니다. 스도쿠 게임의 기본 규칙은 다음과 같습니다:

    1. 숫자 채우기: 플레이어는 빈 칸에 1부터 9까지의 숫자를 채워 넣어야 합니다. 처음 게임을 시작할 때 일부 숫자는 이미 격자에 채워져 있습니다.
    2. 줄과 열의 규칙: 각 수직열과 수평열에는 1부터 9까지의 숫자가 중복 없이 한 번씩만 나타나야 합니다. 즉, 각 줄과 열에는 같은 숫자가 두 번 나타나지 않아야 합니다.
    3. 하위 격자의 규칙: 각 3x3 크기의 하위 격자에도 1부터 9까지의 숫자가 중복 없이 한 번씩만 들어가야 합니다.
    4. 게임 완료: 모든 빈 칸을 올바른 숫자로 채워 넣고, 위의 세 가지 규칙을 모두 만족시키면 게임이 완료됩니다.

    1주차에는 우선 9*9 81칸의 틀을 구현하고, 3*3 9칸씩 분할하였습니다. 다음에는 초기 정답 보드를 생성하고, 플레이어가 로직에 맞춰 정답을 입력할 수 있도록 구현할 예정입니다.

- **김민규**
  - 짝 맞추기 게임(메모리 게임)
  - 준비 : 짝맞추기 게임(메모리 게임)은 기억력과 집중력을 향상시키기 위한 재미있는 게임입니다. 일반적으로 카드를 사용하여 진행되며, 카드들이 뒤집어져 있어 어떤 그림 또는 숫자가 있는지 보이지 않습니다.  카드는 짝을 이루는 두 장씩 똑같은 그림 또는 숫자가 적혀 있어야 합니다.
    1. 게임 시작 단계: 차례가 되면, 플레이어는 두 장의 카드를 선택하여 뒤집습니다. 선택한 카드를 뒤집으면 그림 또는 숫자가 보입니다.
    2. 짝 맞추기 단계 : 플레이어는 두 장의 카드가 같은 그림 또는 숫자인지 확인합니다. 만약 일치한다면, 그 카드들을 뒤집어 놓은 채로 남겨둡니다. 일치하지 않는다면, 두 카드는 다시 뒷면을 위로 뒤집어져 원래 자리에 놓입니다.
    3. 모든 카드 맞추기: 모든 카드의 짝을 찾을 때까지 위의 과정을 반복합니다. 게임이 끝나면, 모든 카드가 짝을 이루고 뒤집혀져 있어야 합니다.


    1주차에는  4*4 16개의 랜덤 카드세팅을 구현하고 클릭하면 뒤집히는 알고리즘을 구현하였습니다. 다음에는 플레이어가 정답을 맞추면 카드가 사라지고 틀리면 다시 뒤집히는 알고리즘을 제작할 예정입니다.


- **김현준**
  - 테트리스 게임
  - 테트리스는 다양한 형태의 블록들이 상단에서 아래로 떨어지고, 플레이어가 이 블록들을 적절히 배치하여 가로줄을 완성하여 점수를 쌓아가는 게임입니다.

    1. 블록의 종류: 테트리스에는 '테트로미노'라 불리는 여러 종류의 블록이 있으며, 4개의 작은 정사각형 블록으로 구성됩니다. 테트로미노는 'I', 'J', 'L', 'O', 'S', 'T', 'Z'의 7가지 형태로 분류됩니다.
    2. 게임 플레이: 게임이 시작되면 테트로미노들이 화면 상단에서 무작위로 하나씩 떨어집니다. 플레이어는 이 블록들을 좌우로 이동시키고 회전시켜 적절한 위치에 배치할 수 있습니다.
    3. 줄 완성: 블록을 쌓아 한 줄을 가득 채우면 그 줄은 사라지고 그 위에 있는 블록들이 아래로 내려옵니다. 줄이 사라질 때마다 플레이어는 점수를 얻습니다.
    4. 게임 오버: 새로운 블록이 화면 상단에 나타날 공간이 없을 때 게임이 끝납니다.
   
    1주차에는 게임 화면의 틀과 배열을 통해 블럭들을 구헌하고, 블럭의 이동과 회전 알고리즘을 작성했습니다. 다음에는 플레이어가 블럭을 이동시키거나 회전시킬 수 있도록 하고 블럭이 하강하는 것을 시각적으로 표현할 예정입니다.

- **최윤형**
  - 슬라이드 퍼즐 게임
  - 슬라이드 게임에서는 타일을 클릭하여 슬라이드하여 숫자 순서대로 정렬하는 것이 목표입니다. 이 게임은 숫자 타일이 놓인 격자가 주어지며, 각 타일은 빈 공간으로 이동할 수     있습니다. 플레이어는 타일을 클릭하여 해당 타일을 빈 공간으로 슬라이드시키면서 숫자를 순서대로 정렬해 나가야 합니다.
    게임 규칙은 다음과 같을 수 있습니다:
    
    1. 타일 이동: 플레이어는 빈 공간과 인접한 타일을 클릭하여 해당 타일을 빈 공간으로 슬라이드시킬 수 있습니다.
    2. 순서 정렬: 게임의 목표는 타일을 클릭하여 슬라이드하여 숫자를 순서대로 정렬하는 것입니다. 일반적으로는 1부터 시작하여 오름차순으로 정렬하는 것이 목표입니다.
    3. 이동 제한: 게임에 따라서는 제한된 횟수 내에 숫자를 정렬하거나, 제한된 시간 내에 최대한 많은 숫자를 정렬하는 등의 추가적인 제한이 있을 수 있습니다.
    4. 게임 완료: 모든 숫자가 순서대로 정렬되면 게임이 완료됩니다.
    
    1주차엔 간단하게 숫자를 맞추도록 게임을 구현했습니다. 다음엔 숫자 대신 그림 혹은 타임어택 등의 게임을 더 풍부하게 만들 수 있는 요소를 넣을 예정입니다.


- **김지수**
  - 구슬 게임
  - 구슬 게임은 순서대로 짝/홀을 맞춰 구슬을 획득하는 게임입니다. 간략한 게임 규칙은 다음과 같습니다.
    1. 시작 상태: 플레이어와 컴퓨터는 각각 10개의 구슬을 가지고 시작합니다.
    2. 공격 및 수비: 각 라운드에서 공격 시에는 1에서 5개의 구슬을 선택하고, 방어 시에는 0에서 5개의 구슬을 선택합니다.
    3. 예측:구슬의 짝/홀을 예측합니다.
    4. 승부 결정: 예측이 일치하면 승리하고, 일치하지 않으면 패배합니다.
    5. 결과에 따른 구슬 전환: 승리한 경우, 선택한 구슬의 수만큼 구슬을 획득하고, 패배한 경우, 선택한 구슬의 수만큼 구슬을 상대에게 빼앗깁니다.
    6. 게임 종료 조건: 이러한 공격과 수비를 번갈아가며 반복하다가 구슬이 0개가 되는 플레이어가 패배하게 됩니다.
   
    1주차에는 이러한 기본 규칙을 기반으로 게임의 기본 플레이를 구현하였습니다. 현재는 승부를 예측하는 부분에서 일부 오류가 발생하고 있어, 2주차에는 이러한 오류를 해결하고 더 정확한 게임 플레이를 구현할 계획입니다.


### 2주차

- **서현우**
  - 스도쿠 게임
    1주차의 코드에서는 사용자의 입력을 직접 보드칸에 받도록 하였는데 이렇게 하니 오류가 많이 발생하고, 보드를 완성해도 게임이 끝나지 않아, 사용자의 입력을 가로줄 인덱스와 세로줄 인덱스를 지정하고 받는 식으로 변경했습니다. 그리고 사용자의 입력값이 정답이 아닐경우에도 입력이 가능하게 하고 만약 그 답이 스도쿠 조건에 부합하지 않을 경우 빨간색으로 숫자색을 바꿔 표기하도록 코드를 수정하였습니다.

- **김민규**
  - 짝 맞추기 게임(메모리 게임)
    1주차 코드에는 오류가 없지만 숫자가 가시성이 좋지않아 색을 대체하여 가시성을 높혔습니다.
 
- **김현준**
  - 테트리스 게임
    블럭을 시각적으로 표시하고 1주차에 구현한 블럭 회전, 블럭 이동 로직을 이용해 플레이어의 키 입력을 감지하여 블럭을 회전시키거나 이동할 수 있도록 하였고 시간이 지남에 따라 블럭이 자동으로 하강하는 기능을 구현했습니다.
 
 - **최윤형**
   - 1주차 코드에서 오류가 발생하지 않아 코드를 따로 수정하진 않고, 대신 시간을 측정할 수 있는 스톱워치 기능을 추가했습니다. 이 기능은 1부터 15까지 모든 수를 맞췄을 때 멈추도록 구현되어 있어 자동으로 시간을 측정해주는 기능을 갖고 있습니다. 2주차 코드 또한 오류가 발생하지 않습니다.

- **김지수**
  - 구슬 게임
    1주차의 코드에서 승부 계산 오류가 발생했습니다. 플레이어의 공격 턴에서는 문제가 없었지만, 컴퓨터의 공격 턴에서 오류가 발생하는 것을 확인했습니다. 원인은 컴퓨터 모델의 pickEven() 메서드에서 홀/짝을 반대로 반환하도록 구현한 실수였습니다. 2주차에는 이러한 오류를 수정하여 코드를 완벽하게 개선했습니다.
