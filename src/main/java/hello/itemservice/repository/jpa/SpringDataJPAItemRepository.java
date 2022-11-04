package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Repository -> 예외 변환 AOP Proxy 적용
// JPA 전용 에러 -> DataAccess 범용 에러로 변환
// 결과로 Service는 JPA를 몰라도 된다.
public interface SpringDataJPAItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNameLike(String itemName);
    List<Item> findByPriceLessThanEqual(Integer price);
    
    //쿼리 메서드
    List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price);

    //쿼리 직접 실행
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
}
