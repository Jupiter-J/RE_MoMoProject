

# MOMO RE_Project

### 제작했던 I'm MoMo 프로젝트의 코드를 개선 및 수정합니다
## Iam MOMO project
### [👏 본 프로젝트로 가기](https://github.com/Jupiter-J/iammomoproject.git)

- 본격 '일상 공감' 프로젝트입니다.
- 모든 글은 '모모'라는 닉네임을 사용하며 가벼운 일상에서 부터 진솔한 감정까지 다양한 이야기로 서로의 삶을 공유하는 서비스입니다.
- 무슨 글을 써야 할지 모를때는 다양한 예시 질문을 보고 선택해서 글을 시작해 보세요 :)



![image](https://user-images.githubusercontent.com/73453283/164159577-6fe902f8-7b33-4177-98d0-7bc8ca8a8b6d.png)

<br>

---

## 개발일지

### 2022-05-02 진행상황
* 롬복(Lombok)으로 수정
* Topic Entity 수정
* 나의 게시글 조회 쿼리 수정 (user_id로 topic, post 조회 가능) [상세정보](https://velog.io/@jupiter-j/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%BF%BC%EB%A6%AC-%EC%97%90%EB%9F%AC-Encountered-a-duplicated-sql-alias-coalesce-during-auto-discovery-of-a-native-sql-query)

### 2022-05-14 진행상황
* [댓글기능 구현을 위한 JPA 학습](#댓글기능-구현을-위한-JPA-학습) 

### 2022-05-15 진행상황
* 댓글 기능 CRUD 구현 
* Json 응답 형식이 보기 힘든 형태라 2차 배열로 수정 필요 

### 2022-05-16 진행상황
* 댓글 기능 JSON 응답 형식 2차 배열로 수정 [상세정보](https://velog.io/@jupiter-j/Json-2%EC%B0%A8%EB%B0%B0%EC%97%B4-%EC%97%90%EB%9F%AC)
* Swagger 적용 (api/v1~ 수정)

![](https://velog.velcdn.com/images/jupiter-j/post/0821e3c8-efb1-4a18-849c-1669403ab7cf/image.png)

### 2022-05-25 진행상황
* JWT 방식의 로그인 파일 추가 생성
* CORS에러 

### 2022-06-02 진행상황
* JWT 로그인 방식을 이메일 방식으로 부분 변경
* CORS에러 해결

### 2022-06-04 진행상황 
* 로그인시 401 Unauthorize 에러 해결 [상세정보](https://velog.io/@jupiter-j/SpringSecurity-JWT-로그인시-401-에러)

### 2022-06-10 진행상황
#### ⚠️ 프로젝트를 다시 구현하기로함
기획자님의 요구사항이 증가하면서 전체적인 설계와 ERD설계의 필요성을 느끼게 되었다
* 이벤트 스토밍 1차 [상세정보](https://velog.io/@jupiter-j/프로젝트-설계-이벤트-스토밍) 

### 2022-06-11 진행상황
* 이벤트 스토밍 2차 [상세정보](https://velog.io/@jupiter-j/프로젝트-설계-이벤트스토밍2)

### 2022-06-16 진행상황
* ERD설계 및 기능명세서 정리 [상세정보](https://velog.io/@jupiter-j/프로젝트-설계-이벤트스토밍3)

### 2022-06-23 진행상황
* 카테고리 CRUD 완료

### 2022-06-24 진행상황
* 질문 CRUD + 질문검색 완료
* 질문검색 네이티브쿼리와 메소드 쿼리 에러 해결 [상세정보](https://velog.io/@jupiter-j/에러Jpa-검색기능-like-사용시nativeQuery와-메소드-사용)

<br>
<br>

--- 


## ERD
![](https://velog.velcdn.com/images/jupiter-j/post/e90fc64f-2199-4bb9-a976-d0315df11881/image.png)




<br>
<br>


---
# 댓글기능 구현을 위한 JPA 학습 
공부자료 : 자바 ORM 표준 JPA 프로그래밍
### 단방향 연관관계
객체의 참조와 테이블의 외래키를 매핑
* 객체를 테이블에 맞추어 데이터 중심으로 모델링하면 협력관계를 만들 수 없다
* 테이블은 **외래키로 조인**을 사용해서 연관된 테이블을 찾는다
* 객체는 **참조를 사용**해서 연관된 객체를 찾는다

  > Post에는 다수의 comment가 있다 (1:N) 
  > 
  > User는 다수의 comment를 작성할 수 있다 (1:N)

### 양방향 연관관계
* 테이블 연관관계는 외래키 하나로 양방향 사용 가능
* 객체는 양방향에 객체를 만들어야 양방향으로 사용이 가능하다 

#### 객체와 테이블이 관계를 맺는 차이 
* 객체 연관관계 2개
  > 회원 -> 팀 연관관계 1개 (단방향)  
  > 
  > 팀 -> 회원 연관관계 1개 (단방향)
* 테이블 연관관계 1개
  > 회원 <-> 팀의 연관관계 1개 (양방향)
* 테이블 관점에서 외래키 FK가 있는곳이 연관관계의 주인으로 설계를 하도록 하자 
