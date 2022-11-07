# itemservice-db
JDBC 템플릿 + MYBatis, JPA, SPRING DATA JPA , QUERY DSL 사용 리파지토리

JDBC 템플릿, MYBatis는 내부 트랜잭션으로 DataSourceTransactionManager를 사용하고

JPA등은 JpaTransactionManger를 사용하여 트랜잭션을 컨트롤한다.

JDBC와 JPA를 같이 사용하는 경우 JpaTransactionManger가 내부에서는 결국 DataSourceTransactionManager를 사용하기 때문에 같이 사용해도 문제가 없다
