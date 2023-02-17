package kr.inhatc.spring.item.entity;

import jakarta.persistence.*;
import kr.inhatc.spring.order.entity.Order;
import kr.inhatc.spring.utils.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemImg extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_img_id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    
    private String imgName;
    
    private String oriName;
    
    private String imgUrl;
    
    private String repImgYn;

    public void updateItemImg(String oriName, String imgName, String imgUrl) {
        this.imgName = imgName;
        this.oriName = oriName;
        this.imgUrl = imgUrl;
    }        
}
