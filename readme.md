# alphavantage Package_알파벤티지에서 제공하는 api 가져오기
이 패키지는 알파벤티지에서 제공하는 정보중 회사 정보, income, balance, cashflow를 정보 api를 가져와서 화면에 보여줍니다.

# Prerequisites
- Java 17
- Gradle

# Installation
- 다음의 URL을 통해 https://github.com/buffpsi/api_fiance.git 클론 해주시면됩니다.

# 설정
- server.port: 애플리케이션이 실행되는 포트 번호입니다. 기본값은 8080입니다.

# 실행방법
1. 클론한후 http://localhost:8080/alphaStocks/(원하는정보)/(티커) url로 접속 하시면 됩니다.
2. 티커랑 주식 종목 티커를 의미하고, 원하는 정보에는 company, income, balance, cashflow중 하나를 선택해서 넣으시면 됩니다.

# 주의점
- 무료 api이기 때문에 1분에 5번 하루 500번으로 요청이 제한되어있습니다.

---
# CoinNews Package_코인데스크 코리아 뉴스 크롤러_java spring

이 패키지는 코인데스크 코리아 웹사이트에서 뉴스 정보를 크롤링하여 기사의 제목, URL 및 간략한 설명을 보여줍니다. 크롤링은 ```<li>``` 태그 -> ```<div class="view-cont">```안에 있는 ```<h4 class="titles">``` 기사의 제목 , ```<a href=~~>```기사의 URL, ```<p class="lead line-6x1">```기사의 간략한 설명 요소들을 추출합니다.
추가적으로 필요한 정보들은 개발자도구를 열어 확인 해주시면 감사하겠습니다.
또한 엔드포인트의 S1N2,S1N3,S1N4,S1N5만 바꾸면 코인 데스크에서 생성하는 섹터별로 1page에 있는 기사를 클롤링 해오기때문에 CoinNews 패키지에 서비스 클래스 주석을 참고해 주시면 됩니다

# Prerequisites
- Java 17
- Gradle

# Installation
- 다음의 URL을 통해 https://github.com/buffpsi/api_fiance.git 클론 해주시면됩니다.

# 설정
- server.port: 애플리케이션이 실행되는 포트 번호입니다. 기본값은 8080입니다.

# 실행방법
1. 클론한후 http://localhost:8080/coinNews/(~) URL을 통해 여시면 클롤링 화면이 나오게 됩니다.
2. (~) 부분에는 S1N1,S1N2,S1N3,S1N4,S1N5 중 하나가 들어 갑니다.
