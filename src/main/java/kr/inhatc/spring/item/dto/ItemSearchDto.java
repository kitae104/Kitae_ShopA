package kr.inhatc.spring.item.dto;

import kr.inhatc.spring.item.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemSearchDto {

    private String searchDateType;

    private ItemSellStatus searchSellStatus; 

    private String searchBy;

    private String searchQuery = ""; 
}
