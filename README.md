## JSP의 탄생배경

### Servlet

```
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<html>"
                        + "<head>"
                        + "        <title>Hello World</title>"
                        + "</head>"
                        + "<body>");

        for(int i=0; i < 3; i++){
            out.println("        hello World !!");
        }

        out.println("</body>"
                  + "</html>");

        out.close();
    }
```

### JSP

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
    <% for(int i=0; i < 3; i++){    %>
        hello World !!
    <% }%>
</body>
</html>
```

https://dololak.tistory.com/82

[코끼리를 냉장고에 넣는 방법:티스토리]

Servlet의 불편함을 개선한 JSP

## 디버깅이 습관화 되어야하는 이유

- 어플리케이션 분석이 어려운 이유는 왜 이렇게 동작하는지 모르기 때문이다.
- 실행하는 어플리케이션의 구조[!]를 알 수 있음
    - stackTrace 사용

## log 라이브러리 또는 System.out.println, console.log

### 단점

- 소스 가독성 저하
- 불편한 관리 (개발 완료 후에 의미없는 로그데이터는 삭제해야함)
- 흐름 파악이 어려움
- 로그로 출력한 데이터만 확인가능하며, 다시 작성 시 서버 재시작이 불편

### 사용처

- 개발, 운영 서버 등 디버깅이 불가능한 환경에서 사용

## 디버깅 옵션 종류

### Variables

- 현재 메소드 범위에서 조회가능한 변수들을 보여줌
- 전역 변수는 보이지 않습니다.

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/8cd583d7-a220-4020-9e29-58011f15a65e)


### StackTrace

- 서버가 OrderController.orderSave 메소드를 호출하기 까지의 여정을 볼 수 있음
    - 예를들어 유명한 DispatcherServlet

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/433b00dd-41e2-4c33-91d3-f65d944fbed7)


### Watch

- 조회하고 싶은 변수를 모니터링 할 수 있음
    - Variables 에서 조회불가능한 전역변수를 Watch 기능을 이용해 모니터링 할수도 있음
- 테스트를 위해 특정 변수의 값을 변경할 수 있음

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/1899406d-9ffa-4297-a18b-28729db6e944)


### BreakPoint

- 중단 시점을 지정할 수 있음

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/a292efd8-ab89-4977-87bb-8b297977348f)


- 조건식 브레이크포인트
    - Exam) item의 값이 3500일경우 브레이크

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/e7c67fff-2316-4408-acb6-677d446b1344)


![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/f5ceb174-cd66-4fba-be3a-bf254cad3ee9)


![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/1331e738-ae91-43ca-a58d-576979562673)


### **Evaluate**

- 기능은 Watch와 동일하나, **Evaluate는 일회성 Watch는 영구성**

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/f676c38c-6e97-47a9-8cc5-e8ad9c0b895f)


### Run to Cursor

- 선택한 라인으로 이동하여 브레이크

## 디버깅 사용

### resume

- 다음 브레이크포인트 중단점까지 이동

### step into

- 브레이크 포인트 지점에서 메소드 실행 시 해당 메소드로 이동
Exam - 해당 브레이크포인트 지점에서 step into 클릭 시 initList 메소드 내로 시점이동

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/732a69af-50c1-460d-9b46-ad396db4c69e)


### step over

- 다음 라인 실행

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/acd8d8cb-b5b9-4da4-8f77-e52b2ecf7a4b)


### step out

- 해당 메소드를 호출한 상위 메소드를 확인 할 수 있음
Exam - 해당 브레이크 포인트 지점에서 step out 시 initList 메소드를 호출한 상위메소드로 이동

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/7a579b62-5fe0-4ca1-a9b4-07608bd37776)


### Mute Breakpoint

- 브레이크포인트 무시

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/ea1e97d5-caaf-4690-baa6-41f10bf3d105)


### Drop Frame

- 상위메소드에서 해당 메소드를 실행 시키기 전 시점으로 돌아감
- Step Out - 상위메소드에서 해당 메소드를 실행 시킨 후 시점으로 돌아감

![image](https://github.com/OHLPstudy/debug_swlee/assets/49707719/d50cd362-ae70-4bc0-9d59-471f977888d3)
