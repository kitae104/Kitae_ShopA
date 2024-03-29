package kr.inhatc.spring.item.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kr.inhatc.spring.item.constant.ItemSellStatus;
import kr.inhatc.spring.item.dto.ItemFormDto;
import kr.inhatc.spring.utils.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 상품을 관리하는 클래스
 * @author 김기태
 *
 */
@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;			// 상품 코드 
	
	@Column(nullable = false, length = 50)
	private String itemName;	// 상품 이름
	
	@Column(nullable = false)
	private int price;			// 상품 가격 
	
	@Column(nullable = false)
	private int stockNumber;	// 재고 수량 
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;	// 상품 상세 설명 
	
	public void updateItem(ItemFormDto itemFormDto) {	    
	    this.itemName = itemFormDto.getItemName();
	    this.price = itemFormDto.getPrice();
	    this.stockNumber = itemFormDto.getStockNumber();
	    this.itemDetail = itemFormDto.getItemDetail();
	    this.itemSellStatus = itemFormDto.getItemSellStatus();
	}
	
}
